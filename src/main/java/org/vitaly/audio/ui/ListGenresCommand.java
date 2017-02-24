package org.vitaly.audio.ui;

import org.vitaly.audio.Genre;

/**
 * Created by vitaly on 2017-02-24.
 */
public class ListGenresCommand implements Command {
    @Override
    public void execute() {
        for (String key : Genre.getAllGenres().keySet()) {
            System.out.println(Genre.getGenre(key));
        }
    }
}
