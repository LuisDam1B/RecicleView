package com.example.recicleview;

public class Persona {

    String nombre;
    String email;

    public Persona(String nombre,String email) {
        this.nombre = nombre;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
