package com.artist.Artist.presentation;

import com.artist.Artist.bussinessLogic.Artist;
import com.artist.Artist.bussinessLogic.ArtistService;
import com.artist.Artist.bussinessLogic.MovieService;
import com.artist.Artist.dataAccess.MovieDTO;
import com.artist.Artist.dataAccess.MusicDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class MovieController {
    @Autowired
    private MovieService movieService;
    @Autowired
    private ArtistService artistService;

    @GetMapping("movie_register")
    public String registerMusic(Model m) {
        List<Artist> artistList = artistService.getAll();
        m.addAttribute("movieDTO", new MovieDTO());
        m.addAttribute("artistList",artistList);
        return "movieRegister";
    }

    @PostMapping("movie_create")
    public String createMovie(@ModelAttribute @Validated MovieDTO movieDTO, BindingResult error, Model m){
        if(error.hasFieldErrors()){
            List<Artist> artistList = artistService.getAll();
            m.addAttribute("artistList",artistList);
            return "movieRegister";
        }
        movieService.update(movieDTO);
        return "redirect:allArtist";
    }

}
