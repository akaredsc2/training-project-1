package org.vitaly.audio;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by vitaly on 2017-02-24.
 */
public class GenreTest {
    @Test
    public void addGenre() throws Exception {
        String genreName = "psychobilly";

        Genre.addGenre("  " + genreName);
        String actualGenreName = Genre.getGenre(genreName + "  ").getName();

        assertThat(actualGenreName, equalTo(genreName));
    }

    @Test
    public void addSameGenreTwiceResultsInOneObject() throws Exception {
        String genreName1 = "Punk rock   ";
        String genreName2 = "   punk Rock";

        Genre.addGenre(genreName1);
        Genre.addGenre(genreName2);
        Genre actualGenre1 = Genre.getGenre(genreName1);
        Genre actualGenre2 = Genre.getGenre(genreName2);

        Genre expectedGenre = Genre.getGenre("punk rock");
        assertThat(actualGenre1, allOf(
                equalTo(expectedGenre),
                equalTo(actualGenre2)
        ));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addGenreNullNameShouldThrowException() throws Exception {
        Genre.addGenre(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getGenreNullNameShouldThrowException() throws Exception {
        Genre.getGenre(null);
    }
}