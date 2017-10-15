package cn.baidu.com;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadFile extends HttpServlet {

	private static final long serialVersionUID = 129654481611414013L;

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(123);
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");

		try {
			DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
			ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
			List<FileItem> list = fileUpload.parseRequest(req);
			for (FileItem item : list) {
				if (item.isFormField()) {
					// 普通字段
					System.out.println(item.getName());
					System.out.println(item.getString("UTF-8"));
					System.out.println(item.getFieldName());
				} else {
					// 文件字段
					System.out.println(item.getName());
					System.out.println(item.getString("UTF-8"));
					System.out.println(item.getFieldName());
				}

			}

			// 获取当前项目下的img文件夹的路径
			String path = getServletContext().getRealPath("/img");

		} catch (Exception e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher("/jsp/callBack.jsp").forward(req, resp);
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

}
