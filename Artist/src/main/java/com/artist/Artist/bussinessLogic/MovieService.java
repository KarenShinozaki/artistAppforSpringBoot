package com.artist.Artist.bussinessLogic;

import com.artist.Artist.dataAccess.MovieDAO;
import com.artist.Artist.dataAccess.MovieDTO;
import com.artist.Artist.dataAccess.MusicDTO;
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
        List<Movie> movie = dao.findFromArtistId(id);
        return movie;
    }

    public void update(MovieDTO movieDTO){
        dao.save(createMovie(movieDTO));
    }

    public Movie createMovie(MovieDTO movieDTO) {
        Movie movie = new Movie();
        movie.setTitle(movieDTO.getTitle());
        movie.setArtistId(movieDTO.getArtist_id());
        return movie;
    }


    @Deprecated
    public Movie getArtistHasAMovie(int id){
        Movie sortMovie = dao.sortMovie(id);
        return sortMovie;
    }
}
