package vn.com.rabbit.service.dto;

import java.util.List;
import java.util.UUID;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class AccountDto {

    private UUID Id;
    private String username;

    private String password;

    private String email;

    private String imageUrl;

    private boolean activated = true;

    private boolean locked = false;

    private String url;

    private String phoneNumber;

    private String hoTen;
    private List<String> roles;

}
