package com.it355projekat.Controllers;

import com.it355projekat.Model.Film;
import com.it355projekat.Repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Luka on 09/01/2017.
 */

@RestController
public class FilmServiceController {
    @Autowired
    private FilmRepository repository;


    @RequestMapping(value = "/filmovi/create", method = RequestMethod.POST)
    @ResponseBody
    public String createFilm(@RequestBody Film film) {
        try {
            repository.save(film);
        } catch (Exception e) {
            return e.getMessage();
        }
        String msg = "{\"poruka:\": \"Sacuvan film sa nazivom: " + film.getNaziv() + ", godina: " + film.getGodina() + ", zanrID: " + "\"}";
        System.out.println(msg);
        return msg;
    }

    @RequestMapping("/filmovi/{id}")
    @ResponseBody
    public Film getFilm(@PathVariable("id") Long id) {
        Film film;
        try {
            film = repository.findOne(id);
        } catch (Exception e) {
            return new Film("Nije pronadjen", 0);
        }

        if (film == null) {
            String errorMsg = "Nije pronadjen film sa id " + id;

            return new Film("Nije pronadjen", 0);
        } else {
            return film;
        }
    }

    @RequestMapping("/filmovi/edit")
    @ResponseBody
    public Film editFilm(@RequestBody Film film) {
        if (film == null) {
            return new Film("Nije pronadjen", 0);
        } else {
            repository.save(film);
            return film;
        }
    }

    @RequestMapping("/filmovi")
    public List<Film> getAllFilmovi() {
        List<Film> filmovi = (List) repository.findAll();
        return filmovi;
    }

    @RequestMapping("/filmovi/delete/{id}")
    @ResponseBody
    public String deleteFilm(@PathVariable Long id) {
        try {
            repository.delete(id);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "{\"poruka\": \"Obrisan film sa id " + id + "\"}";
    }


    @RequestMapping("/filmovi/findByNazivIgnoreCaseContaining")
    public List<Film> findByNazivIgnoreCaseContaining(@RequestParam(value = "naziv") String naziv) {
        return repository.findByNazivIgnoreCaseContaining(naziv);
    }

    @RequestMapping("/filmovi/findByOcena")
    public List<Film> findByOcena(@RequestParam(value = "ocena") int ocena) {
        return repository.findByOcena(ocena);
    }
}
