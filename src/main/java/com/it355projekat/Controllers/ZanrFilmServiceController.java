package com.it355projekat.Controllers;

import com.it355projekat.Model.Zanr;
import com.it355projekat.Repository.FilmZanrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Luka on 09/01/2017.
 */
@RestController
public class ZanrFilmServiceController {
    @Autowired
    private FilmZanrRepository repository;


    @RequestMapping(value = "/zanrovi/create/{zanr}", method = RequestMethod.POST)
    @ResponseBody
    public String createZanr(@PathVariable("zanr") String zanr) {
        Zanr zanrElement = new Zanr(zanr);
        try {
            repository.save(zanrElement);
        } catch (Exception e) {
            return e.getMessage();
        }
        String msg = "{\"poruka\": \"Sacuvan zanr " + zanrElement.getNaziv() + ", id: " + zanrElement.getId() + "\"}";
        System.out.println(msg);
        return msg;
    }

    @RequestMapping("/zanrovi/{id}")
    @ResponseBody
    public Zanr readZanr(@PathVariable("id") Long id) {
        Zanr zanr;
        try {
            zanr = repository.findOne(id);
        } catch (Exception e) {
            return new Zanr(0, "Nije pronadjen");
        }

        if (zanr == null) {
            String errorMsg = "Nema zanr koji ima id " + id;

            return new Zanr(0, "Nije pronadjen");
        } else {
            return zanr;
        }
    }

    @RequestMapping("/zanrovi/edit/{id}/{zanrexp}")
    @ResponseBody
    public Zanr editZanr(@PathVariable("id") Long id, @PathVariable("zanrexp") String exp) {
        Zanr zanrFilm;
        try {
            zanrFilm = repository.findOne(id);
        } catch (Exception e) {
            return new Zanr("Nije pronadjen");
        }

        if (zanrFilm == null) {
            String errorMsg = "Nema pronadjenih za id" + id;
            return new Zanr("Nije pronadjen");
        } else {
            zanrFilm.setNaziv(exp);
            repository.save(zanrFilm);
            return zanrFilm;
        }
    }

    @RequestMapping("/zanrovi")
    public List<Zanr> getAllZanrovi() {
        List<Zanr> zanrovi = (List) repository.findAll();
        return zanrovi;
    }

    @RequestMapping("/zanrovi/delete/{id}")
    @ResponseBody
    public String deleteZanr(@PathVariable Long id) {
        try {
            repository.delete(id);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "{\"poruka\": \"Obrisan zanr sa id: " + id + "\"}";
    }

}
