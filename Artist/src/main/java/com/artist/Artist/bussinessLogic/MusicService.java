package com.artist.Artist.bussinessLogic;


import com.artist.Artist.dataAccess.ArtistDTO;
import com.artist.Artist.dataAccess.MusicDAO;
import com.artist.Artist.dataAccess.MusicDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

    public List<Music> getDetail(int id){
        List<Music> music = dao.findFromArtistId(id);
        return music;
    }

    @Transactional
    public void update(MusicDTO musicDTO) {
        dao.save(createMusic(musicDTO));
    }

    public Music createMusic(MusicDTO musicDTO) {
        Music music = new Music();
        music.setMusicTitle(musicDTO.getMusicTitle());
        music.setGenre(musicDTO.getGenre());
        music.setArtistId(musicDTO.getArtist_id());
        return music;
    }
}
