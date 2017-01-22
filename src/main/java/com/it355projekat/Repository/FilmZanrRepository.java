package com.it355projekat.Repository;

import com.it355projekat.Model.Zanr;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Luka on 09/01/2017.
 */
public interface FilmZanrRepository extends CrudRepository<Zanr, Long> {

    List<Zanr> findByNazivIgnoreCaseContaining(String naziv);

}
