package jawa.sinaukoding.sk.config;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.*;

public final class CorsFilter implements Filter {

    private final Set<String> corsAllowedRequestOrigins = new HashSet<>();
    private final Set<String> lowerCaseCorsAllowedRequestMethods = new HashSet<>();
    private final Set<String> lowerCaseCorsAllowedRequestHeaders = new HashSet<>();

    // https://developer.mozilla.org/en-US/docs/Glossary/CORS-safelisted_request_header
    private final String corsSafeListedRequestHeaders = "Accept, Accept-Language, Content-Language, Content-Type, Range";
    private final String corsSafeCustomRequestHeader = "authorization, __rememberme, __rememberme_issued_at";


    public CorsFilter(List<String> allowedOrigins) {
        this.corsAllowedRequestOrigins.addAll(allowedOrigins);
        this.lowerCaseCorsAllowedRequestMethods.addAll(List.of("post", "get", "options"));
        this.lowerCaseCorsAllowedRequestHeaders.addAll(Arrays.stream(corsSafeListedRequestHeaders.split(",")).map(s -> s.trim().toLowerCase()).toList());
        // custom header
        this.lowerCaseCorsAllowedRequestHeaders.addAll(Arrays.stream(corsSafeCustomRequestHeader.split(",")).map(s -> s.trim().toLowerCase()).toList());
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest req = (HttpServletRequest) servletRequest;
        final HttpServletResponse res = (HttpServletResponse) servletResponse;
        final boolean isPreFlight = "OPTIONS".equalsIgnoreCase(req.getMethod()); // handling pre-flight request
        final String origin = req.getHeader("Origin");
        final String method;
        final String headers;
        if (isPreFlight) {
            method = req.getHeader("Access-Control-Request-Method");
            headers = req.getHeader("Access-Control-Request-Headers");
        } else {
            method = req.getMethod();
            final Enumeration<String> names = req.getHeaderNames();
            final StringBuilder sb = new StringBuilder();
            while (names != null && names.hasMoreElements()) {
                String s = names.nextElement();
                if (s != null && !s.isBlank()) {
                    sb.append(s.trim());
                    if (names.hasMoreElements()) {
                        sb.append(", ");
                    }
                }
            }
            headers = sb.toString();
        }
        if (isPreFlight) {
            if (method == null || method.isBlank() || headers == null || headers.isBlank()) {
                res.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
                return;
            }
            if (!corsAllowedRequestOrigins.contains(origin)) {
                if (!corsAllowedRequestOrigins.isEmpty()) { // in production it must be not empty
                    res.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
                    return;
                }
            }
            if (!lowerCaseCorsAllowedRequestMethods.contains(method.toLowerCase())) {
                res.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
                return;
            }
            if (headers != null && !headers.isBlank()) {
                for (String header : headers.split(",")) {
                    final String lowerCaseHeader = header.trim().toLowerCase();
                    if (!lowerCaseCorsAllowedRequestHeaders.contains(lowerCaseHeader)) {
                        res.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
                        return;
                    }
                }
            }
        }
        res.addHeader("Very", "Origin");
        res.addHeader("X-Frame-Options", "DENY");
        res.addHeader("X-Content-Type-Options", "nosniff");
        res.addHeader("X-XSS-Protection", "1; mode=block");
        res.addHeader("Access-Control-Allow-Origin", origin);
        res.addHeader("Access-Control-Allow-Headers", headers);
        res.addHeader("Access-Control-Allow-Methods", method);
        res.addHeader("Access-Control-Allow-Credentials", "true"); // allow js to include cookie (cross-origin); By default, CORS does not include cookies on cross-origin requests
        res.addHeader("Access-Control-Max-Age", "5"); // default value is 5
        // https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Access-Control-Expose-Headers
        res.addHeader("Access-Control-Expose-Headers", corsSafeListedRequestHeaders + ", " + corsSafeCustomRequestHeader);
        if (isPreFlight) {
            res.setStatus(HttpServletResponse.SC_ACCEPTED);
        } else {
            filterChain.doFilter(req, res);
        }
    }
}
