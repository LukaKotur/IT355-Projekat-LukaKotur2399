package com.it355projekat.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

/**
 * Created by Luka on 09/01/2017.
 */

@Entity
@Table(name = "film")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String naziv;

    private int godina;

    private int ocena;


    private int trajanje;

    @Column(name = "imdb_link")
    private String imdblink;



    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "zanr_id", referencedColumnName = "ID")
    @JsonProperty("zanr")
    private Zanr zanrFilm;

    public Film() {
    }

    public Film(String naziv, int godina) {
        this.naziv = naziv;
        this.godina = godina;
    }

    public Film(String naziv, int godina, int ocena, int trajanje, String imdblink) {
        this.naziv = naziv;
        this.godina = godina;
        this.ocena = ocena;
        this.trajanje = trajanje;
        this.imdblink = imdblink;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(int trajanje) {
        this.trajanje = trajanje;
    }

    public String getImdbLink() {
        return imdblink;
    }

    public void setImdbLink(String imdbLink) {
        this.imdblink = imdbLink;
    }

    public int getGodina() {
        return godina;
    }

    public void setGodina(int godina) {
        this.godina = godina;
    }

    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }

    public Zanr getZanrFilm() {
        return zanrFilm;
    }

    public void setImdblink(String imdblink) {
        this.imdblink = imdblink;
    }

    public void setZanrFilm(Zanr zanrFilm) {
        this.zanrFilm = zanrFilm;
    }

    public Film(String naziv, int godina, int ocena, int trajanje, String imdblink, Zanr zanrFilm) {
        this.naziv = naziv;
        this.godina = godina;
        this.ocena = ocena;
        this.trajanje = trajanje;
        this.imdblink = imdblink;
        this.zanrFilm = zanrFilm;
    }
}