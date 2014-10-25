package com.thoughtworks.android_espresso.functionalTests;

import android.test.ActivityInstrumentationTestCase2;

import com.thoughtworks.android_espresso.LoginActivity;
import com.thoughtworks.android_espresso.functionalTests.helpers.Given;
import com.thoughtworks.android_espresso.functionalTests.helpers.Then;
import com.thoughtworks.android_espresso.functionalTests.helpers.When;

public class LoginTest extends ActivityInstrumentationTestCase2<LoginActivity> {

    @SuppressWarnings("deprecation")
    public LoginTest() {
        super("com.thoughtworks.android_espresso", LoginActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    public void testShouldNotLoginWithIncorrectEmail() throws Exception {
        Given.theLoginCredentialHaveBeenEnteredWithTheWrongEmail();
        When.iPressTheLoginButton();
        Then.iShouldSeeAMessageThatInformsMeOfTheWrongEmail();
    }

    public void testShouldNotLoginWithIncorrectPasswordOrUsername() throws Exception {
        Given.theWrongLoginUsernameAndPasswordHaveBeenEntered();
        When.iPressTheLoginButton();
        Then.iShouldSeeAMessageThatInformsMeOfTheWrongUsernameOrPassword();
    }

    public void testShouldLoginCorrectCredentials() throws Exception {
        Given.theCorrectLoginCredentialsHaveBeenEntered();
        When.iPressTheLoginButton();
        Then.iShouldSeeAWelcomeMessage();
    }
}
