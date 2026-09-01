package Negocio;

import Modelo.Vehiculo;

public class ResultadoCarrera {
	
	private Vehiculo vehiculo1;
	private Vehiculo vehiculo2;
	private double distancia;
	private double tiempoVehiculo1;
	private double tiempoVehiculo2;
	private Vehiculo ganador;

	public ResultadoCarrera() {
		super();
	}
	
	public ResultadoCarrera(Vehiculo vehiculo1, Vehiculo vehiculo2, double distancia, double tiempoVehiculo1,
			double tiempoVehiculo2, Vehiculo ganador) {
		super();
		this.vehiculo1 = vehiculo1;
		this.vehiculo2 = vehiculo2;
		this.distancia = distancia;
		this.tiempoVehiculo1 = tiempoVehiculo1;
		this.tiempoVehiculo2 = tiempoVehiculo2;
		this.ganador = ganador;
	}

	public Vehiculo getVehiculo1() {
		return vehiculo1;
	}

	public void setVehiculo1(Vehiculo vehiculo1) {
		this.vehiculo1 = vehiculo1;
	}

	public Vehiculo getVehiculo2() {
		return vehiculo2;
	}

	public void setVehiculo2(Vehiculo vehiculo2) {
		this.vehiculo2 = vehiculo2;
	}

	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	public double getTiempoVehiculo1() {
		return tiempoVehiculo1;
	}

	public void setTiempoVehiculo1(double tiempoVehiculo1) {
		this.tiempoVehiculo1 = tiempoVehiculo1;
	}

	public double getTiempoVehiculo2() {
		return tiempoVehiculo2;
	}

	public void setTiempoVehiculo2(double tiempoVehiculo2) {
		this.tiempoVehiculo2 = tiempoVehiculo2;
	}

	public Vehiculo getGanador() {
		return ganador;
	}

	public void setGanador(Vehiculo ganador) {
		this.ganador = ganador;
	}

	@Override
	public String toString() {
		return "ResultadoCarrera [vehiculo1=" + vehiculo1 + ", vehiculo2=" + vehiculo2 + ", distancia=" + distancia
				+ ", tiempoVehiculo1=" + tiempoVehiculo1 + ", tiempoVehiculo2=" + tiempoVehiculo2 + ", ganador="
				+ ganador + "]";
	}
	
}
