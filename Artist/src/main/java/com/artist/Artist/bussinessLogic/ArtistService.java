package com.artist.Artist.bussinessLogic;

import com.artist.Artist.dataAccess.ArtistDAO;
import com.artist.Artist.dataAccess.ArtistDTO;
import com.artist.Artist.dataAccess.MovieDAO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class ArtistService {
    private static final Logger logger = LoggerFactory.getLogger(ArtistService.class);
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

    public Artist getDetail(int id) {
        Artist artistDetail = dao.findDetail(id);
        return artistDetail;
    }

    public List<Artist> getArtistListByGroupId(int groupId) {
        List<Artist> groupHasAArtists = dao.getGroupMembers(groupId);
        return groupHasAArtists;
    }

    public List<Artist> getSoloArtistList(){
        List<Artist> soloArtistList = dao.getSoloArtist();
        return soloArtistList;
    }

    @Transactional
    public void update(ArtistDTO artistDTO) {
        if (artistDTO.getId() != null) {
            logger.info("update Id={}",artistDTO.getId());
            dao.update(createArtist(artistDTO));
        } else {
            logger.info("insert");
            int artistId = dao.save(createArtist(artistDTO));
            if (StringUtils.isNotBlank(artistDTO.getMovie())) {
                Movie movie = new Movie();
                movie.setTitle(artistDTO.getMovie());
                movie.setArtistId(artistId);
                moviedao.save(movie);
            }
        }
    }

    @Transactional
    public void update2(ArtistDTO artistDTO,Artist selectMember) {
        if (artistDTO.getId() != null) {
            logger.info("update Id={}",artistDTO.getId());
            Artist setArtist = createArtist(artistDTO);
            dao.update2(setArtist,selectMember);
            dao.update(setArtist);
        } else {
            logger.info("insert");
            int artistId = dao.save(createArtist(artistDTO));
            if (StringUtils.isNotBlank(artistDTO.getMovie())) {
                Movie movie = new Movie();
                movie.setTitle(artistDTO.getMovie());
                movie.setArtistId(artistId);
                moviedao.save(movie);
            }
        }
    }


    public Artist createArtist(ArtistDTO artistDTO) {
        Artist artist = new Artist();
        if(artistDTO.getId()!=null) {
            artist.setId(artistDTO.getId());
        }
        artist.setType(artistDTO.getType());
        artist.setName(artistDTO.getName());
        artist.setNumberOfMusical(artistDTO.getIntNumberOfMusical());
        artist.setStart(artistDTO.getDateStart());
        artist.setEnd(artistDTO.getDateEnd());
        return artist;
    }


}
