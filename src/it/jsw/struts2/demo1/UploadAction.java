package it.jsw.struts2.demo1;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * author:JSW version:1.0 description: time:2017��9��25������8:55:17
 */
public class UploadAction extends ActionSupport {
	private File upload;
	private String uploadContentType;
	private String uploadFileName;

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	@Override
	public String execute() throws Exception {
		if (upload == null) {
			System.out.println("�ϴ�ʧ��");
			return NONE;
		}

		File newfile = new File(ServletActionContext.getServletContext().getRealPath("/upload") + "/" + uploadFileName);
		FileUtils.copyFile(upload, newfile);
		System.out.println("�ɹ�");
		return NONE;
	}
}
