package co.edu.smartgym.model;

public class ServicioAdicional {

    private TipoServicio tipoServicio;
    private String codigo;
    private String nombre;
    private String descripcion;
    private double precio;
    private boolean disponibilidad;

    public ServicioAdicional(TipoServicio tipoServicio, String codigo,
                             String nombre, String descripcion,
                             double precio, boolean disponibilidad) {
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo.");
        }

        this.tipoServicio = tipoServicio;
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.disponibilidad = disponibilidad;
    }

    public TipoServicio getTipoServicio() {
        return tipoServicio;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    @Override
    public String toString() {
        return codigo + " - " + nombre;
    }
}
