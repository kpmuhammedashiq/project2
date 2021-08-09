package controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class studentsServlet
 */
@WebServlet("/list")
public class StudentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentListServlet() {
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
		// TODO Auto-generated method stub
		JSONArray students = new JSONArray();
		System.out.print(getServletContext().getRealPath("/"));
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
//		for(JSONObject std:students) {
//			
//		}
		students.forEach(student -> {
			studentList.add(parseStudent((JSONObject) student));
		});
//			Student std=new Student();
//			 JSONObject employeeObject = (JSONObject) employee.get("employee");
//			 JSONObject employeeObject = (JSONObject) student.get("employee");
//			std.name=(String)student.get("name");
//			student.put("regNo", request.getParameter("regNo"));
//			student.put("language", langMark);
//			student.put("maths", mathsMark);
//			student.put("physics", physicsMark);
//			student.put("chemistry", chemistryMark);
//			student.put("biology", biologyMark);
//			student.put("history", historyMark);
//			student.put("geography", geographyMark);
//			student.put("total", total);
//			student.put("average", average);
//		}
		request.setAttribute("studentList", studentList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("student_list.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		RequestDispatcher dispatcher = request.getRequestDispatcher("student_list.jsp");
		dispatcher.forward(request, response);
	}

	public JSONObject parseStudent(JSONObject student) {
		return (JSONObject) student.get("student");
	}

}
