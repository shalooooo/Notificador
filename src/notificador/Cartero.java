/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notificador;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import Datos.ReservaDAO;
import Datos.UsuarioDAO;
import Entidades.Reserva;
import Entidades.Usuario;
import static Util.Utilidades.enviarNotificacion;
import java.util.ArrayList;
import java.util.Date;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
/**
 *
 * @author Gonzalo
 */
public class Cartero implements Job {
    
    @Override
    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        System.out.println("Este es un mensaje impreso a las : " + new Date());
        // Rescatar lista de reservas a notificar
        ReservaDAO reservaDAO = new ReservaDAO();  
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        ArrayList<Reserva> listaReservas = reservaDAO.reservasANotificar();
        // Ciclo de notificaciones y actualizaciones en la BD        
        for(Reserva r: listaReservas){
            Usuario u = usuarioDAO.mostrarUsuario(r.getUsuarioId());
            enviarNotificacion(u.getEmail());
        }
        
    }
    
    
}
