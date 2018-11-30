/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 *
 * @author operaciones
 */
public class Utilidades {
    
    public static int diferencia(Date fechaInicial) throws ParseException {
        //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd H:m:s");
        Date fechaFinal = new Date();
        int diferencia=(int) ((fechaFinal.getTime()-fechaInicial.getTime())/1000);
 
        int dias=0;
        int horas=0;
        int minutos=0;
        if(diferencia>86400) {
            dias=(int)Math.floor(diferencia/86400);
            diferencia=diferencia-(dias*86400);
        }
        if(diferencia>3600) {
            horas=(int)Math.floor(diferencia/3600);
            diferencia=diferencia-(horas*3600);
        }
        if(diferencia>60) {
            minutos=(int)Math.floor(diferencia/60);
            diferencia=diferencia-(minutos*60);
        }
        if (dias>0) {
            horas = horas + (dias * 24);
        }
        return horas;
    }
    
    public static void enviarNotificacion(String to){
        try {
            String host = "smtp.gmail.com";
            String user = "pidetuestacionamiento@gmail.com";
            String pass = "portafolio7";
            String from = "pidetuestacionamiento@gmail.com";
            String subject = "Recupera tu cuenta | Pide Tu Estacionamiento";
            String messageText = "Estimad@, este es un correo de aviso preventivo, usted posee una reserva que se encuentra activa aún en nuestro sistema hace 10 horas, por lo que rogamos revisar su situacion de haber olvidado terminar la reserva, si usted desea seguir ocupando el estacionamiento favor de no tomar en cuenta este correo.";
            
            boolean sessionDebug = false;

            Properties props = System.getProperties();

            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");

            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(sessionDebug);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject);
            msg.setSentDate(new Date());
            msg.setText(messageText);

            Transport transport = mailSession.getTransport("smtp");
            transport.connect(host, user, pass);
            transport.sendMessage(msg, msg.getAllRecipients());
            transport.close();
            
        } catch (Exception ex) {
        }
    }
    
    
}
