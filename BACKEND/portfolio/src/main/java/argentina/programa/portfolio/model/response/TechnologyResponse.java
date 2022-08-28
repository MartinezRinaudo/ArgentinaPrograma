package argentina.programa.portfolio.model.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TechnologyResponse {

    private String category;
    private String imageUrl;
    private String imageName;
    private Integer percentage;
}
