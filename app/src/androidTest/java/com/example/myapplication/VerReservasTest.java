package com.example.myapplication;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.core.app.ActivityScenario;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4ClassRunner.class)
public class VerReservasTest {

    @Test
    public void VerReservasMesaOK() throws InterruptedException {

        ActivityScenario<VerReservas> smurfSesion = ActivityScenario.launch(VerReservas.class);
        onView(withId(R.id.btnverreservamesa)).perform(click());
        Thread.sleep(3000);
        onView(withId(R.id.RMprueba)).check(matches(withText("ok")));

    }

    @Test
    public void VerReservasMesayComidaOK() throws InterruptedException {

        ActivityScenario<VerReservas> smurfSesion = ActivityScenario.launch(VerReservas.class);

        onView(withId(R.id.btnLoad2)).perform(click());
        Thread.sleep(3000);
        onView(withId(R.id.RMprueba2)).check(matches(withText("ok")));

    }
}