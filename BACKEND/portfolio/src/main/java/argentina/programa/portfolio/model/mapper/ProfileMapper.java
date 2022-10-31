package argentina.programa.portfolio.model.mapper;

import argentina.programa.portfolio.common.TechCategory;
import argentina.programa.portfolio.common.exception.BadRequestException;
import argentina.programa.portfolio.common.exception.Errors;
import argentina.programa.portfolio.common.exception.NotFoundException;
import argentina.programa.portfolio.model.entity.*;
import argentina.programa.portfolio.model.request.*;
import argentina.programa.portfolio.model.response.*;
import argentina.programa.portfolio.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class ProfileMapper {

    @Autowired
    AboutMeRepository aboutMeRepository;
    @Autowired
    ContactInformationRepository contactInformationRepository;
    @Autowired
    EducationRepository educationRepository;
    @Autowired
    ExperienceRepository experienceRepository;
    @Autowired
    LanguageRepository languageRepository;
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    TechListRepository techListRepository;
    @Autowired
    TechRepository techRepository;
    @Autowired
    ProfileRepository profileRepository;
    public Profile toProfileEntity(ProfileRequest profileRequest) {
        return Profile.builder()
                .email(profileRequest.getEmail())
                .fullName(profileRequest.getFullName())
                .imageUrl(profileRequest.getImageUrl())
                .location(profileRequest.getLocation())
                .profession(profileRequest.getProfession())
                .contactInformation(toContactInformationList(profileRequest.getContactInformation()))
                .aboutMe(toAboutMe(profileRequest.getAboutMe()))
                .languages(toLanguagesList(profileRequest.getLanguages()))
                .experience(toExperienceList(profileRequest.getExperience()))
                .education(toEducationList(profileRequest.getEducation()))
                .technologies(toTechnologiesFullList(profileRequest.getTechnologies()))
                .projects(toProjectList(profileRequest.getProjects()))
                .build();
    }

    public Set<ContactInformation> toContactInformationList(Set<ContactInformationRequest> contactInformationRequestList){
        Set<ContactInformation> contactInfoList = new HashSet<>();
        contactInformationRequestList.forEach(c -> {
            var contact = toContactInformation(c);
            contactInfoList.add(contact);
        });
        return contactInfoList;
    }
    public ContactInformation toContactInformation(ContactInformationRequest contactInformationRequest) {
        var contact = ContactInformation.builder()
                .id(contactInformationRequest.getId())
                .imageUrl(contactInformationRequest.getImageUrl())
                .imageName(contactInformationRequest.getImageName())
                .link(contactInformationRequest.getLink())
                .socialMedia(contactInformationRequest.getSocialMedia())
                .build();
        return contact;
    }

    public Set<Language> toLanguagesList(Set<LanguageRequest> languagesRequestList) {
        Set<Language> languagesList = new HashSet<>();
        languagesRequestList.forEach(l -> {
            var lang =toLanguage(l);
            languagesList.add(lang);
        });
        return languagesList;
    }

    public Language toLanguage(LanguageRequest languageRequest) {
        var lang = Language.builder()
                .id(languageRequest.getId())
                .name(languageRequest.getName())
                .level(languageRequest.getLevel())
                .build();
        return lang;
    }

    public AboutMe toAboutMe(AboutMeRequest aboutMeRequest){
        return AboutMe.builder()
                .id(aboutMeRequest.getId())
                .spanishDescription(aboutMeRequest.getSpanishDescription())
                .englishDescription(aboutMeRequest.getEnglishDescription())
                .build();
    }

    public Set<Experience> toExperienceList(Set<ExperienceRequest> experienceRequestsList){
        Set<Experience> experienceList = new HashSet<>();
        experienceRequestsList.forEach(e -> {
            var exp= toExperience(e);
            experienceList.add(exp);
        });
        return experienceList;
    }

    public Experience toExperience(ExperienceRequest experienceRequest) {
        var exp= Experience.builder()
                .id(experienceRequest.getId())
                .job(experienceRequest.getJob())
                .place(experienceRequest.getPlace())
                .startDate(experienceRequest.getStartDate())
                .endDate(experienceRequest.getEndDate())
                .typeOfJob(experienceRequest.getTypeOfJob())
                .skills(experienceRequest.getSkills())
                .build();
        return exp;
    }

    public Set<Education> toEducationList(Set<EducationRequest> educationRequestList){
        Set<Education> educationList = new HashSet<>();
        educationRequestList.forEach(e -> {
            var edu= toEducation(e);
            educationList.add(edu);
        });
        return educationList;
    }

    public Education toEducation(EducationRequest educationRequest) {
        var edu= Education.builder()
                .id(educationRequest.getId())
                .name(educationRequest.getName())
                .place(educationRequest.getPlace())
                .startDate(educationRequest.getStartDate())
                .endDate(educationRequest.getEndDate())
                .build();
        return edu;
    }

    public Set<TechnologiesList> toTechnologiesFullList(Set<TechListRequest> technologiesRequestList){
        Set<TechnologiesList> technologiesList = new HashSet<>();
        technologiesRequestList.forEach(t -> {
            var tech= toTechnologiesList(t);
            technologiesList.add(tech);
        });
        return technologiesList;
    }

    public TechnologiesList toTechnologiesList(TechListRequest techListRequest) {
        var tech= TechnologiesList.builder()
                .id(techListRequest.getId())
                .category(returnCategory(techListRequest).getTechCategory())
                .technologiesList(toTechnologyList(techListRequest.getTechnologyList()))
                .build();
        return tech;
    }
    public Set<Technology> toTechnologyList(Set<TechnologyRequest> technologiesRequestList){
        Set<Technology> technologyList = new HashSet<>();
        technologiesRequestList.forEach(t -> {
            var tech= toTechnology(t);
            technologyList.add(tech);
        });
        return technologyList;
    }

    public Technology toTechnology(TechnologyRequest technologyRequest){
        var tech= Technology.builder()
                .id(technologyRequest.getId())
                .imageUrl(technologyRequest.getImageUrl())
                .imageName(technologyRequest.getImageName())
                .percentage(technologyRequest.getPercentage())
                .build();
        return tech;
    }

    private TechCategory returnCategory(TechListRequest tech) {
        if (tech.getCategory().toString().toUpperCase().equalsIgnoreCase(TechCategory.BACKEND.toString())) {
            return TechCategory.BACKEND;
        }
        else if (tech.getCategory().toString().toUpperCase().equalsIgnoreCase(TechCategory.FRONTEND.toString())){
            return TechCategory.FRONTEND;
        } else {
            return TechCategory.OTHER;
        }
    }

    public Set<Project> toProjectList(Set<ProjectRequest> projectsRequestList){
        Set<Project> projectsList = new HashSet<>();
        projectsRequestList.forEach(p -> {
            var proj= toProject(p);
            projectsList.add(proj);
        });
        return projectsList;
    }

    public Project toProject(ProjectRequest projectRequest){
        var proj= Project.builder()
                .id(projectRequest.getId())
                .name(projectRequest.getName())
                .place(projectRequest.getPlace())
                .spanishDescription(projectRequest.getSpanishDescription())
                .englishDescription(projectRequest.getEnglishDescription())
                .build();
        return proj;
    }

    public ProfileResponse toProfileResponse(Profile profile) {
       return ProfileResponse.builder()
                .id(profile.getId())
                .email(profile.getEmail())
                .fullName(profile.getFullName())
                .location(profile.getLocation())
                .profession(profile.getProfession())
                .imageUrl(profile.getImageUrl())
                .contactInformation(toContactInformationResponseList(profile.getContactInformation()))
                .languages(toLanguagesResponseList(profile.getLanguages()))
                .aboutMe(toAboutMeResponse(profile.getAboutMe()))
                .experience(toExperienceResponseList(profile.getExperience()))
                .education(toEducationResponseList(profile.getEducation()))
                .technologies(toTechnologiesResponseList((profile.getTechnologies())))
                .projects(toProjectResponseList(profile.getProjects()))
                .build();
    }

    public Set<ContactInformationResponse> toContactInformationResponseList(Set<ContactInformation> contactInformationList){
        Set<ContactInformationResponse> contactInfoResponseList = new HashSet<>();
        contactInformationList.forEach(c -> {
            var contact = ContactInformationResponse.builder()
                    .id(c.getId())
                    .imageUrl(c.getImageUrl())
                    .imageName(c.getImageName())
                    .link(c.getLink())
                    .socialMedia(c.getSocialMedia())
                    .build();

            contactInfoResponseList.add(contact);
        });
        return contactInfoResponseList;
    }

    public Set<LanguageResponse> toLanguagesResponseList(Set<Language> languagesList){
        Set<LanguageResponse> languagesResponseList = new HashSet<>();
        languagesList.forEach(l -> {
            var lang = LanguageResponse.builder()
                    .id(l.getId())
                    .name(l.getName())
                    .level(l.getLevel())
                    .build();
            languagesResponseList.add(lang);
        });
        return languagesResponseList;
    }

    public AboutMeResponse toAboutMeResponse(AboutMe aboutMe){
        return AboutMeResponse.builder()
                .id(aboutMe.getId())
                .spanishDescription(aboutMe.getSpanishDescription())
                .englishDescription(aboutMe.getEnglishDescription())
                .build();
    }

    public Set<ExperienceResponse> toExperienceResponseList(Set<Experience> experienceList){
        Set<ExperienceResponse> experienceResponseList = new HashSet<>();
        experienceList.forEach(e -> {
            var exp= ExperienceResponse.builder()
                    .id(e.getId())
                    .job(e.getJob())
                    .place(e.getPlace())
                    .startDate(e.getStartDate())
                    .endDate(e.getEndDate())
                    .typeOfJob(e.getTypeOfJob())
                    .skills(e.getSkills())
                    .build();
            experienceResponseList.add(exp);
        });
        return experienceResponseList;
    }

    public Set<EducationResponse> toEducationResponseList(Set<Education> educationList){
        Set<EducationResponse> educationResponseList = new HashSet<>();
        educationList.forEach(e -> {
            var edu= EducationResponse.builder()
                    .id(e.getId())
                    .name(e.getName())
                    .place(e.getPlace())
                    .startDate(e.getStartDate())
                    .endDate(e.getEndDate())
                    .build();
            educationResponseList.add(edu);
        });
        return educationResponseList;
    }

    public Set<TechListResponse> toTechnologiesResponseList(Set<TechnologiesList> technologiesList){
        Set<TechListResponse> technologiesResponseList = new HashSet<>();
        technologiesList.forEach(t -> {
            var tech= TechListResponse.builder()
                    .id(t.getId())
                    .category(returnCategory(t).getTechCategory())
                    .technologyList(toTechnologyResponseList(t.getTechnologiesList()))
                    .build();
            technologiesResponseList.add(tech);
        });
        return technologiesResponseList;
    }

    public Set<TechnologyResponse> toTechnologyResponseList(Set<Technology> technologiesList){
        Set<TechnologyResponse> technologyResponseList = new HashSet<>();
        technologiesList.forEach(t -> {
            var tech= TechnologyResponse.builder()
                    .id(t.getId())
                    .imageUrl(t.getImageUrl())
                    .imageName(t.getImageName())
                    .percentage(t.getPercentage())
                    .build();
            technologyResponseList.add(tech);
        });
        return technologyResponseList;
    }

    private TechCategory returnCategory(TechnologiesList tech) {
        if (tech.getCategory().toString().toUpperCase().equalsIgnoreCase(TechCategory.BACKEND.toString())) {
            return TechCategory.BACKEND;
        }
        else if (tech.getCategory().toString().toUpperCase().equalsIgnoreCase(TechCategory.FRONTEND.toString())){
            return TechCategory.FRONTEND;
        } else {
            return TechCategory.OTHER;
        }
    }

    public Set<ProjectResponse> toProjectResponseList(Set<Project> projectsList){
        Set<ProjectResponse> projectsResponseList = new HashSet<>();
        projectsList.forEach(p -> {
            var proj= ProjectResponse.builder()
                    .id(p.getId())
                    .name(p.getName())
                    .place(p.getPlace())
                    .spanishDescription(p.getSpanishDescription())
                    .englishDescription(p.getEnglishDescription())
                    .build();
            projectsResponseList.add(proj);
        });
        return projectsResponseList;
    }

    public Profile updateProfile(Profile profile, ProfileRequest profileReq) {
        profile.setId(profile.getId());
        profile.setEmail(profileReq.getEmail());
        profile.setImageUrl(profileReq.getImageUrl());
        profile.setFullName(profileReq.getFullName());
        profile.setProfession(profileReq.getProfession());
        profile.setLocation(profileReq.getLocation());
        profile.setContactInformation(toContactInformationList(profileReq.getContactInformation()));
        profile.setLanguages(toLanguagesList(profileReq.getLanguages()));
        profile.setAboutMe(toAboutMe(profileReq.getAboutMe()));
        profile.setEducation(toEducationList(profileReq.getEducation()));
        profile.setExperience(toExperienceList(profileReq.getExperience()));
        profile.setTechnologies(toTechnologiesFullList(profileReq.getTechnologies()));
        profile.setProjects(toProjectList(profileReq.getProjects()));

        return profile;
    }
    public void updateProfile(Long id, ProfileRequest profileReq, String element) {
        var profile = profileRepository.findById(id).get();
        switch(element.toUpperCase()){
                case "EMAIL":
                    profile.setEmail(profileReq.getEmail());
                    profileRepository.save(profile);
                break;
                case "FULLNAME":
                    profile.setFullName(profileReq.getFullName());
                    profileRepository.save(profile);
                break;
                case "IMAGEURL":
                    profile.setImageUrl(profileReq.getImageUrl());
                    profileRepository.save(profile);
                break;
                case "PROFESSION":
                    profile.setProfession(profileReq.getProfession());
                    profileRepository.save(profile);
                break;
                case "LOCATION":
                    profile.setLocation(profileReq.getLocation());
                    profileRepository.save(profile);
                break;
                case "CONTACTINFORMATION":
                    var contactList = profileReq.getContactInformation();
                    contactList.forEach((c) -> {
                       var contact = toContactInformation(c);
                       contactInformationRepository.save(contact);
                   });
                break;
                case "LANGUAGE":
                    var languagesList = profileReq.getLanguages();
                    languagesList.forEach((l) -> {
                        var lang = toLanguage(l);
                        languageRepository.save(lang);
                    });
                break;
                case "ABOUTME":
                    var aboutMe = toAboutMe(profileReq.getAboutMe());
                    aboutMeRepository.save(aboutMe);
                break;
                case "EDUCATION":
                    var educationList = profileReq.getEducation();
                    educationList.forEach(e -> {
                        var edu = toEducation(e);
                        educationRepository.save(edu);
                    });
                break;
                case "EXPERIENCE":
                    var experienceList = profileReq.getExperience();
                    experienceList.forEach(e -> {
                        var exp = toExperience(e);
                        experienceRepository.save(exp);
                    });
                break;
                case "TECHNOLOGY":
                    var technologiesList = profileReq.getTechnologies();
                    technologiesList.forEach(t -> {
                        var technologies = toTechnologiesList(t);
                        techListRepository.save(technologies);
                        technologies.getTechnologiesList().forEach((tech) -> {
                            var technology = tech;
                            techRepository.save(technology);
                        });
                    });
                break;
                case "PROJECT":
                    var projectList = profileReq.getProjects();
                    projectList.forEach(p -> {
                        var proj = toProject(p);
                        projectRepository.save(proj);
                    });
                break;
                default:
                    throw new BadRequestException(Errors.WRONGELEMENT);
        }
    }
}
