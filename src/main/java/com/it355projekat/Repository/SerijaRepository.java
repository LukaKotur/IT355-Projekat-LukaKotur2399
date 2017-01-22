package com.it355projekat.Repository;

import com.it355projekat.Model.Serija;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Luka on 09/01/2017.
 */
public interface SerijaRepository extends CrudRepository<Serija, Long> {

    List<Serija> findByGodinaLessThan(int godina);

    List<Serija> findByNazivIgnoreCase(String naziv);

    List<Serija> findByGodina(int godina);

    List<Serija> findByOcena(int ocena);

    List<Serija> findByOcenaLessThan(int ocena);

    List<Serija> findByOcenaGreaterThan(int ocena);

    List<Serija> findByNazivIgnoreCaseContaining(String naziv);
}
