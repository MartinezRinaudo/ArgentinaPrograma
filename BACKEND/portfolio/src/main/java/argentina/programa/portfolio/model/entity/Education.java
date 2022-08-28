package argentina.programa.portfolio.model.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "education")
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "education_id")
    private long id;

    @NotBlank(message = "The name can't be empty")
    @Column(name = "name", length = 60, nullable = false)
    private String name;

    @NotBlank(message = "The place can't be empty")
    @Column(name = "place", length = 60, nullable = false)
    private String place;

    @NotNull(message = "The start date can't be empty")
    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;
}
