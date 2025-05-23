package org.iths.bookning.services;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EmailService {
    @Value("${spring.sendgrid.api-key}")
    private String sendGridApiKey;

    public void sendEmail(String to, String subject, String content) throws IOException {
        Email from = new Email("kouroshrentcar@gmail.com");
        Email recipient = new Email(to);
        Content emailContent = new Content("text/html", content);
        Mail mail = new Mail(from, subject, recipient, emailContent);

        SendGrid sg = new SendGrid(sendGridApiKey);
        Request request = new Request();

        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);

            System.out.println("Statuskod: " + response.getStatusCode());
            System.out.println("Svar: " + response.getBody());
        } catch (IOException ex) {
            throw ex;
        }
    }
}
