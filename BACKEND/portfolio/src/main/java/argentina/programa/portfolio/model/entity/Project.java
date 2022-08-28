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
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private long id;

    @NotBlank(message = "The name can't be empty")
    @Column(name = "name", length = 60, nullable = false)
    private String name;

    @NotBlank(message = "The place can't be empty")
    @Column(name = "place", length = 60, nullable = false)
    private String place;

    @NotBlank(message = "The description can't be empty")
    @Column(name = "spanish_description", columnDefinition = "TEXT", nullable = false)
    private String spanishDescription;

    @NotBlank(message = "The description can't be empty")
    @Column(name = "english_description", columnDefinition = "TEXT", nullable = false)
    private String englishDescription;
}
