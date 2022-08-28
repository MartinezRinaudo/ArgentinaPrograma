package argentina.programa.portfolio.model.response;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EducationResponse {

    private String name;
    private String place;
    private Date startDate;
    private Date endDate;
}
