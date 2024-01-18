package BeanDAO;

import java.sql.Connection;
import java.sql.SQLException;
/**
 * Interface BeanDAO
 */
public interface BeanDAO {    
    public Connection getConexion() throws SQLException;
    public void close() throws SQLException;
    public String getDriver();
    public void setDriver(String driver);
    public String getUrlBase();
    public void setUrlBase(String urlBase);
    public String getBaseDatos();
    public void setBaseDatos(String baseDatos);
    public String getUsuario();
    public void setUsuario(String usuario);
    public String getClave();
    public void setClave(String clave);
    
}
