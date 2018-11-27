/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notificador;


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
        // Conectarse a la BD        
        // Rescatar lista de reservas a notificar
        // Ciclo de notificaciones y actualizaciones en la BD        
        
    }
}
