package argentina.programa.portfolio.model.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TechnologyResponse {


    private long id;
    private String imageUrl;
    private String imageName;
    private Integer percentage;
}
