package api;

import javax.mail.*;
import javax.mail.internet.MimeMultipart;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaMailApi {

    private static final JavaMailApi instance = new JavaMailApi();

    public static JavaMailApi getInstance() {
        return instance;
    }

    public Message[] getInboxMessages(String user, String password) throws Exception {

        Properties properties = new Properties();

        String host = "pop.gmail.com";
        properties.put("mail.pop3.host", host);
        properties.put("mail.pop3.port", "995");
        properties.put("mail.pop3.starttls.enable", "true");
        Session emailSession = Session.getDefaultInstance(properties);

        Store store = emailSession.getStore("pop3s");
        store.connect(host, user, password);

        Folder emailFolder = store.getFolder("INBOX");
        emailFolder.open(Folder.READ_ONLY);

        return emailFolder.getMessages();
    }

    public List getTextFromMessage(Message message) throws Exception {

        if (message.isMimeType("multipart/*")) {

            MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
            int count = mimeMultipart.getCount();
            ArrayList<String> links = new ArrayList<>();

            for (int i = 0; i < count; i++) {

                BodyPart bodyPart = mimeMultipart.getBodyPart(i);

                if (bodyPart.isMimeType("text/html")) {

                    String desc = mimeMultipart.getBodyPart(i).getContent().toString();
                    Pattern linkPattern = Pattern.compile(" <a\\b[^>]*href=\"([^\"]*)[^>]*>(.*?)</a>", Pattern.CASE_INSENSITIVE | Pattern.DOTALL);

                    Matcher pageMatcher = linkPattern.matcher(desc);
                    while (pageMatcher.find()) {
                        links.add(pageMatcher.group(1));
                    }
                }
            }

            return links;
        }

        return null;
    }
}
