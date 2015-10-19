package com.et.delegates;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.et.beans.User;
import com.et.dal.UserDal;
import com.et.workers.Emailer;

/**
 * Servlet implementation class ApproveRejectUsers
 */
@WebServlet("/ApproveRejectUsers")
public class ApproveRejectUsersDelegate extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ApproveRejectUsersDelegate()
	{
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String errorUrl = "./views/error.jsp";
		try
		{
			String email = "";
			UserDal userDal = new UserDal();
			Emailer emailer = new Emailer();

			response.setContentType("text/html");
			String approveUrl = "./views/approve.jsp";

			int id = 0;
			Enumeration<String> reqParameters = request.getParameterNames();
			boolean userUpdatedResult = false;
			boolean userRemovedResult = false;

			while (reqParameters.hasMoreElements())
			{
				try
				{
					String param = reqParameters.nextElement();
					if (request.getParameter(param).equals("Approve"))
					{
						id = Integer.parseInt(param.replace("/", ""));
						User userTobeApproved = new User();
						userTobeApproved = userDal.getUserById(id);
						userUpdatedResult = userDal.updateUserApprovedFlag(userTobeApproved.getUserId());
						if (userUpdatedResult)
						{
							User approvedUser = new User();
							approvedUser = userDal.getUserById(id);
							emailer.emailRegistrationApprovalEmailNow(approvedUser, "User Registration Approved");
							request.getRequestDispatcher(approveUrl).forward(request, response);
						}
						else
						{
							request.setAttribute("userApprovedRejectedMessage", "User couldnt be \"Approved\". Please try again later.");
							request.getRequestDispatcher(errorUrl).forward(request, response);
						}
					}
					else if (request.getParameter(param).equals("Reject"))
					{
						id = Integer.parseInt(param.replace("/", ""));
						User userToBeDeleted = new User();
						userToBeDeleted = userDal.getUserById(id);
						userRemovedResult = userDal.deleteUser(userToBeDeleted.getUserId());
						if (userRemovedResult)
						{
							emailer.emailRegistrationRejectionEmailNow(userToBeDeleted, "User Registration Rejected");
							request.getRequestDispatcher(approveUrl).forward(request, response);
						}
						else
						{
							request.setAttribute("userApprovedRejectedMessage", "User couldnt be \"Deleted\". Please try again later.");
							request.getRequestDispatcher(errorUrl).forward(request, response);
						}
						email = param;
					}
					else
					{
						request.setAttribute("userApprovedRejectedMessage", "Couldnt Approve/Reject. Please try again later.");
						request.getRequestDispatcher(errorUrl).forward(request, response);
					}

				}
				catch (Exception ex)
				{
					request.setAttribute("userApprovedRejectedMessage", "Couldnt Approve/Reject. Please try again later.");
					request.getRequestDispatcher(errorUrl).forward(request, response);
				}

			}
		}
		catch (Exception ex)
		{
			request.setAttribute("userApprovedRejectedMessage", "Couldnt Approve/Reject. Please try again later.");
			request.getRequestDispatcher(errorUrl).forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}

}
