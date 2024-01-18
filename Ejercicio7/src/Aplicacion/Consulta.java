package Aplicacion;

import Procesos.ProcesosBD;
import Procesos.ProcesosBDImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class Consulta {


    public ArrayList<Integer> listaEmpleados(){
        ArrayList<Integer> listaCodigoEmp;
        listaCodigoEmp = new ArrayList<>();
        listaCodigoEmp.add(7369);
        listaCodigoEmp.add(7499);
        listaCodigoEmp.add(7521);

        return listaCodigoEmp;

    }

    public void consultarEmpleados(){
        ProcesosBD procesosBD = new ProcesosBDImpl();
        Properties properties = new Properties();

        try {
            procesosBD.conexionBD(properties, listaEmpleados());
        } catch (IOException e) {
            System.out.println("Error al cargar las propiedades: " + e.getMessage());
        }

    }

}
