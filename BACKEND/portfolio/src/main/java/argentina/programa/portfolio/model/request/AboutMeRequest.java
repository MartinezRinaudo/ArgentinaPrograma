package argentina.programa.portfolio.model.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AboutMeRequest {

    private String spanishDescription;
    private String englishDescription;
}
