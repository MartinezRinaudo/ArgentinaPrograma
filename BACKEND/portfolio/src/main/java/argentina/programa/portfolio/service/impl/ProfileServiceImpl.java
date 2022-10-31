package argentina.programa.portfolio.service.impl;

import argentina.programa.portfolio.common.exception.BadRequestException;
import argentina.programa.portfolio.common.exception.Errors;
import argentina.programa.portfolio.common.exception.NotFoundException;
import argentina.programa.portfolio.model.entity.*;
import argentina.programa.portfolio.model.mapper.ProfileMapper;
import argentina.programa.portfolio.model.request.ProfileRequest;
import argentina.programa.portfolio.model.response.ProfileResponse;
import argentina.programa.portfolio.repository.*;
import argentina.programa.portfolio.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ProfileServiceImpl implements ProfileService {
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
    @Autowired
    ProfileMapper profileMapper;

    @Override
    public ProfileResponse getProfileById(Long id) {

        var profile = profileRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Errors.USERNOTFOUND));
        return profileMapper.toProfileResponse(profile);
    }

    @Override
    public ProfileResponse createProfile(ProfileRequest profileRequest) {
        profileRepository
                .findByEmail(profileRequest.getEmail())
                .orElseThrow(() -> new NotFoundException(Errors.USERNOTFOUND));
        var profileToSave = profileMapper.toProfileEntity(profileRequest);
        var profile = profileRepository.save(profileToSave);
        return profileMapper.toProfileResponse(profile);
    }

    @Override
    public ProfileResponse editProfile(ProfileRequest profileRequest, Long id) {
        var profileEntity = profileRepository
                .findById(id)
                .orElseThrow(()-> new NotFoundException(Errors.USERNOTFOUND));
        var updatedProfile = profileMapper.updateProfile(profileEntity, profileRequest);
        profileRepository.save(updatedProfile);
        return profileMapper.toProfileResponse(updatedProfile);
    }

    @Override
    public ProfileResponse partialEditProfile(ProfileRequest profileRequest, Long id, String element) {
        profileMapper.updateProfile(id, profileRequest, element);
        var profileEntity = profileRepository
                .findById(id)
                .orElseThrow(()-> new NotFoundException(Errors.USERNOTFOUND));
        return profileMapper.toProfileResponse(profileEntity);
    }

    @Override
    public String removeProfile(Long id) {
        var profileEntity = profileRepository
                .findById(id)
                .orElseThrow(()-> new NotFoundException(Errors.USERNOTFOUND));
        profileRepository.delete(profileEntity);
        return "Deleted profile";
    }

    @Override
    public String removeElement(Long id, String element, Long idElement) {
        var p = profileRepository.findById(id).orElseThrow(() -> new NotFoundException(Errors.USERNOTFOUND));


        switch(element.toUpperCase()){
        case "CONTACTINFORMATION":
            var c = contactInformationRepository.findById(idElement).orElseThrow(() -> new NotFoundException(Errors.ELEMENTNOTFOUND));
            contactInformationRepository.delete(c);
            var contacts =contactInformationRepository.findAll();
            Set<ContactInformation> contList = new HashSet<>();
            contacts.forEach((contact) ->{
                contList.add(contact);
            });
            p.setContactInformation(contList);
            profileRepository.save(p);
        break;
        case "LANGUAGE":
            var l = languageRepository.findById(idElement).orElseThrow(() -> new NotFoundException(Errors.ELEMENTNOTFOUND));
            languageRepository.delete(l);
            var langs =languageRepository.findAll();
            Set<Language> langList = new HashSet<>();
            langs.forEach((lang) ->{
                langList.add(lang);
            });
            p.setLanguages(langList);
            profileRepository.save(p);
        break;
        case "ABOUTME":
            var am = aboutMeRepository.findById(idElement).orElseThrow(() -> new NotFoundException(Errors.ELEMENTNOTFOUND));
            aboutMeRepository.delete(am);
            AboutMe aboutme =  aboutMeRepository.findById(idElement).get();
            p.setAboutMe((AboutMe) aboutme);
            profileRepository.save(p);
        break;
        case "EDUCATION":
            var e = educationRepository.findById(idElement).orElseThrow(() -> new NotFoundException(Errors.ELEMENTNOTFOUND));
            educationRepository.delete(e);
            var edu = educationRepository.findAll();
            Set<Education> eduList = new HashSet<>();
            edu.forEach((ed) ->{
                eduList.add(ed);
            });
            p.setEducation(eduList);
            profileRepository.save(p);
        break;
        case "EXPERIENCE":
            var ex = experienceRepository.findById(idElement).orElseThrow(() -> new NotFoundException(Errors.ELEMENTNOTFOUND));
            experienceRepository.delete(ex);
            var experiences = experienceRepository.findAll();
            Set<Experience> expList = new HashSet<>();
            experiences.forEach((exp) ->{
                expList.add(exp);
            });
            p.setExperience(expList);
            profileRepository.save(p);
        break;
        case "TECHNOLOGY":
            var t = techListRepository.findById(idElement).orElseThrow(() -> new NotFoundException(Errors.ELEMENTNOTFOUND));
            techListRepository.delete(t);
            var techs = techListRepository.findAll();
            Set<TechnologiesList> techList = new HashSet<>();
            techs.forEach((tech) ->{
                techList.add(tech);
            });
            p.setTechnologies(techList);
            profileRepository.save(p);

        break;
        case "PROJECT":
            var proj = projectRepository.findById(idElement).orElseThrow(() -> new NotFoundException(Errors.ELEMENTNOTFOUND));
            p.removeProject(proj);
            projectRepository.delete(proj);
            /*var projs = projectRepository.findAll();
            Set<Project> projList = new HashSet<>();
            projs.forEach((project) ->{
                projList.add(project);
            });
            p.setProjects(projList);
            profileRepository.save(p);*/
        break;
        default:
        throw new BadRequestException(Errors.WRONGELEMENT);
    }
        return "Deleted element";
    }

}
