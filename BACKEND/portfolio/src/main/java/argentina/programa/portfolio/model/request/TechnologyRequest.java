package argentina.programa.portfolio.model.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TechnologyRequest {

    private String category;
    private String imageUrl;
    private String imageName;
    private Integer percentage;
}
