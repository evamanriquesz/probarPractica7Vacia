package com.evamanrique.probarPractica7Vacia.repository;

import com.evamanrique.probarPractica7Vacia.model.Dispositivo;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface StockRepository extends CrudRepository<Dispositivo, String> {
    @Query("SELECT * FROM STOCK WHERE STOCK.EXISTENCIAS= :existencias")
    public Iterable<Dispositivo> retrieveDispositivoByExistencias(int existencias);

    /*
    @Query("INSERT INTO STOCK VALUES (:id, :modelo, :color, :existencias)")
    public Dispositivo createDispositivo(String id, String modelo, String color, int existencias);
    */

    @Query("SELECT * FROM STOCK WHERE STOCK.ID = :id")
    public Iterable<Dispositivo> retrieveDispositivo(String id);

}
