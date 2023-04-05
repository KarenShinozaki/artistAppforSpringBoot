package com.artist.Artist.service;
import com.artist.Artist.*;
import com.artist.Artist.DAO.ArtistDAO;
import com.artist.Artist.DAO.MovieDAO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.*;

@Service
public class ArtistService {

    @Autowired
    private ArtistDAO dao;
    @Autowired
    private MovieDAO moviedao;


    public boolean isSoloArtist() {
        return true;
    }

    public List<Artist> getAll() {
        List<Artist> artistList = dao.findAll();
        return artistList;
    }

    public Artist getDetail(int id){
        Artist artistDetail = dao.findDetail(id);
        return artistDetail;
    }

    public List<Artist> getArtistListByGroupId(int groupId){
        List<Artist> groupHasAArtists = dao.getGroupMembers(groupId);
        return groupHasAArtists;
    }

    @Transactional
    public void create(ArtistDTO artistDTO) {
       int artistId = dao.save(createArtist(artistDTO));
        if(StringUtils.isNotBlank(artistDTO.getMovie())){
            Movie movie = new Movie();
            movie.setTitle(artistDTO.getMovie());
            movie.setArtistId(artistId);
            moviedao.save(movie);
        }
    }

    public Artist createArtist(ArtistDTO artistDTO) {
        Artist artist = new Artist();
        artist.setType(artistDTO.getType());
        artist.setName(artistDTO.getName());
        artist.setNumberOfMusical(artistDTO.getIntNumberOfMusical());
        artist.setStart(artistDTO.getDateStart());
        artist.setEnd(artistDTO.getDateEnd());
        return artist;
    }
}
