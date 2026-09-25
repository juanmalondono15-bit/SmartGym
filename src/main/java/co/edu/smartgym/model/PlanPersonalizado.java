package co.edu.smartgym.model;

public class PlanPersonalizado extends PlanEntrenamiento {

    private int numSesiones;
    private String especialidadRequerida;
    private String objetivoCliente;
    private Entrenador entrenador;

    public PlanPersonalizado(String codigo, String nombre, String descripcion,
                             int duracion, double valorMensual, int numSesiones,
                             String especialidadRequerida, String objetivoCliente) {
        super(codigo, nombre, descripcion, duracion, valorMensual);

        if (numSesiones < 0) {
            throw new IllegalArgumentException("Las sesiones no pueden ser negativas.");
        }

        this.numSesiones = numSesiones;
        this.especialidadRequerida = especialidadRequerida;
        this.objetivoCliente = objetivoCliente;
    }

    public int getNumSesiones() {
        return numSesiones;
    }

    public String getEspecialidadRequerida() {
        return especialidadRequerida;
    }

    public String getObjetivoCliente() {
        return objetivoCliente;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void asignarEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    @Override
    public double calcularValor() {
        double total = getValorMensual() * getDuracion();

        if (entrenador != null) {
            total += numSesiones * entrenador.getTarifaSesion();
        }

        return total;
    }
}
