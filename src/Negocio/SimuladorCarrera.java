package Negocio;

import Modelo.Vehiculo;

public class SimuladorCarrera {

	public void pruebaSimulacion(Vehiculo vehiculo1,
            Vehiculo vehiculo2) {

	
	}
	public ResultadoCarrera simular(Vehiculo vehiculo1,
            Vehiculo vehiculo2,
            double distancia) {
	
		EstadoVehiculo estadoVehiculo1 =
		simularVehiculo(vehiculo1, distancia);
		
		EstadoVehiculo estadoVehiculo2 =
		simularVehiculo(vehiculo2, distancia);
		
		Vehiculo ganador;
		
		if (estadoVehiculo1.getTiempo() < estadoVehiculo2.getTiempo()) {
			ganador = vehiculo1;
		} else if (estadoVehiculo2.getTiempo() < estadoVehiculo1.getTiempo()) {
			ganador = vehiculo2;
		} else {
			ganador = null;
		}
		
		ResultadoCarrera resultado = new ResultadoCarrera();
		
		resultado.setVehiculo1(vehiculo1);
		resultado.setVehiculo2(vehiculo2);
		resultado.setDistancia(distancia);
		resultado.setTiempoVehiculo1(estadoVehiculo1.getTiempo());
		resultado.setTiempoVehiculo2(estadoVehiculo2.getTiempo());
		resultado.setGanador(ganador);
		
		System.out.println("Vehículo 1: "
		        + estadoVehiculo1.getVehiculo().getMarca()
		        + " "
		        + estadoVehiculo1.getVehiculo().getModelo());

		System.out.println("Tiempo: "
		        + estadoVehiculo1.getTiempo()
		        + " segundos");

		System.out.println("Distancia: "
		        + estadoVehiculo1.getDistanciaRecorrida()
		        + " metros");

		System.out.println("--------------------------------");

		System.out.println("Vehículo 2: "
		        + estadoVehiculo2.getVehiculo().getMarca()
		        + " "
		        + estadoVehiculo2.getVehiculo().getModelo());

		System.out.println("Tiempo: "
		        + estadoVehiculo2.getTiempo()
		        + " segundos");

		System.out.println("Distancia: "
		        + estadoVehiculo2.getDistanciaRecorrida()
		        + " metros");
	
	return resultado;
	}
	
	private EstadoVehiculo simularVehiculo(Vehiculo vehiculo, double distancia) {

	    EstadoVehiculo estado = inicializarEstado(vehiculo, distancia);

	    final double DELTA_T = 0.05;

	    int iteraciones = 0;

	    while (distancia - estado.getDistanciaRecorrida() > 0.0005) {

	        actualizarEstado(estado, DELTA_T);

	    }
	    estado.setDistanciaRecorrida(distancia);

	    return estado;
	}
	
	private void actualizarEstado(EstadoVehiculo estado, double deltaT) {

	    double aceleracion = calcularAceleracion(estado);

	    double velocidadActual = estado.getVelocidadActual();

	    double distanciaRestante =
	            estado.getDistanciaObjetivo() - estado.getDistanciaRecorrida();

	    double distanciaIntervalo =
	            velocidadActual * deltaT
	            + 0.5 * aceleracion * deltaT * deltaT;

	    if (distanciaIntervalo > distanciaRestante) {

	        if (aceleracion > 0) {

	            double a = 0.5 * aceleracion;
	            double b = velocidadActual;
	            double c = -distanciaRestante;

	            deltaT = (-b + Math.sqrt(b * b - 4 * a * c))
	                    / (2 * a);

	        } else if (velocidadActual > 0) {

	            deltaT = distanciaRestante / velocidadActual;

	        }
	    }

	    double nuevaVelocidad =
	            velocidadActual + aceleracion * deltaT;

	    estado.setVelocidadActual(nuevaVelocidad);

	    double nuevaDistancia =
	            estado.getDistanciaRecorrida()
	            + velocidadActual * deltaT
	            + 0.5 * aceleracion * deltaT * deltaT;

	    estado.setDistanciaRecorrida(nuevaDistancia);

	    estado.setTiempo(estado.getTiempo() + deltaT);
	}
	private EstadoVehiculo inicializarEstado(Vehiculo vehiculo,
            double distancia) {

		EstadoVehiculo estado = new EstadoVehiculo();
		
		estado.setVehiculo(vehiculo);
		estado.setVelocidadActual(0);
		estado.setDistanciaRecorrida(0);
		estado.setTiempo(0);
		estado.setDistanciaObjetivo(distancia);
		
		return estado;
	}
	
	private double calcularAceleracion(EstadoVehiculo estado) {
		Vehiculo vehiculo = estado.getVehiculo();
			double aceleracionBase = calcularAceleracionBase(vehiculo);
			double factorVelocidad = calcularFactorVelocidad(estado);
			double factorTraccion = calcularFactorTraccion(vehiculo, estado);
			double factorAerodinamico = calcularFactorAerodinamico(estado);
			double factorPeso = calcularFactorPeso(vehiculo);
		    return aceleracionBase * factorVelocidad * factorTraccion * factorAerodinamico * factorPeso;
	}
	private double calcularAceleracionBase(Vehiculo vehiculo) {

	    double aceleracion100 = 100 / 3.6;
	    double tiempo0100 = vehiculo.getAceleracion();

	    return aceleracion100 / tiempo0100;
	}

	private double calcularFactorVelocidad(EstadoVehiculo estado) {

	    Vehiculo vehiculo = estado.getVehiculo();

	    double velocidadActual = estado.getVelocidadActual();

	    double velocidadMaxima = vehiculo.getVelocidadMaxima() / 3.6;

	    double factor = 1 - (velocidadActual / velocidadMaxima);

	    return Math.max(0, factor);
	}
	
	private double calcularFactorTraccion(Vehiculo vehiculo,
            EstadoVehiculo estado) {

		double velocidad = estado.getVelocidadActual() * 3.6;
		
		if (velocidad >= 40) {
			return 1.0;
		}
		
		String traccion = vehiculo.getTraccion();
		
		if (traccion == null) {
			return 1.0;
		}
		
		if (traccion.equalsIgnoreCase("Total")) {
			return 1.10;
		}
		
		if (traccion.equalsIgnoreCase("Trasera")) {
			return 1.05;
		}
		
		if (traccion.equalsIgnoreCase("Delantera")) {
			return 1.00;
		}
		
		return 1.0;
	
	}

	private double calcularFactorAerodinamico(EstadoVehiculo estado) {

	    Vehiculo vehiculo = estado.getVehiculo();

	    double velocidad = estado.getVelocidadActual() * 3.6;

	    Double coeficiente = vehiculo.getCoeficienteAerodinamico();

	    if (coeficiente == null) {
	        return 1.0;
	    }

	    if (velocidad <= 100) {
	        return 1.0;
	    }

	    double factorVelocidad = (velocidad - 100) / 100;

	    double factorAerodinamico =
	            1 - (coeficiente * 0.15 * factorVelocidad);

	    return Math.max(0.5, factorAerodinamico);
	}

	private double calcularFactorPeso(Vehiculo vehiculo) {

	    double peso = vehiculo.getPeso();
	    double pesoReferencia = 1500.0;
	    double diferencia = peso - pesoReferencia;
	    double factor = 1 - (diferencia / pesoReferencia) * 0.05;

	    return Math.max(0.95, Math.min(1.05, factor));
	}
}
