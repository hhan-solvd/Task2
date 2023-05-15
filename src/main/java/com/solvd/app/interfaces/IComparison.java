package com.solvd.app.interfaces;

@FunctionalInterface
public interface IComparison<T, U, R> {
    R compare(T t, U u);
}
