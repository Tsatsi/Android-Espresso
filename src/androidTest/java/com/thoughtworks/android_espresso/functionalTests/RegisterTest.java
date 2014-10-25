package com.thoughtworks.android_espresso.functionalTests;

import android.test.ActivityInstrumentationTestCase2;

import com.thoughtworks.android_espresso.R;
import com.thoughtworks.android_espresso.RegisterActivity;
import com.thoughtworks.android_espresso.functionalTests.helpers.Given;
import com.thoughtworks.android_espresso.functionalTests.helpers.Then;
import com.thoughtworks.android_espresso.functionalTests.helpers.When;

import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.click;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.typeText;
import static com.google.android.apps.common.testing.ui.espresso.assertion.ViewAssertions.matches;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withId;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.containsString;

public class RegisterTest extends ActivityInstrumentationTestCase2<RegisterActivity> {

    @SuppressWarnings("deprecation")
    public RegisterTest() {
        super("com.thoughtworks.android_espresso", RegisterActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    public void testShouldNotRegisterWrongEmail() throws Exception {
        Given.theRegistrationDetailsWithTheWrongEmailHaveBeenEntered();
        When.iPressTheRegisterButton();
        Then.iShouldSeeAMessageThatInformsMeOfTheWrongEmail();
    }

    public void testShouldNotRegisterMissingDetails() throws Exception {
        Given.theRegistrationDetailsWithMissingFieldsHaveBeenEntered();
        When.iPressTheRegisterButton();
        Then.iShouldSeeAMessageThatTellsMeToEnterAllDetails();
    }

    public void testShouldNotRegisterExistingUser() throws Exception {
        Given.theRegistrationDetailsOfAnExistingUserHaveBeenEntered();
        When.iPressTheRegisterButton();
        Then.iShouldSeeAMessageThatInformsMeThatTheUserAlreadyExists();
    }

    public void testShouldRegisterValidDetails() throws Exception {
        Given.theValidRegistrationDetailsHaveBeenEntered();
        When.iPressTheRegisterButton();
        Then.iShouldSeeAWelcomeMessage();
    }
}
