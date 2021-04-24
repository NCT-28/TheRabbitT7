package vn.com.rabbit.service.dto;

import java.time.Instant;
import java.util.UUID;

import lombok.Data;


@Data
public class BaseAuditDTO {

	private UUID id;

	private String createdBy;

	private Instant createdDate = Instant.now();

	private String updatedBy;

	private Instant UpdatedDate = Instant.now();

}
