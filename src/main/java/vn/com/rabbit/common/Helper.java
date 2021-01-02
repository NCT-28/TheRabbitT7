package vn.com.rabbit.common;

import java.text.Normalizer;
import java.util.regex.Pattern;

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
	public static void main(String[] args) {
		//System.out.println(pathVariableString("Sinh Viên Công Nghệ Thông Tin trƯờnG Đh qUy Nhơn"));
	}
}
