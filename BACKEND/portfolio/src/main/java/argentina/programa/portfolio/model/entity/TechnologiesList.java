package argentina.programa.portfolio.model.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "technologies_list")
public class TechnologiesList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "technologies_list_id")
    private long id;

    @NotBlank(message = "The category can't be empty")
    @Column(name = "category")
    private String category;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinTable(name = "tech_list",
            joinColumns = {@JoinColumn(name = "technologies_list_id")},
            inverseJoinColumns = {@JoinColumn(name = "technology_id")})
    private Set<Technology> technologiesList;
}
