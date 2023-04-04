package com.artist.Artist;

import java.sql.Date;
import java.util.Optional;


public class ArtistDTO {
    private String name;
    private String type;
    private int numberOfMusical;
    private Date start;
    private Date end;


    public ArtistDTO() {
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public int getNumberOfMusical() {
        return this.numberOfMusical;
    }

    public Date getStart() {
        return this.start;
    }

    public Optional<Date> getEnd() {
        return Optional.ofNullable(this.end);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setNumberOfMusical(int numberOfMusical) {
        this.numberOfMusical = numberOfMusical;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
}
