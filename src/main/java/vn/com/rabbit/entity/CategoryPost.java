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
@Table(name = "bl_category_post")
@EqualsAndHashCode(callSuper = false)
public class CategoryPost extends AbstractEntity implements Serializable {

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category categorys;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private  Post posts;
}
