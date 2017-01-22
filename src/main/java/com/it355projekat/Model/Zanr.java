package com.it355projekat.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by Luka on 09/01/2017.
 */
@Entity
@Table(name = "zanr")
public class Zanr implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String naziv;

    //    @ManyToMany(mappedBy = "filmZanrovi", fetch = FetchType.LAZY)


    @OneToMany(mappedBy = "zanrFilm", fetch = FetchType.EAGER)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIgnore
    private Set<Film> filmovi;

    @OneToMany(mappedBy = "zanrSerija", fetch = FetchType.EAGER)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIgnore
    private Set<Serija> serije;

    public Zanr() {
    }

    public Zanr(String zanrNaziv) {
        this.naziv = zanrNaziv;
    }

    public Zanr(long id, String zanrNaziv) {
        this.naziv = zanrNaziv;
        this.id = id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Set<Film> getFilmovi() {
        return filmovi;
    }

    public void setFilmovi(Set<Film> filmovi) {
        this.filmovi = filmovi;
    }

    public Set<Serija> getSerije() {
        return serije;
    }

    public void setSerije(Set<Serija> serije) {
        this.serije = serije;
    }
}
