package com.artist.Artist.service;
import com.artist.Artist.DAO.ArtistDAO;
import com.artist.Artist.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistService {

    @Autowired
    private ArtistDAO dao;
    @Autowired
    private JdbcTemplate template;

    public boolean isSoloArtist() {
        return true;
    }

    public List<Artist> getAll() {
        List<Artist> artistList = dao.findAll();
        return artistList;
    }

    public Artist getDetail(int id){
        Artist artist = dao.findDetails(id);
        return artist;
    }
}
