package it.revo.sms.smsTwilio;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("twilio")
public class TwilioConfig {
    private String accauntSid;
    private String authToken;
    private String trialNumber;

    public TwilioConfig(){

    }

    public String getAccauntSid() {
        return accauntSid;
    }

    public void setAccauntSid(String accauntSid) {
        this.accauntSid = accauntSid;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getTrialNumber() {
        return trialNumber;
    }

    public void setTrialNumber(String trialNumber) {
        this.trialNumber = trialNumber;
    }
}
