package argentina.programa.portfolio.model.response;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfileResponse {

    private String email;
    private String fullName;
    private String location;
    private String profession;
    private String imageUrl;
    private Set<ContactInformationResponse> contactInformation;
    private Set<LanguageResponse> languages;
    private AboutMeResponse aboutMe;
    private Set<ExperienceResponse> experience;
    private Set<EducationResponse> education;
    private Set<TechnologyResponse> technologies;
    private Set<ProjectResponse> projects;
}
