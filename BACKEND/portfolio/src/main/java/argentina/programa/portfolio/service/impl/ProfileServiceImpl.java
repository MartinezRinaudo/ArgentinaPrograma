package argentina.programa.portfolio.service.impl;

import argentina.programa.portfolio.common.exception.Errors;
import argentina.programa.portfolio.common.exception.NotFoundException;
import argentina.programa.portfolio.model.mapper.ProfileMapper;
import argentina.programa.portfolio.model.request.ProfileRequest;
import argentina.programa.portfolio.model.response.ProfileResponse;
import argentina.programa.portfolio.repository.ProfileRepository;
import argentina.programa.portfolio.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService {

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
        var profileEntity = profileRepository
                .findById(id)
                .orElseThrow(()-> new NotFoundException(Errors.USERNOTFOUND));
        var updatedProfile = profileMapper.updateProfile(profileEntity, profileRequest, element);
        profileRepository.save(updatedProfile);
        return profileMapper.toProfileResponse(updatedProfile);
    }

    @Override
    public String removeProfile(Long id) {
        var profileEntity = profileRepository
                .findById(id)
                .orElseThrow(()-> new NotFoundException(Errors.USERNOTFOUND));
        profileRepository.delete(profileEntity);
        return "Deleted profile";
    }


}
