package de.service;

import de.pojo.Firm;

import java.io.IOException;
import java.util.List;

/**
 * Created by devnull on 17.01.17.
 */
public interface FirmService {

    void save(Firm firm);
    Firm findOne(long id);
    List<Firm> findAll();
    void delete(long id);
    void updateData() throws IOException;
    List<Firm> getKriterium1();
    List<Firm> getKriterium2();
    List<Firm> getKriterium3();
    List<Firm> getKriterium5();

}