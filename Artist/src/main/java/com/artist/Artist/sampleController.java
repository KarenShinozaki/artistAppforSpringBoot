package com.artist.Artist;

import com.artist.Artist.DAO.ArtistDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class sampleController {
    @Autowired
    private ArtistDAO dao;

    @RequestMapping("/db01")
    public String db01(Model m) {
        List<Artist> products = dao.findAll();
        m.addAttribute("products", products);
        return "db01";
    }
}

