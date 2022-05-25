package com.example.myapplication;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.app.Activity;
import android.app.Instrumentation;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4ClassRunner.class)
public class BuscarusuarioTest {

    @Test
    public void datovacio() {

        ActivityScenario<Buscarusuario> smurfSesion = ActivityScenario.launch(Buscarusuario.class);

        String nombre = "";
        onView(withId(R.id.txtbuscarnombre)).perform(ViewActions.typeText(nombre));
        Espresso.closeSoftKeyboard();

        onView(withId(R.id.btnbusc)).perform(click());

        onView(withId(R.id.BUprueb)).check(matches(withText("Nok")));

    }

    @Test
    public void usuariocorrecto() {

        ActivityScenario<Buscarusuario> smurfSesion = ActivityScenario.launch(Buscarusuario.class);

        String nombre = "ruben";
        onView(withId(R.id.txtbuscarnombre)).perform(ViewActions.typeText(nombre));
        Espresso.closeSoftKeyboard();

        onView(withId(R.id.btnbusc)).perform(click());

        onView(withId(R.id.BUprueb)).check(matches(withText("ok")));

    }

    @Test
    public void usuarioincorrecto() {

        ActivityScenario<Buscarusuario> smurfSesion = ActivityScenario.launch(Buscarusuario.class);

        String nombre = "rubena";
        onView(withId(R.id.txtbuscarnombre)).perform(ViewActions.typeText(nombre));
        Espresso.closeSoftKeyboard();

        onView(withId(R.id.btnbusc)).perform(click());

        onView(withId(R.id.BUprueb)).check(matches(withText("Nok")));

    }

    @Test
    public void BuscarUsuariobtnAtras(){

        ActivityScenario<Buscarusuario> smurfSesion = ActivityScenario.launch(Buscarusuario.class);

        onView(withId(R.id.buttonatras)).perform(click());

        Instrumentation.ActivityMonitor monitor = new Instrumentation.ActivityMonitor(Pantalla_admin.class.getName(),null,false);
        Activity sec = monitor.waitForActivityWithTimeout(5000);

        onView(withId(R.id.pantallaadmin)).check(matches(isDisplayed()));

    }

}