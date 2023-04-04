package com.artist.Artist.DAO;

import com.artist.Artist.Artist;
import com.artist.Artist.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MovieDAO {

    @Autowired
    private JdbcTemplate template;

    public List<Movie> findAll() {
        String sql = "select * from movies";
        List<Movie> movieList = template.query(sql, new BeanPropertyRowMapper<Movie>(Movie.class));
        return movieList;
    }

    public Movie findDetail(int movieId){
        String sql = "SELECT * FROM movies WHERE id =?";
        Movie movie = template.queryForObject(sql, new BeanPropertyRowMapper<Movie>(Movie.class),movieId);
        return movie;
    }


    public Movie sortMovie(int id){
        String sql = "SELECT * FROM movies WHERE id = (SELECT id FROM movies WHERE artist_id =?)";
        Movie artistMovie = template.queryForObject(sql,new BeanPropertyRowMapper<Movie>(Movie.class),id);
        return artistMovie;
    }
}
