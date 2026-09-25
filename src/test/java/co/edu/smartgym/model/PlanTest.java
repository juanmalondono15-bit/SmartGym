package co.edu.smartgym.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlanTest {

    @Test
    void planBasicoCalculaValorSegunDuracion() {
        PlanBasico plan = new PlanBasico(
                "B01", "Plan Básico", "Acceso básico", 3, 100_000
        );

        assertEquals(300_000, plan.calcularValor(), 0.001);
        assertEquals(Estado.ACTIVO, plan.getEstado());
    }

    @Test
    void planPremiumCalculaValorSegunDuracion() {
        PlanPremium plan = new PlanPremium(
                "P01", "Plan Premium", "Acceso premium", 6, 180_000
        );

        assertEquals(1_080_000, plan.calcularValor(), 0.001);
    }

    @Test
    void planPersonalizadoIncluyeSesionesDelEntrenador() {
        Entrenador entrenador = new Entrenador(
                "100", "Carlos", "Fuerza", "3000000000", 50_000
        );
        PlanPersonalizado plan = new PlanPersonalizado(
                "PC01", "Plan Personalizado", "Plan individual", 2,
                150_000, 4, "Fuerza", "Ganar resistencia"
        );
        plan.asignarEntrenador(entrenador);

        assertEquals(500_000, plan.calcularValor(), 0.001);
    }

    @Test
    void noPermiteDuracionInvalida() {
        assertThrows(IllegalArgumentException.class, () ->
                new PlanBasico("B01", "Plan", "Desc", 0, 100_000)
        );
    }
}
