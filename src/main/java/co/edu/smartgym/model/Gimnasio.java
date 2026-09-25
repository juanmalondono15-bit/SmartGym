package co.edu.smartgym.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Gimnasio {

    private String nombre;
    private String nit;
    private String direccion;
    private String telefono;
    private String correo;
    private String paginaWeb;

    private final List<Cliente> listaClientes;
    private final List<Entrenador> listaEntrenadores;
    private final List<PlanEntrenamiento> listaPlanesEntrenamiento;
    private final List<ServicioAdicional> listaServicios;
    private final List<Inscripcion> listaInscripciones;

    public Gimnasio(String nombre, String nit, String direccion,
                    String telefono, String correo, String paginaWeb) {
        this.nombre = nombre;
        this.nit = nit;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.paginaWeb = paginaWeb;

        this.listaClientes = new ArrayList<>();
        this.listaEntrenadores = new ArrayList<>();
        this.listaPlanesEntrenamiento = new ArrayList<>();
        this.listaServicios = new ArrayList<>();
        this.listaInscripciones = new ArrayList<>();
    }

    public void registrarCliente(Cliente cliente) {
        listaClientes.add(cliente);
    }

    public void registrarEntrenador(Entrenador entrenador) {
        listaEntrenadores.add(entrenador);
    }

    public void registrarPlan(PlanEntrenamiento plan) {
        listaPlanesEntrenamiento.add(plan);
    }

    public void registrarServicio(ServicioAdicional servicio) {
        listaServicios.add(servicio);
    }

    public void registrarInscripcion(Inscripcion inscripcion) {
        listaInscripciones.add(inscripcion);
    }

    public String getNombre() {
        return nombre;
    }

    public String getNit() {
        return nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public List<Cliente> getListaClientes() {
        return Collections.unmodifiableList(listaClientes);
    }

    public List<Entrenador> getListaEntrenadores() {
        return Collections.unmodifiableList(listaEntrenadores);
    }

    public List<PlanEntrenamiento> getListaPlanesEntrenamiento() {
        return Collections.unmodifiableList(listaPlanesEntrenamiento);
    }

    public List<ServicioAdicional> getListaServicios() {
        return Collections.unmodifiableList(listaServicios);
    }

    public List<Inscripcion> getListaInscripciones() {
        return Collections.unmodifiableList(listaInscripciones);
    }
}
