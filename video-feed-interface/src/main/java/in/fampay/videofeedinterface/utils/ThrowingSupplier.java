package in.fampay.videofeedinterface.utils;

import java.util.function.Supplier;

import lombok.SneakyThrows;

public interface ThrowingSupplier<T, E extends Throwable> {

    T get() throws E;

    @SneakyThrows
    static <T, E extends Throwable> T safeGet(ThrowingSupplier<T, E> supplier) {
        return supplier.get();
    }

    static <T, E extends Throwable> Supplier<T> unchecked(ThrowingSupplier<T, E> supplier) {
        return () -> safeGet(supplier);
    }
}
