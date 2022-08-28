package argentina.programa.portfolio.model.response;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContactInformationResponse {

    private String imageUrl;
    private String imageName;
    private String link;
    private String socialMedia;
}
