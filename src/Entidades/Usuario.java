/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Gonzalo
 */
public class Usuario {
    // Variables
    private int idUsuario;
    private String nombre;
    private int rut;
    private String dv;
    private String apePaterno;
    private String apeMaterno;
    private String email;
    private String telefono;
    private String password;
    private int rolId;
    private int estadoUsuarioId;
    private int cuentaId;
    private int tarjetaId;
    
    // Constructor sin parametros

    public Usuario() {
    }
    
    
    // Constructor con parametros
    public Usuario(int idUsuario, String nombre, int rut, String dv, String apePaterno, String apeMaterno, String email, String telefono, String password, int rolId, int estadoUsuarioId, int cuentaId, int tarjetaId) {
        //setIdUsuario(idUsuario);
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.rut = rut;
        this.dv = dv;
        this.apePaterno = apePaterno;
        this.apeMaterno = apeMaterno;
        this.email = email;
        this.telefono = telefono;
        this.password = password;
        this.rolId = rolId;
        this.estadoUsuarioId = estadoUsuarioId;
        this.cuentaId = cuentaId;
        this.tarjetaId = tarjetaId;
    }
    
    // Accesadores

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public int getRut() {
        return rut;
    }

    public String getDv() {
        return dv;
    }

    public String getApePaterno() {
        return apePaterno;
    }

    public String getApeMaterno() {
        return apeMaterno;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getPassword() {
        return password;
    }

    public int getRolId() {
        return rolId;
    }

    public int getEstadoUsuarioId() {
        return estadoUsuarioId;
    }

    public int getCuentaId() {
        return cuentaId;
    }

    public int getTarjetaId() {
        return tarjetaId;
    }
    
    // Mutadores 

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public void setDv(String dv) {
        this.dv = dv;
    }

    public void setApePaterno(String apePaterno) {
        this.apePaterno = apePaterno;
    }

    public void setApeMaterno(String apeMaterno) {
        this.apeMaterno = apeMaterno;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRolId(int rolId) {
        this.rolId = rolId;
    }

    public void setEstadoUsuarioId(int estadoUsuarioId) {
        this.estadoUsuarioId = estadoUsuarioId;
    }

    public void setCuentaId(int cuentaId) {
        this.cuentaId = cuentaId;
    }

    public void setTarjetaId(int tarjetaId) {
        this.tarjetaId = tarjetaId;
    }
}