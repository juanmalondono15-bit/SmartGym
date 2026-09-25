package co.edu.smartgym.model;

public abstract class PlanEntrenamiento implements Calculable {

    private String codigo;
    private String nombre;
    private String descripcion;
    private int duracion;
    private double valorMensual;
    private Estado estado;

    protected PlanEntrenamiento(String codigo, String nombre, String descripcion,
                                int duracion, double valorMensual) {
        if (duracion <= 0) {
            throw new IllegalArgumentException("La duración debe ser mayor que cero.");
        }
        if (valorMensual < 0) {
            throw new IllegalArgumentException("El valor mensual no puede ser negativo.");
        }

        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.valorMensual = valorMensual;
        this.estado = Estado.ACTIVO;
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

    public int getDuracion() {
        return duracion;
    }

    public double getValorMensual() {
        return valorMensual;
    }

    public Estado getEstado() {
        return estado;
    }

    public void cambiarEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return codigo + " - " + nombre;
    }
}
