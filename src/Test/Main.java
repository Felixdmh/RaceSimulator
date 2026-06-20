package Test;

import java.util.List;

import Modelo.Vehiculo;
import Persistencia.VehiculoDAOJSON;

public class Main {

    public static void main(String[] args) {

        try {

            VehiculoDAOJSON dao = new VehiculoDAOJSON();

            List<Vehiculo> vehiculos =
                    dao.cargarVehiculosDesdeJSON();

            System.out.println(vehiculos.size());

            System.out.println(vehiculos.get(0));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}