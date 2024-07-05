
package jawa.sinaukoding.sk.service;


import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

import jawa.sinaukoding.sk.entity.User;
import jawa.sinaukoding.sk.model.Authentication;
import jawa.sinaukoding.sk.model.request.LoginReq;
import jawa.sinaukoding.sk.model.request.RegisterBuyerReq;
import jawa.sinaukoding.sk.model.request.RegisterSellerReq;
import jawa.sinaukoding.sk.model.request.UpdateProfileReq;
import jawa.sinaukoding.sk.model.Response;
import jawa.sinaukoding.sk.model.response.UserDto;
import jawa.sinaukoding.sk.repository.UserRepository;
import jawa.sinaukoding.sk.util.HexUtils;
import jawa.sinaukoding.sk.util.JwtUtils;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jawa.sinaukoding.sk.model.request.ResetPasswordReq;


@Service
public final class UserService extends AbstractService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final byte[] jwtKey;
    // private final JwtUtils jwtUtils;

    public UserService(final Environment env, final UserRepository userRepository, final PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        final String skJwtKey = env.getProperty("sk.jwt.key");
        this.jwtKey = HexUtils.hexToBytes(skJwtKey);
        // this.jwtUtils = jwtUtils;

    }

    public Response<Object> listUsers(final Authentication authentication, final int page, final int size) {
        return precondition(authentication, User.Role.ADMIN).orElseGet(() -> {
            if (page <= 0 || size <= 0) {
                return Response.badRequest();
            }
            final List<UserDto> users = userRepository.listUsers(page, size) //
                    .stream().map(user -> new UserDto(user.name(), user.role())).toList();
            return Response.create("09", "00", "Sukses", users);
        });
    }

    public Response<Object> registerSeller(final Authentication authentication, final RegisterSellerReq req) {
        return precondition(authentication, User.Role.ADMIN).orElseGet(() -> {
            if (req == null) {
                return Response.badRequest();
            }
            final String encoded = passwordEncoder.encode(req.password());
            final User user = new User( //
                    null, //
                    req.name(), //
                    req.email(), //
                    encoded, //
                    User.Role.SELLER, //
                    authentication.id(), //
                    null, //
                    null, //
                    OffsetDateTime.now(), //
                    null, //
                    null //
            );
            final Long saved = userRepository.saveSeller(user);
            if (0L == saved) {
                return Response.create("05", "01", "Gagal mendaftarkan seller", null);
            }
            return Response.create("05", "00", "Sukses", saved);
        });
    }

    public Response<Object> registerBuyer(final Authentication authentication, final RegisterBuyerReq req) {
        return precondition(authentication, User.Role.ADMIN).orElseGet(() -> {
            if (req == null) {
                return Response.badRequest();
            }
            final String encoded = passwordEncoder.encode(req.password());
            final User user = new User( //
                    null, //
                    req.name(), //
                    req.email(), //
                    encoded, //
                    User.Role.BUYER, //
                    authentication.id(), //
                    null, //
                    null, //
                    OffsetDateTime.now(), //
                    null, //
                    null //
            );
            final Long saved = userRepository.saveBuyer(user);
            if (0L == saved) {
                return Response.create("06", "01", "Gagal mendaftarkan buyer", null);
            }
            return Response.create("06", "00", "Sukses", saved);
        });
    }

    public Response<Object> login(final LoginReq req) {
        if (req == null) {
            return Response.badRequest();
        }

        final Optional<User> userOpt = userRepository.findByEmail(req.email());
        if (userOpt.isEmpty()) {
            return Response.create("08", "01", "Email atau password salah", null);
        }

        final User user = userOpt.get();
        if (!passwordEncoder.matches(req.password(), user.password())) {
            return Response.create("08", "02", "Email atau password salah", null);
        }

        final Authentication authentication = new Authentication(user.id(), user.role(), true);
        final long iat = System.currentTimeMillis();
        final long exp = 1000 * 60 * 60 * 24; // 24 hour
        final JwtUtils.Header header = new JwtUtils.Header() //
                .add("typ", "JWT") //
                .add("alg", "HS256"); //
        final JwtUtils.Payload payload = new JwtUtils.Payload() //
                .add("sub", user.id()) //
                .add("role", user.role().name()) //
                .add("iat", iat) //
                .add("exp", exp); //

        final String token = JwtUtils.hs256Tokenize(header, payload, jwtKey);
        return Response.create("08", "00", "Sukses", token);
    }

    public Response<Object> resetPassword(final Authentication authentication, final ResetPasswordReq req,  final Long id){
        return precondition(authentication, User.Role.ADMIN,User.Role.BUYER, User.Role.SELLER ).orElseGet(()->{

            if (req == null || req.newPassword() == null || req.oldPassword() == null){
                return Response.badRequest();
            }
            Long userId = authentication.id();

            Optional<User> userOpt= userRepository.findById(authentication.id());
            if (userOpt.isEmpty()){
                return Response.create("07","01" , "user not found", null);
            }

            User user = userOpt.get();

            if (user.deletedAt() != null || user.deletedBy() != null) {
                return Response.create("07", "06", "Account has been deleted", null);
            }

            if(!passwordEncoder.matches(req.oldPassword(), user.password())){
                return Response.create("07","03","Old password is incorect" , null);
            }

            if(passwordEncoder.matches(req.newPassword(), user.password())){
                return Response.create("07", "04", "New password cannot be the same as the old password", null);
            }

            final String encode = passwordEncoder.encode(req.newPassword());

            final long saved = userRepository.updatePassword(userId, encode);
            if (0L == saved) {
                return Response.create("07", "02", "Gagal mereset password", null);
            }

            Optional<User> userCheck = userRepository.findById(userId);
            if (userCheck.isEmpty() || userCheck.get().deletedAt() != null || userCheck.get().deletedBy() != null) {
                return Response.create("07", "07", "Account no longer exists", null);
            }
            UserDto userDto = new UserDto(user.name(), user.role());
            return Response.create("07", "00", "Sukses", userDto );
 
        });

        
    }

    public Response<Object> updateProfile(final Authentication auth,final UpdateProfileReq req,long id){
        return precondition(auth, User.Role.ADMIN,User.Role.BUYER,User.Role.SELLER).orElseGet(() -> {
            if(id == 0L){
                return Response.badRequest();
            }

            Optional<User> userValidate = userRepository.findById(id);

            if(userValidate.get().deletedAt() != null ){
                return Response.badRequest();
            }

            if(req.name() != ""){
                if(req.name() == userValidate.get().name()){
                    return Response.create("40", "00", "gagal update user karena nama yang baru sama dengan nama lama", null);
                }
            }

            if(req.email() != ""){
                if(req.email() == userValidate.get().email()){
                    return Response.create("40", "00", "gagal update user karena email yang baru sama dengan email lama", null);
                }
            }

            final User user = new User(
                id, //
                req.name(), //
                req.email(), //
                null, //
                null, //
                null, //
                id, //
                null, //
                null, //
                OffsetDateTime.now(), //
                null //
            );

            final Long update = userRepository.updateProfile(user);

            if(update == 0L){
                return Response.create("06", "01", "gagal update profile", update);
            }

            return Response.create("06", "00", "sukses update profile", update);
        });

    }

    public Response<Object> deletedResponse(Authentication authentication,final Long id, Long idUser) {
        return precondition(authentication, User.Role.ADMIN).orElseGet(() -> {
            final Optional<User> userOpt = userRepository.findById(idUser);
        if (userOpt.isEmpty()) {
            return Response.create("08", "01", "Email atau password salah", null);
        }
        if (userOpt.get().deletedAt() != null) {
            return Response.badRequest();
        }
        if (id == 0L) {
            return Response.badRequest();
        } 
        Long delete = userRepository.deleteUser(id, idUser);
        if (delete == 0L) {
            return Response.create("06", "01", "Gagal menghapus. Data sudah di hapus atau data tidak ditemukan", delete);
        }
        return Response.create("06", "00", "Berhasil Menghapus", delete);
        }
        );

    }
}
