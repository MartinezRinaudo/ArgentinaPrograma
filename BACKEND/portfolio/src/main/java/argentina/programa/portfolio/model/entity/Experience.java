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
@Table(name = "experience")
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "experience_id")
    private long id;

    @NotBlank(message = "The job can't be empty")
    @Column(name = "job", length = 60, nullable = false)
    private String job;

    @NotBlank(message = "The place can't be empty")
    @Column(name = "place", length = 60, nullable = false)
    private String place;

    @NotNull(message = "The start date can't be empty")
    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @NotBlank(message = "The type of job can't be empty")
    @Column(name = "type_of_job", length = 60, nullable = false)
    private String typeOfJob;

    @NotBlank(message = "The skills can't be empty")
    @Column(name = "skills", columnDefinition = "TEXT", nullable = false)
    private String skills;
}
