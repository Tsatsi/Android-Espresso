package com.thoughtworks.android_espresso.functionalTests;

import android.os.SystemClock;
import android.test.ActivityInstrumentationTestCase2;

import com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers;
import com.thoughtworks.android_espresso.R;
import com.thoughtworks.android_espresso.RegisterActivity;

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
       onView(ViewMatchers.withId(R.id.reg_name)).perform(typeText("Tsatsi"));
       onView(withId(R.id.reg_surname)).perform(typeText("Mahase"));
        SystemClock.sleep(1000);
        onView(withId(R.id.user_name)).perform(typeText("tsatsi.mahase#gmail.com"));
        SystemClock.sleep(1000);
       onView(withId(R.id.password)).perform(typeText("Password123"));
        SystemClock.sleep(1000);
       onView(withId(R.id.btnRegister)).perform(click());
       onView(withId(R.id.error_message)).check(matches(withText(containsString("Incorrect email address"))));
    }

    public void testShouldNotRegisterMissingDetails() throws Exception {
        onView(withId(R.id.reg_name)).perform(typeText("Tsatsi"));
        SystemClock.sleep(1000);
        onView(withId(R.id.reg_surname)).perform(typeText(""));
        SystemClock.sleep(1000);
        onView(withId(R.id.user_name)).perform(typeText("mradebe@gmail.com"));
        SystemClock.sleep(1000);
        onView(withId(R.id.password)).perform(typeText(""));
        SystemClock.sleep(1000);
        onView(withId(R.id.btnRegister)).perform(click());
        onView(withId(R.id.error_message)).check(matches(withText(containsString("Please enter all details"))));
    }

    public void testShouldNotRegisterExistingUser() throws Exception {
        onView(withId(R.id.reg_name)).perform(typeText("Tsatsi"));
        SystemClock.sleep(1000);
        onView(withId(R.id.reg_surname)).perform(typeText("Mahase"));
        SystemClock.sleep(1000);
        onView(withId(R.id.user_name)).perform(typeText("tsatsi.mahase@gmail.com"));
        SystemClock.sleep(1000);
        onView(withId(R.id.password)).perform(typeText("Password123"));
        SystemClock.sleep(1000);
        onView(withId(R.id.btnRegister)).perform(click());
        onView(withId(R.id.error_message)).check(matches(withText(containsString("Already have user registered with this email"))));

    }

    public void testShouldRegisterValidDetails() throws Exception {
        onView(withId(R.id.reg_name)).perform(typeText("Mboneni"));
        SystemClock.sleep(1000);
        onView(withId(R.id.reg_surname)).perform(typeText("Radebe"));
        SystemClock.sleep(1000);
        onView(withId(R.id.user_name)).perform(typeText("mradebe@thoughtworks.com"));
        SystemClock.sleep(1000);
        onView(withId(R.id.password)).perform(typeText("Password123"));
        SystemClock.sleep(1000);
        onView(withId(R.id.btnRegister)).perform(click());
        onView(withId(R.id.welcome_espresso)).check(matches(withText(containsString("Welcome! Enjoy your coffee"))));
    }
}
