package com.it355projekat.Repository;

import com.it355projekat.Model.Film;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Luka on 09/01/2017.
 */
public interface FilmRepository extends CrudRepository<Film, Long> {

    List<Film> findByGodinaLessThan(int godina);

    List<Film> findByNazivIgnoreCase(String naziv);

    List<Film> findByGodina(int godina);

    List<Film> findByOcena(int ocena);

    List<Film> findByNazivIgnoreCaseContaining(String naziv);
}
