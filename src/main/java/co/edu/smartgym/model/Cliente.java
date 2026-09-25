package co.edu.smartgym.model;

import java.time.LocalDate;

public class Cliente {

    private String nombre;
    private String documento;
    private String telefono;
    private String correo;
    private int edad;
    private LocalDate fechaRegistro;

    public Cliente(String nombre, String documento, String telefono,
                   String correo, int edad, LocalDate fechaRegistro) {
        this.nombre = nombre;
        this.documento = documento;
        this.telefono = telefono;
        this.correo = correo;
        this.edad = edad;
        this.fechaRegistro = fechaRegistro;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public int getEdad() {
        return edad;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    @Override
    public String toString() {
        return nombre + " - " + telefono;
    }
}
