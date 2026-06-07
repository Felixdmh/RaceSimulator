
# Race Simulator
RaceSimulator es una aplicación desarrollada en java que nos perite comparar y simular carreras entre dos vehiculos utilizando especificaciones técnicas reales

Los vehiculos empleados son cargados desde un archivo JSON y pueden enfrentarse en diferentes simulaciones para observar su comportamiento




## Funcionalidades
 - Catálogo de veiculos
 - Comparación de especificaciones técnicas
 - Simulación de carreras
 - Cálculo de resultados
 - Lectura de datos desde archivos JSON

---
## Tecnologías utilizadas
 - Java
 - Eclipse IDE
 - WindowBuilder
 - JSON
 - Git
 - GitHub

## Arquitectura
Este proyecto sigue una arquitectura por capas

---
### Modelo

Contiene las entidades principales de la aplicación.

- Vehiculo
- ResultadoCarrera

### Persistencia

Gestiona la lectura y carga de los datos almacenados en archivos JSON.

- VehiculoDAOJSON

### Negocio

Implementa toda la lógica de simulación y comparación de vehículos.

- SimuladorCarrera
- ComparadorVehiculos

### Presentación

Gestiona la interfaz gráfica y la interacción con el usuario.

- Main
- VentanaPrincipal

---

## Estructura del proyecto

```text
src/
│
├── modelo/
│   ├── Vehiculo.java
│
├── persistencia/
│   └── VehiculoDAOJSON.java
│
├── negocio/
│   ├── SimuladorCarrera.java
│   └── ComparadorVehiculos.java
│
└── presentacion/
    ├── Main.java
    └── VentanaPrincipal.java

resources/
└── vehiculos.json
```

---

## Fuente de datos

La información de los vehículos se almacena en un archivo JSON y contiene exclusivamente especificaciones técnicas utilizadas por el simulador.

---

## Objetivos del proyecto

- Aplicar Programación Orientada a Objetos (POO).
- Diseñar una arquitectura por capas.
- Trabajar con persistencia mediante JSON.
- Desarrollar una interfaz gráfica en Java.
- Implementar algoritmos de simulación basados en datos reales.

---

## Posibles mejoras futuras

- Incorporación de nuevos vehículos.
- Más tipos de simulación.
- Estadísticas avanzadas.
- Persistencia mediante bases de datos.
- Exportación de resultados.
- Sistema de clasificación y rankings.

---

## Autor
Félix Diaz-Malaguilla Hidalgo

Proyecto personal desarrollado con fines educativos, de aprendizaje y portfolio profesional.
