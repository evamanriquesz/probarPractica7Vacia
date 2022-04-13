package com.evamanrique.probarPractica7Vacia.service;

import com.evamanrique.probarPractica7Vacia.model.Dispositivo;

import java.util.Optional;

public interface StockService {
    Iterable<Dispositivo> retrieveDispositivos(String existencias);
    Dispositivo updateDispositivo(String id, Dispositivo dispositivo);
   // Dispositivo createDispositivo(Dispositivo dispositivo);
    void deleteDispositivo(String id);
    Dispositivo retrieveDispositivo(String id);
}
