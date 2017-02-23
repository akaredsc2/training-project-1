package org.vitaly.audio;

import java.util.Comparator;
import java.util.Iterator;

/**
 * Created by vitaly on 2017-02-23.
 */
public class DiskPlayer {
    private Disk disk;
    private Iterator<Song> playlist;

    private DiskPlayer() {
    }

    public boolean hasDisk() {
        return disk != null;
    }

    public void setDisk(Disk disk) {
        this.disk = disk;
        this.playlist = null;
    }

    public long getTotalLength() {
        long result = 0;
        for (Song song : disk.getSongs()) {
            result += song.getLength();
        }
        return result;
    }

    public void sortSongsByGenre() {
        disk.getSongs().sort(Comparator.comparingInt(x -> x.getGenre().getName().hashCode()));
    }

    public void prepareToPlay() {
        playlist = disk.getSongs().iterator();
    }

    public String playNext() {
        if (playlist.hasNext()) {
            Song song = playlist.next();
            return "Now playing : " + song.toString();
        } else if (disk.getSongs().size() > 0) {
            prepareToPlay();
            playNext();
        }
        return "Disk is empty";
    }
}
