package com.evamanrique.probarPractica7Vacia.service.implementation;

import com.evamanrique.probarPractica7Vacia.model.Dispositivo;
import com.evamanrique.probarPractica7Vacia.repository.StockRepository;
import com.evamanrique.probarPractica7Vacia.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StockServiceImplementation implements StockService {

    @Autowired
    private StockRepository stockRepository;

    @Override
     public Iterable<Dispositivo> retrieveDispositivos(String existencias) {
         if(existencias==null)
         {
             return stockRepository.findAll();

         }else {
             int existenciasInt = Integer.parseInt(existencias);
             return stockRepository.retrieveDispositivoByExistencias(existenciasInt);
         }
    }

    //esto me sirve para actualizar las existenicias
    @Override
    public Dispositivo updateDispositivo(String id, Dispositivo dispositivo)
    {
        if(stockRepository.existsById(id))
        {
            return stockRepository.save(dispositivo); //para no actualizar un dispositivo que no exista
        }else{
            return null;
        }

    }

    /*
    //para crear un dispositivo nuevo
    @Override
    public Dispositivo createDispositivo(Dispositivo dispositivo)
    {
        return stockRepository.createDispositivo(dispositivo.getId(), dispositivo.getModelo(), dispositivo.getColor(), dispositivo.getExistencias());
    }
     */

    @Override
    public void deleteDispositivo(String id)
    {
        stockRepository.deleteById(id);
    }

    @Override
    public Dispositivo retrieveDispositivo(String id)
    {
        Dispositivo respuesta = null;
        if(stockRepository.existsById(id)) {
           Iterable<Dispositivo> dispositivos =  stockRepository.retrieveDispositivo(id);

           for (Dispositivo dispositivo: dispositivos)
           {
              respuesta=dispositivo;
           }
        }
        return respuesta;
    }

}
