package Modelo;

public class Vehiculo {

	private int id;
	private String marca;
	private String modelo;
	private String generacion;
	private int potenciaCV;
	private int parMotorNm;
	private int peso;
	private String traccion;
	private double aceleracion;
	private int velocidadMaxima;
	private double coeficienteAerodinamico;
	private String cambio;
	private int numeroMarchas;
	
	public Vehiculo(int id, String marca, String modelo, String generacion, int potenciaCV, int parMotorNm, int peso,
			String traccion, double aceleracion, int velocidadMaxima, double coeficienteAerodinamico, String cambio,
			int numeroMarchas) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.generacion = generacion;
		this.potenciaCV = potenciaCV;
		this.parMotorNm = parMotorNm;
		this.peso = peso;
		this.traccion = traccion;
		this.aceleracion = aceleracion;
		this.velocidadMaxima = velocidadMaxima;
		this.coeficienteAerodinamico = coeficienteAerodinamico;
		this.cambio = cambio;
		this.numeroMarchas = numeroMarchas;
	}
	
	public Vehiculo() {
		super();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getGeneracion() {
		return generacion;
	}
	public void setGeneracion(String generacion) {
		this.generacion = generacion;
	}
	public int getPotenciaCV() {
		return potenciaCV;
	}
	public void setPotenciaCV(int potenciaCV) {
		this.potenciaCV = potenciaCV;
	}
	public int getParMotorNm() {
		return parMotorNm;
	}
	public void setParMotorNm(int parMotorNm) {
		this.parMotorNm = parMotorNm;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	public String getTraccion() {
		return traccion;
	}
	public void setTraccion(String traccion) {
		this.traccion = traccion;
	}
	public double getAceleracion() {
		return aceleracion;
	}
	public void setAceleracion(double aceleracion) {
		this.aceleracion = aceleracion;
	}
	public int getVelocidadMaxima() {
		return velocidadMaxima;
	}
	public void setVelocidadMaxima(int velocidadMaxima) {
		this.velocidadMaxima = velocidadMaxima;
	}
	public double getCoeficienteAerodinamico() {
		return coeficienteAerodinamico;
	}
	public void setCoeficienteAerodinamico(double coeficienteAerodinamico) {
		this.coeficienteAerodinamico = coeficienteAerodinamico;
	}
	public String getCambio() {
		return cambio;
	}
	public void setCambio(String cambio) {
		this.cambio = cambio;
	}
	public int getNumeroMarchas() {
		return numeroMarchas;
	}
	public void setNumeroMarchas(int numeroMarchas) {
		this.numeroMarchas = numeroMarchas;
	}

	@Override
	public String toString() {
		return "Vehiculo [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", generacion=" + generacion
				+ ", potenciaCV=" + potenciaCV + ", parMotorNm=" + parMotorNm + ", peso=" + peso + ", traccion="
				+ traccion + ", aceleracion=" + aceleracion + ", velocidadMaxima=" + velocidadMaxima
				+ ", coeficienteAerodinamico=" + coeficienteAerodinamico + ", cambio=" + cambio + ", numeroMarchas="
				+ numeroMarchas + "]";
	}

	
	
}
