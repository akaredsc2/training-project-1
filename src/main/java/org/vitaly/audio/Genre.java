package org.vitaly.audio;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by vitaly on 2017-02-23.
 */
public class Genre {
    private static final Map<String, Genre> genres = new TreeMap<>();

    private String name;

    private Genre(String name) {
        this.name = name;
    }

    public static Set<String> getGenres() {
        return genres.keySet();
    }

    public String getName() {
        return name;
    }

    public static Genre getGenre(String genreName) {
        return genres.get(genreName);
    }

    public static void addGenre(String genreName) {
        genres.put(genreName, new Genre(genreName.toLowerCase()));
    }
}
