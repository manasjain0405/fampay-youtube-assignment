package in.fampay.videofeedinterface.utils;

import java.util.function.Consumer;

import lombok.SneakyThrows;

public interface ThrowingConsumer<T, E extends Throwable> {

    void accept(T t) throws E;

    @SneakyThrows
    static <T, E extends Throwable> void safeAccept(T t, ThrowingConsumer<T, E> consumer) {
        consumer.accept(t);
    }

    static <T, E extends Throwable> Consumer<T> unchecked(ThrowingConsumer<T, E> consumer) {
        return (t) -> safeAccept(t, consumer);
    }
}