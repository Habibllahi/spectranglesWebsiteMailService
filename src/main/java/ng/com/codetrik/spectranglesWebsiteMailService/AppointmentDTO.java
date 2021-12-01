package ng.com.codetrik.spectranglesWebsiteMailService;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonPropertyOrder(alphabetic = true)
public class AppointmentDTO {
    private String companyName;
    private String industry;
    private String website;
    private String workAddress;
    private String position;
    private String phoneNumber;
    private String workType;
    private String country;
    private String jobDetails;
    
}
