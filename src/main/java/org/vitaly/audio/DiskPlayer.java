package org.vitaly.audio;

import org.vitaly.audio.util.Checker;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import static org.vitaly.audio.util.Checker.*;
import static org.vitaly.audio.util.Checker.requireNonNull;

/**
 * Created by vitaly on 2017-02-23.
 */
public class DiskPlayer {
    private Disk disk;
    private Iterator<Song> playlist;

    public boolean hasDisk() {
        return disk != null;
    }

    public Disk getDisk() {
        return disk;
    }

    public void changeDisk(Disk disk) {
        requireNonNull(disk, "Disk can't be null!");
        this.disk = disk;
        prepareToPlay();
    }

    public void sortSongsByGenre() {
        disk.getSongs().sort(Comparator.comparingInt(x -> x.getGenre().getName().hashCode()));
        prepareToPlay();
    }

    public void prepareToPlay() {
        playlist = disk.getSongs().iterator();
    }

    public String playNext() {
        if (playlist.hasNext()) {
            Song song = playlist.next();
            return "Now playing : " + song.toString();
        } else if (!disk.getSongs().isEmpty()) {
            prepareToPlay();
            return playNext();
        }
        return "Disk is empty";
    }

    public List<Song> getSongWithLengthBetween(long lowerBound, long higherBound) {
        requirePositive(lowerBound, "Lower bound must be positive");
        requirePositive(higherBound, "Higher bound must be positive");
        List<Song> result = new ArrayList<>();
        for (Song song : disk.getSongs()) {
            long songLength = song.getLength();
            if (lowerBound <= songLength && songLength <= higherBound) {
                result.add(song);
            }
        }
        return result;
    }
}
