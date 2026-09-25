package co.edu.smartgym.factory;

import co.edu.smartgym.model.PlanBasico;
import co.edu.smartgym.model.PlanEntrenamiento;

public class PlanBasicoFactory implements PlanFactory {

    @Override
    public PlanEntrenamiento crearPlan(String codigo, String nombre, String descripcion, int duracion, double valorMensual, int numSesiones, String especialidad, String objetivo) {
        return null;
    }

    @Override
    public PlanEntrenamiento crearPlan(String codigo, String nombre,
                                       String descripcion, int duracion,
                                       double valorMensual) {
        return new PlanBasico(codigo, nombre, descripcion, duracion, valorMensual);
    }
}
