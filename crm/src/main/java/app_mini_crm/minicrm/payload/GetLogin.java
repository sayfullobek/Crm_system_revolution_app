package app_mini_crm.minicrm.payload;

import app_mini_crm.minicrm.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetLogin {
    private User user;
    private ResToken resToken;
}
