package isp.code.delegates;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import isp.bal.beans.User;

/**
 * Servlet implementation class Delegate
 */
public class Delegate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String unitTech = "/pages/unitTech.jsp";
	private String coInfo = "/pages/coInfo.jsp";
	private String login = "/pages/login.jsp";
	private String partners = "/pages/partners.jsp";
	private String logout = "/IndSpCap/pages/login.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Delegate() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		User user = null;
		HttpSession session = null;

		try {
			switch (request.getParameter("btnAction")) {
				case "Login": {
					String username = request.getParameter("txtUsername");
					String password = request.getParameter("txtPassword");

					if ((username.equals("Admin")) && (password.equals("admin"))) {
						user = new User(username, password);
						user.setLoggedIn(true);
						session = request.getSession();
						session.setAttribute("user", user);
						request.getRequestDispatcher(coInfo).forward(request, response);
					} else {
						request.getRequestDispatcher(login).forward(request, response);
					}

					break;
				}

				case "Submit Co. Info": {
					request.getRequestDispatcher(unitTech).forward(request, response);
					break;
				}

				case "Submit Unit Tech": {
					request.getRequestDispatcher(partners).forward(request, response);
					break;
				}

				case "Logout": {
					Enumeration<String> attributes;
					int count = 1;
					try {
						System.out.println("*** In Logout case statement ***");
						session = request.getSession();
						if (!(session == null)) {
							session = request.getSession();
							attributes = session.getAttributeNames();

							while (attributes.hasMoreElements()) {
								String attribute = attributes.nextElement();
								System.out.println("Removing: " + count + ") " + attribute);
								session.removeAttribute(attribute);
								count++;
							}
							session = null;
							response.sendRedirect(logout);
						} else {
							response.sendRedirect(logout);
						}
					} catch (Exception ex) {
						ex.printStackTrace();
					} finally {
						session = null;
					}
					break;
				}

				default: {
					request.getRequestDispatcher(login).forward(request, response);
					break;
				}
			}

		} catch (Exception ex) {
			pw.write(ex.getMessage());
		}
	}
}
