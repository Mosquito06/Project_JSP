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
			SendEmail(c,newPw);
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
	
	private void SendEmail(Client to, String pw){
		
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
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to.getEmail()));

			// Subject
			String subject = "신라리워즈 임시비밀번호 발송메일입니다.";
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
					+ "<div style='float:left; width:680px; background:#FFF; min-height:100px; margin:0 10px; padding:0; padding-bottom:10px;'>"
					+ "<div style='margin:30px;line-height:200%'><p style='margin:0; padding:0;color:#666;'>안녕하십니까. 신라리워즈입니다. </p>"
					+ "<p style='margin:0; padding:0;color:#666;'>"+to.getNameEn()+"님의 임시비밀번호를 안내해 드립니다.</p></div>"
					+ "	<div style='background-color:#f9f7f4;border-top:1px solid #edeae6;border-bottom:1px solid #edeae6;padding:10px 0 5px 0;'>"
					+ "<div style='margin:10px 30px 0 30px;'>"
					+ "<p style='color:#333;'>아래의 임시 비밀번호로 로그인 하신 후에 타인에게 공개되지 않도록 비밀번호를 변경해 주시기 바랍니다.</p>"
					+ "<div style='overflow:hidden;width:290px;margin:20px 0 30px 165px;'>"
					+ "<span style='display:block; width:87px; height:40px; background:url(http://www.shilla.net/images/ko/seoul/email/emailPwd/tmpPwdText.gif); text-indent:-9999%; overflow:hidden;float:left;'>임시비밀번호</span>"
					+ "<span style='float:right;width:185px;height:40px;background-color:#dbdbdb;font-size:20px;line-height:40px;text-align:center;font-family:Verdana;'>"+pw+"</span></div></div></div>"
					+ "<div style='margin:10px 30px 0 30px;padding:20px 0;text-align:center;'>"
							+ "<a style='text-decoration:none; color:#555' target='_blank' href='http://localhost:8080/Project_JSP/login.do'><img style='border:0;' src='http://www.shilla.net/images/ko/seoul/email/emailPwd/loginBtn.gif' alt='로그인 버튼'></a></div></div>"
							+ "<div style='width:700px;'>"
							+ "<div style='background:#f1e3c4; float:left; overflow:hidden;padding:20px 40px; width:620px;'><div style='float:left;width:134px;'>"
							+ "<h2 style='margin:20px 0;'><a style='text-decoration:none; color:#555' target='_blank' href='http://localhost:8080/Project_JSP/login.do'><img style='border:0;' src='http://www.shillahotels.com/images/ko/common/email/theShilla/fLogo.gif' alt=''></a></h2></div>"
							+ "<div style='float:right;width:465px;margin-top:15px;'><p style='color:#3e2b2c;font-size:11px; '>본 메일은 발신전용 메일입니다. 궁금하신 점은 <a style='text-decoration:none; color:#555' target='_blank' href='http://www.shillahotels.com/membership/inquires/contactus/memIndex.do?lang=ko'>Contact Us</a>로 문의해주시기 바랍니다.</p></div></div>"
							+ "<div style='float:left; background-color:#3e2b2c;padding:10px 0;text-align:center;width:100%;'>"
							+ "<p style='font-size:10px;color:#ab9899;'>Copyright © HOTEL SHILLA CO LTD. All Rights Reserved. 신라리워즈 : TEL +82-2-2230-5528</p></div></div></div>";
			
			// Text/Project_JSP/img/login/login.gif
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