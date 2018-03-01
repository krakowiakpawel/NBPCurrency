package pl.pkrakowiak;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

@WebServlet("/")
public class App extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Rate> rList = unmarshal().getRates();

//		System.out.println(rList);

		System.out.println(rList.get(0).getCurrency());
		System.out.println(rList.get(0).getCode());
		System.out.println(rList.get(0).getAsk());
		System.out.println(rList.get(0).getBid());

		
		
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		try {

			request.setAttribute("rates", rList);

			getServletContext().getRequestDispatcher("/WEB-INF/view.jsp").forward(request, response);

		} catch (Exception e) {
			response.getWriter().append("Błąd, try again ;(");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public Rates unmarshal() {
		try {
			File file = new File("c.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Rates.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Rates rates = (Rates) jaxbUnmarshaller.unmarshal(file);

			// URL url = new URL("http://api.nbp.pl/api/exchangerates/tables/c");
			// HttpURLConnection http = (HttpURLConnection) url.openConnection();
			// http.addRequestProperty("User-Agent", "Mozilla/4.76");
			// InputStream is = http.getInputStream();
			// System.out.println(is);
			return rates;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}

	}

}
