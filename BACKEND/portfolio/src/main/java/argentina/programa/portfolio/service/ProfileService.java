package argentina.programa.portfolio.service;

import argentina.programa.portfolio.model.request.ProfileRequest;
import argentina.programa.portfolio.model.response.ProfileResponse;
import org.springframework.stereotype.Service;

@Service
public interface ProfileService {

    public ProfileResponse getProfileById(Long id);
    public ProfileResponse createProfile(ProfileRequest profileRequest);
    public ProfileResponse editProfile(ProfileRequest profileRequest, Long id);
    public ProfileResponse partialEditProfile(ProfileRequest profileRequest, Long id, String element);
    public String removeProfile(Long id);
}
