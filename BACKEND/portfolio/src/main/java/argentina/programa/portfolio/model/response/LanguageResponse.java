package argentina.programa.portfolio.model.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LanguageResponse {


    private long id;
    private String name;
    private String level;
}
