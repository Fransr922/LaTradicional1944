package com.example.myapplication;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4ClassRunner.class)
public class DarsedeBajaTest {

    @Test
    public void correovacio() {

        ActivityScenario<DarsedeBaja> smurfSesion = ActivityScenario.launch(DarsedeBaja.class);

        String correoEliminar = "";
        onView(withId(R.id.correoconf)).perform(ViewActions.typeText(correoEliminar));
        Espresso.closeSoftKeyboard();

        onView(withId(R.id.btnaceptar)).perform(click());

        onView(withId(R.id.activitydardebaja)).check(matches(isDisplayed()));

    }

}