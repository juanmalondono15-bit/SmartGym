package co.edu.smartgym.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class InscripcionTest {

    @Test
    void inscripcionCalculaPlanServiciosYDescuento() {
        Cliente cliente = new Cliente(
                "Juan", "123", "3001234567", "juan@mail.com", 20,
                LocalDate.of(2026, 9, 1)
        );
        PlanBasico plan = new PlanBasico(
                "B01", "Básico", "Desc", 2, 100_000
        );
        ServicioAdicional servicio = new ServicioAdicional(
                TipoServicio.VALORACIONFISICA, "S01", "Valoración",
                "Valoración inicial", 30_000, true
        );

        Inscripcion inscripcion = new Inscripcion(
                cliente, plan, null, LocalDate.of(2026, 9, 10), 20_000
        );
        inscripcion.agregarServicio(servicio);

        assertEquals(210_000, inscripcion.calcularValor(), 0.001);
        assertEquals(1, inscripcion.getServicios().size());
    }

    @Test
    void noPermiteAgregarServicioNoDisponible() {
        Cliente cliente = new Cliente("Juan", "123", "300", "a@a.com", 20,
                LocalDate.of(2026, 9, 1));
        PlanBasico plan = new PlanBasico("B01", "Básico", "Desc", 1, 100_000);
        ServicioAdicional servicio = new ServicioAdicional(
                TipoServicio.CLASESESPECIALES, "S01", "Clase", "Desc", 20_000, false
        );
        Inscripcion inscripcion = new Inscripcion(
                cliente, plan, null, LocalDate.of(2026, 9, 10), 0
        );

        assertThrows(IllegalArgumentException.class, () -> inscripcion.agregarServicio(servicio));
    }
}
