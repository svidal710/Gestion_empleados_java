import java.util.ArrayList;

public class GestionEmpleados {

    private ArrayList<Empleado> empleados;

    public GestionEmpleados() {
        empleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public ArrayList<Empleado> obtenerEmpleados() {
        return empleados;
    }

    public Empleado buscarPorId(int id) {

        for (Empleado empleado : empleados) {

            if (empleado.getId() == id) {
                return empleado;
            }
        }

        return null;
    }

    public boolean eliminarEmpleado(int id) {

        Empleado empleado = buscarPorId(id);

        if (empleado != null) {
            empleados.remove(empleado);
            return true;
        }

        return false;
    }
}
