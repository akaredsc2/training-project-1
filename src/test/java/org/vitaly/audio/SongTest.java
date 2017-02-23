package org.vitaly.audio;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

/**
 * Created by vitaly on 2017-02-23.
 */
public class SongTest {
    private String songName = "Killing Ground";
    private String genreName = "Power metal";
    private Long songLength = 264_000L;
    private Integer kbps = 320;
    private String artistName = "Sabaton";

    @Test
    public void doRecordSong() throws Exception {
        Song song = Song.doRecordSong(songName, genreName, songLength, kbps, artistName);

        assertThat(song, hasToString(allOf(
                not(containsString(genreName)),
                containsString(genreName.toLowerCase()),
                containsString(songName),
                containsString(artistName)
        )));
    }

    @Test(expected = IllegalArgumentException.class)
    public void doRecordSongWithNullSongNameShouldThrowException() throws Exception {
        Song.doRecordSong(null, genreName, songLength, kbps, artistName);
    }

    @Test(expected = IllegalArgumentException.class)
    public void doRecordSongWithNullGenreNameShouldThrowException() throws Exception {
        Song.doRecordSong(songName, null, songLength, kbps, artistName);
    }

    @Test(expected = IllegalArgumentException.class)
    public void doRecordSongWithZeroSongLengthShouldThrowException() throws Exception {
        Song.doRecordSong(songName, genreName, 0L, kbps, artistName);
    }

    @Test(expected = IllegalArgumentException.class)
    public void doRecordSongWithZeroKbpsShouldThrowException() throws Exception {
        Song.doRecordSong(songName, genreName, songLength, 0, artistName);
    }

    @Test(expected = IllegalArgumentException.class)
    public void doRecordSongWithNullArtistNameShouldThrowException() throws Exception {
        Song.doRecordSong(songName, genreName, songLength, kbps, null);
    }
}