package org.vitaly.audio;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Created by vitaly on 2017-02-18.
 */
public class Song {
    private String name;
    private Genre genre;
    private LocalDate recordDate;
    private final long length;
    private final int kbps;
    private String artist;

    public Song(String name, Genre genre, LocalDate recordDate,
                long length, int kbps, String artist) {
        this.name = name;
        this.genre = genre;
        this.recordDate = recordDate;
        this.length = length;
        this.kbps = kbps;
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public Genre getGenre() {
        return genre;
    }

    public LocalDate getRecordDate() {
        return recordDate;
    }

    public long getLength() {
        return length;
    }

    public int getKbps() {
        return kbps;
    }

    public String getArtist() {
        return artist;
    }

    public static Song doRecordSong(String songName, String genreName, long length, int kbps, String artistName) {
        Objects.requireNonNull(songName, "Song name can't be null!");
        Objects.requireNonNull(genreName, "Genre name can't be null!");
        Objects.requireNonNull(artistName, "Artist name can't be null!");

        if (length <= 0) {
            throw new IllegalArgumentException("Song length can't be less than or equal to zero milliseconds!");
        }
        if (kbps <= 0) {
            throw new IllegalArgumentException("Kbps can't be less than or equal to zero!");
        }

        Genre.addGenre(genreName);
        return new Song(songName, Genre.getGenre(genreName), LocalDate.now(), length, kbps, artistName);
    }
}
