package com.artist.Artist;

import com.artist.Artist.DAO.ArtistDAO;
import com.artist.Artist.DAO.MovieDAO;
import com.artist.Artist.DAO.MusicDAO;
import com.artist.Artist.service.*;
import com.artist.Artist.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
public class ArtistController {
    @Autowired
    private ArtistDAO dao;
    @Autowired
    private ArtistService artistService;
    @Autowired
    private MovieDAO movieDAO;
    @Autowired
    private MovieService movieService;
    @Autowired
    private MusicDAO musicDAO;
    @Autowired
    private MusicService musicService;

    @RequestMapping("allArtist")
    public String allArtist(Model m) {
        List<Artist> artistAllList = artistService.getAll();
        m.addAttribute("artistAllList",artistAllList);

        return "allArtist";
    }

    @RequestMapping("artist_details")
    public String details(@RequestParam("id") int id, Model m) {
        Artist artistDetail = artistService.getDetail(id);
        List<Music> musics = musicService.getDetail(id);
        List<Movie> movies = movieService.getDetail(id);
        if(artistDetail.isHasGroupId()){
            Artist group = artistService.getDetail(artistDetail.getGroupId().get());
            m.addAttribute("group",group);
        }
        m.addAttribute("musics",musics);
        m.addAttribute("movies",movies);
        List<Artist> artistListByGroupId = artistService.getArtistListByGroupId(id);
        m.addAttribute("artistDetail",artistDetail);
        m.addAttribute("artistListByGroupId",artistListByGroupId);

        return "details";
    }


    @RequestMapping("artist_register")
    public String registerArtist(Model model) {
        model.addAttribute("artistDTO", new ArtistDTO());
        return "artistRegister";
    }
    @PostMapping("artist_create")
    public String createArtist(@ModelAttribute ArtistDTO artistDTO, Model m){
        artistService.create(artistDTO);
        return "redirect:allArtist";
    }
}
