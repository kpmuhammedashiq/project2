package controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
 * Servlet implementation class CreateStudentServlet
 */
@WebServlet("/create")
public class CreateStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateStudentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("student_create.html");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int langMark = Integer.parseInt(request.getParameter("language"));
		int mathsMark = Integer.parseInt(request.getParameter("maths"));
		int physicsMark = Integer.parseInt(request.getParameter("physics"));
		int chemistryMark = Integer.parseInt(request.getParameter("chemistry"));
		int biologyMark = Integer.parseInt(request.getParameter("biology"));
		int historyMark = Integer.parseInt(request.getParameter("history"));
		int geographyMark = Integer.parseInt(request.getParameter("geography"));
		int total = langMark + mathsMark + physicsMark + chemistryMark + biologyMark + historyMark + geographyMark;
		Long average = (long) (total / 7);
		JSONObject student = new JSONObject();
		student.put("name", request.getParameter("name"));
		student.put("regNo", request.getParameter("regNo"));
		student.put("language", langMark);
		student.put("maths", mathsMark);
		student.put("physics", physicsMark);
		student.put("chemistry", chemistryMark);
		student.put("biology", biologyMark);
		student.put("history", historyMark);
		student.put("geography", geographyMark);
		student.put("total", total);
		student.put("total", average);
		JSONArray studentList = new JSONArray();
		try (FileReader reader = new FileReader(getServletContext().getRealPath("/") + "students.json")) {
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(reader);
			studentList = (JSONArray) obj;
//			System.out.println(obj);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		studentList.add(student);
		try (FileWriter file = new FileWriter(getServletContext().getRealPath("/") + "students.json")) {
			file.write(studentList.toJSONString());
			file.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
