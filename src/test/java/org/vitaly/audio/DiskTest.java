package org.vitaly.audio;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Created by vitaly on 2017-02-24.
 */
public class DiskTest {
    @Test
    public void doBurnDisk() throws Exception {
        Song song1 = Song.doRecordSong("Saint Veronika", "punk rock", 249_000L, 320, "Billy Talent");
        Song song2 = Song.doRecordSong("Road Runner", "rockabilly", 185_000L, 320, "Imelda May");
        Song song3 = Song.doRecordSong("Vengeful One", "hard rock", 252_000L, 320, "Disturbed");
        List<Song> songs = new ArrayList<>();
        Collections.addAll(songs, song1, song2, song3);

        Disk actual = Disk.doBurnDisk("Random", songs);

        assertNotNull(actual);
    }

    @Test
    public void getDiskLength() throws Exception {
        long songLength = 252_000L;
        Song song = Song.doRecordSong("Vengeful One", "hard rock", songLength, 320, "Disturbed");
        List<Song> songs = new ArrayList<>();
        songs.add(song);
        songs.add(song);
        songs.add(song);

        long actual = Disk.doBurnDisk("RandomDom", songs).getDiskLength();

        long expected = songLength * 3;
        assertThat(actual, equalTo(expected));
    }

    @Test(expected = IllegalArgumentException.class)
    public void doBurnDiskWithNullNameShouldThrowException() throws Exception {
        Song song1 = Song.doRecordSong("Saint Veronika", "punk rock", 249_000L, 320, "Billy Talent");
        Song song2 = Song.doRecordSong("Road Runner", "rockabilly", 185_000L, 320, "Imelda May");
        Song song3 = Song.doRecordSong("Vengeful One", "hard rock", 252_000L, 320, "Disturbed");
        List<Song> songs = new ArrayList<>();
        Collections.addAll(songs, song1, song2, song3);

        Disk.doBurnDisk(null, songs);
    }

    @Test(expected = IllegalArgumentException.class)
    public void doBurnDiskWithNullSongListShouldThrowException() throws Exception {
        Disk.doBurnDisk("Another", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void doBurnDiskWithTooLongSongsShouldThrowException() throws Exception {
        Song song = Song.doRecordSong("Saint Veronika", "punk rock", 249_000_000L, 320, "Billy Talent");
        List<Song> songs = new ArrayList<>();
        Collections.addAll(songs, song);

        Disk.doBurnDisk("Random", songs);
    }

    @Test(expected = IllegalArgumentException.class)
    public void doBurnDiskWithTooLargeSongsShouldThrowException() throws Exception {
        Song song = Song.doRecordSong("Road Runner", "rockabilly", 185_000L, 320_000_000, "Imelda May");
        List<Song> songs = new ArrayList<>();
        Collections.addAll(songs, song);

        Disk.doBurnDisk("Random", songs);
    }
}