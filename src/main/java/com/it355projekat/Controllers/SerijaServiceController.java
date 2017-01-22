package com.it355projekat.Controllers;

import com.it355projekat.Model.Serija;
import com.it355projekat.Repository.SerijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Luka on 10/01/2017.
 */
@RestController
public class SerijaServiceController {
    @Autowired
    private SerijaRepository repository;


    @RequestMapping(value = "/serija/create", method = RequestMethod.POST)
    @ResponseBody
    public String createSerija(@RequestBody Serija serija) {
        try {
            repository.save(serija);
        } catch (Exception e) {
            return e.getMessage();
        }
        String msg = "{\"poruka:\": \"Sacuvana serija sa nazivom: " + serija.getNaziv() + ", godina: " + serija.getGodina() + ", id: " + serija.getGodina() + "\"}";
        return msg;
    }

    @RequestMapping("/serija/{id}")
    @ResponseBody
    public Serija getSerija(@PathVariable("id") Long id) {
        Serija serija;
        try {
            serija = repository.findOne(id);
        } catch (Exception e) {
            return new Serija("Nije pronadjen", 0);
        }

        if (serija == null) {
            String errorMsg = "Nije pronadjena serija sa id " + id;

            return new Serija("Nije pronadjen", 0);
        } else {
            return serija;
        }
    }

    @RequestMapping("/serija/edit")
    @ResponseBody
    public Serija editSerija(@RequestBody Serija serija) {
        if (serija == null) {
            return new Serija("Nije pronadjen", 0);
        } else {
            repository.save(serija);
            return serija;
        }
    }

    @RequestMapping("/serije")
    public List<Serija> getAllSerije() {
        List<Serija> serije = (List) repository.findAll();
        return serije;
    }

    @RequestMapping("/serija/delete/{id}")
    @ResponseBody
    public String deleteSerija(@PathVariable Long id) {
        try {
            repository.delete(id);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "{\"poruka\": \"Obrisana serija sa id " + id + "\"}";
    }

    @RequestMapping("/serija/findByNazivIgnoreCaseContaining")
    public List<Serija> findByNazivIgnoreCaseContaining(@RequestParam(name = "naziv") String naziv) {
        return repository.findByNazivIgnoreCaseContaining(naziv);
    }
}
