/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.Date;

/**
 *
 * @author Gonzalo
 */
public class Reserva {
    // Variables
    private int idReserva;
    private Date tiempoInicio;
    private Date tiempoFin;
    private int estacionamientoId;
    private int usuarioId;
    private int montoTarifa;
    private int minutosUsados;
    private int total;
    private int estPagoId;
    private int vehiculoId;
    private Date avisoPreventivo;

    // Constructores
    public Reserva() {
    }

    public Reserva(int idReserva, Date tiempoInicio, Date tiempoFin, int estacionamientoId, int usuarioId, int montoTarifa, int minutosUsados, int total, int estPagoId, int vehiculoId, Date avisoPreventivo) {
        setIdReserva(idReserva);
        setTiempoInicio(tiempoInicio);
        setTiempoFin(tiempoFin);
        setEstacionamientoId(estacionamientoId);
        setUsuarioId(usuarioId);
        setMontoTarifa(montoTarifa);
        setMinutosUsados(minutosUsados);
        setTotal(total);
        setEstPagoId(estPagoId);
        setVehiculoId(vehiculoId);
        setAvisoPreventivo(avisoPreventivo);
    }

    // Accesadores

    public int getIdReserva() {
        return idReserva;
    }

    public Date getTiempoInicio() {
        return tiempoInicio;
    }

    public Date getTiempoFin() {
        return tiempoFin;
    }

    public int getEstacionamientoId() {
        return estacionamientoId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public int getMontoTarifa() {
        return montoTarifa;
    }

    public int getMinutosUsados() {
        return minutosUsados;
    }

    public int getTotal() {
        return total;
    }

    public int getEstPagoId() {
        return estPagoId;
    }

    public int getVehiculoId() {
        return vehiculoId;
    }

    public Date getAvisoPreventivo() {
        return avisoPreventivo;
    }
    // Mutadores

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public void setTiempoInicio(Date tiempoInicio) {
        this.tiempoInicio = tiempoInicio;
    }

    public void setTiempoFin(Date tiempoFin) {
        this.tiempoFin = tiempoFin;
    }

    public void setEstacionamientoId(int estacionamientoId) {
        this.estacionamientoId = estacionamientoId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public void setMontoTarifa(int montoTarifa) {
        this.montoTarifa = montoTarifa;
    }

    public void setMinutosUsados(int minutosUsados) {
        this.minutosUsados = minutosUsados;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setEstPagoId(int estPagoId) {
        this.estPagoId = estPagoId;
    }

    public void setVehiculoId(int vehiculoId) {
        this.vehiculoId = vehiculoId;
    }
    
    public void setAvisoPreventivo(Date avisoPreventivo) {
        this.avisoPreventivo = avisoPreventivo;
    }
}