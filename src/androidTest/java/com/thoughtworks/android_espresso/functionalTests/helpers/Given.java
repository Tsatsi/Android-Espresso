package com.thoughtworks.android_espresso.functionalTests.helpers;

import com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers;
import com.thoughtworks.android_espresso.R;

import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.typeText;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withId;

public class Given {

    public static void theLoginCredentialHaveBeenEnteredWithTheWrongEmail(){
        onView(ViewMatchers.withId(R.id.user_name)).perform(typeText("tsatsi.mahase"));
        onView(withId(R.id.password)).perform(typeText("Password123"));
    }
    public static void theWrongLoginUsernameAndPasswordHaveBeenEntered(){
        onView(withId(R.id.user_name)).perform(typeText("tsatsi.mahse@gmail.com"));
        onView(withId(R.id.password)).perform(typeText("Password12"));
    }
    public static void theCorrectLoginCredentialsHaveBeenEntered(){
        onView(withId(R.id.user_name)).perform(typeText("tsatsi.mahase@gmail.com"));
        onView(withId(R.id.password)).perform(typeText("Password123"));
    }

    public static void theRegistrationDetailsWithTheWrongEmailHaveBeenEntered() {
        onView(ViewMatchers.withId(R.id.reg_name)).perform(typeText("Tsatsi"));
        onView(withId(R.id.reg_surname)).perform(typeText("Mahase"));
        onView(withId(R.id.user_name)).perform(typeText("tsatsi.mahase#gmail.com"));
        onView(withId(R.id.password)).perform(typeText("Password123"));
    }

    public static void theRegistrationDetailsWithMissingFieldsHaveBeenEntered() {
        onView(withId(R.id.reg_name)).perform(typeText("Tsatsi"));
        onView(withId(R.id.reg_surname)).perform(typeText(""));
        onView(withId(R.id.user_name)).perform(typeText("mradebe@gmail.com"));
        onView(withId(R.id.password)).perform(typeText(""));
    }

    public static void theRegistrationDetailsOfAnExistingUserHaveBeenEntered() {
        onView(withId(R.id.reg_name)).perform(typeText("Tsatsi"));
        onView(withId(R.id.reg_surname)).perform(typeText("Mahase"));
        onView(withId(R.id.user_name)).perform(typeText("tsatsi.mahase@gmail.com"));
        onView(withId(R.id.password)).perform(typeText("Password123"));
    }

    public static void theValidRegistrationDetailsHaveBeenEntered() {
        onView(withId(R.id.reg_name)).perform(typeText("Mboneni"));
        onView(withId(R.id.reg_surname)).perform(typeText("Radebe"));
        onView(withId(R.id.user_name)).perform(typeText("mradebe@thoughtworks.com"));
        onView(withId(R.id.password)).perform(typeText("Password123"));
    }
}
