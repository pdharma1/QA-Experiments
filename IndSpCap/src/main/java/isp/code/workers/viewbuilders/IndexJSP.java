package isp.code.workers.viewbuilders;

public class IndexJSP {

	private StringBuilder introContent = new StringBuilder("");

	public StringBuilder getIntroContent() {
		introContent.append("<div class=\"PartContainer\">");

		introContent.append("Marketing and development of   S & M Es." + "There are about 5,000 000 Small and medium scale industries in the country."
		        + "As per the information available about 28% units are sick. The sickness may vary from state to state."
		        + "There are many reasons for the sickness like shortage of power, insufficient working capital, non-adoption or non-awareness of high technology, lack of or inadequate marketing strength and other reasons."
		        + "Lack of marketing strength leads   to non-utilization of the capacity to the full extent. This once again leads to sickness of the industry."
		        + "If the capacity utilization can be improved by 10%  the profitability will be better and the units can be revived.");

		introContent.append("</div>");
		return introContent;
	}
}
