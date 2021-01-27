package vn.com.rabbit.base.entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import vn.com.rabbit.base.models.INaturalIdEntity;
import vn.com.rabbit.base.models.annotation.ReportFieldName;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@Data
@MappedSuperclass
@EqualsAndHashCode(callSuper = true)
public abstract class NaturalIdEntity extends BaseEntity implements INaturalIdEntity<UUID> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ReportFieldName("mã")
    @Column(unique = true, nullable = false)
    private String code;

    @Override
    public String toString() {
        return "NaturalIdEntity{" +
                "code='" + code + '\'' +
                '}';
    }
}