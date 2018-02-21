package Project_JSP.handler;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;
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

import Project_JSP.dto.QnaReply;
import Project_JSP.mvc.controller.CommandHandler;
import Project_JSP.service.QnaReplyService;

public class AdminReplyUpdateHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		int num = Integer.parseInt(req.getParameter("num"));
		String email = req.getParameter("email");
		String grade = req.getParameter("clientGrade");
		String reply = req.getParameter("reply");
	
		
		 if(grade.equals("NONMEMBER")){
			 SendEmail(email,reply);
		 }
		 
		 QnaReply re = new QnaReply();
		 re.setNum(num);
		 re.setContent(reply);
		 Date time = new Date();
		 re.setTime(time);
		
		 QnaReplyService service = QnaReplyService.getInstance();
		 service.updateReply(re);
		
		 
		 QnaReply confirm = service.selectQnaReplyByNum(re);
		 HashMap<String,QnaReply> map = new HashMap<>();
			map.put("reply",confirm);
			ObjectMapper om = new ObjectMapper();
			
			String json = om.writeValueAsString(map);
			
			res.setContentType("application/json;charset=utf-8");
			PrintWriter pw = res.getWriter();
			pw.print(json);
			pw.flush(); //고객에게 돌려줌
		return null;
	}
	
	private void SendEmail(String to, String Meg){
		
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
			String subject = "신라리워즈 고객님께서 문의하신 내용입니다.";
			try {
				message.setSubject(MimeUtility.encodeText(subject, "UTF-8", "B"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String qnaMeg ="<h1>고객님께서 문의하신 내용입니다</h1>"+Meg;
			// Text
			message.setText(qnaMeg,"UTF-8");
			message.setHeader("content-Type", "text/html");
			
			

			// send the message
			Transport.send(message);
			System.out.println("전송성공");

		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}


}
