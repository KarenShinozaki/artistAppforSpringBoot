package com.artist.Artist.service;
import com.artist.Artist.ArtistEntity;
import com.artist.Artist.DAO.ArtistDAO;
import com.artist.Artist.Artist;
import com.artist.Artist.ArtistRepository;
import com.artist.Artist.ArtistDTO;
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
    ArtistRepository artistRepository;

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
        artistRepository.save(createUser(artistDTO));
    }

    public ArtistEntity createUser(ArtistDTO artistDTO) {
        ArtistEntity artistEntity = new ArtistEntity();
        artistEntity.setType(artistDTO.getType());
        artistEntity.setName(artistDTO.getName());
        artistEntity.setNumberOfMusical(artistDTO.getNumberOfMusical());
        artistEntity.setStart(artistDTO.getStart());
        artistEntity.setEnd(artistDTO.getEnd().orElse(null));
        return artistEntity;
    }
}
