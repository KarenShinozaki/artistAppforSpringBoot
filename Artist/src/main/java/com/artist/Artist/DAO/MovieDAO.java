package com.artist.Artist.DAO;

import com.artist.Artist.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MovieDAO {

    @Autowired
    private JdbcTemplate template;

    public List<Movie> findAll() {
        //SQL定義
        String sql = "select * from movies";
        //SQL実行
        SqlRowSet rs = template.queryForRowSet(sql);
        //結果反映
        List<Movie> list = new ArrayList<>();
        while (rs.next()) {

            list.add(new Movie(rs.getInt("id"),
                    rs.getString("title"),
                    rs.getInt("artist_id")));
        }
        return list;
    }

    public Movie findDetails(int movieId){

        String sql = "SELECT id, title, artist_id FROM movies WHERE id =?";
        Map<String,Object> result = template.queryForMap(sql,movieId);
        Movie movie = new Movie();
        movie.setId((int)result.get("id"));
        movie.setTitle((String)result.get("title"));
        movie.setArtistId((int)result.get("artist_id"));
        return movie;
    }
}
