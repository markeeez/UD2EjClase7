package Procesos;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Properties;

public interface ProcesosBD {
    public void conexionBD(Properties properties, ArrayList<Integer> listaCodigoEmp) throws IOException;

    public void consultarEmpleados(Connection conexion, ArrayList<Integer> listaCodigoEmp);
}
