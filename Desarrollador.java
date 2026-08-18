public class Desarrollador extends Empleado implements Bonificable {

    private double bonificacionTecnica;

    public Desarrollador(String nombre, int id, double salario, double bonificacionTecnica) {
        super(nombre, id, salario);
        this.bonificacionTecnica = bonificacionTecnica;
    }

    @Override
    public double calcularSalario() {
        return getSalario() + bonificacionTecnica;
    }

    @Override
    public double calcularBonificacion() {
        return getSalario() * 0.10;
    }

}