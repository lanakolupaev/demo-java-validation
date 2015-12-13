package me.kolupaev.lana.validation.business;

import org.junit.Assert;
import org.hibernate.validator.HibernateValidator;
import org.junit.Before;
import org.junit.Test;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.ConstraintViolation;
import java.util.Set;

/**
 * @author Lana Kolupaev
 * @date 2015-05-18
 */
public class UserValidatorTest {
    private LocalValidatorFactoryBean localValidatorFactory;

    @Before
    public void setup() {
        localValidatorFactory = new LocalValidatorFactoryBean();
        localValidatorFactory.setProviderClass(HibernateValidator.class);
        localValidatorFactory.afterPropertiesSet();
    }

    @Test
    public void validUser_validate_success() {
        final User user = getValidUser();
        Set<ConstraintViolation<User>> constraintViolations = localValidatorFactory.validate(user);
        expectNoError(constraintViolations);
    }

    @Test
    public void usernameTooShort_validate_failure() {
        final User user = getValidUser();
        user.setUsername("abc");
        Set<ConstraintViolation<User>> constraintViolations = localValidatorFactory.validate(user);
        expectError(constraintViolations);
    }

    @Test
    public void forbiddenCharactersInUsername_validate_failure() {
        final User user = getValidUser();
        user.setUsername("abcd#");
        Set<ConstraintViolation<User>> constraintViolations = localValidatorFactory.validate(user);
        expectError(constraintViolations);
    }

    @Test
    public void passwordTooShort_validate_failure() {
        final User user = getValidUser();
        user.setPassword("aaaB3");
        Set<ConstraintViolation<User>> constraintViolations = localValidatorFactory.validate(user);
        expectError(constraintViolations);
    }

    @Test
    public void passwordHasNoDigits_validate_failure() {
        final User user = getValidUser();
        user.setPassword("aaaaAAAA");
        Set<ConstraintViolation<User>> constraintViolations = localValidatorFactory.validate(user);
        expectError(constraintViolations);
    }

    @Test
    public void passwordHasNoUppercaseLetters_validate_failure() {
        final User user = getValidUser();
        user.setPassword("aaaa3333");
        Set<ConstraintViolation<User>> constraintViolations = localValidatorFactory.validate(user);
        expectError(constraintViolations);
    }

    @Test
    public void passwordHasNoLowercaseLetters_validate_failure() {
        final User user = getValidUser();
        user.setPassword("AAAA3333");
        Set<ConstraintViolation<User>> constraintViolations = localValidatorFactory.validate(user);
        expectError(constraintViolations);
    }

    @Test
    public void passwordHasForbiddenCharacters_validate_failure() {
        final User user = getValidUser();
        user.setPassword("aaaaAA33#");
        Set<ConstraintViolation<User>> constraintViolations = localValidatorFactory.validate(user);
        Assert.assertTrue("Expected no validation errors", constraintViolations.size() == 0);
    }

    private static User getValidUser() {
        final User user = new User();
        user.setUsername("johndoe");
        user.setPassword("aaaaAAA1");
        return user;
    }

    private static void expectError(Set<ConstraintViolation<User>> constraintViolations) {
        Assert.assertTrue("Expected errors", constraintViolations.size() > 0);
    }

    private static void expectNoError(Set<ConstraintViolation<User>> constraintViolations) {
        Assert.assertTrue("Expected NO errors", constraintViolations.size() == 0);
    }


}
