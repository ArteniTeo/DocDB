package ServiceTesting;

import com.DocDB.common.AccountType;
import com.DocDB.common.Status;
import com.DocDB.controller.UserService;
import com.DocDB.entities.User;
import com.DocDB.reposiory.IUserRepository;
import com.DocDB.validator.UserValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.DocDB.validator.UserValidator.verifyEmail;
import static com.DocDB.validator.UserValidator.verifyPassword;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class userServiceTesting {

    @Mock
    IUserRepository repository;

    @InjectMocks
    UserService service;

    // TODO Make testing method for create user from UserService class

    @ParameterizedTest
    @ValueSource (strings = {"good@email.com", "anotherGood@domain.ro"})
    @DisplayName("Verify good emails with validator method")
    void testGoodEmailWithEmailVerifyingMethod(String goodEmails){
        assertDoesNotThrow(() -> verifyEmail(goodEmails));
    }

    @ParameterizedTest
    @ValueSource (strings = {"something@email..com", "something@emailcom", "somethingEmail.com", "@email.com", "test@"})
    @DisplayName("Verify bad emails with validator method")
    void testBadEmailWithEmailVerifyingMethod(String badEmails){
        assertThrows(RuntimeException.class, () -> verifyEmail(badEmails));
    }

    @Test
    @DisplayName("Verify good password with validator method")
    void testGoodPasswordsWithPasswordVerifyingMethod(){
        String password1 = "GoodPassword";
        assertDoesNotThrow(() -> verifyPassword(password1));
    }

    @ParameterizedTest
    @ValueSource(strings = {"bad", "passwordIsTooLongAndWillReturnException"})
    @DisplayName("Verify bad password with validator method")
    void testBadPasswordsWithPasswordVerifyingMethod(String string){
        assertThrows(RuntimeException.class, () -> verifyPassword(string));
    }

    @Test
    @DisplayName("Testing creation of user and insertion in DB")
    void testCreateUser(){
        //given
        var user = new User();
        String email = "testmail@gmail.com";
        user.setEmail(email);
        user.setUsername("testUsername");
        user.setPassword("testPassword");
        user.setStatus(Status.ACTIVE);
        user.setAccountType(AccountType.DOCTOR);

        //when
        User foundUser = service.createUser(user);

        //then
        assertEquals(email, user.getEmail());

    }

    @Test
    @DisplayName("Testing creation of user with invalid email")
    void testCreateUserWithInvalidEmail(){
        //given
        var user = new User();
        String email = "testmail@notRight.com";
        user.setEmail(email);
        user.setUsername("testUsername");
        user.setPassword("testPassword");
        user.setStatus(Status.ACTIVE);
        user.setAccountType(AccountType.DOCTOR);

        //then
        assertDoesNotThrow(() -> service.createUser(user));

    }

}
