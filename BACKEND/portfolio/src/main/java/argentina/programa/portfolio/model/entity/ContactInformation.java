package argentina.programa.portfolio.model.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "contact_information")
public class ContactInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id")
    private long id;

    @NotBlank(message = "The url can't be empty")
    @Column(name = "image_url", length = 60, nullable = false)
    private String imageUrl;

    @NotBlank(message = "The name of the image can't be empty")
    @Column(name = "image_name", length = 60, nullable = false)
    private String imageName;

    @NotBlank(message = "The link can't be empty")
    @Column(name = "link", length = 200 , nullable = false)
    private String link;

    @NotBlank(message = "The social media can't be empty")
    @Column(name = "social_media", length = 60, nullable = false)
    private String socialMedia;
}
