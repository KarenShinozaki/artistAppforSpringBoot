package com.artist.Artist.service;


import com.artist.Artist.DAO.MusicDAO;
import com.artist.Artist.Music;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService {
    @Autowired
    private MusicDAO dao;
    @Autowired
    private JdbcTemplate template;

    public List<Music> getAll() {
        List<Music> musicList = dao.findAll();
        return musicList;
    }

    public Music getDetail(int id){
        Music music = dao.findDetails(id);
        return music;
    }
}
