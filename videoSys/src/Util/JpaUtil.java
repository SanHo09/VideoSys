package Util;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;

public class JpaUtil {
	private static EntityManagerFactory emf;
	
	public static EntityManager getEntityManager() {
		if(emf==null||emf.isOpen()) {
			emf = Persistence.createEntityManagerFactory("videoSys");
			return emf.createEntityManager();
		}
		return null;
	}
	
	public static void shutDown() {
		if(emf != null && emf.isOpen()) {
			emf.close();
		}
		
		emf = null;
	}
	
	public static void sendEmail(String recipient, String videoCode, String userName) {
		final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
		// Get a Properties object
				Properties props = System.getProperties();
				props.setProperty("mail.smtp.host", "smtp.gmail.com");
				props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
				props.setProperty("mail.smtp.socketFactory.fallback", "false");
				props.setProperty("mail.smtp.port", "465");
				props.setProperty("mail.smtp.socketFactory.port", "465");
				props.put("mail.smtp.auth", "true");
				props.put("mail.debug", "true");
				props.put("mail.store.protocol", "pop3");
				props.put("mail.transport.protocol", "smtp");
				final String username = "sangpvps18851@fpt.edu.vn";//
				final String password = "tmxrybxpksaxohxw";
				try {
					javax.mail.Session session = javax.mail.Session.getDefaultInstance(props, new javax.mail.Authenticator() {
						protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
							return new javax.mail.PasswordAuthentication(username, password);
						}
					});
						
				
					
					
					// -- Create a new message --
					Message msg = new MimeMessage(session);

					// -- Set the FROM and TO fields --
					msg.setFrom(new InternetAddress("sangpvps18851@fpt.edu.vn"));
					msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient, false));
					msg.setSubject("Bạn mới được chia sẻ một video "+" từ "+userName);
					msg.setText("https://www.youtube.com/watch?v="+videoCode);
					msg.setSentDate(new Date());
					Transport.send(msg);
					
				} catch (MessagingException e) {
					System.out.println("Erreur d'envoi, cause: " + e);
				}

	}
	
	public static void sendCodeEmail(String email, String content) {
		final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
		// Get a Properties object
				Properties props = System.getProperties();
				props.setProperty("mail.smtp.host", "smtp.gmail.com");
				props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
				props.setProperty("mail.smtp.socketFactory.fallback", "false");
				props.setProperty("mail.smtp.port", "465");
				props.setProperty("mail.smtp.socketFactory.port", "465");
				props.put("mail.smtp.auth", "true");
				props.put("mail.debug", "true");
				props.put("mail.store.protocol", "pop3");
				props.put("mail.transport.protocol", "smtp");
				final String username = "sangpvps18851@fpt.edu.vn";//
				final String password = "tmxrybxpksaxohxw";
				try {
					javax.mail.Session session = javax.mail.Session.getDefaultInstance(props, new javax.mail.Authenticator() {
						protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
							return new javax.mail.PasswordAuthentication(username, password);
						}
					});
						
				
					
					
					// -- Create a new message --
					Message msg = new MimeMessage(session);

					// -- Set the FROM and TO fields --
					msg.setFrom(new InternetAddress("sangpvps18851@fpt.edu.vn"));
					msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email, false));
					msg.setSubject("Mã PIN để khôi phục tài khoản của bạn: ");
					msg.setText("mã PIN: "+content);
					msg.setSentDate(new Date());
					Transport.send(msg);
					
				} catch (MessagingException e) {
					System.out.println("Erreur d'envoi, cause: " + e);
				}

	}
}
