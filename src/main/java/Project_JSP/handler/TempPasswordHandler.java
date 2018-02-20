package Project_JSP.handler;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Properties;
import java.util.Random;

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

public class TempPasswordHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String id = req.getParameter("id");
		String nameEn = req.getParameter("nameEn1").toUpperCase()+" "+req.getParameter("nameEn2").toUpperCase();
		String email = req.getParameter("email");
		
		Client client = new Client();
		client.setId(id);
		client.setEmail(email);
		client.setNameEn(nameEn);
		client.setClientGrade(ClientGrade.MEMBER);
		System.out.println(client);
		ClientDaoService service = ClientDaoService.getInstance();
		Client c = service.findClientByNameAndEmailAndId(client);
		
		if(c!=null){
			String newPw =temporaryPassword(10); 
			c.setPw(newPw);
			service.updatePassword(c);
			SendEmail(c.getEmail(),newPw);
		}
		
		HashMap<String,Client> map = new HashMap<>();
		map.put("client",c);
		ObjectMapper om = new ObjectMapper();
		
		String json = om.writeValueAsString(map);
		
		res.setContentType("application/json;charset=utf-8");
		PrintWriter pw = res.getWriter();
		pw.print(json);
		pw.flush(); //고객에게 돌려줌
		return null;
	}
	
	private void SendEmail(String to, String pw){
		
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
			String subject = "신라리워즈 임시비밀번호 발송메일입니다.";
			try {
				message.setSubject(MimeUtility.encodeText(subject, "UTF-8", "B"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String PwMeg ="<h1>"+pw+"</h1>";
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

	//임시비밀번호 랜덤으로 생성
	private String temporaryPassword(int size) {

	StringBuffer buffer = new StringBuffer();

	Random random = new Random();

	String chars[] = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W"
			,"X","Y","Z","a","b","c","d","e","f","g","h","i","j","k","l","m","n",
			"o","p","q","r","s","t","u","v","w","x","y","z","0","1","2","3","4","5","6","7","8","9"};

	for (int i = 0; i < size; i++) {

	buffer.append(chars[random.nextInt(chars.length)]);

	}
	System.out.println(buffer.toString());
	return buffer.toString();
	
	}

}