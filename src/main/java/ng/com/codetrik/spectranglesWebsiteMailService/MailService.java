package ng.com.codetrik.spectranglesWebsiteMailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
    @Autowired
    JavaMailSender mailSender;

    @Value("codetrik@gmail.com")
    String sender;

    @Value("spectrangletechnologies@gmail.com")
    String receiver;

    public void sendAppointmentMail(AppointmentDTO appointment){
        var mail = setupMail("Appointment Booking");
        mail.setText("\n" +
                "Dear Spectrangle Technologies Team \n"+
                appointment.getCompanyName()+" writes to book a work appointment \n"+
                "phone: "+appointment.getPhoneNumber()+"\n"+
                "work Address: "+ appointment.getWorkAddress()+"\n"+
                "work Type: "+ appointment.getWorkType()+"\n"+
                "website: "+ appointment.getWebsite()+"\n"+
                "position: "+ appointment.getPosition()+"\n"+
                "country: "+ appointment.getCountry()+"\n"+
                "industry: "+ appointment.getIndustry()+"\n"+
                "The job detail is as follows:"+"\n"+
                appointment.getJobDetails()
        );
        mailSender.send(mail);
    }

    public void sendApplicationMail(ApplicationDTO application){
        var mail = setupMail("Application for the role of "+ application.getPreferredWorkType());
        mail.setText("\n"+
                "Dear Spectrangle Technologies Team \n"+
                "I " + application.getLastName() +" " + application.getFirstName() + " "+
                "hereby apply for the role of " + application.getPreferredWorkType() +" "+
                "in your respected Organization. I have " + application.getTotalYearOfExperience() + " years of experience "+
                "and " +application.getProficiency() + " in "+application.getPreferredWorkType()+" and my employment status is " + "\""+application.getEmploymentStatus()+"\""+"."+
                "My Salary expectation is " + application.getSalaryExpectation() + " and the below is my employment detail: \n"+
                "Current organization: " + application.getCurrentOrganization() + "\n"+
                "Current Job: " + application.getCurrentJob()+ "\n"+
                "Preferred work type: " + application.getPreferredWorkType() + "\n"+"\n"+"\n"+
                "Other Skills: " + listOutSkills(application)+"\n"+
                "Below are my social links and work portfolio: "+ "\n"+
                "LinkedIn: " + application.getLinkedProfile().toString() + "\n"+
                "Github: " + application.getGithubUrl().toString() + "\n"+
                "Portfolio: " + application.getPortfolioUrl().toString() + "\n"+
                "Twitter: " + application.getTwitterUrl().toString() + "\n" + "\n" + "\n"+

                "Additional Information are as follows: \n" + application.getAdditionalInformation().toString()

                );
        mailSender.send(mail);
    }

    public SimpleMailMessage setupMail(String subject){
        var mail = new SimpleMailMessage();
        mail.setSubject(subject);
        mail.setFrom(sender);
        mail.setTo(receiver);
        return mail;
    }

    public String listOutSkills(ApplicationDTO application){
        var skills = "";
        for(String skill : application.getOtherSkills()){
            skills = skills.concat(skill+", ");
        }
        return skills;
    }
}
