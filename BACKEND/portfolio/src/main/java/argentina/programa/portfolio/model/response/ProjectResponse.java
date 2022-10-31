package argentina.programa.portfolio.model.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectResponse {


    private long id;
    private String name;
    private String place;
    private String spanishDescription;
    private String englishDescription;
}
