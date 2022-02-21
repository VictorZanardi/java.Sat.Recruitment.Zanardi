package sat.recruitment.api.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import sat.recruitment.api.dto.UserCreateResponse;
import sat.recruitment.api.dto.UserDto;
import sat.recruitment.api.enums.UserType;
import sat.recruitment.api.service.UserService;


import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class MessagesActionsControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private SatRecruitmentController controller;

    @Mock
    private UserService service;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .build();
    }

    @Test
    void testCreateUSer() throws Exception {

        ResponseEntity<UserCreateResponse> httpResponse = controller.createUser(getUserDto());

        assertEquals(httpResponse.getStatusCode(), HttpStatus.CREATED);

    }

    private UserDto getUserDto() {
        return UserDto.builder()
                .name("Juan")
                .email("Juan@marmol.com")
                .address("Peru 2464")
                .phone("+5491154762312")
                .type(UserType.NORMAL)
                .money(1234.0)
                .build();
    }

}
