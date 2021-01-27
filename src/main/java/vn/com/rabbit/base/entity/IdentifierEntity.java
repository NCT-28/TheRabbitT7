package vn.com.rabbit.base.entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import vn.com.rabbit.base.models.IIdentifierEntity;
import vn.com.rabbit.base.models.annotation.ReportFieldName;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
public abstract class IdentifierEntity extends NaturalIdEntity implements IIdentifierEntity<UUID> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ReportFieldName("Tên")
    @Column(nullable = false)
    private String name;

    @Override
    public String toString() {
        return "IdentifierEntity{" +
                "name='" + name + '\'' +
                '}';
    }
}