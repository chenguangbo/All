package cn.baidu.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;

public class DownloadUtils {

	public static void downloadFile(HttpServletRequest req, HttpServletResponse resp, String fileName, String filePath,
			String mime, InputStream in, OutputStream out) {

		try {
			// 设置文件MIME类型
			resp.setContentType(mime);
			// 文件下载需要 一个流 两个头
			in = new FileInputStream(filePath + fileName);
			fileName = FileDownloadUtils.encodeDownloadFilename(fileName, req.getHeader("User-Agent"));
			// 设置浏览器打开数据的方式
			resp.setHeader("Content-Disposition", "attachment;filename=" + fileName);
			IOUtils.copy(in, out);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
