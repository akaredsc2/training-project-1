package org.vitaly.audio.util;

/**
 * Created by vitaly on 2017-02-23.
 */
public class Checker {
    public static final String GENRE_NAME_NOT_NULL = "Genre name can't be null!";

    private Checker() {
    }

    public static void requireLessThanOrEqualTo(long value, long max, String errorMessage) {
        if (value > max) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static void requirePositive(long value, String errorMessage) {
        if (value <= 0) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static void requireNonNull(Object object, String errorMessage) {
        if (object == null) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
