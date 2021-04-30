package util;

import java.io.InputStream;
import java.util.Properties;

public class Configuration {

    private static final Configuration instance = new Configuration();

    private String rainBaseUrl;
    private String rainUserFirstName;
    private String rainUserLastName;
    private String rainUserEmail;
    private String rainUserPassword;
    private String rainUser2Email;
    private String rainUser2Password;
    private String twilioAccountSid;
    private String twilioToken;
    private String userEmail;
    private String userPassword;
    private String userPhoneNumber;

    public static Configuration getInstance() {
        return instance;
    }

    private Configuration() {

        try (InputStream is = ClassLoader.getSystemResourceAsStream("config.properties")) {

            Properties configProps = new Properties();
            configProps.load(is);

            this.rainBaseUrl = configProps.getProperty("rain.base.url");
            this.rainUserFirstName = configProps.getProperty("rain.user.firstName");
            this.rainUserLastName = configProps.getProperty("rain.user.lastName");
            this.rainUserEmail = configProps.getProperty("rain.user.email");
            this.rainUserPassword = configProps.getProperty("rain.user.password");
            this.rainUser2Email = configProps.getProperty("rain.user2.email");
            this.rainUser2Password = configProps.getProperty("rain.user2.password");
            this.twilioAccountSid = configProps.getProperty("twilio.account.sid");
            this.twilioToken = configProps.getProperty("twilio.token");
            this.userEmail = configProps.getProperty("user.email");
            this.userPassword = configProps.getProperty("user.email.password");
            this.userPhoneNumber = configProps.getProperty("user.phone.number");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getRainBaseUrl() { return rainBaseUrl; }
    public String getRainUserFirstName() { return rainUserFirstName; }
    public String getRainUserLastName() { return rainUserLastName; }
    public String getRainUserEmail() { return rainUserEmail; }
    public String getRainUserPassword() { return rainUserPassword; }
    public String getTwilioAccountSid() { return twilioAccountSid; }
    public String getTwilioToken() { return twilioToken; }
    public String getUserEmail() { return userEmail; }
    public String getUserEmailPassword() { return userPassword; }
    public String getUserPhoneNumber() { return userPhoneNumber; }
    public String getRainUser2Email() { return rainUser2Email; }
    public String getRainUser2Password() { return rainUser2Password; }
}
