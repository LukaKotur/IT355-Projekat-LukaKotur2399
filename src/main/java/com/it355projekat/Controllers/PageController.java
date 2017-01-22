package com.it355projekat.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Luka on 09/01/2017.
 */

@Controller
public class PageController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homeStranica() {
        return "index";
    }

    @RequestMapping(value = "/filmoviIndex", method = RequestMethod.GET)
    public String filmoviStranica() {
        return "filmovi";
    }


    @RequestMapping(value = "/serijeIndex", method = RequestMethod.GET)
    public String serijeStranica() {
        return "serija";
    }


    @RequestMapping(value = "/addZanr", method = RequestMethod.GET)
    public String zanrStranica() {
        return "addzanr";
    }


    @RequestMapping(value = "/searchFilmovi", method = RequestMethod.GET)
    public String searchFilmove() {
        return "searchFilmovi";
    }

    @RequestMapping(value = "/searchSerije", method = RequestMethod.GET)
    public String searchSerije() {
        return "searchSerije";
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String errorStranica() {
        return "error";
    }

}
