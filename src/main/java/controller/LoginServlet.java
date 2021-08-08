package controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.html");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String loginUsername = request.getParameter("username");
		String loginPassword = request.getParameter("password");
//		System.out.println(getServletContext().getRealPath("/"));
//		JSONObject admin = new JSONObject();
//		admin.put("username", username);
//		admin.put("password", password);
		String savedUsername = null;
		String savedPass = null;
		try (FileReader reader = new FileReader(getServletContext().getRealPath("/") + "adminCred.json")) {
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(reader);
			JSONObject admin = (JSONObject) obj;
//			System.out.println(admin.get("username"));
			savedUsername = (String) admin.get("username");
			savedPass = (String) admin.get("password");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (loginUsername.equals(savedUsername) && loginPassword.equals(savedPass)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("student_list.html");
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.html");
			dispatcher.forward(request, response);
		}
	}

}
