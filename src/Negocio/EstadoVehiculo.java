package Negocio;

import Modelo.Vehiculo;

public class EstadoVehiculo {
	
	private Vehiculo vehiculo;
	// En metros por segundo (m/s)
	private double velocidadActual;
	private double distanciaRecorrida;
	private double tiempo;
	private double distanciaObjetivo;
	
	public EstadoVehiculo(Vehiculo vehiculo, double velocidadActual, double distanciaRecorrida, double tiempo, double distanciaObjetivo) {
		super();
		this.vehiculo = vehiculo;
		this.velocidadActual = velocidadActual;
		this.distanciaRecorrida = distanciaRecorrida;
		this.tiempo = tiempo;
		this.distanciaObjetivo = distanciaObjetivo; // Inicializamos la distancia objetivo a 0
	}
	
	public EstadoVehiculo() {
		super();
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public double getVelocidadActual() {
		return velocidadActual;
	}

	public void setVelocidadActual(double velocidadActual) {
		this.velocidadActual = velocidadActual;
	}

	public double getDistanciaRecorrida() {
		return distanciaRecorrida;
	}

	public void setDistanciaRecorrida(double distanciaRecorrida) {
		this.distanciaRecorrida = distanciaRecorrida;
	}

	public double getTiempo() {
		return tiempo;
	}

	public void setTiempo(double tiempo) {
		this.tiempo = tiempo;
	}
	
	public double getDistanciaObjetivo() {
		return distanciaObjetivo;
	}
	
	public void setDistanciaObjetivo(double distanciaObjetivo) {
		this.distanciaObjetivo = distanciaObjetivo;
	}

	@Override
	public String toString() {
		return "EstadoVehiculo [vehiculo=" + vehiculo + ", velocidadActual=" + velocidadActual + ", distanciaRecorrida="
				+ distanciaRecorrida + ", tiempo=" + tiempo + ", distanciaObjetivo=" + distanciaObjetivo + "]";
	}

	
	
	
}
