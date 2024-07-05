package com.babcsany.minecraft.ervin_mod_1.util;

public class Cast<T> {
    private T cast;

    public Cast() {}

    public Cast(T cast) {
        this.cast = cast;
    }

    public T get() {
        return this.cast;
    }

    public void set(T cast) {
        this.cast = cast;
    }

    @SuppressWarnings("unchecked")
    public T cast(Object object) {
        return (T) object;
    }

    public T cast() {
        return cast(this.cast);
    }
}
