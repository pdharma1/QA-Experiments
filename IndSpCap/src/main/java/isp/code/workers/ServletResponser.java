package isp.code.workers;

public class ServletResponser {

	private StringBuffer htmlContent = new StringBuffer("");

	public StringBuffer getHtmlContent(String yourTextHere) {

		try {
			htmlContent = htmlContent.append("<%@ page language=\"java\" contentType=\"text/html; charset=UTF-8\" pageEncoding=\"UTF-8\"%>" + "<%@ include file=\"header.jsp\"%>"
			        + "<!DOCTYPE html><html><head><link href=\"css/isp1.css\" rel=\"stylesheet\" type=\"text/css\">"
			        + "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">" + "<title>New User Registration</title></head><body>" + yourTextHere + "</body>");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return htmlContent;
	}
}
