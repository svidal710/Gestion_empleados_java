public class Gerente extends Empleado implements Bonificable {
    private double bono;

    public Gerente(String nombre, int id, double salario, double bono) {
        super(nombre, id, salario);
        this.bono = bono;
    }

    @Override
    public double calcularSalario() {
        return getSalario() + bono;
    }

    @Override
    public double calcularBonificacion() {
        return getSalario() * 0.20;
    }

}