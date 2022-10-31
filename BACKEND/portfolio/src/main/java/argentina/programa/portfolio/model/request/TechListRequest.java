package argentina.programa.portfolio.model.request;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TechListRequest {


    private long id;
    private String category;
    private Set<TechnologyRequest> technologyList;

}
