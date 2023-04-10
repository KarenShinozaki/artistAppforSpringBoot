package com.artist.Artist.dataAccess;

import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import static java.lang.Integer.parseInt;


public class MusicDTO {
    @NotBlank(message = "タイトルを入力してください")
    private String musicTitle;
    @NotBlank(message = "ジャンルを入力してください")
    private String genre;
    @NotNull(message = "歌手を選択してください")
    private Integer artist_id;
    public MusicDTO() {
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

    public Integer getArtist_id() {
        return artist_id;
    }

    public void setArtist_id(Integer artist_id) {
        this.artist_id = artist_id;
    }

}
