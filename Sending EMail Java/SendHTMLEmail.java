import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendHTMLEmail {

   public static void main(String [] args) {
      // Recipient's email ID needs to be mentioned.
      String to = "jgranados@insite360suite.com";

      // Sender's email ID needs to be mentioned
      String from = "sc29-uat-bosselman@insite360suite.com";

      // Assuming you are sending email from localhost
      String host = "localhost";

      // Get system properties
      Properties properties = System.getProperties();

      // Setup mail server
      properties.setProperty("mailhost.fuelquest.com", host);

      // Get the default Session object.
      Session session = Session.getDefaultInstance(properties);

      try {
         // Create a default MimeMessage object.
         MimeMessage message = new MimeMessage(session);

         // Set From: header field of the header.
         message.setFrom(new InternetAddress(from));

         // Set To: header field of the header.
         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

         // Set Subject: header field
         message.setSubject("This is a test from SC29 HOST UAT - Bosselman!");

         // Send the actual HTML message, as big as you like
         message.setContent("<h1>This is a test from SC29 UAT Bosselman</h1>", "text/html");

         // Send message
         Transport.send(message);
         System.out.println("Sent message successfully....");
      } catch (MessagingException mex) {
         mex.printStackTrace();
      }
   }
}