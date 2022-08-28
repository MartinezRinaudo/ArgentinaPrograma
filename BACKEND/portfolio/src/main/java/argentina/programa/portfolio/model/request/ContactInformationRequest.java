package argentina.programa.portfolio.model.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContactInformationRequest {

    private String imageUrl;
    private String imageName;
    private String link;
    private String socialMedia;
}
