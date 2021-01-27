package vn.com.rabbit.base.entity;
import lombok.Getter;
import lombok.Setter;
import vn.com.rabbit.base.models.IDescriptionEntity;
import vn.com.rabbit.base.models.annotation.ReportFieldName;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
public abstract class DescriptionEntity extends IdentifierEntity implements IDescriptionEntity<UUID> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ReportFieldName("Mô tả")
    @Column(columnDefinition = "TEXT")
    private String description;

    @Override
    public String toString() {
        return "DescriptionEntity{" +
                "description='" + description + '\'' +
                '}';
    }
}