package com.example.demo.model;

import java.util.Date;

/**
 * Objeto que representa un fila de la tabal Películas
 */
public class Pelicula {
    private Integer id;
    private String titulo;
    private Date anio;
    private Double puntuacion;
    private String portada;
    
    public Pelicula(Integer id, String titulo, Date anio, Double puntuacion, String portada) {
        this.id = id;
        this.titulo = titulo;
        this.anio = anio;
        this.puntuacion = puntuacion;
        this.portada = portada;
    }

    
    /**
     * Constructor que solo recibe 3 parámetros
     * @param titulo
     * @param puntuacion
     * @param portada
     */
    public Pelicula(String titulo, Double puntuacion, String portada) {
        this.titulo = titulo;
        this.puntuacion = puntuacion;
        this.portada = portada;
    }



    public Pelicula(Integer id) {
        this.id = id;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getAnio() {
        return anio;
    }

    public void setAnio(Date anio) {
        this.anio = anio;
    }

    public Double getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Double puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    
}
