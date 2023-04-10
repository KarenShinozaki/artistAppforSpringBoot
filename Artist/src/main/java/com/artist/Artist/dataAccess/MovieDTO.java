package com.artist.Artist.dataAccess;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class MovieDTO {
    @NotBlank(message="タイトルを入力してください")
    private String title;
    @NotNull(message="制作アーティストを入力してください")
    private Integer artist_id;

    public MovieDTO() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getArtist_id() {
        return artist_id;
    }

    public void setArtist_id(Integer artist_id) {
        this.artist_id = artist_id;
    }
}
