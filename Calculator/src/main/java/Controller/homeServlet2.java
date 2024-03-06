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
@WebServlet("/cal2")
public class homeServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public homeServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("result","0");
		String view="WEB-INF/views/calculator2.jsp";
		RequestDispatcher dispatcher= request .getRequestDispatcher(view);
        dispatcher.forward(request, response);}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String input=request.getParameter("input");
		String result=request.getParameter("result");
		result = result.replaceAll("\\s+", "");
		
		if(input.contains("R")) {
			if(result.matches("\\d+")) {
				if(Double.parseDouble(result)!=0) {
					double result_dbl= Double.parseDouble(result);
					result_dbl=1.0/result_dbl;
					result=result_dbl+"";
					request.setAttribute("result",result);
					String view="WEB-INF/views/calculator2.jsp";
			        RequestDispatcher dispatcher= request.getRequestDispatcher(view);
			        dispatcher.forward(request, response);
				}
			}
			else {result="error";}
		}
		if(input.contains("C")) { result="0";
		request.setAttribute("result",result);
		String view="WEB-INF/views/calculator2.jsp";
        RequestDispatcher dispatcher= request.getRequestDispatcher(view);
        dispatcher.forward(request, response);
		}
		
		
		
		if(result.matches("\\d+")) {
			if(Integer.parseInt(result)==0) {result=input;}
			else {result=result+input;} 
		}
		else {
			if(input.contains("e")) {
				if(result.contains("+")) { 
					int index=result.indexOf('+');
					int leng1=result.length();
					int a_int,b_int,result_int;
					double a_dbl,b_dbl,result_dbl;
					String a="", b="";
					for(int i=0; i<index; i++){a+=result.charAt(i);}
					for(int i=index+1; i<leng1;i++){b+=result.charAt(i);}

					if(a.matches("-?\\d+")&&b.matches("-?\\d+")) {
						a_int=Integer.parseInt(a);
						b_int=Integer.parseInt(b);						
						result_int=a_int+b_int;
						result=result_int+"";
					}else {
						a_dbl=Double.parseDouble(a);
						b_dbl=Double.parseDouble(b);						
						result_dbl=a_dbl+b_dbl;
						result=result_dbl+"";
						if(result_dbl%1==0) {
							result=(int)result_dbl+"";	
						}
					}
					
					}
				else if(result.contains("-")) {
					int index=result.indexOf('-');
					int leng1=result.length();
					int a_int,b_int,result_int;
					double a_dbl,b_dbl,result_dbl;
					String a="", b="";
					for(int i=0; i<index; i++){a+=result.charAt(i);}
					for(int i=index+1; i<leng1;i++){b+=result.charAt(i);}

						if(a.matches("-?\\d+")&&b.matches("-?\\d+")) {
							a_int=Integer.parseInt(a);
							b_int=Integer.parseInt(b);						
							result_int=a_int-b_int;
							result=result_int+"";
						}else {
							a_dbl=Double.parseDouble(a);
							b_dbl=Double.parseDouble(b);						
							result_dbl=a_dbl-b_dbl;
							result=result_dbl+"";
							if(result_dbl%1==0) {
								result=(int)result_dbl+"";	
							}
						}
						
					}
				else if(result.contains("*")) {
					int index=result.indexOf('*');
					int leng1=result.length();
					int a_int,b_int,result_int;
					double a_dbl,b_dbl,result_dbl;
					String a="", b="";
					for(int i=0; i<index; i++){a+=result.charAt(i);}
					for(int i=index+1; i<leng1;i++){b+=result.charAt(i);}
					if(a.matches("-?\\d+")&&b.matches("-?\\d+")) {
						a_int=Integer.parseInt(a);
						b_int=Integer.parseInt(b);						
						result_int=a_int*b_int;
						result=result_int+"";
					}else {
						a_dbl=Double.parseDouble(a);
						b_dbl=Double.parseDouble(b);						
						result_dbl=a_dbl*b_dbl;
						result=result_dbl+"";
						if(result_dbl%1==0) {
							result=(int)result_dbl+"";	
						}
					}
					}
				else if(result.contains("/")) {
					int index=result.indexOf('/');
					int leng1=result.length();
					int a_int,b_int;
					double a_dbl,b_dbl,result_dbl;
					String a="", b="";
					for(int i=0; i<index; i++){a+=result.charAt(i);}
					for(int i=index+1; i<leng1;i++){b+=result.charAt(i);}
					if(a.matches("-?\\d+")&&b.matches("-?\\d+")) {
						a_int=Integer.parseInt(a);
						b_int=Integer.parseInt(b);						
						result_dbl=(double)a_int/(double)b_int;
					}else {
						a_dbl=Double.parseDouble(a);
						b_dbl=Double.parseDouble(b);						
						result_dbl=a_dbl/b_dbl;
					}
					result=result_dbl+"";
						if(result_dbl%1==0) {
						result=(int)result_dbl+"";	
						}
					}
				else if(result.contains("^")) {
					int index=result.indexOf('^');
					int leng1=result.length();
					int a_int,b_int;
					double a_dbl,b_dbl,result_dbl;
					String a="", b="";
					for(int i=0; i<index; i++){a+=result.charAt(i);}
					for(int i=index+1; i<leng1;i++){b+=result.charAt(i);}
					if(a.matches("-?\\d+")&&b.matches("-?\\d+")) {
						a_int=Integer.parseInt(a);
						b_int=Integer.parseInt(b);						
						result_dbl=Math.pow(a_int, b_int);
					}else {
						a_dbl=Double.parseDouble(a);
						b_dbl=Double.parseDouble(b);						
						result_dbl=Math.pow(a_dbl,b_dbl);
					}
					result=result_dbl+"";
						if(result_dbl%1==0) {
						result=(int)result_dbl+"";	
						}
					
					}
			}else {
				result=result+input;
			}
			
		}			
		
		
		

		request.setAttribute("result",result);
		String view="WEB-INF/views/calculator2.jsp";
        RequestDispatcher dispatcher= request.getRequestDispatcher(view);
        dispatcher.forward(request, response);
	}

	
	
	
	
	
}
