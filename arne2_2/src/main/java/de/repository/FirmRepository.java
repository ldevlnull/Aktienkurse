package de.repository;

import de.pojo.Firm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by devnull on 17.01.17.
 */
@Repository
public interface FirmRepository extends JpaRepository<Firm, Long> {

    @Query("select f from Firm f where f.konzurn_s2 != -1")
    List<Firm> getKriterium1();

    @Query("select f from Firm f where f.konzurn_s2 != -1 and f.tiefstand_s4 != 'n/a'")
    List<Firm> getKriterium2();

    @Query("select f from Firm f where f.konzurn_s2 != -1 and f.tiefstand_s4 != 'n/a' and f.kriterium3_s5 != 'n/a'")
    List<Firm> getKriterium3();

    @Query("select f from Firm f where f.konzurn_s2 != -1 and f.tiefstand_s4 != 'n/a' and f.kriterium3_s5 != 'n/a' and f.dividende_k5_s10 != 'n/a'")
    List<Firm> getKriterium5();

}
