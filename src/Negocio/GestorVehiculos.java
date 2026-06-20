package Negocio;

import java.io.IOException;
import java.util.List;

import Modelo.Vehiculo;
import Persistencia.VehiculoDAOJSON;

public class GestorVehiculos {
	
	private  VehiculoDAOJSON vehiculoDAOJSON;
	
	public GestorVehiculos() {
		vehiculoDAOJSON = new VehiculoDAOJSON();
	}
	
	public List<Vehiculo> obtenerVehiculos() throws IOException {
		return vehiculoDAOJSON.cargarVehiculosDesdeJSON();
	}

}
