package argentina.programa.portfolio.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "languages")
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "language_id")
    private long id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "level", length = 100, nullable = false)
    private String level;
}
