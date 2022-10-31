package argentina.programa.portfolio.model.response;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TechListResponse {


    private long id;
    private String category;
    private Set<TechnologyResponse> technologyList;

}
