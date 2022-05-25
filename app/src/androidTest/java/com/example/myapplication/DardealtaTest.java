package com.example.myapplication;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
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
public class DardealtaTest {

    @Test
    public void nombrevacio() {

        ActivityScenario<Dardealta> smurfSesion = ActivityScenario.launch(Dardealta.class);

        String nombree ="";
        String apellidoss ="Garcia Lopez";
        String email = "pepe@gmail.com";
        String contra = "1234567";
        String telefonoo = "123456789";
        String rol = "1";
        onView(withId(R.id.altaNombre)).perform(ViewActions.typeText(nombree));
        onView(withId(R.id.altaApellido)).perform(ViewActions.typeText(apellidoss));
        onView(withId(R.id.altaCorreo)).perform(ViewActions.typeText(email));
        onView(withId(R.id.altaContrasenia)).perform(ViewActions.typeText(contra));
        onView(withId(R.id.altaTelefono)).perform(ViewActions.typeText(telefonoo));
        onView(withId(R.id.altaRol)).perform(ViewActions.typeText(rol));
        Espresso.closeSoftKeyboard();

        onView(withId(R.id.btnAgregar)).perform(click());

        onView(withId(R.id.ACDDAlta)).check(matches(isDisplayed()));

    }
    @Test
    public void apellidosvacio() {

        ActivityScenario<Dardealta> smurfSesion = ActivityScenario.launch(Dardealta.class);

        String nombree ="Pepe";
        String apellidoss ="";
        String email = "pepe@gmail.com";
        String contra = "1234567";
        String telefonoo = "123456789";
        String rol = "1";
        onView(withId(R.id.altaNombre)).perform(ViewActions.typeText(nombree));
        onView(withId(R.id.altaApellido)).perform(ViewActions.typeText(apellidoss));
        onView(withId(R.id.altaCorreo)).perform(ViewActions.typeText(email));
        onView(withId(R.id.altaContrasenia)).perform(ViewActions.typeText(contra));
        onView(withId(R.id.altaTelefono)).perform(ViewActions.typeText(telefonoo));
        onView(withId(R.id.altaRol)).perform(ViewActions.typeText(rol));
        Espresso.closeSoftKeyboard();

        onView(withId(R.id.btnAgregar)).perform(click());

        onView(withId(R.id.ACDDAlta)).check(matches(isDisplayed()));

    }

    @Test
    public void correovacio() {

        ActivityScenario<Dardealta> smurfSesion = ActivityScenario.launch(Dardealta.class);

        String nombree ="Pepe";
        String apellidoss ="Garcia Lopez";
        String email = "";
        String contra = "1234567";
        String telefonoo = "123456789";
        String rol = "1";
        onView(withId(R.id.altaNombre)).perform(ViewActions.typeText(nombree));
        onView(withId(R.id.altaApellido)).perform(ViewActions.typeText(apellidoss));
        onView(withId(R.id.altaCorreo)).perform(ViewActions.typeText(email));
        onView(withId(R.id.altaContrasenia)).perform(ViewActions.typeText(contra));
        onView(withId(R.id.altaTelefono)).perform(ViewActions.typeText(telefonoo));
        onView(withId(R.id.altaRol)).perform(ViewActions.typeText(rol));
        Espresso.closeSoftKeyboard();

        onView(withId(R.id.btnAgregar)).perform(click());

        onView(withId(R.id.ACDDAlta)).check(matches(isDisplayed()));

    }

    @Test
    public void contraseniavacia() {

        ActivityScenario<Dardealta> smurfSesion = ActivityScenario.launch(Dardealta.class);

        String nombree ="Pepe";
        String apellidoss ="Garcia Lopez";
        String email = "pepe@gmail.com";
        String contra = "";
        String telefonoo = "123456789";
        String rol = "1";
        onView(withId(R.id.altaNombre)).perform(ViewActions.typeText(nombree));
        onView(withId(R.id.altaApellido)).perform(ViewActions.typeText(apellidoss));
        onView(withId(R.id.altaCorreo)).perform(ViewActions.typeText(email));
        onView(withId(R.id.altaContrasenia)).perform(ViewActions.typeText(contra));
        onView(withId(R.id.altaTelefono)).perform(ViewActions.typeText(telefonoo));
        onView(withId(R.id.altaRol)).perform(ViewActions.typeText(rol));
        Espresso.closeSoftKeyboard();

        onView(withId(R.id.btnAgregar)).perform(click());

        onView(withId(R.id.ACDDAlta)).check(matches(isDisplayed()));

    }

