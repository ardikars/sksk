package jawa.sinaukoding.sk.model;

import java.util.Collection;

public record Page<T>(int totalData, int totalPage, int currentPage, int pageSize, Collection<T> data) {
}
