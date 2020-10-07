
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DBUtils;


/**
 * This Servlet will add a task into the database
 */
@WebServlet("/AddTask")
public class AddTask extends HttpServlet
{

	private static final long serialVersionUID = 1L;
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddTask()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//Getting input
		String input_name = request.getParameter( "name" ).trim();
		String input_description = request.getParameter( "description" );
		String input_dueDate = request.getParameter( "dueDate" );
		String input_tag = request.getParameter( "tag" );
		
		//DEBUGGING
		/*System.out.println("[DEBUG] [AddTask] input_name: "+input_name);
		System.out.println("[DEBUG] [AddTask] input_description: "+input_description);
		System.out.println("[DEBUG] [AddTask] input_dueDate: "+input_dueDate);
		System.out.println("[DEBUG] [AddTask] input_tag: "+input_tag);*/
		
		//Convert Date from string to MySQL date
		Date dueDate = getDate(input_dueDate);
		
		boolean success = DBUtils.createTask( input_name, input_description, dueDate, input_tag );
		
		if( !success)
		{
			request.setAttribute( "Addsuccessful", "Unable to Add Task Due to Missing Data fields. Please make sure all data blocks are filled out." );
		}
		
		request.getRequestDispatcher("/TodoList/").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		doGet( request, response );
	}
	
	private Date getDate(String input_dueDate)
	{
		SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date java_date;
		try
		{
			java_date = date_format.parse(input_dueDate);
			return new Date(java_date.getTime());
		}
		catch ( ParseException e )
		{
			System.out.println("[ERROR] Unable to parse date");
			e.printStackTrace();
		}
		
		return null;
	}

}
