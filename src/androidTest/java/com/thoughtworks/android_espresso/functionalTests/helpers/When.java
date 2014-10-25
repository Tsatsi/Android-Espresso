package com.thoughtworks.android_espresso.functionalTests.helpers;

import com.thoughtworks.android_espresso.R;

import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.click;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withId;

public class When {
    public static void iPressTheLoginButton(){
        onView(withId(R.id.login_btnLogin)).perform(click());
    }

    public static void iPressTheRegisterButton() {
        onView(withId(R.id.btnRegister)).perform(click());
    }
}
