package argentina.programa.portfolio.model.request;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TechListRequest {

    private String category;
    private Set<TechnologyRequest> technologyRequestSet;

}
