package co.edu.smartgym.factory;

import co.edu.smartgym.model.PlanBasico;
import co.edu.smartgym.model.PlanEntrenamiento;
import co.edu.smartgym.model.PlanPersonalizado;
import co.edu.smartgym.model.PlanPremium;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlanFactoryTest {

    @Test
    void fabricaCreaPlanBasico() {
        PlanFactory factory = new PlanBasicoFactory();
        PlanEntrenamiento plan = factory.crearPlan(
                "B01", "Básico", "Desc", 1, 100_000,
                0, null, null
        );

        assertInstanceOf(PlanBasico.class, plan);
    }

    @Test
    void fabricaCreaPlanPremium() {
        PlanFactory factory = new PlanPremiumFactory();
        PlanEntrenamiento plan = factory.crearPlan(
                "P01", "Premium", "Desc", 1, 150_000,
                0, null, null
        );

        assertInstanceOf(PlanPremium.class, plan);
    }

    @Test
    void fabricaCreaPlanPersonalizado() {
        PlanFactory factory = new PlanPersonalizadoFactory(2,"fisio","mejorar");
        PlanEntrenamiento plan = factory.crearPlan(
                "PC01", "Personalizado", "Desc", 2, 200_000,
                5, "Fuerza", "Mejorar condición"
        );

        assertInstanceOf(PlanPersonalizado.class, plan);
        PlanPersonalizado personalizado = (PlanPersonalizado) plan;
        assertEquals(5, personalizado.getNumSesiones());
    }
}
