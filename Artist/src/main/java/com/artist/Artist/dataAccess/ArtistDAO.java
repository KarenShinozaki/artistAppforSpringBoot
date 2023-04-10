package com.artist.Artist.dataAccess;

import com.artist.Artist.bussinessLogic.Artist;
import com.artist.Artist.bussinessLogic.ArtistService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ArtistDAO {
    private static final Logger logger = LoggerFactory.getLogger(ArtistDAO.class);
    @Autowired
    private JdbcTemplate template;

    public List<Artist> findAll() {
        String sql = "select * from artists";
        List<Artist> listArtist = template.query(sql, new BeanPropertyRowMapper<Artist>(Artist.class));
        return listArtist;
    }

    public Artist findDetail(int artistId){
        String sql = "SELECT * FROM artists WHERE id =?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<Artist>(Artist.class),artistId);
    }

    public List<Artist> getGroupMembers(int groupId){
        String  sql = "select * from artists where group_id = ?";
        RowMapper<Artist> rowMapper = new BeanPropertyRowMapper<Artist>(Artist.class);
        return template.query(sql, rowMapper, groupId);
    }

    public int save(Artist artist) {
        String sql = "insert into Artists(type,name,number_of_musical,start,end) values(?,?,?,?,?)";
        template.update(sql,artist.getType(),artist.getName(),artist.getNumberOfMusical(),artist.getStart(),artist.getEnd().orElse(null));
        return template.queryForObject("select last_insert_id()",Integer.class);
    }

    public void update(Artist artist){
        String sql = "UPDATE artists SET type = ? ,name = ? , number_of_musical =?, start = ? , end=? WHERE id = ?";
        int aaa= template.update(sql,artist.getType(),artist.getName(),artist.getNumberOfMusical(),artist.getStart(),artist.getEnd().orElse(null),artist.getId());
        logger.info("update records={} id={}",aaa,artist.getId());
    }


    @Deprecated
    public Artist getGroupFromRelatedMember(int id){
        String sql = "SELECT * FROM artists WHERE id = (SELECT group_id FROM artists WHERE id = ?)";
        List<Artist> aaa= template.query(sql,new BeanPropertyRowMapper<Artist>(Artist.class),id);
        if(aaa.isEmpty()){
            return null;
        }
       return aaa.get(0);
    }






}
