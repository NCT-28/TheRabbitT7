package vn.com.rabbit.base.entity;
import lombok.Getter;
import lombok.Setter;
import vn.com.rabbit.base.models.IPictureEntity;
import vn.com.rabbit.base.models.annotation.ReportFieldName;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
public abstract class PictureEntity extends BaseEntity implements IPictureEntity<UUID> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column
    @ReportFieldName("tên file")
    private String idUpload;

    @Column
    @ReportFieldName("đường dẫn hình ảnh")
    private String picture;

    @Column
    @ReportFieldName("là đường dẫn ngoài")
    private Boolean external;

    @ReportFieldName("Mô tả")
    @Column(columnDefinition = "TEXT")
    private String description;
}