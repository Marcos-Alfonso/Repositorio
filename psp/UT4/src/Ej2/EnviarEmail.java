package Ej2;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EnviarEmail {

    private static final String CORREO_REMITENTE= "dam@peopositando.es";
    private static final String CLAVE_REMITENTE= "aula10dam2";

    public static void main(String[] args) {
        Properties p = new Properties();
        p.put("mail.smtp.auth", "true");
        p.put("mail.smtp.starttls.enable", "true");
        p.put("mail.smtp.host", "ssl0.ovh.net");
        p.put("mail.smtp.port", "587");

        try {
            String destinatarios = leeFicheroDestinatarios("Clientes.txt");
            String cuerpo = leeFicheroCuerpo("Mensaje.txt");
            Session sesion = Session.getInstance(p);
            MimeMessage mensaje = new MimeMessage(sesion);
            enviaMensaje(destinatarios, cuerpo, mensaje);
        } catch (IOException e) {
            System.err.println("No se encontraron todos los ficheros.");
        } catch (MessagingException e) {
            System.err.println("Error al configurar y enviar mensaje.");
            e.printStackTrace();
        }
    }

    private static void enviaMensaje(String destinatarios, String cuerpo, MimeMessage mensaje) throws MessagingException, UnsupportedEncodingException {
        mensaje.setFrom(new InternetAddress("marcos_alfonso_garcia@dam2.ieslamarisma.net","Spam&Arrea"));
        mensaje.setReplyTo(InternetAddress.parse("noresponder@dam2.ieslamarisma.net", false));

        mensaje.addHeader("Content-type", "text/HTML; charset=UTF-8");
        mensaje.addHeader("format", "flowed");
        mensaje.addHeader("Content-Transfer-Encoding", "8bit");

        mensaje.setSubject("- Mensaje de Spam&Arrea -", "UTF-8");
        mensaje.setText(cuerpo, "UTF-8");

        mensaje.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatarios, false));

        // Copia de correo oculta
        mensaje.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(CORREO_REMITENTE, false));

        Transport.send(mensaje, CORREO_REMITENTE, CLAVE_REMITENTE);
    }

    private static String leeFicheroCuerpo(String s) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(s));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
            sb.append("\n");
        }
        br.close();
        return sb.toString();
    }


    public static String leeFicheroDestinatarios(String s) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(s));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
            if (br.ready()) {
                sb.append(", ");
            }
        }
        br.close();
        return sb.toString();
    }
}
