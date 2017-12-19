package sample.jee.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sample.jee.bean.SampleRemote;
import sample.jee.bean.util.ServiceResolver;

public class SampleServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4658420313552834859L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		callServiceLocal();
//		callServiceRemote();
		getServerInfo(response);
	}

	private void callServiceLocal(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		try {
			System.out.println("Servlet invoked....");
			InitialContext initialContext = new InitialContext();
			SampleRemote sample = (SampleRemote) initialContext.lookup("sample/SampleBean");
			System.out.println("Lookup performed.. "+sample);
			PrintWriter out = new PrintWriter(resp.getOutputStream());
			String name = req.getParameter("name");
			String greeting = sample.greeting(name);
			System.out.println("EJB invoked... "+greeting);
			out.println(greeting);
			out.flush();
			out.close();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private void callServiceRemote() {
		SampleRemote sampleRemote = null;
		try {
			sampleRemote = ServiceResolver.getInstance().lookup(SampleRemote.JNDI_NAME, SampleRemote.class);
			System.out.print(sampleRemote.greeting("Pradeep"));
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private void getServerInfo(HttpServletResponse response) {
		SampleRemote sampleRemote = null;
		try {
			sampleRemote = ServiceResolver.getInstance().lookup(SampleRemote.JNDI_NAME, SampleRemote.class);
			try {
				response.getOutputStream().print(sampleRemote.serverInfo());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

}
