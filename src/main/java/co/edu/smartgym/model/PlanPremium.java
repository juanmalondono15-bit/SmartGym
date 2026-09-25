package co.edu.smartgym.model;

public class PlanPremium extends PlanEntrenamiento {

    public PlanPremium(String codigo, String nombre, String descripcion,
                       int duracion, double valorMensual) {
        super(codigo, nombre, descripcion, duracion, valorMensual);
    }

    @Override
    public double calcularValor() {
        return getValorMensual() * getDuracion();
    }
}
