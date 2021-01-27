package vn.com.rabbit.base.entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import vn.com.rabbit.base.models.IPrefixIdentifierEntity;
import vn.com.rabbit.base.models.annotation.ReportFieldName;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
public abstract class PrefixIdentifierEntity extends IdentifierEntity implements IPrefixIdentifierEntity<UUID> {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ReportFieldName("tiền tố")
    @Column(length = 100, nullable = false)
    private String prefix;
}