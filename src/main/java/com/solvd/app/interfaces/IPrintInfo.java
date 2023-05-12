package com.solvd.app.interfaces;

@FunctionalInterface
public interface IPrintInfo<T, U, V> {
    void print(T t, U u, V v);
}
