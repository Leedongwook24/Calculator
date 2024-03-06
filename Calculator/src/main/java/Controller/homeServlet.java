package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class homeServlet
 */
@WebServlet("/cal")
public class homeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public homeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String view="WEB-INF/views/calculator.jsp";
        RequestDispatcher dispatcher= request .getRequestDispatcher(view);
        dispatcher.forward(request, response);}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String input;
		String result="";
		int result_int=0;
		input=request.getParameter("input");
		int leng1=input.length();
		 String a="";
		 int a_int=0;
		 String b="";
		 int b_int=0;
		 
		if(input.indexOf("+")!=-1) {
			int index=input.indexOf("+");
			for(int i=0; i<index; i++) {
				a+=input.charAt(i);	
			}
			for(int i=index+1; i<leng1;i++) {
				b+=input.charAt(i);	
			}
			a_int=Integer.parseInt(a);
			b_int=Integer.parseInt(b);
		result_int=a_int+b_int;
		}
		result=result_int+"";
		
		request.setAttribute("result", result);
		String view="WEB-INF/views/calculator.jsp";
        RequestDispatcher dispatcher= request .getRequestDispatcher(view);
        dispatcher.forward(request, response);
	}

	
	
	
	
	
}
