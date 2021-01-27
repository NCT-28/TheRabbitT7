package vn.com.rabbit.base.entity;
import lombok.Data;
import vn.com.rabbit.base.enums.Gender;
import vn.com.rabbit.base.models.IPeopleDetailsEntity;
import vn.com.rabbit.base.models.annotation.ReportFieldName;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Data
@MappedSuperclass
public abstract class PeopleDetailsEntity extends BaseEntity implements IPeopleDetailsEntity<UUID> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(nullable = false)
    @ReportFieldName("họ và tên")
    private String name;

    @Column
    @ReportFieldName("email")
    private String email;

    @Column
    @ReportFieldName("số điện thoại")
    private String phoneNumber;

    @Column(nullable = false)
    @ReportFieldName("giới tính")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column
    @ReportFieldName("ngày sinh")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthday;

    @Column(nullable = false)
    @ReportFieldName("Chứng minh nhân dân/Hộ chiếu/Thẻ Căn cước công dân")
    private String identityCard;

    @Column
    @ReportFieldName("ngày cấp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfSupply;

    @Column
    @ReportFieldName("Nơi cấp")
    private String locationProvided;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PeopleDetailsEntity that = (PeopleDetailsEntity) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(phoneNumber, that.phoneNumber) &&
                gender == that.gender &&
                Objects.equals(birthday, that.birthday) &&
                Objects.equals(identityCard, that.identityCard) &&
                Objects.equals(dateOfSupply, that.dateOfSupply) &&
                Objects.equals(locationProvided, that.locationProvided);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phoneNumber, gender, birthday, identityCard, dateOfSupply, locationProvided);
    }

    @Override
    public String toString() {
        return "PeopleDetailsEntity{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", gender=" + gender +
                ", birthday=" + birthday +
                ", identityCard='" + identityCard + '\'' +
                ", ngay_cap=" + dateOfSupply +
                ", noiCap='" + locationProvided + '\'' +
                '}';
    }
}