package argentina.programa.portfolio.model.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AboutMeResponse {

    private long id;
    private String spanishDescription;
    private String englishDescription;
}
