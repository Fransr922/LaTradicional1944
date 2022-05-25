package com.example.myapplication;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import android.app.Activity;
import android.app.Instrumentation;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4ClassRunner.class)
public class registrarTest {

    @Test
    public void nombrevacio() {

        ActivityScenario<registrar> smurfSesion = ActivityScenario.launch(registrar.class);

        String nombree ="";
        String apellidoss ="Fernandez Perez";
        String email = "juan@gmail.com";
        String contra1 = "1234567";
        String contra2 = "1234567";
        String telefonoo = "123456789";
        onView(withId(R.id.nombre)).perform(ViewActions.typeText(nombree));
        onView(withId(R.id.apellidos)).perform(ViewActions.typeText(apellidoss));
        onView(withId(R.id.correo)).perform(ViewActions.typeText(email));
        onView(withId(R.id.contrasenia)).perform(ViewActions.typeText(contra1));
        onView(withId(R.id.contrasenia2)).perform(ViewActions.typeText(contra2));
        onView(withId(R.id.telefono)).perform(ViewActions.typeText(telefonoo));
        Espresso.closeSoftKeyboard();

        onView(withId(R.id.btnreg)).perform(click());

        onView(withId(R.id.activityregistrarse)).check(matches(isDisplayed()));

    }

    @Test
    public void apellidosvacio() {

        ActivityScenario<registrar> smurfSesion = ActivityScenario.launch(registrar.class);

        String nombree ="Juan";
        String apellidoss ="";
        String email = "juan@gmail.com";
        String contra1 = "1234567";
        String contra2 = "1234567";
        String telefonoo = "123456789";
        onView(withId(R.id.nombre)).perform(ViewActions.typeText(nombree));
        onView(withId(R.id.apellidos)).perform(ViewActions.typeText(apellidoss));
        onView(withId(R.id.correo)).perform(ViewActions.typeText(email));
        onView(withId(R.id.contrasenia)).perform(ViewActions.typeText(contra1));
        onView(withId(R.id.contrasenia2)).perform(ViewActions.typeText(contra2));
        onView(withId(R.id.telefono)).perform(ViewActions.typeText(telefonoo));
        Espresso.closeSoftKeyboard();

        onView(withId(R.id.btnreg)).perform(click());

        onView(withId(R.id.activityregistrarse)).check(matches(isDisplayed()));

    }

    @Test
    public void emailvacio() {

        ActivityScenario<registrar> smurfSesion = ActivityScenario.launch(registrar.class);

        String nombree ="Juan";
        String apellidoss ="Fernandez Perez";
        String email = "";
        String contra1 = "1234567";
        String contra2 = "1234567";
        String telefonoo = "123456789";
        onView(withId(R.id.nombre)).perform(ViewActions.typeText(nombree));
        onView(withId(R.id.apellidos)).perform(ViewActions.typeText(apellidoss));
        onView(withId(R.id.correo)).perform(ViewActions.typeText(email));
        onView(withId(R.id.contrasenia)).perform(ViewActions.typeText(contra1));
        onView(withId(R.id.contrasenia2)).perform(ViewActions.typeText(contra2));
        onView(withId(R.id.telefono)).perform(ViewActions.typeText(telefonoo));
        Espresso.closeSoftKeyboard();

        onView(withId(R.id.btnreg)).perform(click());

        onView(withId(R.id.activityregistrarse)).check(matches(isDisplayed()));

    }

    @Test
    public void contraseniavacio() {

        ActivityScenario<registrar> smurfSesion = ActivityScenario.launch(registrar.class);

        String nombree ="Juan";
        String apellidoss ="Fernandez Perez";
        String email = "juan@gmail.com";
        String contra1 = "";
        String contra2 = "1234567";
        String telefonoo = "123456789";
        onView(withId(R.id.nombre)).perform(ViewActions.typeText(nombree));
        onView(withId(R.id.apellidos)).perform(ViewActions.typeText(apellidoss));
        onView(withId(R.id.correo)).perform(ViewActions.typeText(email));
        onView(withId(R.id.contrasenia)).perform(ViewActions.typeText(contra1));
        onView(withId(R.id.contrasenia2)).perform(ViewActions.typeText(contra2));
        onView(withId(R.id.telefono)).perform(ViewActions.typeText(telefonoo));
        Espresso.closeSoftKeyboard();

        onView(withId(R.id.btnreg)).perform(click());

        onView(withId(R.id.activityregistrarse)).check(matches(isDisplayed()));

    }

