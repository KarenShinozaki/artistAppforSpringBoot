package com.artist.Artist.presentation;

import com.artist.Artist.bussinessLogic.Artist;
import com.artist.Artist.bussinessLogic.ArtistService;
import com.artist.Artist.bussinessLogic.MovieService;
import com.artist.Artist.bussinessLogic.MusicService;
import com.artist.Artist.dataAccess.*;
import com.artist.Artist.bussinessLogic.Movie;
import com.artist.Artist.bussinessLogic.Music;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;
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
        m.addAttribute("artistAllList", artistAllList);

        return "allArtist";
    }

    @RequestMapping("artist_details")
    public String details(@RequestParam("id") int id, Model m) {
        Artist artistDetail = artistService.getDetail(id);
        List<Music> musics = musicService.getDetail(id);
        List<Movie> movies = movieService.getDetail(id);
        if (artistDetail.isHasGroupId()) {
            Artist group = artistService.getDetail(artistDetail.getGroupId().get());
            m.addAttribute("group", group);
        }
        m.addAttribute("musics", musics);
        m.addAttribute("movies", movies);
        List<Artist> artistListByGroupId = artistService.getArtistListByGroupId(id);
        m.addAttribute("artistDetail", artistDetail);
        m.addAttribute("artistListByGroupId", artistListByGroupId);

        return "details";
    }

    @RequestMapping("artist_register")
    public String registerArtist(Model model) {
        model.addAttribute("artistDTO", new ArtistDTO());
        return "artistRegister";
    }

    @PostMapping("artist_create")
    public String createArtist(@ModelAttribute @Validated ArtistDTO artistDTO, BindingResult error, Model m) {
        if (error.hasFieldErrors()) {
            return "artistRegister";
        }
        artistService.update(artistDTO);
        return "redirect:allArtist";
    }

    @GetMapping("artist_edit")
    public String artistEdit(Model m, @RequestParam("id") int id) {
        List<Artist> soloArtistList = artistService.getSoloArtistList();
        m.addAttribute("soloArtistList",soloArtistList);
        Artist artist = artistService.getDetail(id);
        ArtistDTO artistDTO = new ArtistDTO();
        artistDTO.setId(artist.getId());
        artistDTO.setType(artist.getType());
        artistDTO.setName(artist.getName());
        artistDTO.setNumberOfMusical(artist.getNumberOfMusical() + "");
        artistDTO.setStart(artist.getStart().format(DateTimeFormatter.ofPattern("uuuu-MM-dd")));
        artistDTO.setEnd(artist.getEnd().map(end -> end.format(DateTimeFormatter.ofPattern("uuuu-MM-dd"))).orElse(null));
        m.addAttribute("artist", artistDTO);
        return "artistEdit";
    }


    @PostMapping("artist_update")
    public String update(@ModelAttribute @Validated ArtistDTO artistDTO, BindingResult error,@RequestParam("id") int id,Model m) {
        if (error.hasFieldErrors()) {
            List<Artist> soloArtistList = artistService.getSoloArtistList();
            m.addAttribute("soloArtistList",soloArtistList);
            Artist artist = artistService.getDetail(id);
            m.addAttribute("artist", artistDTO);
            return "artistEdit";
        }
        Artist selectMember = artistService.getDetail(artistDTO.getMemberId());
        selectMember.setGroupId(id);
        artistService.update2(artistDTO,selectMember);
        return "redirect:allArtist";
    }
}
