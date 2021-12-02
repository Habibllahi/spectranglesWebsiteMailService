package ng.com.codetrik.spectranglesWebsiteMailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping(path = "/",produces = {MediaType.APPLICATION_JSON_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE})
public class MailController {
    @Autowired
    MailService mailService;

    @GetMapping()
    public ResponseEntity<String> simple(){
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }
    @PostMapping("api/appointment")
    public ResponseEntity<?> processMail(@RequestBody AppointmentDTO appointment){

        mailService.sendAppointmentMail(appointment);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("api/application")
    public ResponseEntity<?> processMail(@RequestBody ApplicationDTO application){
        mailService.sendApplicationMail(application);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
