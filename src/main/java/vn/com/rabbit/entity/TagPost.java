package vn.com.rabbit.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import vn.com.rabbit.base.entity.BaseEntity;

@Data
@Entity
@Table(name = "bl_tag_post")
@EqualsAndHashCode(callSuper = false)
public class TagPost extends BaseEntity {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne
    @JoinColumn(name = "post_id")
    private Post posts;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    private  Tag tags;
}
