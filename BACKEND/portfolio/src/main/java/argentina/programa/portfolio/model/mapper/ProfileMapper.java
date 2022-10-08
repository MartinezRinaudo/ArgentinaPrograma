package argentina.programa.portfolio.model.mapper;

import argentina.programa.portfolio.common.TechCategory;
import argentina.programa.portfolio.common.exception.BadRequestException;
import argentina.programa.portfolio.common.exception.Errors;
import argentina.programa.portfolio.model.entity.*;
import argentina.programa.portfolio.model.request.*;
import argentina.programa.portfolio.model.response.*;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class ProfileMapper {

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
            var contact = ContactInformation.builder()
                    .imageUrl(c.getImageUrl())
                    .imageName(c.getImageName())
                    .link(c.getLink())
                    .socialMedia(c.getSocialMedia())
                    .build();
            contactInfoList.add(contact);
        });
        return contactInfoList;
    }

    public Set<Language> toLanguagesList(Set<LanguageRequest> languagesRequestList) {
        Set<Language> languagesList = new HashSet<>();
        languagesRequestList.forEach(l -> {
            var lang = Language.builder()
                    .name(l.getName())
                    .level(l.getLevel())
                    .build();
            languagesList.add(lang);
        });
        return languagesList;
    }

    public AboutMe toAboutMe(AboutMeRequest aboutMeRequest){
        return AboutMe.builder()
                .spanishDescription(aboutMeRequest.getSpanishDescription())
                .englishDescription(aboutMeRequest.getEnglishDescription())
                .build();
    }

    public Set<Experience> toExperienceList(Set<ExperienceRequest> experienceRequestsList){
        Set<Experience> experienceList = new HashSet<>();
        experienceRequestsList.forEach(e -> {
            var exp= Experience.builder()
                    .job(e.getJob())
                    .place(e.getPlace())
                    .startDate(e.getStartDate())
                    .endDate(e.getEndDate())
                    .typeOfJob(e.getTypeOfJob())
                    .skills(e.getSkills())
                    .build();
            experienceList.add(exp);
        });
        return experienceList;
    }

    public Set<Education> toEducationList(Set<EducationRequest> educationRequestList){
        Set<Education> educationList = new HashSet<>();
        educationRequestList.forEach(e -> {
            var edu= Education.builder()
                    .name(e.getName())
                    .place(e.getPlace())
                    .startDate(e.getStartDate())
                    .endDate(e.getEndDate())
                    .build();
            educationList.add(edu);
        });
        return educationList;
    }

    public Set<TechnologiesList> toTechnologiesFullList(Set<TechListRequest> technologiesRequestList){
        Set<TechnologiesList> technologiesList = new HashSet<>();
        technologiesRequestList.forEach(t -> {
            var tech= TechnologiesList.builder()
                    .category(returnCategory(t).getTechCategory())
                    .technologiesList(toTechnologyList(t.getTechnologyRequestSet()))
                    .build();
            technologiesList.add(tech);
        });
        return technologiesList;
    }
    public Set<Technology> toTechnologyList(Set<TechnologyRequest> technologiesRequestList){
        Set<Technology> technologyList = new HashSet<>();
        technologiesRequestList.forEach(t -> {
            var tech= Technology.builder()
                    .imageUrl(t.getImageUrl())
                    .imageName(t.getImageName())
                    .percentage(t.getPercentage())
                    .build();
            technologyList.add(tech);
        });
        return technologyList;
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
            var proj= Project.builder()
                    .name(p.getName())
                    .place(p.getPlace())
                    .spanishDescription(p.getSpanishDescription())
                    .englishDescription(p.getEnglishDescription())
                    .build();
            projectsList.add(proj);
        });
        return projectsList;
    }

    public ProfileResponse toProfileResponse(Profile profile) {
       return ProfileResponse.builder()
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
                    .name(l.getName())
                    .level(l.getLevel())
                    .build();
            languagesResponseList.add(lang);
        });
        return languagesResponseList;
    }

    public AboutMeResponse toAboutMeResponse(AboutMe aboutMe){
        return AboutMeResponse.builder()
                .spanishDescription(aboutMe.getSpanishDescription())
                .englishDescription(aboutMe.getEnglishDescription())
                .build();
    }

    public Set<ExperienceResponse> toExperienceResponseList(Set<Experience> experienceList){
        Set<ExperienceResponse> experienceResponseList = new HashSet<>();
        experienceList.forEach(e -> {
            var exp= ExperienceResponse.builder()
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
    public Profile updateProfile(Profile profile, ProfileRequest profileReq, String element) {
        switch(element.toUpperCase()){
                case "EMAIL":
                profile.setEmail(profileReq.getEmail());
                break;
                case "FULLNAME":
                    profile.setFullName(profileReq.getFullName());
                break;
                case "IMAGEURL":
                    profile.setImageUrl(profileReq.getImageUrl());
                break;
                case "PROFESSION":
                    profile.setProfession(profileReq.getProfession());
                break;
                case "LOCATION":
                    profile.setLocation(profileReq.getLocation());
                break;
                case "CONTACTINFORMATION":
                    profile.setContactInformation(toContactInformationList(profileReq.getContactInformation()));
                break;
                case "LANGUAGE":
                    profile.setLanguages(toLanguagesList(profileReq.getLanguages()));
                break;
                case "ABOUTME":
                    profile.setAboutMe(toAboutMe(profileReq.getAboutMe()));
                break;
                case "EDUCATION":
                    profile.setEducation(toEducationList(profileReq.getEducation()));
                break;
                case "EXPERIENCE":
                    profile.setExperience(toExperienceList(profileReq.getExperience()));
                break;
                case "TECHNOLOGY":
                    profile.setTechnologies(toTechnologiesFullList(profileReq.getTechnologies()));
                break;
                case "PROJECT":
                    profile.setProjects(toProjectList(profileReq.getProjects()));
                break;
                default:
                    throw new BadRequestException(Errors.WRONGELEMENT);
        }
        return profile;
    }
}
