package vn.com.rabbit.service.mess;

import vn.com.rabbit.entity.Category;

import java.util.List;

public class CategoryMess {
	private String message;

	private long totalCategorys;

	private List<Category> listCategorys;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getTotalCategorys() {
		return totalCategorys;
	}

	public void setTotalCategorys(long totalCategorys) {
		this.totalCategorys = totalCategorys;
	}

	public List<Category> getListCategorys() {
		return listCategorys;
	}

	public void setListCategorys(List<Category> listCategorys) {
		this.listCategorys = listCategorys;
	}
	
	
}
