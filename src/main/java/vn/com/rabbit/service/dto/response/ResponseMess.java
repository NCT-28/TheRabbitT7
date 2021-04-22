package vn.com.rabbit.service.dto.response;

import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Data
public class ResponseMess<T> {
	private String message;

	private long total;

	private List<T> values;

}
