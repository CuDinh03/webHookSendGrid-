import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

import java.io.IOException;

public class Example {
    public static void main(String[] args) throws IOException {
        Email from = new Email("dinhhuycu0305@gmail.com");
        String subject = "Sending with SendGrid is Fun";
        Email to = new Email("dinhhuycu0305@gmail.com");
        Content content = new Content("text/plain", "and easy to do anywhere, even with Java");
        Mail mail = new Mail(from, subject, to, content);

//        String key = "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";
        SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException ex) {
            throw ex;
        }
    }
}