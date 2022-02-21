package sat.recruitment.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import sat.recruitment.api.dto.UserCreateResponse;
import sat.recruitment.api.dto.UserDto;
import sat.recruitment.api.service.UserService;
import sat.recruitment.api.utils.ValidationUtils;

@RestController
@RequestMapping(value = "/api/v1")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SatRecruitmentController {

	private final UserService service;

	@PostMapping(value = "/create-user", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<UserCreateResponse> createUser(@RequestBody UserDto messageBody) {
		String errors = "";

		ValidationUtils.validateBodyErrors(messageBody.getName(), messageBody.getEmail(), messageBody.getAddress(), messageBody.getPhone(),
				errors);

		UserCreateResponse response = service.createUser(messageBody);

		return new ResponseEntity<UserCreateResponse>(response, HttpStatus.CREATED);
	}
}
