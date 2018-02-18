package Project_JSP.handler;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import Project_JSP.dto.Client;
import Project_JSP.dto.Reservation;
import Project_JSP.mvc.controller.CommandHandler;
import Project_JSP.service.ReservationDaoService;

public class MyReservationCancelHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		int index = Integer.parseInt(req.getParameter("index"));
		Client client = (Client) req.getSession().getAttribute("MEMBER");
		Client nonClient = (Client) req.getSession().getAttribute("NONMEMBER");
		ObjectMapper om = new ObjectMapper();
		List<Reservation> result = null;
		Reservation reservation = new Reservation();
		String data = "";

		if (client != null) {
			reservation.setClientNum(client);
			reservation.setReservationNum(index);

			ReservationDaoService reservService = ReservationDaoService.getInstance();
			reservService.updateReservationCancel(reservation);
			result = reservService.selectReservationOnlyReserv(client.getClientNum());
		} else {
			reservation.setClientNum(nonClient);
			reservation.setReservationNum(index);

			ReservationDaoService reservService = ReservationDaoService.getInstance();
			reservService.updateReservationCancel(reservation);
			result = reservService.selectReservationOnlyReserv(nonClient.getClientNum());
		}

		if (result.isEmpty()) {
			data = om.writeValueAsString("Empty");
		} else {
			data = om.writeValueAsString(result);
		}

		res.setContentType("application/json;charset=utf-8");
		PrintWriter pw = res.getWriter();
		pw.print(data);
		pw.flush();

		return null;

	}

}
