package org.vitaly.audio;

import java.time.LocalDate;
import java.util.List;

import static org.vitaly.audio.util.Checker.requireLessThanOrEqualTo;
import static org.vitaly.audio.util.Checker.requireNonNull;

/**
 * Created by vitaly on 2017-02-18.
 */
public class Disk {
    public static final long MAX_LENGTH = 4_800_000;
    public static final long MAX_SIZE = 734_003_200;

    private String name;
    private LocalDate burnDate;
    private List<Song> songs;

    private Disk(String name, LocalDate burnDate, List<Song> songs) {
        this.name = name;
        this.burnDate = burnDate;
        this.songs = songs;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBurnDate() {
        return burnDate;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public long getDiskLength() {
        long cdLength = 0;
        for (Song song : songs) {
            cdLength += song.getLength();
        }
        return cdLength;
    }

    public static Disk doBurnDisk(String name, List<Song> songs) {
        requireNonNull(name, "Disk name can't be null!");
        requireNonNull(songs, "List of songs can't be null!");

        long totalLength = 0;
        for (Song song : songs) {
            totalLength += song.getLength();
        }
        requireLessThanOrEqualTo(totalLength, MAX_LENGTH, "Total song length is greater than 80 minutes!");

        long totalSize = 0;
        for (Song song : songs) {
            totalSize += song.getLength() / 1000 * song.getKbps();
        }
        requireLessThanOrEqualTo(totalSize, MAX_SIZE, "Total song size is greater than 700 megabytes!");

        return new Disk(name, LocalDate.now(), songs);
    }
}
