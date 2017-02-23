package org.vitaly.audio;

import java.time.LocalDate;

import static org.vitaly.audio.util.Checker.GENRE_NAME_NOT_NULL;
import static org.vitaly.audio.util.Checker.requireNonNull;
import static org.vitaly.audio.util.Checker.requirePositive;

/**
 * Created by vitaly on 2017-02-18.
 */
public class Song {
    private String name;
    private Genre genre;
    private LocalDate recordDate;
    private final Long length;
    private final Integer kbps;
    private String artist;

    private Song(String name, Genre genre, LocalDate recordDate,
                 Long length, Integer kbps, String artist) {
        this.name = name;
        this.genre = genre;
        this.recordDate = recordDate;
        this.length = length;
        this.kbps = kbps;
        this.artist = artist;
    }

    public Genre getGenre() {
        return genre;
    }

    public Long getLength() {
        return length;
    }

    public Integer getKbps() {
        return kbps;
    }

    public static Song doRecordSong(String songName, String genreName, Long length, Integer kbps, String artistName) {
        requireNonNull(songName, "Song name can't be null!");
        requireNonNull(genreName, GENRE_NAME_NOT_NULL);
        requireNonNull(artistName, "Artist name can't be null!");
        requirePositive(length, "Song length can't be less than or equal to zero milliseconds!");
        requirePositive(kbps, "Kbps can't be less than or equal to zero!");

        Genre.addGenre(genreName);
        return new Song(songName, Genre.getGenre(genreName), LocalDate.now(), length, kbps, artistName);
    }

    @Override
    public String toString() {
        return "Song{" +
                "name='" + name + '\'' +
                ", genre=" + genre.getName() +
                ", recordDate=" + recordDate +
                ", length=" + length +
                ", kbps=" + kbps +
                ", artist='" + artist + '\'' +
                '}';
    }
}
