package org.vitaly.audio;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertTrue;

/**
 * Created by vitaly on 2017-02-24.
 */
public class DiskPlayerTest {
    private Song song1;
    private Song song2;
    private Song song3;
    private Song song4;
    private DiskPlayer diskPlayer;
    private Disk disk;

    @Before
    public void setUp() throws Exception {
        song1 = Song.doRecordSong("Revenge Is Mine", "psychobilly", 184_000L, 320, "The Quakes");
        song2 = Song.doRecordSong("Road Runner", "rockabilly", 185_000L, 320, "Imelda May");
        song3 = Song.doRecordSong("Vengeful One", "hard rock", 252_000L, 320, "Disturbed");
        song4 = Song.doRecordSong("No Face", "psychobilly", 201_000L, 320, "The Quakes");
        List<Song> songs = new ArrayList<>();
        Collections.addAll(songs, song1, song2, song3, song4);
        disk = Disk.doBurnDisk("test disk", songs);
        diskPlayer = new DiskPlayer();
        diskPlayer.changeDisk(disk);
    }

    @Test
    public void setDisk() throws Exception {
        diskPlayer.changeDisk(disk);

        assertTrue(diskPlayer.hasDisk());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setNullDiskShouldThrowException() throws Exception {
        diskPlayer = new DiskPlayer();

        diskPlayer.changeDisk(null);
    }

    @Test
    public void sortSongsByGenre() throws Exception {
        diskPlayer.sortSongsByGenre();
        List<Song> actual = diskPlayer.getDisk().getSongs();

        List<Song> expected = new ArrayList<>(4);
        Collections.addAll(expected, song1, song2, song3, song4);
        expected.sort(Comparator.comparingInt(x -> x.getGenre().getName().hashCode()));

        assertThat(actual, equalTo(expected));
    }

    @Test
    public void playNext() throws Exception {
        diskPlayer.prepareToPlay();
        List<String> actualPlayedSongs = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            actualPlayedSongs.add(diskPlayer.playNext());
        }

        List<String> expectedPlayedSongs = new ArrayList<>();
        Collections.addAll(expectedPlayedSongs,
                "Now playing : " + song1.toString(),
                "Now playing : " + song2.toString(),
                "Now playing : " + song3.toString(),
                "Now playing : " + song4.toString(),
                "Now playing : " + song1.toString());
        assertThat(actualPlayedSongs, equalTo(expectedPlayedSongs));
    }

    @Test
    public void playNextOnEmptyDisk() throws Exception {
        diskPlayer.changeDisk(Disk.doBurnDisk("empty", new ArrayList<>()));

        diskPlayer.prepareToPlay();
        String actual = diskPlayer.playNext();

        String expected = "Disk is empty";
        assertThat(actual, equalTo(expected));
    }
}