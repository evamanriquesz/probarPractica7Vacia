package com.evamanrique.probarPractica7Vacia.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@Table("STOCK")
public class Dispositivo {
        @Id
        private String id;

        private String modelo;
        private String color;
        private int existencias;

        public String getId() {
                return id;
        }

        public void setId(String id) {
                this.id = id;
        }
        public String getModelo() {
                return modelo;
        }

        public void setModelo(String modelo) {
                this.modelo = modelo;
        }

        public String getColor() {
                return color;
        }

        public void setColor(String color) {
                this.color = color;
        }

        public int getExistencias() {
                return existencias;
        }

        public void setExistencias(int existencias) {
                this.existencias = existencias;
        }

}


