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
			
			String PwMeg="<div style='width:700px;background-color:#f1e3c4;margin:0 auto; padding:0;font:12px/160% Dotum,'돋움',serif; color:#101010;overflow:hidden;'>"
					+ "<div style='height:70px;text-align:center;'><h1 style='margin:0px; padding:25px 0 0 0;'>"
					+ "<a style='text-decoration:none; color:#555' target='_blank' href='http://localhost:8080/Project_JSP/index.jsp'>"
					+ "<img style='border:0;' src='http://www.shillahotels.com/images/ko/common/email/rewards/hLogo.gif' alt=''></a></h1></div>"
					+"<img style='border:0; vertical-align:middle' src='http://www.shillahotels.com/images/ko/common/email/rewards/mainImg2.jpg' alt='신라리워즈 이미지'>"
					+ "<div style='float:left; width:696px; background:#FFF; min-height:200px; margin:0px; padding:0; padding-bottom:10px; border:2px solid #f1e3c4'>"
					+ "<div style='margin:30px;line-height:200%'><p style='margin:0; padding:0;color:#666;'>안녕하십니까. 신라리워즈입니다. </p>"
					+ "<p style='margin:0; padding:0;color:#666;'>고객님께서 문의내신 내용의 답변입니다. 신라리워즈를 이용해 주셔서 감사합니다.</p></div>"
					+ "	<div style='background-color:#f9f7f4;border-top:1px solid #edeae6;border-bottom:1px solid #edeae6;padding:10px 0 5px 0; width:650px; margin:0 auto;'>"
					+ "<div style='padding:10px 0px 10px 30px;'>"
					+ "<p style='color:#333;'>"+Meg+"</p></div></div>"
					+ "</div>"
							+ "<div style='width:700px;'>"
							+ "<div style='background:#f1e3c4; float:left; overflow:hidden;padding:20px 40px; width:620px;'><div style='float:left;width:134px;'>"
							+ "<h2 style='margin:20px 0;'><a style='text-decoration:none; color:#555' target='_blank' href='http://localhost:8080/Project_JSP/login.do'><img style='border:0;' src='http://www.shillahotels.com/images/ko/common/email/theShilla/fLogo.gif' alt=''></a></h2></div>"
							+ "<div style='float:right;width:465px;margin-top:15px;'><p style='color:#3e2b2c;font-size:11px; '>본 메일은 발신전용 메일입니다. 궁금하신 점은 <a style='text-decoration:none; color:#555' target='_blank' href='http://www.shillahotels.com/membership/inquires/contactus/memIndex.do?lang=ko'>Contact Us</a>로 문의해주시기 바랍니다.</p></div></div>"
							+ "<div style='float:left; background-color:#3e2b2c;padding:10px 0;text-align:center;width:100%;'>"
							+ "<p style='font-size:10px;color:#ab9899;'>Copyright © HOTEL SHILLA CO LTD. All Rights Reserved. 신라리워즈 : TEL +82-2-2230-5528</p></div></div></div>";
			
			
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
