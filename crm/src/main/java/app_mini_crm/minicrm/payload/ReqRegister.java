package app_mini_crm.minicrm.payload;

import app_mini_crm.minicrm.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReqRegister {
    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String email;

    private String password;

    private String prePassword;

    private Integer roleId;
}
