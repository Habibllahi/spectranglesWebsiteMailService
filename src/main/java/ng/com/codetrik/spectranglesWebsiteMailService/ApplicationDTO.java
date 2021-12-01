package ng.com.codetrik.spectranglesWebsiteMailService;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.net.URL;
import java.util.List;

@Data
@JsonPropertyOrder(alphabetic = true)
public class ApplicationDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String city;
    private String country;
    private Gender gender;
    private Proficiency proficiency;
    private double salaryExpectation;
    private String currentOrganization;
    private EmploymentStatus employmentStatus;
    private String currentJob;
    private int totalYearOfExperience;
    private String preferredWorkType;
    private List<String> otherSkills;
    private URL linkedProfile;
    private URL portfolioUrl;
    private URL twitterUrl;
    private URL githubUrl;
    private String additionalInformation;

}
