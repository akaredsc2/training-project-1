package org.vitaly.audio;

import java.util.Map;
import java.util.TreeMap;

import static org.vitaly.audio.util.Checker.GENRE_NAME_NOT_NULL;
import static org.vitaly.audio.util.Checker.requireNonNull;

/**
 * Created by vitaly on 2017-02-23.
 */
public class Genre {
    private static final Map<String, Genre> genres = new TreeMap<>();

    private String name;

    private Genre(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Genre getGenre(String genreName) {
        requireNonNull(genreName, GENRE_NAME_NOT_NULL);
        return genres.get(genreName.toLowerCase().trim());
    }

    public static void addGenre(String genreName) {
        requireNonNull(genreName, GENRE_NAME_NOT_NULL);
        genres.put(genreName.toLowerCase().trim(), new Genre(genreName.toLowerCase().trim()));
    }
}
