package in.fampay.videofeedinterface.utils;

import java.util.function.Function;

import lombok.SneakyThrows;

@FunctionalInterface
public interface ThrowingFunction<T, R, E extends Throwable> {

    R apply(T t) throws E;

    @SneakyThrows
    static <T, U, E extends Throwable> U safeApply(T t, ThrowingFunction<T, U, E> function) {
        return function.apply(t);
    }

    static <T, R, E extends Throwable> Function<T, R> unchecked(ThrowingFunction<T, R, E> function) {
        return (t) -> safeApply(t, function);
    }
}
