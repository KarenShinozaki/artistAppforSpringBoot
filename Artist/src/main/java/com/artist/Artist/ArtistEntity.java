//package com.artist.Artist;
//
//import org.springframework.data.annotation.Id;
//import org.springframework.data.relational.core.mapping.Table;
//
//import java.time.LocalDate;
//import java.sql.Date;
//@Table(name="artists")
//public class ArtistEntity {
//    @Id
//    private Integer id;
//    private String name;
//    private String type;
//    private int numberOfMusical;
//    private Date start;
//    private Date end;
//    private Integer groupId;
//    private Integer movieId;
//
//    public ArtistEntity() {
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public void setNumberOfMusical(int numberOfMusical) {
//        this.numberOfMusical = numberOfMusical;
//    }
//
//    public void setStart(Date start) {
//        this.start = start;
//    }
//
//    public void setEnd(Date end) {
//        this.end = end;
//    }
//
//    public void setGroupId(Integer groupId) {
//        this.groupId = groupId;
//    }
//
//    public void setMovieId(Integer movieId) {
//        this.movieId = movieId;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public int getNumberOfMusical() {
//        return numberOfMusical;
//    }
//
//    public Date getStart() {
//        return start;
//    }
//
//    public Date getEnd() {
//        return end;
//    }
//
//    public Integer getGroupId() {
//        return groupId;
//    }
//
//    public Integer getMovieId() {
//        return movieId;
//    }
//}
//
