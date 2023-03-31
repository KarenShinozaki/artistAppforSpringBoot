package com.artist.Artist.DAO;

import com.artist.Artist.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.time.ZoneId;
import java.util.*;

@Repository
public class ArtistDAO {
    @Autowired
    private JdbcTemplate template;

    public List<Artist> findAll() {
        //SQL定義
        String sql = "select * from artists";
        //SQL実行
//        SqlRowSet rs = template.queryForRowSet(sql);
        List<Artist> query = template.query(sql, new BeanPropertyRowMapper<Artist>(Artist.class));
        return query;
        //結果反映
//        List<Artist> list = new ArrayList<>();
//        while(rs.next()) {
//
//            list.add(new Artist(rs.getInt("id"),
//                    rs.getString("name"),
//                    rs.getString("type"),
//                    rs.getInt("number_of_musical"),
//                    new Date(rs.getDate("start").getTime()),
//                    Optional.ofNullable(rs.getInt("group_id")).orElse(null),
//                    Optional.ofNullable(rs.getInt("movie_id")).orElse(null),
//                    Optional.ofNullable(rs.getDate("end")).map(e->new Date(e.getTime())).orElse(null)));
//        }
//        return list;
    }

    java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());
    public Artist findDetails(int artistId){

        String sql = "SELECT id,name,type,number_of_musical,start,end,group_id,movie_id FROM artists WHERE id =?";
        Artist a = template.queryForObject(sql, new BeanPropertyRowMapper<Artist>(Artist.class),artistId);
        return a;

       // Map<String,Object> result = template.queryForMap(sql,artistId);
//        Artist artist = new Artist();
//
//        artist.setId((int)result.get("id"));
//        artist.setName((String) result.get("name"));
//        artist.setType((String) result.get("type"));
//        artist.setNumberOfMusical((int) result.get("number_of_musical"));
//        artist.setStart(new java.util.Date(((Date)result.get("start")).getTime()));
//        artist.setEnd(Optional.ofNullable(((Date)result.get("end"))).map(e->new Date(e.getTime())).orElse(null));
//        artist.setGroupId((Integer) Optional.ofNullable(result.get("group_id")).orElse(null));
//        artist.setMovieId((Integer)Optional.ofNullable(result.get("movie_id")).orElse(null));
//        return artist;
    }
}
