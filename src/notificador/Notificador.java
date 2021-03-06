/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notificador;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
//import org.quartz.ScheduleBuilder;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
//import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
//import static Util.Utilidades.*;

/**
 *
 * @author Gonzalo
 */
public class Notificador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SchedulerException {
        JobDetail cartero = JobBuilder.newJob(Cartero.class).build();
        // Trigger cada 1 hora con CronMaker
        Trigger cadaUnaHora = TriggerBuilder.newTrigger()
                .withIdentity("CronTrigger")
                .withSchedule(CronScheduleBuilder.cronSchedule("0 0 0/1 1/1 * ? *"))
                .build();
        Scheduler sc = StdSchedulerFactory.getDefaultScheduler();
        sc.start();
        sc.scheduleJob(cartero, cadaUnaHora);

        // Trigger cada 1 hora con SimpleScheduler 
        // Trigger t2 = TriggerBuilder.newTrigger().withIdentity("CronTrigger").withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInHours(1).repeatForever()).build();
        // Trigger cada 1 minuto de prueba
        // Trigger cadaUnMinuto = TriggerBuilder.newTrigger().withIdentity("CronTrigger").withSchedule(CronScheduleBuilder.cronSchedule("0 0/1 * 1/1 * ? *")).build();
        /**
         * * Codigo de Prueba de Funcion diferencia() String fechaPrueba =
         * "2018-11-30 09:00:00"; SimpleDateFormat dateFormat = new
         * SimpleDateFormat("yyyy-MM-dd H:m:s"); Date horaInicio =
         * dateFormat.parse(fechaPrueba); int diferencia =
         * diferencia(horaInicio); System.out.println("Diferencia: " +
         * diferencia);
         */
    }

}
