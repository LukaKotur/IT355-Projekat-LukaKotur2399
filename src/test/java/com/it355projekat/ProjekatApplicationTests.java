package com.it355projekat;

import com.it355projekat.Model.Film;
import com.it355projekat.Model.Serija;
import com.it355projekat.Model.Zanr;
import com.it355projekat.Repository.FilmRepository;
import com.it355projekat.Repository.SerijaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProjekatApplicationTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private SerijaRepository serijaRepository;

    @Test
    public void testFilmJPA() throws Exception {
        this.entityManager.persist(new Film("noon", 1992));
        List<Film> film = this.filmRepository.findByNazivIgnoreCase("noon");
        assertThat(film.get(0).getNaziv()).isEqualTo("noon");
        assertThat(film.get(0).getGodina()).isEqualTo(1992);
    }

    @Test
    public void testSerijaJPA() throws Exception {
        this.entityManager.persist(new Serija("moon", 1993));
        List<Serija> serija = this.serijaRepository.findByNazivIgnoreCase("moon");
        assertThat(serija.get(0).getNaziv()).isEqualTo("moon");
        assertThat(serija.get(0).getGodina()).isEqualTo(1993);
    }

    @Test
    public void testZanrCreate() throws Exception {
        Zanr zanr = new Zanr("Horor");

        assertThat(zanr.getNaziv().equals("Horror"));
    }

    @Test
    public void testFilmCreate() throws Exception {
        Zanr zanr = new Zanr("Horor");

        Film film = new Film("bal", 1995, 10, 240, "imdb", zanr);

        assertThat(film.getNaziv().equalsIgnoreCase("bla"));

        assertThat(film.getImdbLink().equalsIgnoreCase("imdb"));

        assertThat(film.getGodina() == 1995);

        assertThat(film.getOcena() == 10);

        assertThat(film.getTrajanje() == 240);

        assertThat(film.getZanrFilm().getNaziv().equals("Horor"));
    }

    @Test
    public void testSerijaCreate() throws Exception {
        Zanr zanr = new Zanr("Horor");

        Serija serija = new Serija("bal", 1995, 10, 240, "imdb", 20, zanr);

        assertThat(serija.getNaziv().equalsIgnoreCase("bla"));

        assertThat(serija.getImdbLink().equalsIgnoreCase("imdb"));

        assertThat(serija.getGodina() == 1995);

        assertThat(serija.getOcena() == 10);

        assertThat(serija.getTrajanje() == 240);

        assertThat(serija.getZanrSerija().getNaziv().equals("Horor"));
    }



}
