package org.zosia.oasp.to;


import org.zosia.oasp.type.LiteraryGenre;

public class WriterTo extends AuthorTo {

    private LiteraryGenre genre;

    public LiteraryGenre getGenre() {
        return genre;
    }

    public void setGenre(LiteraryGenre genre) {
        this.genre = genre;
    }
}
