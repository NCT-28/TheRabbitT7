package vn.com.rabbit.base.dtos.jpa;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntityDTO {
	private UUID uuid;
}
