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
import Entidades.Reserva;
import java.sql.Date;
import java.util.ArrayList;
import static Util.Utilidades.diferencia;
/**
 *
 * @author operaciones
 */
public class ReservaDAO {
    
    Conexion conn;

    public ReservaDAO() {
        conn = new Conexion();
    }
    
    public ArrayList<Reserva> reservasANotificar() {
        OracleCallableStatement cs = null;
        Connection cn = conn.conectar().getCnn();
        ResultSet rs = null;

        ArrayList<Reserva> listaReservas = new ArrayList<Reserva>();
        try {
            cs = (OracleCallableStatement) cn.prepareCall(" { call RESERVA_PKG.SP_TODOS_RESERVA(?)}");
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            rs = (ResultSet) cs.getObject(1);
            while (rs.next()) {
                Reserva reserva = new Reserva();
                reserva.setIdReserva(rs.getInt("ID_RESERVA"));
                reserva.setTiempoInicio(rs.getDate("TIEMPO_INICIO"));
                reserva.setTiempoFin(rs.getDate("TIEMPO_FIN"));
                reserva.setEstacionamientoId(rs.getInt("ESTACIONAMIENTO_ID"));
                reserva.setUsuarioId(rs.getInt("USUARIO_ID_USUARIO"));
                reserva.setMontoTarifa(rs.getInt("MONTO_TARIFA"));
                reserva.setMinutosUsados(rs.getInt("MINUTOS_USADOS"));
                reserva.setTotal(rs.getInt("TOTAL"));
                reserva.setEstPagoId(rs.getInt("EST_PAGO_ID_ESTADO"));
                reserva.setVehiculoId(rs.getInt("VEHICULO_ID"));
                reserva.setAvisoPreventivo(rs.getDate("AVISO_PREVENTIVO"));
                if (reserva.getTiempoFin() == null 
                    && reserva.getAvisoPreventivo() == null
                    && diferencia(reserva.getTiempoInicio()) >= 10) {
                    listaReservas.add(reserva);
                }
            }
            // Cierre de conexion y liberacion de recursos
            rs.close();
            cn.close();
            cs.close();
        } catch (Exception mensaje) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, mensaje);
        } finally {
            conn.close();
        }
        return listaReservas;
    }
    
    public boolean modificarReserva(Reserva reserva) {
        OracleCallableStatement cs = null;
        Connection cn = conn.conectar().getCnn();
        try {
            /*PROCEDURE SP_MODIFICAR_RESERVA(	P_ID_RESERVA RESERVA.ID_RESERVA%TYPE,
                                                P_TIEMPO_INICIO RESERVA.TIEMPO_INICIO%TYPE,
                                                P_TIEMPO_FIN RESERVA.TIEMPO_FIN%TYPE,
                                                P_ESTACIONAMIENTO_ID RESERVA.ESTACIONAMIENTO_ID%TYPE,
                                                P_USUARIO_ID_USUARIO RESERVA.USUARIO_ID_USUARIO%TYPE,
                                                P_MONTO_TARIFA RESERVA.MONTO_TARIFA%TYPE,
                                                P_MINUTOS_USADOS RESERVA.MINUTOS_USADOS%TYPE,
                                                P_TOTAL RESERVA.TOTAL%TYPE,
                                                P_EST_PAGO_ID_ESTADO RESERVA.EST_PAGO_ID_ESTADO%TYPE,
                                                P_VEHICULO_ID RESERVA.VEHICULO_ID%TYPE);*/
            cs = (OracleCallableStatement) cn.prepareCall(" { call RESERVA_PKG.SP_MODIFICAR_RESERVA(?,?,?,?,?,?,?,?,?,?)}");
            cs.setInt(1, reserva.getIdReserva());
            cs.setDate(2, (Date) reserva.getTiempoInicio());
            cs.setDate(3, (Date) reserva.getTiempoFin());
            cs.setInt(4, reserva.getEstacionamientoId());
            cs.setInt(5, reserva.getUsuarioId());
            cs.setInt(6, reserva.getMontoTarifa());
            cs.setInt(7, reserva.getMinutosUsados());
            cs.setInt(8, reserva.getTotal());
            cs.setInt(9, reserva.getEstPagoId());
            cs.setInt(10, reserva.getVehiculoId());
            cs.execute();
            // Cierre de conexion y liberacion de recursos
            cn.close();
            cs.close();
            return true;
        } catch (Exception mensaje) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, mensaje);
            return false;
        } finally {
            conn.close();
        }
    }
    
    
    
}
