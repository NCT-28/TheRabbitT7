package vn.com.rabbit.common;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.Normalizer;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class Helper {
	public static String pathVariableString(String name) {
		try {
			String temp = Normalizer.normalize(name, Normalizer.Form.NFD);
			Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
			return pattern.matcher(temp).replaceAll("").toLowerCase().replaceAll(" ", "-").replaceAll("đ", "d");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public static void doUpload(HttpServletRequest request, //
			CommonsMultipartFile fileDatas) {

		// Thư mục gốc upload file.
		String uploadRootPath = request.getServletContext().getRealPath("/") + "rabbit/img";
		System.out.println("uploadRootPath=" + uploadRootPath);

		File uploadRootDir = new File(uploadRootPath);
		//
		// Tạo thư mục gốc upload nếu nó không tồn tại.
		if (!uploadRootDir.exists()) {
			uploadRootDir.mkdirs();
		}
		//CommonsMultipartFile fileDatas = file;
		// Tên file gốc tại Client.
		String name = fileDatas.getOriginalFilename();
		System.out.println("Client File Name = " + name);

		if (name != null && name.length() > 0) {
			try {
				// Tạo file tại Server.
				File serverFile = new File(uploadRootDir.getAbsolutePath() + File.separator + name);

				// Luồng ghi dữ liệu vào file trên Server.
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(fileDatas.getBytes());
				stream.close();
				//
				System.out.println("Write file: " + serverFile);
			} catch (Exception e) {
				System.out.println("Error Write file: " + name);
			}
		}

	}

	public static void main(String[] args) {
		//System.out.println(pathVariableString("Sinh Viên Công Nghệ Thông Tin trƯờnG Đh qUy Nhơn"));
	}
}
