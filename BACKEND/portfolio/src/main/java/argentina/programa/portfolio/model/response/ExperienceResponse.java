package argentina.programa.portfolio.model.response;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExperienceResponse {


    private long id;
    private String job;
    private String place;
    private Date startDate;
    private Date endDate;
    private String typeOfJob;
    private String skills;
}
