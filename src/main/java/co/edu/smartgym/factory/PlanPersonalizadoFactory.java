package co.edu.smartgym.factory;

import co.edu.smartgym.model.PlanEntrenamiento;
import co.edu.smartgym.model.PlanPersonalizado;

public class PlanPersonalizadoFactory implements PlanFactory {

    private final int numSesiones;
    private final String especialidad;
    private final String objetivo;



    public PlanPersonalizadoFactory(int numSesiones, String especialidad, String objetivo) {

        this.numSesiones = numSesiones;
        this.especialidad = especialidad;
        this.objetivo = objetivo;
    }



    @Override
    public PlanEntrenamiento crearPlan(String codigo, String nombre, String descripcion, int duracion, double valorMensual, int numSesiones, String especialidad, String objetivo) {
        return null;
    }

    @Override
    public PlanEntrenamiento crearPlan(String codigo, String nombre,
                                       String descripcion, int duracion,
                                       double valorMensual) {
        return new PlanPersonalizado(
                codigo, nombre, descripcion, duracion,
                valorMensual, numSesiones, especialidad, objetivo
        );
    }
}
