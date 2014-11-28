package br.com.cavy.training.management.business.smtp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import br.com.cavy.training.management.smtp.util.PropertisUtil;

public class SMTPMailSender {
	
	public static class SMTPAuth {
		
		private String username;
		private String password;
		
		public SMTPAuth(String username, String password) {
			this.username = username;
			this.password = password;
		}
		
		protected String getUsername() {
			return this.username;
		}
		
		protected String getPassword() {
			return this.password;
		}
	}
	
	private String hostname;
	private String port;
	private SMTPAuth auth;
	
	private Logger LOG = Logger.getAnonymousLogger();
	
	private static Queue<Message> messageErrorList = new LinkedList<Message>();
	
	public SMTPMailSender() {
		this.loadConfig();
	}
	
	public SMTPMailSender(String hostname, String port) {
		this.hostname = hostname;
		this.port = port;
	}
	
	public SMTPMailSender(String hostname, String port, SMTPAuth auth) {
		this.hostname = hostname;
		this.port = port;
		this.auth = auth;
	}

	public void sendMessage(String title, String message, String from, String to) {
		sendMessage(title, message, from, to, null, null);
	}

	public void sendMessage(String title, String message, String to) {
		sendMessage(title, message, auth.username, to, null, null);
	}
	
	public void sendMessage(String title, String message, String from,
				String to, String cc, String bcc) {
		
		synchronized (messageErrorList) {
			
			Message msg = null;
			
			try {
				
				msg = new MimeMessage(this.getSession());
				
				this.getMessage(msg, from, to, cc, bcc, title, message);
				
				this.sendMessage(msg);
				
				if (!messageErrorList.isEmpty()) {
					msg = null;
					this.tryAgain();
				}
				
			} catch (Exception e) {
				if (msg != null) {
					messageErrorList.add(msg);
				}
				LOG.log(Level.SEVERE, "Erro ao enviar E-mail: " + e.getMessage());
				LOG.log(Level.SEVERE, e.getStackTrace().toString());
			}
		}
	}
	
	private void getMessage(Message msg, String from, String to,
			String cc, String bcc, String title, String message) {

		try {
		
			msg.setFrom(new InternetAddress(from));
			
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			
			if (cc != null) {
				msg.setRecipients(Message.RecipientType.CC, InternetAddress.parse(cc));
			}
			if (bcc != null) {
				msg.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(bcc));
			}
			
			msg.setSubject(title);
			msg.setText(message);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private Session getSession() {
		
		Properties props = new Properties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.host", this.hostname);
		props.put("mail.smtp.port", this.port);
		// props.put("mail.from", from);
		
		// FIXME: Configura��es para SSL
		// props.put("mail.smtp.socketFactory.port", this.port);
		// props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		// props.put("mail.smtp.socketFactory.fallback", "true");
		// MailSSLSocketFactory sf = new MailSSLSocketFactory();
		// sf.setTrustAllHosts(true);
		// props.put("mail.smtp.ssl.socketFactory", sf);
		
		if (this.auth != null) {
			props.put("mail.smtp.auth", "true");
		}
		
		Session session = (this.auth == null) ? 
			Session.getDefaultInstance(props)
				: 
					Session.getDefaultInstance(props,
						new Authenticator() {
							protected PasswordAuthentication getPasswordAuthentication() {
								return new PasswordAuthentication(auth.getUsername(), auth.getPassword());
							}
						}
					);
		
		return session;
	}

	/**
	 * Envia as mensagens que n�o foram enviadas.
	 */
	private void tryAgain() {
		
		synchronized (messageErrorList) {
		
			List<Message> successList = new ArrayList<Message>();
			
			for (Message message : messageErrorList) {
				
				try {
				
					this.sendMessage(message);
					
					successList.add(message);
					
				} catch (Exception e) {
					messageErrorList.removeAll(successList);
					throw new RuntimeException(e);
				}
			}
			
			messageErrorList.removeAll(successList);
		}
	}
	
	/**
	 * Envia a mensagem.
	 * 
	 * @param message
	 */
	private void sendMessage(Message message) {
		
		try {

			Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);	
		}
	}
	
	/**
	 * Carrega as configura��es de acesso ao servidor SMTP
	 */
	private void loadConfig() {
		
		this.auth = 
			new SMTPMailSender.SMTPAuth(
				PropertisUtil.getMessage("smtp.config.username"), 
				PropertisUtil.getMessage("smtp.config.password"));
		
		this.hostname = PropertisUtil.getMessage("smtp.config.hostname");
		this.port = PropertisUtil.getMessage("smtp.config.port");
		
	}
	
}
