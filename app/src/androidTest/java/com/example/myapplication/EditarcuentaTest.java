package com.example.myapplication;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

import android.app.Activity;
import android.app.Instrumentation;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4ClassRunner.class)
public class EditarcuentaTest {


    @Test
    public void datosvacios(){

        ActivityScenario<Editarcuenta> smurfSesion = ActivityScenario.launch(Editarcuenta.class);

        String nombre = "";
        String apellidos = "";
        onView(withId(R.id.nombreedit)).perform(ViewActions.typeText(nombre));
        onView(withId(R.id.apellidosedit)).perform(ViewActions.typeText(apellidos));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.btnCambiar)).perform(click());
        onView(withId(R.id.activityeditusu)).check(matches(isDisplayed()));

    }

    @Test
    public void cambiarnombre(){

        ActivityScenario<Editarcuenta> smurfSesion = ActivityScenario.launch(Editarcuenta.class);

        String nombre = "pruebisimaN";
        String apellidos = "";
        onView(withId(R.id.nombreedit)).perform(ViewActions.typeText(nombre));
        onView(withId(R.id.apellidosedit)).perform(ViewActions.typeText(apellidos));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.btnCambiar)).perform(click());

        Instrumentation.ActivityMonitor monitor = new Instrumentation.ActivityMonitor(Pantalla_cliente.class.getName(),null,false);
        Activity sec = monitor.waitForActivityWithTimeout(5000);

        onView(withId(R.id.ACpantallacliente)).check(matches(isDisplayed()));

    }

    @Test
    public void cambiarapellido(){

        ActivityScenario<Editarcuenta> smurfSesion = ActivityScenario.launch(Editarcuenta.class);

        String nombre = "";
        String apellidos = "pruebisimaA";
        onView(withId(R.id.nombreedit)).perform(ViewActions.typeText(nombre));
        onView(withId(R.id.apellidosedit)).perform(ViewActions.typeText(apellidos));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.btnCambiar)).perform(click());

        Instrumentation.ActivityMonitor monitor = new Instrumentation.ActivityMonitor(Pantalla_cliente.class.getName(),null,false);
        Activity sec = monitor.waitForActivityWithTimeout(5000);

        onView(withId(R.id.ACpantallacliente)).check(matches(isDisplayed()));

    }

    @Test
    public void Volver_a_PantallaCliente(){

        ActivityScenario<Editarcuenta> smurfSesion = ActivityScenario.launch(Editarcuenta.class);

        onView(withId(R.id.btnpatras)).perform(click());

        Instrumentation.ActivityMonitor monitor = new Instrumentation.ActivityMonitor(Pantalla_cliente.class.getName(),null,false);
        Activity sec = monitor.waitForActivityWithTimeout(5000);

        onView(withId(R.id.ACpantallacliente)).check(matches(isDisplayed()));

    }



}