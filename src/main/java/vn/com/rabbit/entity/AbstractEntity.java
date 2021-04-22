  package vn.com.rabbit.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

@Data
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {


	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "UUID")
	@Column(updatable = false, nullable = false, unique = true)
	private UUID id;
	
	@CreatedBy
	@Column(name = "created_by", nullable = false, length = 50, updatable = false)
	@JsonIgnore
	private String createdBy;

	@CreatedDate
	@Column(name = "created_date", updatable = false)
	@JsonIgnore
	private Instant createdDate = Instant.now();

	@LastModifiedBy
	@Column(name = "updated_by", length = 50)
	@JsonIgnore
	private String updatedBy;

	@LastModifiedDate
	@Column(name = "updated_date")
	@JsonIgnore
	private Instant UpdatedDate = Instant.now();
}
