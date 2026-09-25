package co.edu.smartgym.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Inscripcion implements Calculable {

    private Cliente cliente;
    private PlanEntrenamiento plan;
    private Entrenador entrenador;
    private LocalDate fechaInscripcion;
    private double descuento;
    private final List<ServicioAdicional> servicios;

    public Inscripcion(Cliente cliente, PlanEntrenamiento plan,
                       Entrenador entrenador, LocalDate fechaInscripcion,
                       double descuento) {
        if (cliente == null || plan == null || fechaInscripcion == null) {
            throw new IllegalArgumentException("Cliente, plan y fecha son obligatorios.");
        }
        if (descuento < 0) {
            throw new IllegalArgumentException("El descuento no puede ser negativo.");
        }

        this.cliente = cliente;
        this.plan = plan;
        this.entrenador = entrenador;
        this.fechaInscripcion = fechaInscripcion;
        this.descuento = descuento;
        this.servicios = new ArrayList<>();

        if (plan instanceof PlanPersonalizado personalizado && entrenador != null) {
            personalizado.asignarEntrenador(entrenador);
        }
    }

    public void agregarServicio(ServicioAdicional servicio) {
        if (servicio == null) {
            throw new IllegalArgumentException("El servicio no puede ser nulo.");
        }
        if (!servicio.isDisponibilidad()) {
            throw new IllegalArgumentException("El servicio no está disponible.");
        }
        servicios.add(servicio);
    }

    @Override
    public double calcularValor() {
        double total = plan.calcularValor();

        for (ServicioAdicional servicio : servicios) {
            total += servicio.getPrecio();
        }

        return Math.max(0, total - descuento);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public PlanEntrenamiento getPlan() {
        return plan;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }

    public double getDescuento() {
        return descuento;
    }

    public List<ServicioAdicional> getServicios() {
        return Collections.unmodifiableList(servicios);
    }

    @Override
    public String toString() {
        return cliente.getNombre() + " | " + plan.getNombre()
                + " | " + fechaInscripcion;
    }
}
