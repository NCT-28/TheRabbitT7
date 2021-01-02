package vn.com.rabbit.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "bl_tag_post")
@EqualsAndHashCode(callSuper = false)
public class TagPost extends AbstractEntity implements Serializable {

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post posts;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    private  Tag tags;
}
