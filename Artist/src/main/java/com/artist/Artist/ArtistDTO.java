package com.artist.Artist;

import java.text.ParseException;
import java.time.LocalDate;


public class ArtistDTO {
    private String name;
    private String type;
    private String numberOfMusical;
    private String start;
    private String end;
    private String movie;


    public ArtistDTO() {
    }


    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
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
    return LocalDate.parse(end);
    }

    public void setEnd(String end) {
        this.end = end;
    }
}
