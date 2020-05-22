package com.example.realm;

import io.realm.RealmObject;
import io.realm.annotations.Required;

public class Campamento  extends RealmObject {

    @Required
    private String nombre;
    @Required
    private String localizacion;

    private int cantidadPersonas;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    @Override
    public String toString() {
        return "\nCampamento: " + nombre +
                "\nLocalización: " + localizacion +
                "\nCantidad de Personas: " + cantidadPersonas;
    }
}
