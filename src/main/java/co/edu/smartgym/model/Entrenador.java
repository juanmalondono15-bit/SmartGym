package co.edu.smartgym.model;

public class Entrenador {

    private String documento;
    private String nombre;
    private String especialidad;
    private String telefono;
    private double tarifaSesion;

    public Entrenador(String documento, String nombre, String especialidad,
                      String telefono, double tarifaSesion) {
        this.documento = documento;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.telefono = telefono;
        this.tarifaSesion = tarifaSesion;
    }

    public String getDocumento() {
        return documento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public double getTarifaSesion() {
        return tarifaSesion;
    }

    @Override
    public String toString() {
        return nombre + " - " + especialidad;
    }
}
