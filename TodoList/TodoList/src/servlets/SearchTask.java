
package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datamodel.Task;
import util.DBUtils;

/**
 * Servlet implementation class SearchTask
 */
@WebServlet("/SearchTask")
public class SearchTask extends HttpServlet
{

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchTask()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String name = request.getParameter( "name" );
		String dueDate = request.getParameter( "dueDate" );
		String tag = request.getParameter( "tag" );
		
		List<Task> tasks = DBUtils.getTasks( name, dueDate, tag );
		
		request.setAttribute( "Tasks", tasks );
		request.getRequestDispatcher("/WEB-INF/searchResults.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		doGet( request, response );
	}

}
