package cn.baidu.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

public class UploadFile extends HttpServlet {

	private static final long serialVersionUID = 129654481611414013L;

	@SuppressWarnings("all")
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(123);
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		User user = new User();
		Map map = new HashMap<String,String>();
		try {
			DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
			ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
			List<FileItem> list = fileUpload.parseRequest(req);
			for (FileItem item : list) {
				String path = null;
				if (item.isFormField()) {//是表单键值对类型
					// 普通字段
					//System.out.println(item.getName());
					//System.out.println(item.getString("UTF-8"));
					//System.out.println(item.getFieldName());
					map.put(item.getFieldName(), item.getString("UTF-8"));
				} else {
					// 文件字段
					//System.out.println(item.getName()); //文件名
					//System.out.println(item.getString("UTF-8"));//文件内容
					//System.out.println(item.getFieldName());//前段传输过程中的的name字段
					// 获取保存文件的路径
					path = getServletContext().getRealPath("/img");
					File file = new File(path, item.getName());
					if(!file.exists())//如果问价不存在
					file.createNewFile();//创建文件
					OutputStream out = new FileOutputStream(file);
					InputStream in = item.getInputStream();//从item中获取输入流
					IOUtils.copy(in, out);
					IOUtils.closeQuietly(in);
					IOUtils.closeQuietly(out);
				}
				user.setPart(path+item.getName());
			}
			BeanUtils.populate(user, map);
			System.out.println(user.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher("/jsp/callBack.jsp").forward(req, resp);
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

}
