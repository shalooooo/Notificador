/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notificador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Gonzalo
 */
public class Conexion {
    private Connection cnn;
    private final String BaseDeDatos = "jdbc:oracle:thin:@localhost:1521:xe";
    private final String Usuario = "pide_tu_estacionamiento";
    private final String Pass = "pide_tu_estacionamiento";

    public Conexion() {
        this.conectar();
    }

    public Connection getCnn() {
        return cnn;
    }

    public void setCnn(Connection cnn) {
        this.cnn = cnn;
    }
        
    public void desconectarBD() {
        try {
            this.getCnn().close();
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());
        }
    }
    
    public Connection getConection()
    {
        try{
        DriverManager.deregisterDriver(new oracle.jdbc.OracleDriver());
        //String BaseDeDatos = "jdbc:oracle:thin:@localhost:1521:xe";
        cnn= DriverManager.getConnection(BaseDeDatos,Usuario,Pass);
            if(cnn==null)
            {
                System.out.println("Conexion fallida");
            }
        }
        catch(SQLException e)
        {
            System.out.println("error"+e);
        }
        return cnn;
    }
    
    private void conectar() {
        try{
        Class.forName("oracle.jdbc.OracleDriver");
        //String BaseDeDatos = "jdbc:oracle:thin:@localhost:1521:xe";
        cnn= DriverManager.getConnection(BaseDeDatos,Usuario,Pass);
            if(cnn==null)
            {
                System.out.println("Conexion fallida");
            }
        }
        catch(ClassNotFoundException | SQLException e)
        {System.out.println("error"+e);}
    }
}
