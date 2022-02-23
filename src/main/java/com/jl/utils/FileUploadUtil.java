package com.jl.utils;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.UUID;

@Component
public class FileUploadUtil {


	private static final String CHARSET="UTF-8";
	private static final String IMAGEPATH="fresh_images/";


	private static FtpUtil ftpUtil=new FtpUtil();

	public static  String paraseRequest(MultipartFile file) throws Exception{
		String image_path="";
		DiskFileItemFactory factory=new DiskFileItemFactory();
		ServletFileUpload upload=new ServletFileUpload(factory);

		//获取文件名称
		String name=file.getOriginalFilename();
		//文件重名问题
		UUID uuid=UUID.randomUUID();
		String fileName=uuid.toString()+""+name;

		InputStream inputStream = file.getInputStream();

//		Boolean flag = ftpUtil.uploadFile(fileName, inputStream);//主要就是这里实现了ftp的文件上传
		Boolean flag = ftpUtil.uploadFileToLocal(fileName, inputStream);//主要就是这里实现了ftp的文件上传

		if (flag){
			//获取存储后的文件路径    如何处理  存储到
			image_path=IMAGEPATH+fileName;
		}
		return image_path;
	}


}
