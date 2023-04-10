package com.artist.Artist.dataAccess;

import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.*;
import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.time.LocalDate;


public class ArtistDTO {
    private Integer id;
    @NotBlank(message = "名前を入力してください")
    private String name;
    @NotBlank(message = "アーティストタイプを入力してください")
    private String type;

    @Pattern(regexp = "\\d{1,}", message = "0以上の半角数字を指定してください")
    private String numberOfMusical;
    @NotBlank(message = "誕生日もしくは活動開始日を入力してください")
    private String start;
    private String end;
    private String movie;


    public ArtistDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumberOfMusical() {
        return numberOfMusical;
    }

    public int getIntNumberOfMusical(){
        return Integer.parseInt(numberOfMusical);
    }

    public void setNumberOfMusical(String numberOfMusical) {
        this.numberOfMusical = numberOfMusical;
    }

    public String getStart() {
        return start;
    }

    public LocalDate getDateStart() {
        return LocalDate.parse(start);
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public LocalDate getDateEnd() {
        if(!StringUtils.isNotEmpty(getEnd())){
            return null;
        }
    return LocalDate.parse(end);
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }
}
