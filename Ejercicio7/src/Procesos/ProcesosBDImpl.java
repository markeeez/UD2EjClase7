package Procesos;

import BeanDAO.BeanDAO;
import BeanDAO.BeanDAOImpl;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

import java.util.ArrayList;


public class ProcesosBDImpl implements ProcesosBD {

    @Override
    public void conexionBD(Properties properties, ArrayList<Integer> listaCodigoEmp) throws IOException {
        properties = new Properties();
        properties.load(new FileInputStream("conexion.properties"));
        BeanDAO beanDAO = new BeanDAOImpl(properties.getProperty("driver"),properties.getProperty("urlBase"),properties.getProperty("baseDatos"),properties.getProperty("usuario"),properties.getProperty("clave"));
        try {
            beanDAO.getConexion();
            System.out.println("La conexión se ha creado correctamente.");
            consultarEmpleados(beanDAO.getConexion(),listaCodigoEmp);
            beanDAO.close();

        } catch (SQLException sqle) {
            System.out.println("Problema al crear la conexión");
            sqle.printStackTrace();
        }
    }

    // Imaginemos que esta es una implementación básica para consultar empleados
    @Override
    public void consultarEmpleados(Connection conexion, ArrayList<Integer> listaCodigoEmp) {

            for (Integer codigo : listaCodigoEmp) {
                String consulta = "SELECT * FROM empleados WHERE emp_no = ?";
                try (PreparedStatement statement = conexion.prepareStatement(consulta)) {
                    statement.setInt(1, codigo);

                    try {

                    ResultSet resultSet = statement.executeQuery();
                    resultSet.next();

                    int emp_no = resultSet.getInt("emp_no");
                    String apellido = resultSet.getString("apellido");
                    String oficio = resultSet.getString("oficio");
                    int dir = resultSet.getInt("dir");
                    Date fecha = resultSet.getDate("fecha_alt");
                    Double salario = resultSet.getDouble("salario");
                    Double comision = resultSet.getDouble("comision");
                    int dept_no = resultSet.getInt("dept_no");

                    System.out.println("Empleado: " + emp_no + ", "+apellido + ", "+oficio + ", "+dir
                            + ", "+fecha + ", "+salario + ", "+comision + ", "+dept_no);

                    } catch (SQLException e) {
                        System.out.println("Error codigo empleado. "+e);
                    }

                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
    }
}

