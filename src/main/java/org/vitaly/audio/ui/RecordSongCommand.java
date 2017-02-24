package org.vitaly.audio.ui;

import org.vitaly.audio.Song;

import java.util.Scanner;

/**
 * Created by vitaly on 2017-02-24.
 */
public class RecordSongCommand implements Command {
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter song name : ");
        String songName = scanner.nextLine();

        System.out.println("Enter genre name : ");
        String genreName = scanner.nextLine();

        System.out.println("Enter song length(milliseconds) : ");
        Long songLength = Long.valueOf(scanner.nextLine());
        if (songLength <= 0) {
            System.out.println("Song length must be positive!");
            return;
        }

        System.out.println("Enter song kbps : ");
        Integer kbps = Integer.valueOf(scanner.nextLine());
        if (kbps <= 0) {
            System.out.println("Song kbps must be positive!");
            return;
        }

        System.out.println("Enter artist name : ");
        String artistName = scanner.nextLine();

        Gui.getSongs().add(Song.doRecordSong(songName, genreName, songLength, kbps, artistName));
    }
}
