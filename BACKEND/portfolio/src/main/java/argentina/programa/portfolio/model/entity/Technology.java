package argentina.programa.portfolio.model.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "technologies")
public class Technology {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "technology_id")
    private long id;

    @NotBlank(message = "The url can't be empty")
    @Column(name = "image_url", length = 60, nullable = false)
    private String imageUrl;

    @NotBlank(message = "The name of the image can't be empty")
    @Column(name = "image_name", length = 60, nullable = false)
    private String imageName;

    @NotNull(message = "The percentage can't be empty")
    @Max(value = 100, message = "Max 100%") @Min(value = 0)
    @Column(name = "percentage")
    private Integer percentage;
}
