package org.iths.bookning.controller;

import org.iths.bookning.services.EmailService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/email")
@CrossOrigin(origins = "http://localhost:3000")
public class EmailController {
    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/sendnews")
    public String sendEmail(@RequestParam String email) {
        try {
            emailService.sendEmail(email, "Välkommen!", "<h3>Hej och välkommen till vårt nyhetsbrev!</h3>");
            return "E-post skickat till " + email;
        } catch (IOException e) {
            return "Fel vid skickning av e-post: " + e.getMessage();
        }
    }
}
