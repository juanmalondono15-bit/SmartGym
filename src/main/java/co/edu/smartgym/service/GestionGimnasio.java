package co.edu.smartgym.service;

import co.edu.smartgym.model.Cliente;
import co.edu.smartgym.model.Gimnasio;
import co.edu.smartgym.model.Inscripcion;

import java.time.LocalDate;

public class GestionGimnasio {

    private final Gimnasio gimnasio;

    public GestionGimnasio(Gimnasio gimnasio) {
        this.gimnasio = gimnasio;
    }

    public Gimnasio getGimnasio() {
        return gimnasio;
    }

    public Cliente buscarClientePorTelefono(String telefono) {
        for (Cliente cliente : gimnasio.getListaClientes()) {
            if (cliente.getTelefono().equals(telefono)) {
                return cliente;
            }
        }
        return null;
    }

    public boolean esNumeroPerfecto(String telefono) {
        String numeroLimpio = telefono.replaceAll("[^0-9]", "");

        if (numeroLimpio.isEmpty()) {
            return false;
        }

        try {
            long numero = Long.parseLong(numeroLimpio);

            if (numero <= 1) {
                return false;
            }

            long suma = 1;

            for (long divisor = 2; divisor <= numero / divisor; divisor++) {
                if (numero % divisor == 0) {
                    suma += divisor;

                    long otroDivisor = numero / divisor;
                    if (otroDivisor != divisor) {
                        suma += otroDivisor;
                    }
                }
            }

            return suma == numero;

        } catch (NumberFormatException e) {
            return false;
        }
    }

    public double calcularIngresos(LocalDate inicio, LocalDate fin) {
        if (inicio == null || fin == null || fin.isBefore(inicio)) {
            throw new IllegalArgumentException("El periodo de fechas no es válido.");
        }

        double total = 0;

        for (Inscripcion inscripcion : gimnasio.getListaInscripciones()) {
            LocalDate fecha = inscripcion.getFechaInscripcion();

            if (!fecha.isBefore(inicio) && !fecha.isAfter(fin)) {
                total += inscripcion.calcularValor();
            }
        }

        return total;
    }
}
