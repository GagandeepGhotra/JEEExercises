package ca.sheridancollege;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String doGet() {
		return "login.html";
	}
	
	@GetMapping("/log")
	public void processLogin(@RequestParam String user,
			@RequestParam String pass, HttpServletResponse response) throws IOException  {
		
		if((user.equals("admin") && (pass.equals("admin123")))) {
			PrintWriter out = response.getWriter();
	        out.println("<html>"
	                + "<head>"
	                    + ""
	                + "</head> "
	                + "<body>"
	                	+ "<h1>Login was a Success!</h1>"
	                    + "<b>USER: </b> " + user + "<br>"
	                    + "<b>PASSWORD: </b> " + pass + "<br>"
	                + "</body>"
	                + "</html>");
	    }
		
		else {
			PrintWriter out = response.getWriter();
	        out.println("<html>"
	                + "<head>"
	                    + ""
	                + "</head> "
	                + "<body>"
	                + "<h1>Username or password is wrong!</h1>"
	                + "</body>"
	                + "</html>");
		}
	}
}
