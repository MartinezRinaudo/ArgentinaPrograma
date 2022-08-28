package argentina.programa.portfolio.model.request;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthenticationRequest {

    @NotBlank(message = "the email can't be empty")
    @Email(message = "Email is not valid")
    private String email;

    @NotBlank(message = "the password can't be empty")
    private String password;
}
