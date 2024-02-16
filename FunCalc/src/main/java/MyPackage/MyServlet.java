package MyPackage;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//to get number input from user
		String No1=request.getParameter("firstNo");
		String No2=request.getParameter("secondNo");
		//get btn value from html file
		String btnvalue=request.getParameter("btn");
		//Type casting string to integer
		int num1=Integer.parseInt(No1);
		int num2=Integer.parseInt(No2);
		int btn=Integer.parseInt(btnvalue);
		//to send output to jsp file and perform Arthematic operation 
		int ans = 0;
		switch(btn) {
		case 1:
			ans = num1+num2;
			break;
		case 2:
			ans=num1 - num2;
			break;
		case 3:
			ans= num1 * num2;
			break;
		case 4:
			ans= num1 / num2;
			break;
		case 5:
			ans= num1 % num2;
			break;
		}
		//API for integration
		URL url = new URL("https://v2.jokeapi.dev/joke/Any?format=txt");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		InputStream responseStream = connection.getInputStream();
		InputStreamReader reader=new InputStreamReader(responseStream);
		//we want to store data in string
		StringBuilder responseContent=new StringBuilder();
		//TO get input from reader, will create scanner object
		Scanner scanner=new Scanner(reader);
		while(scanner.hasNext()) {
			responseContent.append(scanner.nextLine());
		}
		scanner.close();
		response.sendRedirect("index.jsp?ans="+ans+"&joke="+responseContent);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
