package com.jm.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jm.vo.UploadFileVo;
import com.jm.vo.UploadResultVo;


@Controller
public class UploadPictrue {

	/**
	 * 图片上传用图片服务器上传
	 * 
	 * @return
	 */
	@RequestMapping("/pic/upload") 
	@ResponseBody
	public UploadResultVo<UploadFileVo> uploadFile(MultipartFile uploadFile, HttpSession session,HttpServletRequest request) {
		
		String filename = uploadFile.getOriginalFilename();
		String path = session.getServletContext().getRealPath("/upload");
		UploadResultVo<UploadFileVo> resultVo = new UploadResultVo<UploadFileVo>();
		UploadFileVo uploadFileVo = new UploadFileVo();
		try {
			URL resource = session.getServletContext().getResource(File.separator);
			System.out.println(resource);
			String realPath = request.getSession().getServletContext().getRealPath("/");
			System.out.println(realPath);
			
			 String aaa=request.getServletPath();
			System.out.println(aaa);
			
		
			byte[] bytes = uploadFile.getBytes();
			
			File file = new File(path, filename);

			FileUtils.writeByteArrayToFile(file, bytes);
			
			uploadFileVo.setTitle(filename);
			uploadFileVo.setUrl("/upload/"+filename);
			resultVo.setCode(0);
			resultVo.setMsg("成功");
			resultVo.setData(uploadFileVo);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			uploadFileVo.setTitle(filename);
			uploadFileVo.setUrl("/upload/"+filename);
			resultVo.setCode(1);
			resultVo.setMsg("失败");
			resultVo.setData(uploadFileVo);
		}

		return resultVo;
	}
	
	public static String getRootPath() {  
	    String classPath = Thread.currentThread().getContextClassLoader()  
	            .getResource("").getPath();  
	    String rootPath = "";  
	  
	    /** For Windows */  
	    if ("\\".equals(File.separator)) {  
	        String path = classPath.substring(1,  
	                classPath.indexOf("/WEB-INF/classes"));  
	        rootPath = path.substring(0, path.lastIndexOf("/"));  
	        rootPath = rootPath.replace("/", "\\");  
	    }  
	  
	    /** For Linux */  
	    if ("/".equals(File.separator)) {  
	        String path = classPath.substring(0,  
	                classPath.indexOf("/WEB-INF/classes"));  
	        rootPath = path.substring(0, path.lastIndexOf("/"));  
	        rootPath = rootPath.replace("\\", "/");  
	    }  
	    return rootPath;  
	}  

}