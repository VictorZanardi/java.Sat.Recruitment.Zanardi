package sat.recruitment.api.service;

import sat.recruitment.api.dto.UserCreateResponse;
import sat.recruitment.api.dto.UserDto;

public interface UserService {

    UserCreateResponse createUser(UserDto messageBody);
}
