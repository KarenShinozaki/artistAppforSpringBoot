package com.artist.Artist.presentation;

import com.artist.Artist.bussinessLogic.Artist;
import com.artist.Artist.bussinessLogic.ArtistService;
import com.artist.Artist.bussinessLogic.MusicService;
import com.artist.Artist.dataAccess.ArtistDTO;
import com.artist.Artist.dataAccess.MusicDAO;
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
public class MusicController {

    @Autowired
    private ArtistService artistService;
    @Autowired
    private MusicService musicService;


    @GetMapping("music_register")
    public String registerMusic(Model m) {
        List<Artist> artistList =artistService.getAll();
        m.addAttribute("musicDTO", new MusicDTO());
        m.addAttribute("artistList",artistList);
        return "musicRegister";
    }

    @PostMapping("music_create")
    public String createArtist(@ModelAttribute @Validated MusicDTO musicDTO, BindingResult error, Model m){
        if(error.hasFieldErrors()){
            List<Artist> artistList =artistService.getAll();
            m.addAttribute("artistList",artistList);
            return "musicRegister";
        }
        musicService.update(musicDTO);
        return "redirect:allArtist";
    }
}
