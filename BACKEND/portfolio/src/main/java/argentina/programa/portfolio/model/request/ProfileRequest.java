package argentina.programa.portfolio.model.request;

import lombok.*;

import javax.validation.constraints.Email;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfileRequest {


    @Email
    private String email;
    private String fullName;
    private String location;
    private String profession;
    private String imageUrl;
    private Set<ContactInformationRequest> contactInformation;
    private Set<LanguageRequest> languages;
    private AboutMeRequest aboutMe;
    private Set<ExperienceRequest> experience;
    private Set<EducationRequest> education;
    private Set<TechListRequest> technologies;
    private Set<ProjectRequest> projects;
}
