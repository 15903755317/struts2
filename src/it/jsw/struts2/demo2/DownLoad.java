package it.jsw.struts2.demo2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * author:JSW version:1.0 description: time:2017��9��26������3:29:41
 */
public class DownLoad extends ActionSupport {

	private String filename;

	public void setFilename(String filename) throws UnsupportedEncodingException {
		// get��������ʽ
		this.filename = new String(filename.getBytes("ISO-8859-1"), "utf-8");
	}

	@Override
	public String execute() throws Exception {
		System.out.println("����:" + filename);
		return SUCCESS;
	}

	// �ṩ�����ļ���
	// ��ΪInputResult�� protected String inputName = "inputStream";
	public InputStream getInputStream() throws FileNotFoundException {
		File file = new File(ServletActionContext.getServletContext().getRealPath("/download") + "/" + filename);
		return new FileInputStream(file);
	}

	// ���������ļ�����̬��ȡMIME�ļ�����
	public String getContentType() {
		return ServletActionContext.getServletContext().getMimeType(filename);
	}

	// ���ظ�����
	public String getFileName() {
		return filename;
	}
}
