package org.vitaly.audio;

import java.util.HashMap;
import java.util.Map;

import static org.vitaly.audio.util.Checker.GENRE_NAME_NOT_NULL;
import static org.vitaly.audio.util.Checker.requireNonNull;

/**
 * Created by vitaly on 2017-02-23.
 */
public class Genre {
    private static final Map<String, Genre> genres = new HashMap<>();

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

    public static Map<String, Genre> getAllGenres() {
        return genres;
    }

    public static void addGenre(String genreName) {
        requireNonNull(genreName, GENRE_NAME_NOT_NULL);
        genres.put(genreName.toLowerCase().trim(), new Genre(genreName.toLowerCase().trim()));
    }

    @Override
    public String toString() {
        return "Genre{" +
                "name='" + name + '\'' +
                '}';
    }
}
