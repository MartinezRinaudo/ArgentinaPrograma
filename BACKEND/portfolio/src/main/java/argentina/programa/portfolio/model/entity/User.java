package argentina.programa.portfolio.model.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profile_id")
    private long id;

    @NotBlank(message = "The email can't be empty")
    @Column(name = "email", nullable = false, unique = true)
    @Email()
    private String email;

    @NotBlank(message = "The password can't be empty")
    @Column(name = "password")
    private String password;

}
