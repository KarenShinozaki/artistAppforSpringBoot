package com.artist.Artist.dataAccess;
import com.artist.Artist.bussinessLogic.Artist;
import com.artist.Artist.bussinessLogic.Music;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MusicDAO {
    @Autowired
    private JdbcTemplate template;

    public List<Music> findAll() {
        String sql = "select * from musics";
        SqlRowSet rs = template.queryForRowSet(sql);
        List<Music> list = new ArrayList<>();
        while (rs.next()) {

            list.add(new Music(rs.getInt("id"),
                    rs.getString("music_title"),
                    rs.getString("genre"),
                    rs.getInt("artist_id")));
        }
        return list;
    }

    public List<Music> findFromArtistId(int id){
        String sql = "SELECT * FROM musics WHERE artist_id =?";
        return template.query(sql, new BeanPropertyRowMapper<Music>(Music.class),id);
    }

    public void save(Music music){
        String sql = "insert into Musics(music_title,genre,artist_id) values(?,?,?)";
        template.update(sql,music.getMusicTitle(),music.getGenre(),music.getArtistId());
    }

}
