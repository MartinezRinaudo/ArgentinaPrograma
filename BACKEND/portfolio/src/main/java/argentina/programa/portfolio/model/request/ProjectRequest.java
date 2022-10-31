package argentina.programa.portfolio.model.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectRequest {


    private long id;
    private String name;
    private String place;
    private String spanishDescription;
    private String englishDescription;
}
