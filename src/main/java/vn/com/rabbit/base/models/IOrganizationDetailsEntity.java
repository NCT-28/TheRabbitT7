package vn.com.rabbit.base.models;
import java.util.Date;

public interface IOrganizationDetailsEntity<T> extends IBaseEntity<T> {

     String getTenTochuc();

     void setTenTochuc(String tenTochuc);

     String getMaSoThue();

     void setMaSoThue(String maSoThue);

     String getTenGiaoDich();

     void setTenGiaoDich(String tenGiaoDich);

     String getTenVietTat();

     void setTenVietTat(String tenVietTat);

     String getTenTiengAnh();

     void setTenTiengAnh(String tenTiengAnh);

     Date getNgayCapGiayPhep();

     void setNgayCapGiayPhep(Date ngayCapGiayPhep);

     Date getNgayBatDauHoatDong();

     void setNgayBatDauHoatDong(Date ngayBatDauHoatDong);

     String getSoDienThoai();

     void setSoDienThoai(String soDienThoai);

     String getEmail();

     void setEmail(String email);

     String getFax();

     void setFax(String fax);

     String getWebsite();

     void setWebsite(String website);
}