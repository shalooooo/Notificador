/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;
import Entidades.Usuario;

/**
 *
 * @author operaciones
 */
public class UsuarioDAO {
    
    private Conexion conn;

    public UsuarioDAO() {
        conn = new Conexion();
    }
    
    public Usuario mostrarUsuario(int id) {
        OracleCallableStatement cs = null;
        Connection cn = conn.conectar().getCnn();
        ResultSet rs = null;
        Usuario usuario = new Usuario();
        try {
            // PROCEDURE SP_MOSTRAR_USUARIO(P_ID_USUARIO USUARIO.ID_USUARIO%TYPE, PCURSOR OUT SYS_REFCURSOR);
            cs = (OracleCallableStatement) cn.prepareCall(" { call USUARIO_PKG.SP_MOSTRAR_USUARIO(?,?)}");
            cs.setInt(1, id);
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.execute();
            rs = (ResultSet) cs.getObject(2);
            while (rs.next()) {
                usuario.setIdUsuario(rs.getInt("ID_USUARIO"));
                usuario.setNombre(rs.getString("NOMBRE"));
                usuario.setRut(rs.getInt("RUT"));
                usuario.setDv(rs.getString("DV"));
                usuario.setApePaterno(rs.getString("APE_PATERNO"));
                usuario.setApeMaterno(rs.getString("APE_MATERNO"));
                usuario.setEmail(rs.getString("EMAIL"));
                usuario.setTelefono(rs.getString("TELEFONO"));
                usuario.setPassword(rs.getString("PASSWORD"));
                usuario.setRolId(rs.getInt("ROL_ID_ROL"));
                usuario.setEstadoUsuarioId(rs.getInt("EST_USUARIO_ID_ESTADO"));
                usuario.setCuentaId(rs.getInt("CUENTA_ID_CUENTA"));
                usuario.setTarjetaId(rs.getInt("TARJETA_ID_TARJETA"));
            }
            // Cierre de conexion y liberacion de recursos
            rs.close();
            cn.close();
            cs.close();
        } catch (Exception mensaje) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, mensaje);
        } finally {
            conn.close();
        }
        return usuario;
    }
}
