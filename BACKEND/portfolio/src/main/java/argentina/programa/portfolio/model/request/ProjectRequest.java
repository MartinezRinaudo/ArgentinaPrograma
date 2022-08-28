package argentina.programa.portfolio.model.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectRequest {

    private String name;
    private String place;
    private String spanishDescription;
    private String englishDescription;
}