    @Test
    public void contraseniaverificacionvacio() {

        ActivityScenario<registrar> smurfSesion = ActivityScenario.launch(registrar.class);

        String nombree ="Juan";
        String apellidoss ="Fernandez Perez";
        String email = "juan@gmail.com";
        String contra1 = "1234567";
        String contra2 = "";
        String telefonoo = "123456789";
        onView(withId(R.id.nombre)).perform(ViewActions.typeText(nombree));
        onView(withId(R.id.apellidos)).perform(ViewActions.typeText(apellidoss));
        onView(withId(R.id.correo)).perform(ViewActions.typeText(email));
        onView(withId(R.id.contrasenia)).perform(ViewActions.typeText(contra1));
        onView(withId(R.id.contrasenia2)).perform(ViewActions.typeText(contra2));
        onView(withId(R.id.telefono)).perform(ViewActions.typeText(telefonoo));
        Espresso.closeSoftKeyboard();

        onView(withId(R.id.btnreg)).perform(click());

        onView(withId(R.id.activityregistrarse)).check(matches(isDisplayed()));

    }

    @Test
    public void telefononvacio() {

        ActivityScenario<registrar> smurfSesion = ActivityScenario.launch(registrar.class);

        String nombree ="Juan";
        String apellidoss ="Fernandez Perez";
        String email = "juan@gmail.com";
        String contra1 = "1234567";
        String contra2 = "1234567";
        String telefonoo = "";
        onView(withId(R.id.nombre)).perform(ViewActions.typeText(nombree));
        onView(withId(R.id.apellidos)).perform(ViewActions.typeText(apellidoss));
        onView(withId(R.id.correo)).perform(ViewActions.typeText(email));
        onView(withId(R.id.contrasenia)).perform(ViewActions.typeText(contra1));
        onView(withId(R.id.contrasenia2)).perform(ViewActions.typeText(contra2));
        onView(withId(R.id.telefono)).perform(ViewActions.typeText(telefonoo));
        Espresso.closeSoftKeyboard();

        onView(withId(R.id.btnreg)).perform(click());

        onView(withId(R.id.activityregistrarse)).check(matches(isDisplayed()));

    }

    @Test
    public void emailnovalido() {

        ActivityScenario<registrar> smurfSesion = ActivityScenario.launch(registrar.class);

        String nombree ="Juan";
        String apellidoss ="Fernandez Perez";
        String email = "juangmail.com";
        String contra1 = "1234567";
        String contra2 = "1234567";
        String telefonoo = "123456789";
        onView(withId(R.id.nombre)).perform(ViewActions.typeText(nombree));
        onView(withId(R.id.apellidos)).perform(ViewActions.typeText(apellidoss));
        onView(withId(R.id.correo)).perform(ViewActions.typeText(email));
        onView(withId(R.id.contrasenia)).perform(ViewActions.typeText(contra1));
        onView(withId(R.id.contrasenia2)).perform(ViewActions.typeText(contra2));
        onView(withId(R.id.telefono)).perform(ViewActions.typeText(telefonoo));
        Espresso.closeSoftKeyboard();

        onView(withId(R.id.btnreg)).perform(click());

        onView(withId(R.id.activityregistrarse)).check(matches(isDisplayed()));

    }

    @Test
    public void telefononovalido() {

        ActivityScenario<registrar> smurfSesion = ActivityScenario.launch(registrar.class);

        String nombree ="Juan";
        String apellidoss ="Fernandez Perez";
        String email = "juan@gmail.com";
        String contra1 = "1234567";
        String contra2 = "1234567";
        String telefonoo = "12345678966";
        onView(withId(R.id.nombre)).perform(ViewActions.typeText(nombree));
        onView(withId(R.id.apellidos)).perform(ViewActions.typeText(apellidoss));
        onView(withId(R.id.correo)).perform(ViewActions.typeText(email));
        onView(withId(R.id.contrasenia)).perform(ViewActions.typeText(contra1));
        onView(withId(R.id.contrasenia2)).perform(ViewActions.typeText(contra2));
        onView(withId(R.id.telefono)).perform(ViewActions.typeText(telefonoo));
        Espresso.closeSoftKeyboard();

        onView(withId(R.id.btnreg)).perform(click());

        onView(withId(R.id.activityregistrarse)).check(matches(isDisplayed()));

    }

