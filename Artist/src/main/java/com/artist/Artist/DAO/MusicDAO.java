package com.artist.Artist.DAO;
import com.artist.Artist.Artist;
import com.artist.Artist.Music;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    public List<Music> findDetail(int id){
        String sql = "SELECT * FROM musics WHERE artist_id =?";
        return template.query(sql, new BeanPropertyRowMapper<Music>(Music.class),id);
    }
}
