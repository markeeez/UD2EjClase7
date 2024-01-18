package Aplicacion;

import BeanDAO.BeanDAO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import BeanDAO.BeanDAOImpl;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		Consulta c = new Consulta();
		c.consultarEmpleados();

	}

}
