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

    public boolean modificarAviso(int idReserva) {
        OracleCallableStatement cs = null;
        Connection cn = conn.conectar().getCnn();
        try {
            /*PROCEDURE SP_MODIFICAR_AVISO(P_ID_RESERVA RESERVA.ID_RESERVA%TYPE);*/
            cs = (OracleCallableStatement) cn.prepareCall(" { call RESERVA_PKG.SP_MODIFICAR_AVISO(?)}");
            cs.setInt(1, idReserva);
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
