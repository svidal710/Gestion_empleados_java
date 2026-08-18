# Sistema de Gestión de Empleados

Aplicación de consola desarrollada en Java para gestionar empleados mediante los principales conceptos de Programación Orientada a Objetos (POO).

## 📌 Descripción

El sistema permite registrar, consultar, editar y eliminar empleados desde un menú interactivo.

Se implementaron diferentes tipos de empleados, como Gerentes y Desarrolladores, utilizando herencia y polimorfismo.

## ⚙️ Funcionalidades

- Registrar empleados.
- Diferenciar entre Gerentes y Desarrolladores.
- Mostrar empleados registrados.
- Buscar empleados mediante su ID.
- Editar el salario de un empleado.
- Eliminar empleados.
- Validar que no existan IDs repetidos.
- Calcular salarios según el tipo de empleado.
- Calcular bonificaciones.
- Validar que el salario no sea negativo.

## 🧠 Conceptos de POO utilizados

### Encapsulamiento

Los atributos de `Empleado` son privados y se controlan mediante métodos getter y setter.

### Herencia

`Gerente` y `Desarrollador` heredan de la clase abstracta `Empleado`.

### Abstracción

`Empleado` define el comportamiento general que deben tener los empleados mediante la clase abstracta y el método `calcularSalario()`.

### Polimorfismo

Los objetos de tipo `Gerente` y `Desarrollador` pueden ser tratados como objetos `Empleado`, permitiendo que cada clase implemente su propio comportamiento.

### Interfaces

La interfaz `Bonificable` define el método `calcularBonificacion()`, que es implementado por los diferentes tipos de empleados.

## 🏗️ Estructura del proyecto

```text
src/
├── Main.java
├── GestionEmpleados.java
├── modelos/
│   ├── Empleado.java
│   ├── Gerente.java
│   └── Desarrollador.java
└── interfaces/
    └── Bonificable.java
