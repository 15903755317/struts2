package it.jsw.struts2.demo2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * author:JSW version:1.0 description: time:2017年9月26日下午3:29:41
 */
public class DownLoad extends ActionSupport {

	private String filename;

	public void setFilename(String filename) throws UnsupportedEncodingException {
		// get乱码解决方式
		this.filename = new String(filename.getBytes("ISO-8859-1"), "utf-8");
	}

	@Override
	public String execute() throws Exception {
		System.out.println("下载:" + filename);
		return SUCCESS;
	}

	// 提供下载文件流
	// 因为InputResult中 protected String inputName = "inputStream";
	public InputStream getInputStream() throws FileNotFoundException {
		File file = new File(ServletActionContext.getServletContext().getRealPath("/download") + "/" + filename);
		return new FileInputStream(file);
	}

	// 根据下载文件名动态获取MIME文件类型
	public String getContentType() {
		return ServletActionContext.getServletContext().getMimeType(filename);
	}

	// 下载附件名
	public String getFileName() {
		return filename;
	}
}
