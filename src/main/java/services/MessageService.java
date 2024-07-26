package services;

import beans.MessageBean;
import dao.MessageDAO;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.Serializable;
import java.util.List;
import java.util.Properties;

public class MessageService {

	private static final String sender = "valentinabozic251@gmail.com";
    private static final String password = "xpaqviibexgkxraj";
    private static final String port = "587";
    private static final String host = "smtp.gmail.com";

    public MessageService() {
        // TODO Auto-generated constructor stub
    }

    public List<MessageBean> getAllMessages()
    {
    	List<MessageBean> messages = MessageDAO.getAll();
    	System.out.print(messages);
        return MessageDAO.getAll();
    }

    public MessageBean getById(Integer id)
    {
        System.out.println("Message by id" +  MessageDAO.getById(id));

        return MessageDAO.getById(id);
    }

    public void changeStatus(Integer id)
    {
        MessageDAO.update(id);
    }

    public void anwserQuestion(String reicipent,String answer,String question)
    {
//    	System.out.print("Odogovaram na mejl");
//    	String result;
//    	  
//    	   String to = "valentinabozic251@gmail.com";
//
//
//    	   String from = "valentinabozic251@gmail.com";
//
//
//    	   String host = "localhost";
//
//
//    	   Properties properties = System.getProperties();
//    	   properties.setProperty("debug", "true");
//
//
//    	   properties.setProperty("mail.smtp.host", host);
//
//
//    	   Session mailSession = Session.getDefaultInstance(properties);
//
//
//    	   try {
//    	      // Create a MimeMessage object.
//    	      MimeMessage message = new MimeMessage(mailSession);
//    	      
//    	      // Set From: header field of the header.
//    	      message.setFrom(new InternetAddress(from));
//    	      
//    	      // Set To: header field of the header.
//    	      message.addRecipient(Message.RecipientType.TO,
//    	                               new InternetAddress(to));
//    	      // Set Subject: header field
//    	      message.setSubject("This is the Subject !");
//    	      
//    	      // Now set the actual message
//    	      message.setText("This is the actual message");
//    	      
//    	      // Send message
//    	      Transport.send(message);
//    	      result = "Sent email successfully....";
//    	   } catch (MessagingException mex) {
//    	      mex.printStackTrace();
//    	      result = "Error: failed to send message....";
//    	   }
//    	Properties prop = new Properties();
//    	prop.put("mail.smtp.host", "smtp.gmail.com");
//    	prop.put("mail.store.protocol", "pop3");
//    	prop.put("mail.transport.protocol",  "smtp");
//    	prop.put("mail.smtp.auth", "true");
//    	prop.put("mail.debug", "true");
//    	prop.put("mail.smtp.starttls.enable", "true");
//    	prop.put("mail.user", sender);
//    	prop.put("mail.password", password);
//    	prop.put("mail.smtp.port", 465);
//    	prop.put("mail.smtp.socketFactory.port", "465");
//    	prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//    	prop.put("mail.smtp.socketFactory.fallback", "false");
//    	System.out.print("Postavljena podaseavanja");
    	
//        Properties properties = System.getProperties();
//        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
//        properties.put("mail.smtp.auth", "true");
//        properties.put("mail.smtp.port", port);
//        properties.put("mail.smtp.host", host);
//        properties.put("mail.debug", "true");
//        properties.put("mail.smtp.starttls.enable", "true");
//        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(sender, password);
//            }
//        });
//        
//        System.out.println(session);
//        try {
//            MimeMessage message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(sender));
//            message.addRecipient(Message.RecipientType.TO, new InternetAddress(reicipent));
//            message.setSubject("WebShop - Customer Support Reply");
//            message.setText("Reply on: " + question + '\n' + '\n' + answer);
//            System.out.print("Sad ce send");
//            Transport.send(message);
//        } catch (MessagingException ex) {
//            ex.printStackTrace();
//            System.out.print("Error exception in sending email");
//        }
    }

}
