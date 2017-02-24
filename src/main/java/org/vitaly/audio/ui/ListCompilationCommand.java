package org.vitaly.audio.ui;

import org.vitaly.audio.Song;

import java.util.ArrayList;

/**
 * Created by vitaly on 2017-02-24.
 */
public class ListCompilationCommand implements Command {
    @Override
    public void execute() {
        ArrayList<Song> compilation = Gui.getCompilation();
        for (int i = 0, songsSize = compilation.size(); i < songsSize; i++) {
            Song song = compilation.get(i);
            System.out.println(i + ". " +song);
        }
    }
}
