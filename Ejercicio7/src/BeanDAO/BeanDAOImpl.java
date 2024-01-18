package BeanDAO;

import java.sql.*;

/**
 * Implementación de la interface BeanDAO
 */
public class BeanDAOImpl implements BeanDAO{

	/**
	 * Contiene el nombre de la clase Driver.
	 * @uml.property  name="driver"
	 */
	private String driver = "com.mysql.jdbc.Driver";

	/**
	 * URL base para el acceso a la base de datos
	 * @uml.property  name="urlBase"
	 */
	private String urlBase = "jdbc:mysql://localhost:3306/";

	/**
	 * Nombre de la base datos
	 * @uml.property  name="baseDatos"
	 */
	private String baseDatos = null;

	/**
	 * Nombre del usuario con el que se accederá a la base de datos
	 * @uml.property  name="usuario"
	 */
	private String usuario = null;

	/**
	 * Clave de usuario
	 * @uml.property  name="clave"
	 */
	private String clave = null;

	/**
	 * Representa una conexi�n a la base de datos
	 * @uml.property  name="conexion"
	 */
	private Connection conexion = null;

	/**
	 * Construye un bean de DAO a partir de driver, url base, 
	 * base de datos, nombre de usuario y clave
	 */
	public BeanDAOImpl(String driver, String urlBase, String baseDatos, String usuario, String clave){
		this.driver = driver;
		this.urlBase = urlBase;
		this.baseDatos = baseDatos;
		this.usuario = usuario;
		this.clave = clave;
	}

	/**
	 * Construye un bean de DAO a partir de url base, 
	 * base de datos, nombre de usuario y clave
	 */
	public BeanDAOImpl(String urlBase, String baseDatos, String usuario, String clave){
		this.urlBase = urlBase;
		this.baseDatos = baseDatos;
		this.usuario = usuario;
		this.clave = clave;
	}
				
	/**
	 * Construye un bean de DAO a partir de  
	 * base de datos, nombre de usuario y clave
	 */
	public BeanDAOImpl(String baseDatos, String usuario, String clave){
		this.baseDatos = baseDatos;
		this.usuario = usuario;
		this.clave = clave;
	}
	/**
	 * Devuelve el objeto Connection asociado al bean
	 * de servicio. Si no existe previamente, lo crea.
	 * @return  Devuelve la conexión.
	 * @throws SQLException 
	 * @uml.property  name="conexion"
	 */
	public Connection getConexion() throws SQLException {
		if (conexion==null)
			conexion = DriverManager.getConnection(urlBase + baseDatos, usuario, clave);
		return conexion;
	}
		
	/**
	 * Cierra la conexión actual.
	 * @SQLException Excepción al cerrar la conexión
	 */
	public void close() throws SQLException {
		if (conexion!=null)
                        conexion.close();
	}
		
	
	/**
	 * Getter of the property <tt>driver</tt>
	 * @return  Returns the driver.
	 * @uml.property  name="driver"
	 */
	public String getDriver() {
		return driver;
	}

	/**
	 * Setter of the property <tt>driver</tt>
	 * @param driver  The driver to set.
	 * @uml.property  name="driver"
	 */
	public void setDriver(String driver) {
		this.driver = driver;
	}
	/**
	 * Getter of the property <tt>urlBase</tt>
	 * @return  Returns the urlBase.
	 * @uml.property  name="urlBase"
	 */
	public String getUrlBase() {
		return urlBase;
	}

	/**
	 * Setter of the property <tt>urlBase</tt>
	 * @param urlBase  The urlBase to set.
	 * @uml.property  name="urlBase"
	 */
	public void setUrlBase(String urlBase) {
		this.urlBase = urlBase;
	}
	/**
	 * Getter of the property <tt>baseDatos</tt>
	 * @return  Returns the baseDatos.
	 * @uml.property  name="baseDatos"
	 */
	public String getBaseDatos() {
		return baseDatos;
	}

	/**
	 * Setter of the property <tt>baseDatos</tt>
	 * @param baseDatos  The baseDatos to set.
	 * @uml.property  name="baseDatos"
	 */
	public void setBaseDatos(String baseDatos) {
		this.baseDatos = baseDatos;
	}
	/**
	 * Getter of the property <tt>usuario</tt>
	 * @return  Returns the usuario.
	 * @uml.property  name="usuario"
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * Setter of the property <tt>usuario</tt>
	 * @param usuario  The usuario to set.
	 * @uml.property  name="usuario"
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	/**
	 * Getter of the property <tt>clave</tt>
	 * @return  Returns the clave.
	 * @uml.property  name="clave"
	 */
	public String getClave() {
		return clave;
	}

	/**
	 * Setter of the property <tt>clave</tt>
	 * @param clave  The clave to set.
	 * @uml.property  name="clave"
	 */
	public void setClave(String clave) {
		this.clave = clave;
	}
}
