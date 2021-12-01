package ng.com.codetrik.spectranglesWebsiteMailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(path = "/api",produces = {MediaType.APPLICATION_JSON_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE})
public class MailController {
    @Autowired
    MailService mailService;

    @PostMapping("/appointment")
    public void processMail(@RequestBody AppointmentDTO appointment){
        mailService.sendAppointmentMail(appointment);
    }

    @PostMapping("/application")
    public void processMail(@RequestBody ApplicationDTO application){ mailService.sendApplicationMail(application);}
}
