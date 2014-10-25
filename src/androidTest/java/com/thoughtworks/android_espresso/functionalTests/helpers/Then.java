package com.thoughtworks.android_espresso.functionalTests.helpers;

import com.thoughtworks.android_espresso.R;

import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.assertion.ViewAssertions.matches;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withId;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.containsString;

public class Then {
    public static void iShouldSeeAMessageThatInformsMeOfTheWrongEmail() {
        onView(withId(R.id.error_message)).check(matches(withText(containsString("Incorrect email address"))));
    }

    public static void iShouldSeeAMessageThatInformsMeOfTheWrongUsernameOrPassword() {
        onView(withId(R.id.error_message)).check(matches(withText(containsString("Wrong username / password"))));
    }

    public static void iShouldSeeAWelcomeMessage() {
        onView(withId(R.id.welcome_espresso)).check(matches(withText(containsString("Welcome! Enjoy your coffee"))));
    }

    public static void iShouldSeeAMessageThatTellsMeToEnterAllDetails() {
        onView(withId(R.id.error_message)).check(matches(withText(containsString("Please enter all details"))));
    }

    public static void iShouldSeeAMessageThatInformsMeThatTheUserAlreadyExists() {
        onView(withId(R.id.error_message)).check(matches(withText(containsString("Already have user registered with this email"))));
    }
}
