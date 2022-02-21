package sat.recruitment.api.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import sat.recruitment.api.enums.UserType;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UserTest {

    private MockMvc mockMvc;

    @InjectMocks
    private User user;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(user)
                .build();
    }

    @Test
    void testUserNormalIncreaseMoneyGreaterThan100() throws Exception {

        user = new UserNormal("", "", "", "", UserType.NORMAL, 101.0);

        user.increaseMoney();

        assertEquals(user.getMoney(), 113.12);
    }


    @Test
    void testUserNormalIncreaseMoneyLessThan100() throws Exception {

        user = new UserNormal("", "", "", "", UserType.NORMAL, 99.0);

        user.increaseMoney();

        assertEquals(user.getMoney(), 178.2);
    }

    @Test
    void testUserNormalIncreaseMoneyNotModifications() throws Exception {

        user = new UserNormal("", "", "", "", UserType.NORMAL, 9.0);

        user.increaseMoney();

        assertEquals(user.getMoney(), 9.0);
    }

    @Test
    void testUserSuperIncreaseMoneyGreaterThan100() throws Exception {

        user = new UserSuper("", "", "", "", UserType.NORMAL, 101.0);

        user.increaseMoney();

        assertEquals(user.getMoney(), 121.2);
    }

    @Test
    void testUserSuperIncreaseMoneyNotModifications() throws Exception {

        user = new UserSuper("", "", "", "", UserType.NORMAL, 99.0);

        user.increaseMoney();

        assertEquals(user.getMoney(), 99.0);
    }

    @Test
    void tesUserPremiumIncreaseMoneyGreaterThan100() throws Exception {

        user = new UserPremium("", "", "", "", UserType.NORMAL, 101.0);

        user.increaseMoney();

        assertEquals(user.getMoney(), 303.0);
    }

    @Test
    void testUserPremiumIncreaseMoneyNotModifications() throws Exception {

        user = new UserPremium("", "", "", "", UserType.NORMAL, 99.0);

        user.increaseMoney();

        assertEquals(user.getMoney(), 99.0);
    }
}
