package sat.recruitment.api.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import sat.recruitment.api.dto.UserCreateResponse;
import sat.recruitment.api.dto.UserDto;
import sat.recruitment.api.enums.UserType;
import sat.recruitment.api.model.User;
import sat.recruitment.api.model.UserNormal;
import sat.recruitment.api.model.UserPremium;
import sat.recruitment.api.model.UserSuper;
import sat.recruitment.api.repository.UserRepository;
import sat.recruitment.api.service.UserService;

import java.util.List;

@Service

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserCreateResponse createUser(UserDto messageBody) {

        User newUser = new UserNormal(messageBody.getName(),messageBody.getEmail(),messageBody.getAddress(),messageBody.getPhone(),messageBody.getType(),messageBody.getMoney());

        if (messageBody.getType().equals(UserType.NORMAL)) {
           newUser.increaseMoney();
        }
        if (messageBody.getType().equals(UserType.SUPER)) {
            newUser = new UserSuper(messageBody.getName(),messageBody.getEmail(),messageBody.getAddress(),messageBody.getPhone(),messageBody.getType(),messageBody.getMoney());
            newUser.increaseMoney();
        }
        if (messageBody.getType().equals(UserType.PREMIUM)) {
            newUser = new UserPremium(messageBody.getName(),messageBody.getEmail(),messageBody.getAddress(),messageBody.getPhone(),messageBody.getType(),messageBody.getMoney());
            newUser.increaseMoney();
        }

        List<User> users = userRepository.loadUsers();

        Boolean isDuplicated = false;
        for (User currentUser : users) {

            if (currentUser.getEmail().equals(newUser.getEmail()) || currentUser.getPhone().equals(newUser.getPhone())) {
                isDuplicated = true;
            } else if (currentUser.getName().equals(newUser.getName())) {
                if (currentUser.getAddress().equals(newUser.getAddress())) {
                    isDuplicated = true;
                }

            }
        }
        if (isDuplicated) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User is duplicated");
        }

        return new UserCreateResponse("CREATED", "SAVED USER");
    }
}
