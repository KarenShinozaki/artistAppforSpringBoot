package com.artist.Artist;


public class Music {
    private int id;
    private String musicTitle;
    private String genre;
    private Integer artistId;

    public Music(int id, String musicTitle, String genre, Integer artistId) {
        this.id = id;
        this.musicTitle = musicTitle;
        this.genre = genre;
        this.artistId = artistId;
    }

    public Music() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMusicTitle() {
        return musicTitle;
    }

    public void setMusicTitle(String musicTitle) {
        this.musicTitle = musicTitle;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getArtistId() {
        return artistId;
    }

    public void setArtistId(Integer artistId) {
        this.artistId = artistId;
    }
}