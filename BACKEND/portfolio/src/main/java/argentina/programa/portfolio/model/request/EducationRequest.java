package argentina.programa.portfolio.model.request;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EducationRequest {


    private long id;
    private String name;
    private String place;
    private Date startDate;
    private Date endDate;
}
