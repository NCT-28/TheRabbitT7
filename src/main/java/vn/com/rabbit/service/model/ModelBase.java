package vn.com.rabbit.service.model;

import java.util.List;

import lombok.Data;

@Data
public class ModelBase<T> {
	private String message;

	private long count;

	private List<T> value;

}
