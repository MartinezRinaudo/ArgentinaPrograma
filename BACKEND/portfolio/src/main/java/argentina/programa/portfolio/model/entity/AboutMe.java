package argentina.programa.portfolio.model.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "about_me")
public class AboutMe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "about_me_id")
    private long id;

    @NotBlank(message = "The description can't be empty")
    @Column(name = "spanish_description", columnDefinition = "TEXT", nullable = false)
    private String spanishDescription;

    @NotBlank(message = "The description can't be empty")
    @Column(name = "english_description", columnDefinition = "TEXT", nullable = false)
    private String englishDescription;
}