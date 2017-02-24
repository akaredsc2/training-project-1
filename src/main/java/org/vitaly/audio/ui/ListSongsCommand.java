package org.vitaly.audio.ui;

import org.vitaly.audio.Song;

import java.util.ArrayList;

/**
 * Created by vitaly on 2017-02-24.
 */
public class ListSongsCommand implements Command {
    @Override
    public void execute() {
        ArrayList<Song> songs = Gui.getSongs();
        for (int i = 0, songsSize = songs.size(); i < songsSize; i++) {
            Song song = songs.get(i);
            System.out.println(i + ". " + song);
        }
    }
}
