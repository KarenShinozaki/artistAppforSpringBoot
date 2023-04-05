package com.artist.Artist.service;

import com.artist.Artist.Movie;
import com.artist.Artist.DAO.MovieDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieDAO dao;
    @Autowired
    private JdbcTemplate template;

    public List<Movie> getAll() {
        List<Movie> movieList = dao.findAll();
        return movieList;
    }

    public List<Movie> getDetail(int id){
        List<Movie> movie = dao.findDetail(id);
        return movie;
    }

    @Deprecated
    public Movie getArtistHasAMovie(int id){
        Movie sortMovie = dao.sortMovie(id);
        return sortMovie;
    }
}
