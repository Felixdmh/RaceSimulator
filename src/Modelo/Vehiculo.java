package Modelo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Vehiculo {

	private int id;
	private String marca;
	private String modelo;
	private String generacion;
	@JsonProperty("potencia_cv")
	private int potenciaCv;
	@JsonProperty("par_motor_nm")
	private Integer parMotorNm;
	@JsonProperty("peso_kg")
	private Integer peso;
	private String traccion;
	@JsonProperty("aceleracion_0_100")
	private Double aceleracion;
	@JsonProperty("velocidad_max_kmh")
	private int velocidadMaxima;
	@JsonProperty("coeficiente_aerodinamico_cd")
	private Double coeficienteAerodinamico;
	@JsonProperty("caja_cambios")
	private String cambio;
	@JsonProperty("numero_marchas")
	private Integer numeroMarchas;

	public Vehiculo(int id, String marca, String modelo, String generacion, int potenciaCv, Integer parMotorNm,
			Integer peso, String traccion, Double aceleracion, int velocidadMaxima, Double coeficienteAerodinamico,
			String cambio, Integer numeroMarchas) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.generacion = generacion;
		this.potenciaCv = potenciaCv;
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
		return potenciaCv;
	}
	public void setPotenciaCV(int potenciaCv) {
		this.potenciaCv = potenciaCv;
	}
	public Integer getParMotorNm() {
		return parMotorNm;
	}
	public void setParMotorNm(Integer parMotorNm) {
		this.parMotorNm = parMotorNm;
	}
	public Integer getPeso() {
		return peso;
	}
	public void setPeso(Integer peso) {
		this.peso = peso;
	}
	public String getTraccion() {
		return traccion;
	}
	public void setTraccion(String traccion) {
		this.traccion = traccion;
	}
	public Double getAceleracion() {
		return aceleracion;
	}
	public void setAceleracion(Double aceleracion) {
		this.aceleracion = aceleracion;
	}
	public int getVelocidadMaxima() {
		return velocidadMaxima;
	}
	public void setVelocidadMaxima(int velocidadMaxima) {
		this.velocidadMaxima = velocidadMaxima;
	}
	public Double getCoeficienteAerodinamico() {
		return coeficienteAerodinamico;
	}
	public void setCoeficienteAerodinamico(Double coeficienteAerodinamico) {
		this.coeficienteAerodinamico = coeficienteAerodinamico;
	}
	public String getCambio() {
		return cambio;
	}
	public void setCambio(String cambio) {
		this.cambio = cambio;
	}
	public Integer getNumeroMarchas() {
		return numeroMarchas;
	}
	public void setNumeroMarchas(Integer numeroMarchas) {
		this.numeroMarchas = numeroMarchas;
	}

	@Override
	public String toString() {
		return "Vehiculo [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", generacion=" + generacion
				+ ", potenciaCv=" + potenciaCv + ", parMotorNm=" + parMotorNm + ", peso=" + peso + ", traccion="
				+ traccion + ", aceleracion=" + aceleracion + ", velocidadMaxima=" + velocidadMaxima
				+ ", coeficienteAerodinamico=" + coeficienteAerodinamico + ", cambio=" + cambio + ", numeroMarchas="
				+ numeroMarchas + "]";
	}


	
}
