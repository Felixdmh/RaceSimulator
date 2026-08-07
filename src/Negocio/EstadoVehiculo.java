package Negocio;

import Modelo.Vehiculo;

public class EstadoVehiculo {
	
	private Vehiculo vehiculo;
	private double velocidadActual;
	private double distanciaRecorrida;
	private double tiempo;
	
	public EstadoVehiculo(Vehiculo vehiculo, double velocidadActual, double distanciaRecorrida, double tiempo) {
		super();
		this.vehiculo = vehiculo;
		this.velocidadActual = velocidadActual;
		this.distanciaRecorrida = distanciaRecorrida;
		this.tiempo = tiempo;
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

	@Override
	public String toString() {
		return "EstadoVehiculo [vehiculo=" + vehiculo + ", velocidadActual=" + velocidadActual + ", distanciaRecorrida="
				+ distanciaRecorrida + ", tiempo=" + tiempo + "]";
	}
	
	
}
