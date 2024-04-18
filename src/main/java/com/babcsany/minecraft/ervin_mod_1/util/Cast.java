package com.babcsany.minecraft.ervin_mod_1.util;

public class Cast<T> {
    private T cast;

    @SuppressWarnings("unchecked")
    public Cast() {
        this((T) "");
    }

    public Cast(T cast) {
        this.cast = cast;
    }

    public T getCast() {
        return this.cast;
    }

    public void setCast(T cast) {
        this.cast = cast;
    }

    @SuppressWarnings("unchecked")
    public T cast(Object object) {
        return (T) object;
    }
}
