package com.example.recicleview;

public class Persona {

    String nombre;
    String email;
    int edad;

    public Persona(String nombre,String email,int edad) {
        this.nombre = nombre;
        this.email = email;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", edad='" + edad + '\'' +
                '}';
    }
}
