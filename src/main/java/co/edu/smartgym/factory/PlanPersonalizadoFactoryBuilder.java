package co.edu.smartgym.factory;

public class PlanPersonalizadoFactoryBuilder {
    private int numSesiones;
    private String especialidad;
    private String objetivo;

    public PlanPersonalizadoFactoryBuilder setNumSesiones(int numSesiones) {
        this.numSesiones = numSesiones;
        return this;
    }

    public PlanPersonalizadoFactoryBuilder setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
        return this;
    }

    public PlanPersonalizadoFactoryBuilder setObjetivo(String objetivo) {
        this.objetivo = objetivo;
        return this;
    }

    public PlanPersonalizadoFactory createPlanPersonalizadoFactory() {
        return new PlanPersonalizadoFactory(numSesiones, especialidad, objetivo);
    }
}