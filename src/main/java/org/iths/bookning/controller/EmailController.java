package org.iths.bookning.controller;

import org.iths.bookning.collection.NewsEmails;
import org.iths.bookning.entities.EmailRequest;
import org.iths.bookning.repositories.NewsEmailsRepository;
import org.iths.bookning.services.EmailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/email")
@CrossOrigin(origins = "http://localhost:3000")
public class EmailController {
    private final EmailService emailService;
    private final NewsEmailsRepository newsEmailsRepository;

    public EmailController(EmailService emailService, NewsEmailsRepository newsEmailsRepository) {
        this.emailService = emailService;
        this.newsEmailsRepository = newsEmailsRepository;
    }

    @PostMapping("/sendnews")
    public String sendEmail(@RequestParam String email) {
        try {
            newsEmailsRepository.save(new NewsEmails(email));
            emailService.sendEmail(email, "Välkommen!", "<h3>Hej och välkommen till vårt nyhetsbrev!</h3>");
            return "E-post skickat till " + email;
        } catch (IOException e) {
            return "Fel vid skickning av e-post: " + e.getMessage();
        }
    }
    @PostMapping("/send-confirmation")
    public ResponseEntity<String> sendConfirmationEmail(@RequestBody EmailRequest emailRequest) {
        try {
            emailService.sendEmail(
                    emailRequest.getEmail(),
                    "Bekräftelse på bilbokning",
                    emailRequest.getMessage()
            );
            return ResponseEntity.ok("E-post skickat till " + emailRequest.getEmail());
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Fel vid skickning av e-post: " + e.getMessage());
        }
    }

}
