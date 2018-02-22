package Project_JSP.handler;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import Project_JSP.dto.Client;
import Project_JSP.dto.ClientGrade;
import Project_JSP.mvc.controller.CommandHandler;
import Project_JSP.service.ClientDaoService;

public class FindReservationNumHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String nameEn1 = req.getParameter("nameEn1");
		String nameEn2 = req.getParameter("nameEn2");
		String nameEn = nameEn1.toUpperCase()+" "+nameEn2.toUpperCase();
		String email = req.getParameter("email");
		
		Client client = new Client();
		client.setNameEn(nameEn);
		client.setEmail(email);
		client.setClientGrade(ClientGrade.NONMEMBER);
		ClientDaoService service = ClientDaoService.getInstance();
		Client c = service.selectNonClientByNameAndEmil(client);
		
		if(c !=null){
			SendEmail(c.getEmail(),c.getId());
		}
		
		HashMap<String,Client> map = new HashMap<>();
		map.put("client",c);
		ObjectMapper om = new ObjectMapper();
		
		String json = om.writeValueAsString(map);
		
		res.setContentType("application/json;charset=utf-8");
		PrintWriter pw = res.getWriter();
		pw.print(json);
		pw.flush(); //고객에게 돌려줌
		System.out.println(c);
		return null;
	}
	
	private void SendEmail(String to, String reservation){
		
		 String host = "smtp.naver.com";
		String user = "rkd7327";
		String password = "rkdgus0519";
		
		
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.auth", "true");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});
	
		// Compose the message
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			// Subject
			String subject = "신라리워즈 예약번호  재발송메일입니다.";
			try {
				message.setSubject(MimeUtility.encodeText(subject, "UTF-8", "B"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String PwMeg ="<h1>고객님의 예약번호입니다. : " +reservation+"</h1>";
			// Text
			message.setText(PwMeg,"UTF-8");
			message.setHeader("content-Type", "text/html");
			
			

			// send the message
			Transport.send(message);
			System.out.println("전송성공");

		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

}
