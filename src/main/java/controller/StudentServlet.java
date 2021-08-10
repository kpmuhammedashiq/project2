package controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/student")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public StudentServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("student_detail.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String regNo = request.getParameter("regNo");
		JSONArray students = new JSONArray();
		try (FileReader reader = new FileReader(getServletContext().getRealPath("/") + "students.json")) {
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(reader);
			students = (JSONArray) obj;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		ArrayList<JSONObject> studentList = new ArrayList<JSONObject>();
		students.forEach(student -> {
			studentList.add(parseStudent((JSONObject) student));
		});
		ArrayList<JSONObject> selectedStudent = (ArrayList<JSONObject>) studentList.stream()
				.filter(std -> std.get("regNo").equals(regNo)).collect(Collectors.toList());
		if (selectedStudent != null && selectedStudent.size() > 0) {
			request.setAttribute("selectedStudent", selectedStudent);
			RequestDispatcher dispatcher = request.getRequestDispatcher("student_detail.jsp");
			dispatcher.forward(request, response);
		} else {
			PrintWriter out = response.getWriter();
			out.println("reg no. incorrect");
		}
	}

	public JSONObject parseStudent(JSONObject student) {
		return (JSONObject) student.get("student");
	}

}
