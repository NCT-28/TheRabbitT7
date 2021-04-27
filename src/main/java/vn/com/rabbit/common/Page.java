package vn.com.rabbit.common;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Page {
		
	public  final  String P403="403";
	public  final  String Forget="forget" ;
	public  final  String Index= "index";
	public  final  String Login = "login";
	public  final  String Register= "register";
	
	
	public  final  String PathRoot = "admin";
	public  final  String QuanTri = PathRoot +"/index";
	public  final  String Category = PathRoot + "/bl_category";
	public  final  String Post= PathRoot + "/bl_post";
	public  final  String AddPost= PathRoot +"/bl_post_them";
	public  final  String ViewPost= PathRoot +"/bl_post_view";
	public  final  String Setting= PathRoot +"/sys_setting";
	public  final  String Function= PathRoot +"/tk_function";
	public  final  String Menu= PathRoot +"/tk_menu";
	public  final  String Role= PathRoot +"/tk_role";
	public  final  String Account= PathRoot +"/tk_taikhoan";
}
