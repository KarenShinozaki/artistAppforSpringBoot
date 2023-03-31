package com.artist.Artist;

public class Movie {
    private int id;
    private String title;
    private int artistId;

    public Movie(int id, String title, int artistId) {
        this.id = id;
        this.title = title;
        this.artistId = artistId;
    }

    public Movie() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }
}

