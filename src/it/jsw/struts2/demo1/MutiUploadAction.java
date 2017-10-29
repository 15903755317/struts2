package it.jsw.struts2.demo1;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * author:JSW version:1.0 description: time:2017年9月26日上午10:56:57
 */
public class MutiUploadAction extends ActionSupport {
	// 接收多文件上传的参数
	private File[] upload;
	private String[] uploadContentType;
	private String[] uploadFileName;

	public File[] getUpload() {
		return upload;
	}

	public void setUpload(File[] upload) {
		this.upload = upload;
	}

	public String[] getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String[] uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String[] getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String[] uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String execute() throws Exception {
		for (int i = 0; i < upload.length; i++) {
			// 循环完成上传
			File srcFile = upload[i];
			String filename = uploadFileName[i];
			File destFile = new File(ServletActionContext.getServletContext().getRealPath("/upload" + "/" + filename));
			FileUtils.copyFile(srcFile, destFile);
		}

		return NONE;
	}

}