    @Test
    public void contrasenianovalida() {

        ActivityScenario<registrar> smurfSesion = ActivityScenario.launch(registrar.class);

        String nombree ="Juan";
        String apellidoss ="Fernandez Perez";
        String email = "juan@gmail.com";
        String contra1 = "1234";
        String contra2 = "1234";
        String telefonoo = "123456789";
        onView(withId(R.id.nombre)).perform(ViewActions.typeText(nombree));
        onView(withId(R.id.apellidos)).perform(ViewActions.typeText(apellidoss));
        onView(withId(R.id.correo)).perform(ViewActions.typeText(email));
        onView(withId(R.id.contrasenia)).perform(ViewActions.typeText(contra1));
        onView(withId(R.id.contrasenia2)).perform(ViewActions.typeText(contra2));
        onView(withId(R.id.telefono)).perform(ViewActions.typeText(telefonoo));
        Espresso.closeSoftKeyboard();

        onView(withId(R.id.btnreg)).perform(click());

        onView(withId(R.id.activityregistrarse)).check(matches(isDisplayed()));

    }

    @Test
    public void constraseniasdiferentes() {

        ActivityScenario<registrar> smurfSesion = ActivityScenario.launch(registrar.class);

        String nombree ="Juan";
        String apellidoss ="Fernandez Perez";
        String email = "juan@gmail.com";
        String contra1 = "1234567";
        String contra2 = "1234333";
        String telefonoo = "123456789";
        onView(withId(R.id.nombre)).perform(ViewActions.typeText(nombree));
        onView(withId(R.id.apellidos)).perform(ViewActions.typeText(apellidoss));
        onView(withId(R.id.correo)).perform(ViewActions.typeText(email));
        onView(withId(R.id.contrasenia)).perform(ViewActions.typeText(contra1));
        onView(withId(R.id.contrasenia2)).perform(ViewActions.typeText(contra2));
        onView(withId(R.id.telefono)).perform(ViewActions.typeText(telefonoo));
        Espresso.closeSoftKeyboard();

        onView(withId(R.id.btnreg)).perform(click());

        onView(withId(R.id.activityregistrarse)).check(matches(isDisplayed()));

    }

    @Test
    public void RegistrarOK() {

        ActivityScenario<registrar> smurfSesion = ActivityScenario.launch(registrar.class);

        String nombree ="Juan";
        String apellidoss ="Fernandez Perez";
        String email = "juan@gmail.com";
        String contra1 = "1234567";
        String contra2 = "1234567";
        String telefonoo = "123456789";
        onView(withId(R.id.nombre)).perform(ViewActions.typeText(nombree));
        onView(withId(R.id.apellidos)).perform(ViewActions.typeText(apellidoss));
        onView(withId(R.id.correo)).perform(ViewActions.typeText(email));
        onView(withId(R.id.contrasenia)).perform(ViewActions.typeText(contra1));
        onView(withId(R.id.contrasenia2)).perform(ViewActions.typeText(contra2));
        onView(withId(R.id.telefono)).perform(ViewActions.typeText(telefonoo));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.btnreg)).perform(click());

        Instrumentation.ActivityMonitor monitor = new Instrumentation.ActivityMonitor(iniciarsesion.class.getName(),null,false);
        Activity sec = monitor.waitForActivityWithTimeout(5000);

        onView(withId(R.id.foto)).check(matches(isDisplayed()));

    }


    @Test
    public void usuarioexistente() {

        ActivityScenario<registrar> smurfSesion = ActivityScenario.launch(registrar.class);

        String nombree ="Juan";
        String apellidoss ="Fernandez Perez";
        String email = "juan@gmail.com";
        String contra1 = "1234567";
        String contra2 = "1234567";
        String telefonoo = "123456789";
        onView(withId(R.id.nombre)).perform(ViewActions.typeText(nombree));
        onView(withId(R.id.apellidos)).perform(ViewActions.typeText(apellidoss));
        onView(withId(R.id.correo)).perform(ViewActions.typeText(email));
        onView(withId(R.id.contrasenia)).perform(ViewActions.typeText(contra1));
        onView(withId(R.id.contrasenia2)).perform(ViewActions.typeText(contra2));
        onView(withId(R.id.telefono)).perform(ViewActions.typeText(telefonoo));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.btnreg)).perform(click());
        onView(withId(R.id.activityregistrarse)).check(matches(isDisplayed()));

    }

    @Test
    public void Ir_a_Iniciarsesion() {

        ActivityScenario<registrar> smurfSesion = ActivityScenario.launch(registrar.class);

        onView(withId(R.id.btninic)).perform(click());

        Instrumentation.ActivityMonitor monitor = new Instrumentation.ActivityMonitor(iniciarsesion.class.getName(),null,false);
        Activity sec = monitor.waitForActivityWithTimeout(5000);

        onView(withId(R.id.foto)).check(matches(isDisplayed()));

    }



}