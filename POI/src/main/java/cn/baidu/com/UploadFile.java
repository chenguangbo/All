package cn.baidu.com;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import cn.baidu.utils.FileUtils;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import cn.baidu.utils.UploadUtils;

public class UploadFile extends HttpServlet {

	private static final long serialVersionUID = 129654481611414013L;

	@SuppressWarnings("all")
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		User user = new User();
		Map map = new HashMap<String, String>();
		try {
			DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
			ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
			List<FileItem> list = fileUpload.parseRequest(req);
			for (FileItem item : list) {
				String path = null;
				String uuidFileName = null;
				if (item.isFormField()) {// 是表单键值对类型
					// 普通字段
					// System.out.println(uuidFileName);
					// System.out.println(item.getString("UTF-8"));
					// System.out.println(item.getFieldName());
					map.put(item.getFieldName(), item.getString("UTF-8"));
				} else {
					// 文件字段
					// System.out.println(uuidFileName); //文件名
					// System.out.println(item.getString("UTF-8"));//文件内容
					// System.out.println(item.getFieldName());//前段传输过程中的的name字段
					// 找到项目根路径下的img文件夹的位置
					uuidFileName = UploadUtils.getUUIDName(item.getName());
					path = getServletContext().getRealPath("/img");
					// 拼装存储文件的文件夹路径
					path = path + UploadUtils.getDir(uuidFileName).replace("/", "\\")+"\\";
					System.out.println(path+uuidFileName);
					// 创建这个
					
					File file = new File(path+uuidFileName);
					File dir = new File(path);
					if(!dir.exists())
//						FileUtils.createDir(path);
						dir.mkdirs();
					if (!file.exists())// 如果文件夹不存在
						file.createNewFile();// 创建文件夹
					OutputStream out = new FileOutputStream(file);
					InputStream in = item.getInputStream();// 从item中获取输入流
					IOUtils.copy(in, out);
					IOUtils.closeQuietly(in);
					IOUtils.closeQuietly(out);
				}
				user.setPart(path + uuidFileName);
			}
			BeanUtils.populate(user, map);
			System.out.println(user.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.sendRedirect(req.getContextPath()+"/jsp/callBack.jsp");
//		req.getRequestDispatcher("/callBack.jsp").forward(req, resp);
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

}
