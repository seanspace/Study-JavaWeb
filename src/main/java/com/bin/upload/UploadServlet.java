package com.bin.upload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet ("/uploadServlet")
public class UploadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * 1.获取请求信息;使用之前的方法不可行!
		 * 2.使用流,可行,但处理麻烦.
		 */
		// 1
//		String file = req.getParameter("file") ;
//		String desc = req.getParameter("desc") ;
		
//		System.out.println("file:" + file);
//		System.out.println("desc:" + desc);
		
		// 2
//		InputStream inputStream = req.getInputStream() ;
//		Reader reader = new InputStreamReader(inputStream) ;
//		BufferedReader bufferedReader = new BufferedReader(reader) ;
//		
//		String string = null ;
//		while ((string = bufferedReader.readLine()) != null) {
//			System.out.println(string);
//		}
		
		// 3.使用commons-fileupload
		/*
		 * 1.得到FileItem的集合.
		 * 2.遍历items:若是一个表单域,打印信息.
		 * 3.若是文件域则把文件保存到d:\\files目录下.
		 */
		// Create a factory for disk-based file items
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		// 设置内存中最多存储的文件的大小,若超出,写入硬盘.
		factory.setSizeThreshold(1024 * 5);// 5k
		File tempDirectory = new File("d:\\tempDirectory") ;
		factory.setRepository(tempDirectory);// 设置临时文件夹
		
		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		// 设置总的文件最大值.
		upload.setSizeMax(1024 * 1024 * 5);// 5M
		// 设置单个文件的最大值.
//		upload.setFileSizeMax(size) ;
		
		// Parse the request
		try {
			List<FileItem> items = upload.parseRequest(req);
			for (FileItem item:items) {
				if (item.isFormField()) {
					String name = item.getFieldName() ;
					String value = item.getString("UTF-8") ;
					System.out.println(name + " : " + value);
				} else {
					String fieldName = item.getFieldName() ;
					String fileName = item.getName() ;
					String contentType = item.getContentType() ;
					long sizeInBytes = item.getSize() ;
					
					System.out.println(fieldName);
					System.out.println(fileName);
					System.out.println(contentType);
					System.out.println(sizeInBytes);

					InputStream in = item.getInputStream() ;
					byte [] buffer = new byte[1024] ;
					int len = 0 ;
					fileName = "d:\\files\\" + fileName ;
					System.out.println(fileName);
					OutputStream outputStream = new FileOutputStream(fileName) ;
					while ((len = in.read(buffer)) != -1) {
						outputStream.write(buffer,0,len);
					}
					outputStream.close();
					in.close();
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		
	}
	
}
