import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String instructionDate = request.getParameter("InstructionDate");
		String settlementDate  = request.getParameter("SettlementDate");
		String currency = request.getParameter("Currency");

		String agreedFx = request.getParameter("AgreedFx");
		String units = request.getParameter("Units");
		String price_per_unit = request.getParameter("Priceperunit");

		Date instructionDatenow = new Date(instructionDate);
		Date settlementDatenow = new Date(settlementDate);

		SimpleDateFormat simpleDateformat = new SimpleDateFormat("E"); // the
																		// day
																		// of
																		// the
																		// week
																		// abbreviated
		System.out.println(simpleDateformat.format(instructionDatenow));
		int agreedFx_count = Integer.parseInt(agreedFx);
		int units_count = Integer.parseInt(units);
		int price_per_unit_count = Integer.parseInt(price_per_unit);

		System.out.println(simpleDateformat.format(settlementDatenow));

		if (LoginDao.validate(instructionDate, settlementDate, currency)) {
			if (isNumeric(agreedFx) && isNumeric(units) && isNumeric(price_per_unit)) {
				double trade_amount = agreedFx_count * units_count * (price_per_unit_count);
				out.print("Total USD amount in trade is " + trade_amount);

			}
		} else {
			out.print("Sorry trade would be settled in nxt");
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.include(request, response);
		}

		out.close();
	}

	public static boolean isNumeric(String str) {
		try {
			double check_Num = Double.parseDouble(str);

		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

}
