/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio7.pkg1;

import java.io.Serializable;

/**
 *
 * @author Alberto Real
 */
public class Pelicula implements Serializable {

    private String nombre;
    private String publicacion;
    private String director;
    private String duracion;
    private String sinopsis;
    private String reparto;
    private String session;

    public Pelicula() {
    }

    public Pelicula(String nombre, String publicacion, String director, String duracion, String sinopsis, String reparto, String session) {
        this.nombre = nombre;
        this.publicacion = publicacion;
        this.director = director;
        this.duracion = duracion;
        this.sinopsis = sinopsis;
        this.reparto = reparto;
        this.session = session;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(String publicacion) {
        this.publicacion = publicacion;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getReparto() {
        return reparto;
    }

    public void setReparto(String reparto) {
        this.reparto = reparto;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public void mostrar() {
        System.out.println(this.getNombre());
        System.out.println(this.getDuracion());
    }
}
