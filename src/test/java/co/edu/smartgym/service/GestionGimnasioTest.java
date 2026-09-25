package co.edu.smartgym.service;

import co.edu.smartgym.model.Cliente;
import co.edu.smartgym.model.Gimnasio;
import co.edu.smartgym.model.Inscripcion;
import co.edu.smartgym.model.PlanBasico;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class GestionGimnasioTest {

    private Gimnasio gimnasio;
    private GestionGimnasio gestion;

    @BeforeEach
    void setUp() {
        gimnasio = new Gimnasio(
                "SmartGym", "900123456", "Armenia", "6060000000",
                "info@smartgym.com", "www.smartgym.com"
        );
        gestion = new GestionGimnasio(gimnasio);
    }

    @Test
    void buscaClientePorTelefono() {
        Cliente cliente = new Cliente(
                "Ana", "456", "3005551234", "ana@mail.com", 22,
                LocalDate.of(2026, 9, 1)
        );
        gimnasio.registrarCliente(cliente);

        assertSame(cliente, gestion.buscarClientePorTelefono("3005551234"));
        assertNull(gestion.buscarClientePorTelefono("9999999999"));
    }

    @Test
    void identificaNumerosPerfectos() {
        assertTrue(gestion.esNumeroPerfecto("6"));
        assertTrue(gestion.esNumeroPerfecto("28"));
        assertFalse(gestion.esNumeroPerfecto("10"));
        assertFalse(gestion.esNumeroPerfecto("1"));
    }

    @Test
    void puedeCalcularIngresosDentroDeUnPeriodo() {
        Cliente cliente = new Cliente("Ana", "456", "300", "ana@mail.com", 22,
                LocalDate.of(2026, 9, 1));
        PlanBasico plan = new PlanBasico("B01", "Básico", "Desc", 1, 100_000);
        gimnasio.registrarCliente(cliente);
        gimnasio.registrarPlan(plan);

        gimnasio.registrarInscripcion(new Inscripcion(
                cliente, plan, null, LocalDate.of(2026, 9, 10), 0));
        gimnasio.registrarInscripcion(new Inscripcion(
                cliente, plan, null, LocalDate.of(2026, 10, 10), 0));

        assertEquals(100_000,
                gestion.calcularIngresos(LocalDate.of(2026, 9, 1), LocalDate.of(2026, 9, 30)),
                0.001);
    }

    @Test
    void rechazaPeriodoInvalido() {
        assertThrows(IllegalArgumentException.class, () ->
                gestion.calcularIngresos(LocalDate.of(2026, 10, 1), LocalDate.of(2026, 9, 1))
        );
    }
}
