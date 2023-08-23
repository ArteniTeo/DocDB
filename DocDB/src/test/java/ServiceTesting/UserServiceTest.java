package ServiceTesting;

import com.DocDB.common.AccountType;
import com.DocDB.common.Status;
import com.DocDB.controller.UserController;
import com.DocDB.service.UserService;
import com.DocDB.entities.User;
import com.DocDB.reposiory.IUserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static com.DocDB.validator.UserValidator.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.RequestEntity.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
public class UserServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    IUserRepository repository;

    @MockBean
    UserService service;

    @Test
    void givenUserId_whenFindingUser_thenReturnStatus() throws Exception {
        //given
        User mockUser = new User(1L,
                "email.mail.com",
                "username",
                "Password!23",
                Status.ACTIVE,
                AccountType.PATIENT);
        given(service.getUserById(1L)).willReturn(mockUser);

        //when & then
        mockMvc.perform(MockMvcRequestBuilders.get("/user")
                        .param("id", String.valueOf(1L))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
   // void  throws Exception {

    @ParameterizedTest
    @ValueSource(strings = {"good@email.com", "another.good@domain.ro"})
    @DisplayName("Verify good emails")
    void givenGoodEmail_whenVerifyingEmail_thenDoesNothing(String goodEmails) {
        assertTrue(() -> isEmailValid(goodEmails));
    }

    @ParameterizedTest
    @ValueSource(strings = {"something@email..com", "something@emailcom", "somethingEmail.com", "@email.com", "test@"})
    @DisplayName("Verify bad emails")
    void givenBadEmail_whenVerifyingEmail_thenThrowsException(String badEmails) {
        assertFalse(() -> isEmailValid(badEmails));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Good Password !23", "GoodPassword!23"})
    @DisplayName("Verify good password")
    void givenGoodPassword_whenPasswordVerifying_thenDoesNothing(String passwords) {
        assertDoesNotThrow(() -> verifyPassword(passwords));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "bad", "NoDigitsOrSymbols", "Not1Symbol", "NoNumbers!@#", "passwordIsTooLongAndWillReturnException"})
    @DisplayName("Verify bad password")
    void givenBadPassword_whenPasswordVerifying_thenThrowsException(String string) {
        assertThrows(RuntimeException.class, () -> verifyPassword(string));
    }

    @Test
    @DisplayName("Testing creation of user")
    void givenUser_whenCreatingUser_thenReturnUser() {
        //given
        var user = new User();
        user.setEmail("testmail@gmail.com");
        user.setUsername("testUsername");
        user.setPassword("Password!23");
        user.setStatus(Status.ACTIVE);
        user.setAccountType(AccountType.DOCTOR);
        given(repository.save(user)).willReturn(user);

        //when
        User foundUser = service.createUser(user);

        //then
        assertEquals(user, foundUser);

    }

    @Test
    @DisplayName("Testing creation of user with email that is already in use")
    void givenUserWithAnEmailThatIsAlreadyInUse_whenCreatingUser_thenThrowException() {
        //given
        var user = new User();
        user.setEmail("emailAlreadyInUse@used.com");
        user.setUsername("testUsername");
        user.setPassword("Password!23");
        user.setStatus(Status.ACTIVE);
        user.setAccountType(AccountType.DOCTOR);
        given(repository.findByEmail("emailAlreadyInUse@used.com")).willReturn(user);

        //then
        assertThrows(RuntimeException.class, () -> service.createUser(user));

    }

    @Test
    @DisplayName("Testing creation of user with username that is already in use")
    void givenUserWithAnUsernameThatIsAlreadyInUse_whenCreatingUser_thenThrowException() {
        //given
        var user = new User();
        user.setEmail("email@good.com");
        user.setUsername("UsedUsername");
        user.setPassword("Password!23");
        user.setStatus(Status.ACTIVE);
        user.setAccountType(AccountType.DOCTOR);
        given(repository.findByUsername("UsedUsername")).willReturn(user);

        //then
        assertThrows(RuntimeException.class, () -> service.createUser(user));

    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
