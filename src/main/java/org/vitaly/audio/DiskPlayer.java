package org.vitaly.audio;

import java.util.Comparator;
import java.util.Iterator;

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
}
