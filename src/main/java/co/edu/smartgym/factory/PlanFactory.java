package co.edu.smartgym.factory;

import co.edu.smartgym.model.PlanEntrenamiento;

public interface PlanFactory {
    PlanEntrenamiento crearPlan(String codigo, String nombre,
                                String descripcion, int duracion,
                                double valorMensual,
                                int numSesiones, String especialidad, String objetivo);

    PlanEntrenamiento crearPlan(String codigo, String nombre, String descripcion, int duracion, double valor);
}
