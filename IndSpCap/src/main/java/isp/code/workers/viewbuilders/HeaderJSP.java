package isp.code.workers.viewbuilders;

import javax.servlet.http.HttpSession;

import isp.bal.beans.User;

public class HeaderJSP {

	private StringBuffer headerContent = new StringBuffer("");

	public StringBuffer getHeaderContent(HttpSession session) {

		User user = (User) session.getAttribute("user");

		if ((user == null) || (!user.isLoggedIn())) {
			headerContent.append("<div CLASS=\"Table\">" + "<div class=\"Cell\">" + "<A href=\"/IndSpCap/index.jsp\">Home</A></div>" + "<div class=\"Cell\">"
			        + "<A href=\"/IndSpCap/pages/login.jsp\">Login</A></div>");
		} else {
			headerContent.append("<div CLASS=\"Table\">" + "<div class=\"Cell\">" + "<A href=\"/IndSpCap/index.jsp\">Home</A></div>" + "<div class=\"Cell\">"
			        + "<A href=\"/IndSpCap/pages/login.jsp\">Login</A></div>" + "<div class=\"Cell\">"
			        + "<form method=\"post\" action=\"/IndSpCap/Delegate\"><input type=\"submit\" value=\"Logout\" name=\"btnAction\" class=\"LogoutButton\" /></form></div>");
		}

		return headerContent;
	}
}