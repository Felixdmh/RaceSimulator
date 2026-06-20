package Persistencia;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import Modelo.Vehiculo;

public class VehiculoDAOJSON {

	public List<Vehiculo> cargarVehiculosDesdeJSON() throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		
		Vehiculo[] vehiculos = objectMapper.readValue(new File("src/Resource/especificacionesCoches.json"), Vehiculo[].class);
		
		return Arrays.asList(vehiculos);
	}
}