    @Test
    public void telefonovacio() {

        ActivityScenario<Dardealta> smurfSesion = ActivityScenario.launch(Dardealta.class);

        String nombree ="Pepe";
        String apellidoss ="Garcia Lopez";
        String email = "pepe@gmail.com";
        String contra = "1234567";
        String telefonoo = "";
        String rol = "1";
        onView(withId(R.id.altaNombre)).perform(ViewActions.typeText(nombree));
        onView(withId(R.id.altaApellido)).perform(ViewActions.typeText(apellidoss));
        onView(withId(R.id.altaCorreo)).perform(ViewActions.typeText(email));
        onView(withId(R.id.altaContrasenia)).perform(ViewActions.typeText(contra));
        onView(withId(R.id.altaTelefono)).perform(ViewActions.typeText(telefonoo));
        onView(withId(R.id.altaRol)).perform(ViewActions.typeText(rol));
        Espresso.closeSoftKeyboard();

        onView(withId(R.id.btnAgregar)).perform(click());

        onView(withId(R.id.ACDDAlta)).check(matches(isDisplayed()));

    }

    @Test
    public void rolvacio() {

        ActivityScenario<Dardealta> smurfSesion = ActivityScenario.launch(Dardealta.class);

        String nombree ="Pepe";
        String apellidoss ="Garcia Lopez";
        String email = "pepe@gmail.com";
        String contra = "1234567";
        String telefonoo = "123456789";
        String rol = "";
        onView(withId(R.id.altaNombre)).perform(ViewActions.typeText(nombree));
        onView(withId(R.id.altaApellido)).perform(ViewActions.typeText(apellidoss));
        onView(withId(R.id.altaCorreo)).perform(ViewActions.typeText(email));
        onView(withId(R.id.altaContrasenia)).perform(ViewActions.typeText(contra));
        onView(withId(R.id.altaTelefono)).perform(ViewActions.typeText(telefonoo));
        onView(withId(R.id.altaRol)).perform(ViewActions.typeText(rol));
        Espresso.closeSoftKeyboard();

        onView(withId(R.id.btnAgregar)).perform(click());

        onView(withId(R.id.ACDDAlta)).check(matches(isDisplayed()));

    }

    @Test
    public void DarDeAltaOK() {

        ActivityScenario<Dardealta> smurfSesion = ActivityScenario.launch(Dardealta.class);

        String nombree ="Pepe";
        String apellidoss ="Garcia Lopez";
        String email = "pepe@gmail.com";
        String contra = "1234567";
        String telefonoo = "123456789";
        String rol = "1";
        onView(withId(R.id.altaNombre)).perform(ViewActions.typeText(nombree));
        onView(withId(R.id.altaApellido)).perform(ViewActions.typeText(apellidoss));
        onView(withId(R.id.altaCorreo)).perform(ViewActions.typeText(email));
        onView(withId(R.id.altaContrasenia)).perform(ViewActions.typeText(contra));
        onView(withId(R.id.altaTelefono)).perform(ViewActions.typeText(telefonoo));
        onView(withId(R.id.altaRol)).perform(ViewActions.typeText(rol));
        Espresso.closeSoftKeyboard();

        onView(withId(R.id.btnAgregar)).perform(click());

        onView(withId(R.id.DDprueb)).check(matches(withText("ok")));

    }

    @Test
    public void DarDeAltabtnAtras() {

        ActivityScenario<Dardealta> smurfSesion = ActivityScenario.launch(Dardealta.class);

        onView(withId(R.id.btnatras)).perform(click());

        Instrumentation.ActivityMonitor monitor = new Instrumentation.ActivityMonitor(Pantalla_admin.class.getName(),null,false);
        Activity sec = monitor.waitForActivityWithTimeout(5000);

        onView(withId(R.id.pantallaadmin)).check(matches(isDisplayed()));

    }

}