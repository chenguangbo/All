package cn.baidu.com;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UploadFile extends HttpServlet {
	
	private static final long serialVersionUID = 129654481611414013L;

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(123);
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//存储路径
		List<String> list = new ArrayList<String>();
		list.add("你好");
		list.add("陳廣波");
		System.out.println(list.toString());
		req.setAttribute("user", list);
		req.getRequestDispatcher("/jsp/callBack.jsp").forward(req,resp);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

	
}
