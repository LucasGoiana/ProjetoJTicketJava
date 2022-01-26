package br.com.lucasgoiana.projetojticket.client;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
@Service
public class SendEmail {
    public String sendEmail(Integer id, String title, String name, JavaMailSender mailSender){

        try {

            StringBuilder email = new StringBuilder("<p>Olá, \n");
            email.append("O Ticket: \"" + id + "-" + title +  "\" foi alterado para o status " + name).append("</p>");
            MimeMessage mail = mailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper( mail );
            helper.setTo( "lucasgoianam@hotmail.com" );
            helper.setFrom("send@lucasgoiana.com");
            helper.setSubject( "ProjetoJTicket" );



            helper.setText(email.toString(), true);
            mailSender.send(mail);
            System.out.println("Enviado");;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "a";

    }
}
