package com.artist.Artist;

import jdk.jfr.DataAmount;
import org.springframework.data.relational.core.sql.In;

import javax.swing.text.html.Option;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Optional;

public class Artist {

    private int id;
    private String name;
    private String type;
    private int numberOfMusical;
    private LocalDate start;
    private LocalDate end;
    private Integer groupId;
    private Integer movieId;


    public Artist(int id, String name, String type, int numberOfMusical, LocalDate start, Integer movieId, Integer groupId) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.numberOfMusical = numberOfMusical;
        this.start = start;
        this.groupId = groupId;
        this.movieId = movieId;
    }

    public Artist(int id, String name, String type, int numberOfMusical, LocalDate start, Integer movieId, Integer groupId, LocalDate end) {
        this(id, name, type, numberOfMusical, start, groupId, movieId);
        this.end = end;
    }

    public Artist() {
    }

    public Artist(int id, String name, String type, int numberOfMusical, Date start, Date end) {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return this.name;
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

    public int getNumberOfMusical() {
        return this.numberOfMusical;
    }

    public void setNumberOfMusical(int numberOfMusical) {
        this.numberOfMusical = numberOfMusical;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public Optional<LocalDate> getEnd() {
        return Optional.ofNullable(this.end);
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }


    public Optional<Integer> getMovieId() {
        return Optional.ofNullable(this.movieId);
    }


    public Optional<Integer> getGroupId() {
        return Optional.ofNullable(this.groupId);
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public boolean isDied() {
        return this.getEnd().isPresent();
    }

    public boolean isAlive() {
        return !isDied();
    }


    public boolean isHasGroupId() {
        return this.getGroupId().isPresent();
    }

    public boolean isHasNotGroupId() {
        return !isHasGroupId();
    }

    public boolean isHasMovieId() {
        return this.getMovieId().isPresent();
    }

    public boolean isHasNotMovieId() {
        return !isHasMovieId();
    }

    public long getAge() {
        ZoneId defaultZone = ZoneId.of("Asia/Tokyo");
        return ChronoUnit.YEARS.between(start, this.getEnd().orElse(LocalDate.now()));
    }
}

