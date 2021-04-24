package vn.com.rabbit.service.dto.form;

import java.util.UUID;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class FormAddPost {

	private String title;
	private String content;
	private String author;
	private UUID category[];
	private CommonsMultipartFile featuredImage;	
}
