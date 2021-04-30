package api;

import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;
import util.Configuration;

public class ReadMessage {

    protected static final Configuration config = Configuration.getInstance();
    private static final ReadMessage instance = new ReadMessage();

    public static ReadMessage getInstance() {
        return instance;
    }

    public String getSMS() {

        Twilio.init(config.getTwilioAccountSid(), config.getTwilioToken());
        ResourceSet<Message> messages = Message.reader().limit(20).read();

        String message = null;
        for(Message record : messages) {

            System.out.println("Verification code message: " + record.getBody());
            message = record.getBody();
            break;
        }
        return message;
    }
}
