package com.thoughtworks.android_espresso.functionalTests;

import android.os.SystemClock;
import android.test.ActivityInstrumentationTestCase2;

import com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers;
import com.thoughtworks.android_espresso.LoginActivity;
import com.thoughtworks.android_espresso.R;

import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.click;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.typeText;
import static com.google.android.apps.common.testing.ui.espresso.assertion.ViewAssertions.matches;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withId;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.containsString;

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
        onView(ViewMatchers.withId(R.id.user_name)).perform(typeText("tsatsi.mahase"));
        SystemClock.sleep(1000);
        onView(withId(R.id.password)).perform(typeText("Password123"));
        onView(withId(R.id.login_btnLogin)).perform(click());
        onView(withId(R.id.error_message)).check(matches(withText(containsString("Incorrect email address"))));
    }

    public void testShouldNotLoginWithIncorrectCredentials() throws Exception {
        onView(withId(R.id.user_name)).perform(typeText("tsatsi.mahase@gmail.com"));
        SystemClock.sleep(1000);
        onView(withId(R.id.password)).perform(typeText("Password12"));
        onView(withId(R.id.login_btnLogin)).perform(click());
        onView(withId(R.id.error_message)).check(matches(withText(containsString("Wrong username / password"))));

    }

    public void testShouldLoginCorrectCredentials() throws Exception {
        onView(withId(R.id.user_name)).perform(typeText("tsatsi.mahase@gmail.com"));
        SystemClock.sleep(1000);
        onView(withId(R.id.password)).perform(typeText("Password123"));
        SystemClock.sleep(1000);SystemClock.sleep(1000);
        onView(withId(R.id.login_btnLogin)).perform(click());
        onView(withId(R.id.welcome_espresso)).check(matches(withText(containsString("Welcome! Enjoy your coffee"))));
    }
}
