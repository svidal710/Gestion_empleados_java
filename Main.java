import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Empleado> empleados = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int opcion;

        do {

            System.out.println("\n===== SISTEMA DE EMPLEADOS =====");
            System.out.println("1. Registrar empleado");
            System.out.println("2. Mostrar empleados");
            System.out.println("3. Buscar empleado");
            System.out.println("4. Editar sueldo empleado");
            System.out.println("5. Eliminar empleado");
            System.out.println("6. Salir");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:
                    System.out.println("\n--- REGISTRAR EMPLEADO ---");
                    System.out.println("1. Gerente");
                    System.out.println("2. Desarrollador");
                    System.out.print("Seleccione el tipo: ");

                    int tipo = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.print("ID: ");
                    int id = scanner.nextInt();

                    if (buscarPorId(empleados, id) != null) {

                        System.out.println("Error: ya existe un empleado con ese ID.");
                        break;
                    }
                        
                    System.out.print("Salario: ");
                    double salario = scanner.nextDouble();

                    Empleado nuevoEmpleado = null;

                    if (tipo == 1) {

                        System.out.print("Bono: ");
                        double bono = scanner.nextDouble();

                        nuevoEmpleado = new Gerente(
                            nombre,
                            id,
                            salario,
                            bono
                        );

                    } else if (tipo == 2) {

                        System.out.print("Bonificación técnica: ");
                        double bonificacionTecnica = scanner.nextDouble();

                        nuevoEmpleado = new Desarrollador(
                            nombre,
                            id,
                            salario,
                            bonificacionTecnica
                        );

                    } else {

                        System.out.println("Tipo de empleado inválido.");
                    }

                    if (nuevoEmpleado != null) {
                        empleados.add(nuevoEmpleado);
                        System.out.println("Empleado registrado correctamente.");
                    }

                    break;

                case 2:

                    System.out.println("\n--- LISTA DE EMPLEADOS ---");

                    if (empleados.isEmpty()) {
                        System.out.println("No hay empleados registrados.");
                    } else {

                        for (Empleado empleado : empleados) {

                            System.out.println("------------------------");
                            System.out.println("Nombre: " + empleado.getNombre());
                            System.out.println("ID: " + empleado.getId());
                            System.out.println("Salario: " + empleado.calcularSalario());
                        }
                    }

                    break;

                case 3:

                    System.out.println("\n--- BUSCAR EMPLEADO ---");

                    System.out.print("Ingrese el ID del empleado: ");
                    int idBuscado = scanner.nextInt();

                    boolean encontrado = false;

                    for (Empleado empleado : empleados) {

                        if (empleado.getId() == idBuscado) {

                            System.out.println("\nEmpleado encontrado:");
                            System.out.println("Nombre: " + empleado.getNombre());
                            System.out.println("ID: " + empleado.getId());
                            System.out.println("Salario: " + empleado.calcularSalario());

                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("No se encontró un empleado con ese ID.");
                    }

                    break;

                case 4:

                    System.out.println("\n--- EDITAR SUELDO EMPLEADO ---");

                    System.out.print("Ingrese el ID del empleado: ");
                    int idEditar = scanner.nextInt();
                    scanner.nextLine();

                    Empleado empleadoEditar = buscarPorId(empleados, idEditar);

                    if (empleadoEditar != null) {

                        System.out.println("Empleado encontrado:");
                        System.out.println("Nombre actual: " + empleadoEditar.getNombre());
                        System.out.println("ID: " + empleadoEditar.getId());
                        System.out.println("Salario actual: " + empleadoEditar.getSalario());

                        System.out.print("Nuevo salario: ");
                        double nuevoSalario = scanner.nextDouble();

                        empleadoEditar.setSalario(nuevoSalario);

                        System.out.println("Empleado actualizado correctamente.");

                    } else {

                        System.out.println("No se encontró un empleado con ese ID.");
                    }

                    break;   

                case 5:

                    System.out.println("\n--- ELIMINAR EMPLEADO ---");

                    System.out.print("Ingrese el ID del empleado: ");
                    int idEliminar = scanner.nextInt();

                    Empleado empleadoEliminar = buscarPorId(empleados, idEliminar);

                    if (empleadoEliminar != null) {

                        empleados.remove(empleadoEliminar);

                        System.out.println("Empleado eliminado correctamente.");

                    } else {

                        System.out.println("No se encontró un empleado con ese ID.");
                    }

                    break;

                default:
                    System.out.println("Opción inválida");

                case 6:
                    System.out.println("Saliendo...");
                    break;
            }
        
        } while (opcion != 6);

        // Crear empleados
        Empleado gerente = new Gerente(
            "Sebastian",
            1,
            4000000,
            800000
        );

        Empleado desarrollador = new Desarrollador(
            "Carlos",
            2,
            3000000,
            500000
        );

        // Guardar los empleados en un arreglo
        Empleado[] empleados = {
            gerente,
            desarrollador
        };

        // Mostrar información y salario
        System.out.println("===== EMPLEADOS =====");

        for (Empleado empleado : empleados) {
            System.out.println(
                empleado.getNombre() +
                " → Salario: " +
                empleado.calcularSalario()
            );
        }

        // Trabajar con la interfaz Bonificable
        Bonificable[] bonificables = {
            gerente,
            desarrollador
        };

        System.out.println("\n===== BONIFICACIONES =====");

        for (Bonificable persona : bonificables) {
            System.out.println(
                "Bonificación: " +
                persona.calcularBonificacion()
            );
        }
    }

    public static Empleado buscarPorId(ArrayList<Empleado> empleados, int id) {

        for (Empleado empleado : empleados) {

            if (empleado.getId() == id) {
                return empleado;
            }
        }

        return null;
    }
}