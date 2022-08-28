package argentina.programa.portfolio.model.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LanguageRequest {

    private String name;
    private String level;
}
