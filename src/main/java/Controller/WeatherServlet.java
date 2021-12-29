package Controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.GetWeather;
import Model.WeatherBean;
/**
 * Servlet implementation class WeatherServlet
 */
@WebServlet("/WeatherServlet")
public class WeatherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WeatherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		try {
			if(request.getParameter("Accept-cookies") != null) {
				String cityStr = request.getParameter("city");
				String countryStr = request.getParameter("country");
				
				
				
				WeatherBean WBean = new WeatherBean(cityStr, countryStr);

				GetWeather.getWeather(WBean);
				
				request.setAttribute("WBean", WBean);
				
				Cookie cookie = new Cookie("cityStr", cityStr);
				Cookie cookie2 = new Cookie("countryStr", countryStr);
				response.addCookie(cookie);
				response.addCookie(cookie2);
				
				HttpSession session = request.getSession();
				session.setAttribute("Accept-cookies", "true");	
				
				

				RequestDispatcher rd = request.getRequestDispatcher("weather.jsp");
				rd.forward(request, response);
			}else {
				HttpSession session = request.getSession();
				session.setAttribute("Accept-cookies", "false");	
				String cityStr = request.getParameter("city");
				String countryStr = request.getParameter("country");
				
				
				
				WeatherBean WBean = new WeatherBean(cityStr, countryStr);

				GetWeather.getWeather(WBean);	
				request.setAttribute("WBean", WBean);
				RequestDispatcher rd = request.getRequestDispatcher("weather.jsp");
				rd.forward(request, response);
			}
			
		}catch(FileNotFoundException e){
			request.setAttribute("errorMessage", "City or Country not found.");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

































