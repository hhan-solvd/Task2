package com.solvd.app.interfaces;

@FunctionalInterface
public interface IFilter<T, U, V> {
    boolean filter(T t, U u, V v);
}
