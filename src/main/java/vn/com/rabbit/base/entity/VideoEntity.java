package vn.com.rabbit.base.entity;
import lombok.Getter;
import lombok.Setter;
import vn.com.rabbit.base.enums.ProviderVideo;
import vn.com.rabbit.base.models.IVideoEntity;
import vn.com.rabbit.base.models.annotation.ReportFieldName;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
public abstract class VideoEntity extends BaseEntity implements IVideoEntity<UUID> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column
    @ReportFieldName("đường dẫn video")
    private String video;

    @Column
    @Enumerated(EnumType.STRING)
    @ReportFieldName("nền tảng cung cấp video")
    private ProviderVideo providerVideo;

    @ReportFieldName("Mô tả")
    @Column(columnDefinition = "TEXT")
    private String description;
}