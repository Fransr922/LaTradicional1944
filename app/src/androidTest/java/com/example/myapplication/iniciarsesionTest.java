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

//@LargeTest
@RunWith(AndroidJUnit4ClassRunner.class)
public class iniciarsesionTest {

    ///////////////////VER PEDIDOS A PREPAR - A domicilio////////////////////
    /*@Test
    public void VisualizarPedidosaaPreparaaDomicilioOK() throws InterruptedException {

        //Se inicia sesion como Cocinero
        String correo = "ruben@gmail.com";
        String contra = "1234567";
        ActivityScenario<iniciarsesion> smurfSesion = ActivityScenario.launch(iniciarsesion.class);
        onView(withId(R.id.txtCorreo)).perform(ViewActions.typeText(correo));
        onView(withId(R.id.txtcontrasenia)).perform(ViewActions.typeText(contra));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.boton_iniciar_sesion)).perform(click());

        //Se entra en Pantalla Cocinero y se va a ver comida a domicilio
        Instrumentation.ActivityMonitor monitor1 = new Instrumentation.ActivityMonitor(Pantalla_cocinero.class.getName(), null, false);
        Activity sec1 = monitor1.waitForActivityWithTimeout(2000);
        onView(withId(R.id.btnvercomidaaprepararcam)).perform(click());

        //Dentro de ver comida a domicilio, se ven
        Instrumentation.ActivityMonitor monitor3 = new Instrumentation.ActivityMonitor(Visualizarpedidoapreparar.class.getName(), null, false);
        Activity sec3 = monitor3.waitForActivityWithTimeout(2000);
        onView(withId(R.id.AcVerpedAdomiCoci)).check(matches(isDisplayed()));
    }

    ///////////////////VER PEDIDOS A PREPAR - A mesa////////////////////
    @Test
    public void VisualizarPedidosaaPreparaaMesaOK() throws InterruptedException {

        //Se inicia sesion como Cocinero
        String correo = "ruben@gmail.com";
        String contra = "1234567";
        ActivityScenario<iniciarsesion> smurfSesion = ActivityScenario.launch(iniciarsesion.class);
        onView(withId(R.id.txtCorreo)).perform(ViewActions.typeText(correo));
        onView(withId(R.id.txtcontrasenia)).perform(ViewActions.typeText(contra));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.boton_iniciar_sesion)).perform(click());

        //Se entra en Pantalla Cocinero y se va a ver comida a mesa
        Instrumentation.ActivityMonitor monitor1 = new Instrumentation.ActivityMonitor(Pantalla_cocinero.class.getName(), null, false);
        Activity sec1 = monitor1.waitForActivityWithTimeout(2000);
        onView(withId(R.id.btnvercomidaaprepararcam2)).perform(click());

        //Dentro de ver comida a mesa, se ven
        Instrumentation.ActivityMonitor monitor3 = new Instrumentation.ActivityMonitor(Visualizarpedidoaprepararmesa.class.getName(), null, false);
        Activity sec3 = monitor3.waitForActivityWithTimeout(2000);
        onView(withId(R.id.AcVisupedAMCoci)).check(matches(isDisplayed()));
    }*/

    ///////////////////VER PEDIDOS A ENTREGAR////////////////////
    /*@Test
    public void VisualizarPedidosaaEntregarOK() throws InterruptedException {

        //Se inicia sesion como Trasportista
        String correo = "miri@gmail.com";
        String contra = "1234567";
        ActivityScenario<iniciarsesion> smurfSesion = ActivityScenario.launch(iniciarsesion.class);
        onView(withId(R.id.txtCorreo)).perform(ViewActions.typeText(correo));
        onView(withId(R.id.txtcontrasenia)).perform(ViewActions.typeText(contra));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.boton_iniciar_sesion)).perform(click());

        //Se entra en Pantalla Trasportista y se ven
        Instrumentation.ActivityMonitor monitor1 = new Instrumentation.ActivityMonitor(Pantalla_trasportista.class.getName(), null, false);
        Activity sec1 = monitor1.waitForActivityWithTimeout(2000);
        onView(withId(R.id.AcTransVerPedEntreg)).check(matches(isDisplayed()));
    }

    ///////////////////VER PEDIDOS a mesa (Admin)////////////////////
    @Test
    public void VisualizarPedidosaMesaAdminOK() throws InterruptedException {

        //Se inicia sesion como Admin
        String correo = "fransr922@gmail.com";
        String contra = "1234567";
        ActivityScenario<iniciarsesion> smurfSesion = ActivityScenario.launch(iniciarsesion.class);
        onView(withId(R.id.txtCorreo)).perform(ViewActions.typeText(correo));
        onView(withId(R.id.txtcontrasenia)).perform(ViewActions.typeText(contra));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.boton_iniciar_sesion)).perform(click());

        //Se entra en Pantalla Admin y se va ver Pedidos
        Instrumentation.ActivityMonitor monitor1 = new Instrumentation.ActivityMonitor(Pantalla_admin.class.getName(), null, false);
        Activity sec1 = monitor1.waitForActivityWithTimeout(2000);
        onView(withId(R.id.btnverpedad)).perform(click());

        //Dentro de ver Pedidos, se ven
        Instrumentation.ActivityMonitor monitor2 = new Instrumentation.ActivityMonitor(VisualizarpedidosAdmin.class.getName(), null, false);
        Activity sec2 = monitor2.waitForActivityWithTimeout(2000);
        onView(withId(R.id.btnverrPedad)).perform(click());
        onView(withId(R.id.ACVerpedM)).check(matches(isDisplayed()));
    }

    ///////////////////VER PEDIDOS a mesa (Camarero)////////////////////
    @Test
    public void VisualizarPedidosaMesaCamareroOK() throws InterruptedException {

        //Se inicia sesion como Camarero
        String correo = "pablo@gmail.com";
        String contra = "1234567";
        ActivityScenario<iniciarsesion> smurfSesion = ActivityScenario.launch(iniciarsesion.class);
        onView(withId(R.id.txtCorreo)).perform(ViewActions.typeText(correo));
        onView(withId(R.id.txtcontrasenia)).perform(ViewActions.typeText(contra));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.boton_iniciar_sesion)).perform(click());

        //Se entra en Pantalla Camarero y se va ver Pedidos
        Instrumentation.ActivityMonitor monitor1 = new Instrumentation.ActivityMonitor(Pantalla_camarero.class.getName(), null, false);
        Activity sec1 = monitor1.waitForActivityWithTimeout(2000);
        onView(withId(R.id.btnverpeds)).perform(click());

        //Dentro de ver Pedidos, se ven
        Instrumentation.ActivityMonitor monitor2 = new Instrumentation.ActivityMonitor(Visualizarpedidos.class.getName(), null, false);
        Activity sec2 = monitor2.waitForActivityWithTimeout(2000);
        onView(withId(R.id.btnverrPed)).perform(click());
        onView(withId(R.id.AcverpedidosM)).check(matches(isDisplayed()));
    }*/

    ///////////////////TOMAR NOTA////////////////////
    /*@Test
    public void TomarNotalistacomidavacia() throws InterruptedException {

        //Se inicia sesion como Camarero
        String correo = "pablo@gmail.com";
        String contra = "1234567";
        ActivityScenario<iniciarsesion> smurfSesion = ActivityScenario.launch(iniciarsesion.class);
        onView(withId(R.id.txtCorreo)).perform(ViewActions.typeText(correo));
        onView(withId(R.id.txtcontrasenia)).perform(ViewActions.typeText(contra));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.boton_iniciar_sesion)).perform(click());

        //Se entra en Pantalla Camarero y se va a Tomar nota
        Instrumentation.ActivityMonitor monitor1 = new Instrumentation.ActivityMonitor(Pantalla_camarero.class.getName(), null, false);
        Activity sec1 = monitor1.waitForActivityWithTimeout(2000);
        onView(withId(R.id.btntomarnota)).perform(click());

        //Dentro de Tomar nota, no se selecciona la comida y la mesa y se toma nota
        Instrumentation.ActivityMonitor monitor2 = new Instrumentation.ActivityMonitor(Tomarnota.class.getName(), null, false);
        Activity sec2 = monitor2.waitForActivityWithTimeout(2000);
        onView(withId(R.id.btnpediramesa3)).perform(click());
        onView(withId(R.id.acTomarnota)).check(matches(isDisplayed()));
    }

    @Test
    public void TomarNotaOK() throws InterruptedException {

        //Se inicia sesion como Camarero
        String correo = "pablo@gmail.com";
        String contra = "1234567";
        ActivityScenario<iniciarsesion> smurfSesion = ActivityScenario.launch(iniciarsesion.class);
        onView(withId(R.id.txtCorreo)).perform(ViewActions.typeText(correo));
        onView(withId(R.id.txtcontrasenia)).perform(ViewActions.typeText(contra));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.boton_iniciar_sesion)).perform(click());

        //Se entra en Pantalla Camarero y se va a Tomar nota
        Instrumentation.ActivityMonitor monitor1 = new Instrumentation.ActivityMonitor(Pantalla_camarero.class.getName(), null, false);
        Activity sec1 = monitor1.waitForActivityWithTimeout(2000);
        onView(withId(R.id.btntomarnota)).perform(click());

        //Dentro de Tomar nota, se selecciona la comida y la mesa y se toma nota
        Instrumentation.ActivityMonitor monitor2 = new Instrumentation.ActivityMonitor(Tomarnota.class.getName(), null, false);
        Activity sec2 = monitor2.waitForActivityWithTimeout(2000);
        onView(withId(R.id.comp123)).perform(click());
        onView(withId(R.id.comp323)).perform(click());
        onView(withId(R.id.btnpediramesa3)).perform(click());

        //Nos envia a Pantalla Camarero
        Instrumentation.ActivityMonitor monitor3 = new Instrumentation.ActivityMonitor(Pantalla_camarero.class.getName(), null, false);
        Activity sec3 = monitor3.waitForActivityWithTimeout(2000);
        onView(withId(R.id.ActCamarero)).check(matches(isDisplayed()));
    }*/

    ///////////////////HACER PEDIDOS////////////////////
    /*@Test
    public void HacerPedidoaDomicilioOK() throws InterruptedException {

        //Se inicia sesion como Cliente
        String correo = "strayborx@gmail.com";
        String contra = "1234567";
        ActivityScenario<iniciarsesion> smurfSesion = ActivityScenario.launch(iniciarsesion.class);
        onView(withId(R.id.txtCorreo)).perform(ViewActions.typeText(correo));
        onView(withId(R.id.txtcontrasenia)).perform(ViewActions.typeText(contra));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.boton_iniciar_sesion)).perform(click());

        //Se entra en Pantalla Cliente y se va a Hacer pedido a domicilio
        Instrumentation.ActivityMonitor monitor1 = new Instrumentation.ActivityMonitor(Pantalla_cliente.class.getName(), null, false);
        Activity sec1 = monitor1.waitForActivityWithTimeout(2000);
        onView(withId(R.id.btnpedadom)).perform(click());

        //Dentro de Hacer pedido a domicilio, se selecciona la comida y la ubicacion y se hace el pedido
        Instrumentation.ActivityMonitor monitor2 = new Instrumentation.ActivityMonitor(HacerPedidoMesa.class.getName(), null, false);
        Activity sec2 = monitor2.waitForActivityWithTimeout(2000);
        onView(withId(R.id.comp1)).perform(click());
        onView(withId(R.id.comp3)).perform(click());
        onView(withId(R.id.comp4)).perform(click());
        //se introduce la ubicacion
        Thread.sleep(5000);
        onView(withId(R.id.btntramitar)).perform(click());

        //Nos envia a Pantalla cliente
        Instrumentation.ActivityMonitor monitor3 = new Instrumentation.ActivityMonitor(Pantalla_cliente.class.getName(), null, false);
        Activity sec3 = monitor3.waitForActivityWithTimeout(2000);
        onView(withId(R.id.ACpantallacliente)).check(matches(isDisplayed()));
    }

    @Test
    public void HacerPedidoaDomicilioubicacionvacia() throws InterruptedException {

        //Se inicia sesion como Cliente
        String correo = "strayborx@gmail.com";
        String contra = "1234567";
        ActivityScenario<iniciarsesion> smurfSesion = ActivityScenario.launch(iniciarsesion.class);
        onView(withId(R.id.txtCorreo)).perform(ViewActions.typeText(correo));
        onView(withId(R.id.txtcontrasenia)).perform(ViewActions.typeText(contra));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.boton_iniciar_sesion)).perform(click());

        //Se entra en Pantalla Cliente y se va a Hacer pedido a domicilio
        Instrumentation.ActivityMonitor monitor1 = new Instrumentation.ActivityMonitor(Pantalla_cliente.class.getName(), null, false);
        Activity sec1 = monitor1.waitForActivityWithTimeout(2000);
        onView(withId(R.id.btnpedadom)).perform(click());

        //Dentro de Hacer pedido a domicilio, se selecciona la comida pero no la ubicacion y se hace el pedido
        Instrumentation.ActivityMonitor monitor2 = new Instrumentation.ActivityMonitor(HacerPedidoMesa.class.getName(), null, false);
        Activity sec2 = monitor2.waitForActivityWithTimeout(2000);
        onView(withId(R.id.comp1)).perform(click());
        onView(withId(R.id.comp3)).perform(click());
        onView(withId(R.id.comp4)).perform(click());
        onView(withId(R.id.btntramitar)).perform(click());

        onView(withId(R.id.AcTADomi)).check(matches(isDisplayed()));
    }

    @Test
    public void HacerPedidoaDomiciliolistacomidavacia() throws InterruptedException {

        //Se inicia sesion como Cliente
        String correo = "strayborx@gmail.com";
        String contra = "1234567";
        ActivityScenario<iniciarsesion> smurfSesion = ActivityScenario.launch(iniciarsesion.class);
        onView(withId(R.id.txtCorreo)).perform(ViewActions.typeText(correo));
        onView(withId(R.id.txtcontrasenia)).perform(ViewActions.typeText(contra));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.boton_iniciar_sesion)).perform(click());

        //Se entra en Pantalla Cliente y se va a Hacer pedido a domicilio
        Instrumentation.ActivityMonitor monitor1 = new Instrumentation.ActivityMonitor(Pantalla_cliente.class.getName(), null, false);
        Activity sec1 = monitor1.waitForActivityWithTimeout(2000);
        onView(withId(R.id.btnpedadom)).perform(click());

        //Dentro de Hacer pedido a domicilio, no se selecciona la comida y se hace el pedido
        Instrumentation.ActivityMonitor monitor2 = new Instrumentation.ActivityMonitor(HacerPedidoMesa.class.getName(), null, false);
        Activity sec2 = monitor2.waitForActivityWithTimeout(2000);
        //se introduce la ubicacion
        Thread.sleep(5000);
        onView(withId(R.id.btntramitar)).perform(click());

        onView(withId(R.id.AcTADomi)).check(matches(isDisplayed()));
    }

    @Test
    public void HacerPedidoaMesaOK() {

        //Se inicia sesion como Cliente
        String correo = "strayborx@gmail.com";
        String contra = "1234567";
        ActivityScenario<iniciarsesion> smurfSesion = ActivityScenario.launch(iniciarsesion.class);
        onView(withId(R.id.txtCorreo)).perform(ViewActions.typeText(correo));
        onView(withId(R.id.txtcontrasenia)).perform(ViewActions.typeText(contra));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.boton_iniciar_sesion)).perform(click());

        //Se entra en Pantalla Cliente y se va a Hacer pedido a mesa
        Instrumentation.ActivityMonitor monitor1 = new Instrumentation.ActivityMonitor(Pantalla_cliente.class.getName(), null, false);
        Activity sec1 = monitor1.waitForActivityWithTimeout(2000);
        onView(withId(R.id.btnpedmes)).perform(click());

        //Dentro de Hacer pedido a mesa, se selecciona la comida y se hace el pedido
        Instrumentation.ActivityMonitor monitor2 = new Instrumentation.ActivityMonitor(HacerPedidoMesa.class.getName(), null, false);
        Activity sec2 = monitor2.waitForActivityWithTimeout(2000);
        onView(withId(R.id.comp12)).perform(click());
        onView(withId(R.id.comp32)).perform(click());
        onView(withId(R.id.comp42)).perform(click());
        onView(withId(R.id.btnpediramesa)).perform(click());

        //Nos envia a Pantalla cliente
        Instrumentation.ActivityMonitor monitor3 = new Instrumentation.ActivityMonitor(Pantalla_cliente.class.getName(), null, false);
        Activity sec3 = monitor3.waitForActivityWithTimeout(2000);
        onView(withId(R.id.ACpantallacliente)).check(matches(isDisplayed()));
    }

    @Test
    public void HacerPedidoaMesalistacomidavacia() {

        //Se inicia sesion como Cliente
        String correo = "strayborx@gmail.com";
        String contra = "1234567";
        ActivityScenario<iniciarsesion> smurfSesion = ActivityScenario.launch(iniciarsesion.class);
        onView(withId(R.id.txtCorreo)).perform(ViewActions.typeText(correo));
        onView(withId(R.id.txtcontrasenia)).perform(ViewActions.typeText(contra));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.boton_iniciar_sesion)).perform(click());

        //Se entra en Pantalla Cliente y se va a Hacer pedido a mesa
        Instrumentation.ActivityMonitor monitor1 = new Instrumentation.ActivityMonitor(Pantalla_cliente.class.getName(), null, false);
        Activity sec1 = monitor1.waitForActivityWithTimeout(2000);
        onView(withId(R.id.btnpedmes)).perform(click());

        //Dentro de Hacer pedido a mesa, no se selecciona la comida y se hace el pedido
        Instrumentation.ActivityMonitor monitor2 = new Instrumentation.ActivityMonitor(HacerPedidoMesa.class.getName(), null, false);
        Activity sec2 = monitor2.waitForActivityWithTimeout(2000);
        onView(withId(R.id.btnpediramesa)).perform(click());

        onView(withId(R.id.AcTPmesa)).check(matches(isDisplayed()));
    }*/


    ///////////////////VISUALIZAR COMIDA RESERVADA////////////////////
    /*@Test
    public void VerComidareservadaOK() {

        //Se inicia sesion como Cocinero
        String correo = "ruben@gmail.com";
        String contra = "1234567";
        ActivityScenario<iniciarsesion> smurfSesion = ActivityScenario.launch(iniciarsesion.class);
        onView(withId(R.id.txtCorreo)).perform(ViewActions.typeText(correo));
        onView(withId(R.id.txtcontrasenia)).perform(ViewActions.typeText(contra));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.boton_iniciar_sesion)).perform(click());

        //Se entra en Pantalla Cocinero y se va ver comida reservada
        Instrumentation.ActivityMonitor monitor1 = new Instrumentation.ActivityMonitor(Pantalla_cocinero.class.getName(), null, false);
        Activity sec1 = monitor1.waitForActivityWithTimeout(3000);
        onView(withId(R.id.comidareservCoci)).perform(click());

        //Dentro de ver comida reservada se comprueba que se accede
        Instrumentation.ActivityMonitor monitor2 = new Instrumentation.ActivityMonitor(VerComidaReservada.class.getName(), null, false);
        onView(withId(R.id.acComidaR)).check(matches(isDisplayed()));
    }*/

    ///////////////////VISUALIZAR RESERVA CLIENTE////////////////////
    /*@Test
    public void VerReservasMesaClienteOK() throws InterruptedException {

        //Se inicia sesion como Cliente
        String correo = "strayborx@gmail.com";
        String contra = "1234567";
        ActivityScenario<iniciarsesion> smurfSesion = ActivityScenario.launch(iniciarsesion.class);
        onView(withId(R.id.txtCorreo)).perform(ViewActions.typeText(correo));
        onView(withId(R.id.txtcontrasenia)).perform(ViewActions.typeText(contra));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.boton_iniciar_sesion)).perform(click());

        //Se entra en Pantalla Cliente y se va ver reservas
        Instrumentation.ActivityMonitor monitor1 = new Instrumentation.ActivityMonitor(Pantalla_cliente.class.getName(), null, false);
        Activity sec1 = monitor1.waitForActivityWithTimeout(3000);
        onView(withId(R.id.btnverreservascliente)).perform(click());

        //Dentro de ver reservar se da al boton de ver reservas de tipo reserva mesa
        Instrumentation.ActivityMonitor monitor2 = new Instrumentation.ActivityMonitor(VerReservasCliente.class.getName(), null, false);
        Activity sec2 = monitor2.waitForActivityWithTimeout(3000);
        onView(withId(R.id.btnLoadclient)).perform(click());
        Thread.sleep(3000);
        onView(withId(R.id.RMCprueba)).check(matches(withText("ok")));
    }

    @Test
    public void VerReservasMesayComidaClienteOK() throws InterruptedException {

        //Se inicia sesion como Cliente
        String correo = "strayborx@gmail.com";
        String contra = "1234567";
        ActivityScenario<iniciarsesion> smurfSesion = ActivityScenario.launch(iniciarsesion.class);
        onView(withId(R.id.txtCorreo)).perform(ViewActions.typeText(correo));
        onView(withId(R.id.txtcontrasenia)).perform(ViewActions.typeText(contra));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.boton_iniciar_sesion)).perform(click());

        //Se entra en Pantalla Cliente y se va ver reservas
        Instrumentation.ActivityMonitor monitor1 = new Instrumentation.ActivityMonitor(Pantalla_cliente.class.getName(), null, false);
        Activity sec1 = monitor1.waitForActivityWithTimeout(3000);
        onView(withId(R.id.btnverreservascliente)).perform(click());

        //Dentro de ver reservar se da al boton de ver reservas de tipo reserva mesa
        Instrumentation.ActivityMonitor monitor2 = new Instrumentation.ActivityMonitor(VerReservasCliente.class.getName(), null, false);
        Activity sec2 = monitor2.waitForActivityWithTimeout(3000);
        onView(withId(R.id.btnLoadclient2)).perform(click());
        Thread.sleep(3000);
        onView(withId(R.id.RMCprueba2)).check(matches(withText("ok")));
    }*/

    ///////////////////ANULAR RESERVA////////////////////
    /*@Test
    public void AnularReservaMesaOK() {

        //Se inicia sesion como Cliente
        String correo = "strayborx@gmail.com";
        String contra = "1234567";
        ActivityScenario<iniciarsesion> smurfSesion = ActivityScenario.launch(iniciarsesion.class);
        onView(withId(R.id.txtCorreo)).perform(ViewActions.typeText(correo));
        onView(withId(R.id.txtcontrasenia)).perform(ViewActions.typeText(contra));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.boton_iniciar_sesion)).perform(click());

        //Se entra en Pantalla Cliente y se va a anular reserva
        Instrumentation.ActivityMonitor monitor1 = new Instrumentation.ActivityMonitor(Pantalla_cliente.class.getName(), null, false);
        Activity sec1 = monitor1.waitForActivityWithTimeout(3000);
        onView(withId(R.id.btnanularservaXD)).perform(click());

        //Dentro de anular reserva se introducen los datos y se anula reserva de tipo reserva mesa
        String fecha = "2022-05-23";
        String hora = "15:00";
        Instrumentation.ActivityMonitor monitor2 = new Instrumentation.ActivityMonitor(AnularReserva.class.getName(), null, false);
        Activity sec2 = monitor2.waitForActivityWithTimeout(3000);
        onView(withId(R.id.anularfecha)).perform(ViewActions.typeText(fecha));
        onView(withId(R.id.anularhora)).perform(ViewActions.typeText(hora));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.btnanularreserva)).perform(click());

        //Nos envia a pantalla cliente
        Instrumentation.ActivityMonitor monitor3 = new Instrumentation.ActivityMonitor(Pantalla_cliente.class.getName(), null, false);
        Activity sec3 = monitor3.waitForActivityWithTimeout(3000);
        onView(withId(R.id.ACpantallacliente)).check(matches(isDisplayed()));
    }

    @Test
    public void AnularReservafechavacio() {

        //Se inicia sesion como Cliente
        String correo = "strayborx@gmail.com";
        String contra = "1234567";
        ActivityScenario<iniciarsesion> smurfSesion = ActivityScenario.launch(iniciarsesion.class);
        onView(withId(R.id.txtCorreo)).perform(ViewActions.typeText(correo));
        onView(withId(R.id.txtcontrasenia)).perform(ViewActions.typeText(contra));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.boton_iniciar_sesion)).perform(click());

        //Se entra en Pantalla Cliente y se va a anular reserva
        Instrumentation.ActivityMonitor monitor1 = new Instrumentation.ActivityMonitor(Pantalla_cliente.class.getName(), null, false);
        Activity sec1 = monitor1.waitForActivityWithTimeout(3000);
        onView(withId(R.id.btnanularservaXD)).perform(click());

        //Dentro de anular reserva no se introduce fecha
        String hora = "04:00";
        Instrumentation.ActivityMonitor monitor2 = new Instrumentation.ActivityMonitor(AnularReserva.class.getName(), null, false);
        Activity sec2 = monitor2.waitForActivityWithTimeout(3000);
        onView(withId(R.id.anularhora)).perform(ViewActions.typeText(hora));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.btnanularreserva)).perform(click());
        onView(withId(R.id.activityARMklk)).check(matches(isDisplayed()));
    }

    @Test
    public void AnularReservahoravacio() {

        //Se inicia sesion como Cliente
        String correo = "strayborx@gmail.com";
        String contra = "1234567";
        ActivityScenario<iniciarsesion> smurfSesion = ActivityScenario.launch(iniciarsesion.class);
        onView(withId(R.id.txtCorreo)).perform(ViewActions.typeText(correo));
        onView(withId(R.id.txtcontrasenia)).perform(ViewActions.typeText(contra));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.boton_iniciar_sesion)).perform(click());

        //Se entra en Pantalla Cliente y se va a anular reserva
        Instrumentation.ActivityMonitor monitor1 = new Instrumentation.ActivityMonitor(Pantalla_cliente.class.getName(), null, false);
        Activity sec1 = monitor1.waitForActivityWithTimeout(3000);
        onView(withId(R.id.btnanularservaXD)).perform(click());

        //Dentro de anular reserva no se introduce hora
        String fecha = "2022-05-11";
        Instrumentation.ActivityMonitor monitor2 = new Instrumentation.ActivityMonitor(AnularReserva.class.getName(), null, false);
        Activity sec2 = monitor2.waitForActivityWithTimeout(3000);
        onView(withId(R.id.anularfecha)).perform(ViewActions.typeText(fecha));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.btnanularreserva)).perform(click());
        onView(withId(R.id.activityARMklk)).check(matches(isDisplayed()));
    }

    @Test
    public void AnularReservahoraerronea() {

        //Se inicia sesion como Cliente
        String correo = "strayborx@gmail.com";
        String contra = "1234567";
        ActivityScenario<iniciarsesion> smurfSesion = ActivityScenario.launch(iniciarsesion.class);
        onView(withId(R.id.txtCorreo)).perform(ViewActions.typeText(correo));
        onView(withId(R.id.txtcontrasenia)).perform(ViewActions.typeText(contra));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.boton_iniciar_sesion)).perform(click());

        //Se entra en Pantalla Cliente y se va a anular reserva
        Instrumentation.ActivityMonitor monitor1 = new Instrumentation.ActivityMonitor(Pantalla_cliente.class.getName(), null, false);
        Activity sec1 = monitor1.waitForActivityWithTimeout(3000);
        onView(withId(R.id.btnanularservaXD)).perform(click());

        //Dentro de anular reserva se introduce la hora con mal formato
        String fecha = "2022-05-11";
        String hora = "0400";
        Instrumentation.ActivityMonitor monitor2 = new Instrumentation.ActivityMonitor(AnularReserva.class.getName(), null, false);
        Activity sec2 = monitor2.waitForActivityWithTimeout(3000);
        onView(withId(R.id.anularfecha)).perform(ViewActions.typeText(fecha));
        onView(withId(R.id.anularhora)).perform(ViewActions.typeText(hora));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.btnanularreserva)).perform(click());
        onView(withId(R.id.activityARMklk)).check(matches(isDisplayed()));
    }

    @Test
    public void AnularReservafechaerronea() {

        //Se inicia sesion como Cliente
        String correo = "strayborx@gmail.com";
        String contra = "1234567";
        ActivityScenario<iniciarsesion> smurfSesion = ActivityScenario.launch(iniciarsesion.class);
        onView(withId(R.id.txtCorreo)).perform(ViewActions.typeText(correo));
        onView(withId(R.id.txtcontrasenia)).perform(ViewActions.typeText(contra));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.boton_iniciar_sesion)).perform(click());

        //Se entra en Pantalla Cliente y se va a anular reserva
        Instrumentation.ActivityMonitor monitor1 = new Instrumentation.ActivityMonitor(Pantalla_cliente.class.getName(), null, false);
        Activity sec1 = monitor1.waitForActivityWithTimeout(3000);
        onView(withId(R.id.btnanularservaXD)).perform(click());

        //Dentro de anular reserva se introduce la fecha con mal formato
        String fecha = "20220511";
        String hora = "04:00";
        Instrumentation.ActivityMonitor monitor2 = new Instrumentation.ActivityMonitor(AnularReserva.class.getName(), null, false);
        Activity sec2 = monitor2.waitForActivityWithTimeout(3000);
        onView(withId(R.id.anularfecha)).perform(ViewActions.typeText(fecha));
        onView(withId(R.id.anularhora)).perform(ViewActions.typeText(hora));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.btnanularreserva)).perform(click());
        onView(withId(R.id.activityARMklk)).check(matches(isDisplayed()));
    }

    @Test
    public void AnularReservaMesaInexistente() {

        //Se inicia sesion como Cliente
        String correo = "strayborx@gmail.com";
        String contra = "1234567";
        ActivityScenario<iniciarsesion> smurfSesion = ActivityScenario.launch(iniciarsesion.class);
        onView(withId(R.id.txtCorreo)).perform(ViewActions.typeText(correo));
        onView(withId(R.id.txtcontrasenia)).perform(ViewActions.typeText(contra));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.boton_iniciar_sesion)).perform(click());

        //Se entra en Pantalla Cliente y se va a anular reserva
        Instrumentation.ActivityMonitor monitor1 = new Instrumentation.ActivityMonitor(Pantalla_cliente.class.getName(), null, false);
        Activity sec1 = monitor1.waitForActivityWithTimeout(3000);
        onView(withId(R.id.btnanularservaXD)).perform(click());

        //Dentro de anular reserva se introduce una reserva inexistente
        String fecha = "2022-05-13";
        String hora = "04:00";
        Instrumentation.ActivityMonitor monitor2 = new Instrumentation.ActivityMonitor(AnularReserva.class.getName(), null, false);
        Activity sec2 = monitor2.waitForActivityWithTimeout(3000);
        onView(withId(R.id.anularfecha)).perform(ViewActions.typeText(fecha));
        onView(withId(R.id.anularhora)).perform(ViewActions.typeText(hora));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.btnanularreserva)).perform(click());
        onView(withId(R.id.activityARMklk)).check(matches(isDisplayed()));
    }

    @Test
    public void AnularReservaMesayComidaOK() {

        //Se inicia sesion como Cliente
        String correo = "strayborx@gmail.com";
        String contra = "1234567";
        ActivityScenario<iniciarsesion> smurfSesion = ActivityScenario.launch(iniciarsesion.class);
        onView(withId(R.id.txtCorreo)).perform(ViewActions.typeText(correo));
        onView(withId(R.id.txtcontrasenia)).perform(ViewActions.typeText(contra));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.boton_iniciar_sesion)).perform(click());

        //Se entra en Pantalla Cliente y se va a anular reserva
        Instrumentation.ActivityMonitor monitor1 = new Instrumentation.ActivityMonitor(Pantalla_cliente.class.getName(), null, false);
        Activity sec1 = monitor1.waitForActivityWithTimeout(3000);
        onView(withId(R.id.btnanularservaXD)).perform(click());

        //Dentro de anular reserva se introducen los datos y se anula reserva de tipo reserva mesa y comida
        String fecha = "2022-05-24";
        String hora = "18:00";
        Instrumentation.ActivityMonitor monitor2 = new Instrumentation.ActivityMonitor(AnularReserva.class.getName(), null, false);
        onView(withId(R.id.anularfecha)).perform(ViewActions.typeText(fecha));
        onView(withId(R.id.anularhora)).perform(ViewActions.typeText(hora));
        Espresso.closeSoftKeyboard();
        Activity sec2 = monitor2.waitForActivityWithTimeout(5000);
                /////////Selecionar el checkbox
        onView(withId(R.id.btnanularreserva)).perform(click());

        //Nos envia a pantalla cliente
        Instrumentation.ActivityMonitor monitor3 = new Instrumentation.ActivityMonitor(Pantalla_cliente.class.getName(), null, false);
        Activity sec3 = monitor3.waitForActivityWithTimeout(3000);
        onView(withId(R.id.ACpantallacliente)).check(matches(isDisplayed()));
    }

    @Test
    public void AnularReservaMesayComidaInexistente() {

        //Se inicia sesion como Cliente
        String correo = "strayborx@gmail.com";
        String contra = "1234567";
        ActivityScenario<iniciarsesion> smurfSesion = ActivityScenario.launch(iniciarsesion.class);
        onView(withId(R.id.txtCorreo)).perform(ViewActions.typeText(correo));
        onView(withId(R.id.txtcontrasenia)).perform(ViewActions.typeText(contra));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.boton_iniciar_sesion)).perform(click());

        //Se entra en Pantalla Cliente y se va a anular reserva
        Instrumentation.ActivityMonitor monitor1 = new Instrumentation.ActivityMonitor(Pantalla_cliente.class.getName(), null, false);
        Activity sec1 = monitor1.waitForActivityWithTimeout(3000);
        onView(withId(R.id.btnanularservaXD)).perform(click());

        //Dentro de anular reserva se introducen los datos de una reserva inexistente
        String fecha = "2022-05-31";
        String hora = "05:00";
        Instrumentation.ActivityMonitor monitor2 = new Instrumentation.ActivityMonitor(AnularReserva.class.getName(), null, false);
        onView(withId(R.id.anularfecha)).perform(ViewActions.typeText(fecha));
        onView(withId(R.id.anularhora)).perform(ViewActions.typeText(hora));
        Espresso.closeSoftKeyboard();
        Activity sec2 = monitor2.waitForActivityWithTimeout(5000);
                /////////Selecionar el checkbox
        onView(withId(R.id.btnanularreserva)).perform(click());
        onView(withId(R.id.activityARMklk)).check(matches(isDisplayed()));
    }*/


    ///////////////////INICIAR SESION Y CERRAR SESION////////////////////
    /*@Test
    public void datovacios(){

        ActivityScenario<iniciarsesion> smurfSesion = ActivityScenario.launch(iniciarsesion.class);

        String email = "";
        String contra = "";
        onView(withId(R.id.txtCorreo)).perform(ViewActions.typeText(email));
        onView(withId(R.id.txtcontrasenia)).perform(ViewActions.typeText(contra));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.boton_iniciar_sesion)).perform(click());
        onView(withId(R.id.foto)).check(matches(isDisplayed()));


    }

    @Test
    public void usuarionoexistente() {

        ActivityScenario<iniciarsesion> smurfSesion = ActivityScenario.launch(iniciarsesion.class);

        String email = "email@gmail.com";
        String contra = "1234567";
        onView(withId(R.id.txtCorreo)).perform(ViewActions.typeText(email));
        onView(withId(R.id.txtcontrasenia)).perform(ViewActions.typeText(contra));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.boton_iniciar_sesion)).perform(click());
        onView(withId(R.id.foto)).check(matches(isDisplayed()));

    }

    @Test
    public void usuariocontraseniaincorrecta() {

        ActivityScenario<iniciarsesion> smurfSesion = ActivityScenario.launch(iniciarsesion.class);

        String email = "fransr922@gmail.com";
        String contra = "12345678";
        onView(withId(R.id.txtCorreo)).perform(ViewActions.typeText(email));
        onView(withId(R.id.txtcontrasenia)).perform(ViewActions.typeText(contra));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.boton_iniciar_sesion)).perform(click());


        Instrumentation.ActivityMonitor monitor = new Instrumentation.ActivityMonitor(Pantalla_admin.class.getName(),null,false);
        Activity sec = monitor.waitForActivityWithTimeout(5000);

        onView(withId(R.id.foto)).check(matches(isDisplayed()));

    }

    @Test
    public void usuarioexistente() {

        ActivityScenario<iniciarsesion> smurfSesion = ActivityScenario.launch(iniciarsesion.class);

        String email = "fransr922@gmail.com";
        String contra = "1234567";
        onView(withId(R.id.txtCorreo)).perform(ViewActions.typeText(email));
        onView(withId(R.id.txtcontrasenia)).perform(ViewActions.typeText(contra));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.boton_iniciar_sesion)).perform(click());


        Instrumentation.ActivityMonitor monitor = new Instrumentation.ActivityMonitor(Pantalla_admin.class.getName(),null,false);
        Activity sec = monitor.waitForActivityWithTimeout(5000);

        onView(withId(R.id.txtPantAdmin)).check(matches(isDisplayed()));

    }

    @Test
    public void Ir_a_Registrarse() {

        ActivityScenario<iniciarsesion> smurfSesion = ActivityScenario.launch(iniciarsesion.class);

        onView(withId(R.id.boton_registrar)).perform(click());


        Instrumentation.ActivityMonitor monitor = new Instrumentation.ActivityMonitor(Pantalla_admin.class.getName(),null,false);
        Activity sec = monitor.waitForActivityWithTimeout(5000);

        onView(withId(R.id.activityregistrarse)).check(matches(isDisplayed()));

    }

    @Test
    public void CerrarSesion_Admin() {

        //Se inicia sesion como Cliente
        String email = "fransr922@gmail.com";
        String contra = "1234567";
        ActivityScenario<iniciarsesion> smurfSesion = ActivityScenario.launch(iniciarsesion.class);
        onView(withId(R.id.txtCorreo)).perform(ViewActions.typeText(email));
        onView(withId(R.id.txtcontrasenia)).perform(ViewActions.typeText(contra));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.boton_iniciar_sesion)).perform(click());

        //Se entra en Pantalla Cliente y se cierra sesion
        Instrumentation.ActivityMonitor monitor2 = new Instrumentation.ActivityMonitor(Pantalla_admin.class.getName(), null, false);
        Activity sec2 = monitor2.waitForActivityWithTimeout(5000);
        onView(withId(R.id.btnLogout)).perform(click());

        //Se vuelve a la Activity de iniciar sesion
        Instrumentation.ActivityMonitor monitor3 = new Instrumentation.ActivityMonitor(iniciarsesion.class.getName(), null, false);
        Activity sec3 = monitor3.waitForActivityWithTimeout(5000);
        onView(withId(R.id.foto)).check(matches(isDisplayed()));
    }

    @Test
    public void CerrarSesion_Cliente() {

        //Se inicia sesion como Cliente
        String email = "strayborx@gmail.com";
        String contra = "1234567";
        ActivityScenario<iniciarsesion> smurfSesion = ActivityScenario.launch(iniciarsesion.class);
        onView(withId(R.id.txtCorreo)).perform(ViewActions.typeText(email));
        onView(withId(R.id.txtcontrasenia)).perform(ViewActions.typeText(contra));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.boton_iniciar_sesion)).perform(click());

        //Se entra en Pantalla Cliente y se cierra sesion
        Instrumentation.ActivityMonitor monitor2 = new Instrumentation.ActivityMonitor(Pantalla_cliente.class.getName(), null, false);
        Activity sec2 = monitor2.waitForActivityWithTimeout(5000);
        onView(withId(R.id.btnLogout)).perform(click());

        //Se vuelve a la Activity de iniciar sesion
        Instrumentation.ActivityMonitor monitor3 = new Instrumentation.ActivityMonitor(iniciarsesion.class.getName(), null, false);
        Activity sec3 = monitor3.waitForActivityWithTimeout(5000);
        onView(withId(R.id.foto)).check(matches(isDisplayed()));
    }

    @Test
    public void CerrarSesion_Camarero() {

        //Se inicia sesion como Cliente
        String email = "pablo@gmail.com";
        String contra = "1234567";
        ActivityScenario<iniciarsesion> smurfSesion = ActivityScenario.launch(iniciarsesion.class);
        onView(withId(R.id.txtCorreo)).perform(ViewActions.typeText(email));
        onView(withId(R.id.txtcontrasenia)).perform(ViewActions.typeText(contra));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.boton_iniciar_sesion)).perform(click());

        //Se entra en Pantalla Cliente y se cierra sesion
        Instrumentation.ActivityMonitor monitor2 = new Instrumentation.ActivityMonitor(Pantalla_camarero.class.getName(), null, false);
        Activity sec2 = monitor2.waitForActivityWithTimeout(5000);
        onView(withId(R.id.btnLogoutCam)).perform(click());

        //Se vuelve a la Activity de iniciar sesion
        Instrumentation.ActivityMonitor monitor3 = new Instrumentation.ActivityMonitor(iniciarsesion.class.getName(), null, false);
        Activity sec3 = monitor3.waitForActivityWithTimeout(5000);
        onView(withId(R.id.foto)).check(matches(isDisplayed()));
    }

    @Test
    public void CerrarSesion_Cocinero() {

        //Se inicia sesion como Cliente
        String email = "ruben@gmail.com";
        String contra = "1234567";
        ActivityScenario<iniciarsesion> smurfSesion = ActivityScenario.launch(iniciarsesion.class);
        onView(withId(R.id.txtCorreo)).perform(ViewActions.typeText(email));
        onView(withId(R.id.txtcontrasenia)).perform(ViewActions.typeText(contra));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.boton_iniciar_sesion)).perform(click());

        //Se entra en Pantalla Cliente y se cierra sesion
        Instrumentation.ActivityMonitor monitor2 = new Instrumentation.ActivityMonitor(Pantalla_cocinero.class.getName(), null, false);
        Activity sec2 = monitor2.waitForActivityWithTimeout(5000);
        onView(withId(R.id.btnLogoutCoc)).perform(click());

        //Se vuelve a la Activity de iniciar sesion
        Instrumentation.ActivityMonitor monitor3 = new Instrumentation.ActivityMonitor(iniciarsesion.class.getName(), null, false);
        Activity sec3 = monitor3.waitForActivityWithTimeout(5000);
        onView(withId(R.id.foto)).check(matches(isDisplayed()));
    }

    @Test
    public void CerrarSesion_Trasportista() {

        //Se inicia sesion como Cliente
        String email = "miri@gmail.com";
        String contra = "1234567";
        ActivityScenario<iniciarsesion> smurfSesion = ActivityScenario.launch(iniciarsesion.class);
        onView(withId(R.id.txtCorreo)).perform(ViewActions.typeText(email));
        onView(withId(R.id.txtcontrasenia)).perform(ViewActions.typeText(contra));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.boton_iniciar_sesion)).perform(click());

        //Se entra en Pantalla Cliente y se cierra sesion
        Instrumentation.ActivityMonitor monitor2 = new Instrumentation.ActivityMonitor(Pantalla_trasportista.class.getName(), null, false);
        Activity sec2 = monitor2.waitForActivityWithTimeout(5000);
        onView(withId(R.id.btnLogoutTrans)).perform(click());

        //Se vuelve a la Activity de iniciar sesion
        Instrumentation.ActivityMonitor monitor3 = new Instrumentation.ActivityMonitor(iniciarsesion.class.getName(), null, false);
        Activity sec3 = monitor3.waitForActivityWithTimeout(5000);
        onView(withId(R.id.foto)).check(matches(isDisplayed()));
    }

    ///////////////////DARSE DE BAJA/////////////////////
    @Test
    public void DarsedeBajaOK() {

        //Se inicia sesion como Cliente
        String correo = "juan@gmail.com";
        String contra = "1234567";
        ActivityScenario<iniciarsesion> smurfSesion = ActivityScenario.launch(iniciarsesion.class);
        onView(withId(R.id.txtCorreo)).perform(ViewActions.typeText(correo));
        onView(withId(R.id.txtcontrasenia)).perform(ViewActions.typeText(contra));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.boton_iniciar_sesion)).perform(click());

        //Se entra en Pantalla Cliente y se va a dar de baja
        Instrumentation.ActivityMonitor monitor1 = new Instrumentation.ActivityMonitor(Pantalla_cliente.class.getName(), null, false);
        Activity sec1 = monitor1.waitForActivityWithTimeout(5000);
        onView(withId(R.id.btnBaja)).perform(click());

        //Dentro de dar de baja se pone el correo y se da de baja
        String correoaElim = "juan@gmail.com";
        Instrumentation.ActivityMonitor monitor2 = new Instrumentation.ActivityMonitor(DarsedeBaja.class.getName(),null,false);
        Activity sec2 = monitor2.waitForActivityWithTimeout(5000);
        onView(withId(R.id.correoconf)).perform(ViewActions.typeText(correoaElim));
        onView(withId(R.id.btnaceptar)).perform(click());

        //Se vuelve a la activity iniciar sesion
        Instrumentation.ActivityMonitor monitor3 = new Instrumentation.ActivityMonitor(iniciarsesion.class.getName(),null,false);
        Activity sec3 = monitor3.waitForActivityWithTimeout(5000);

        onView(withId(R.id.foto)).check(matches(isDisplayed()));
    }

    @Test
    public void DarsedeBajaEmailIncorrecto() {

        //Se inicia sesion como Cliente
        String correo = "juanP@gmail.com";
        String contra = "1234567";
        ActivityScenario<iniciarsesion> smurfSesion = ActivityScenario.launch(iniciarsesion.class);
        onView(withId(R.id.txtCorreo)).perform(ViewActions.typeText(correo));
        onView(withId(R.id.txtcontrasenia)).perform(ViewActions.typeText(contra));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.boton_iniciar_sesion)).perform(click());

        //Se entra en Pantalla Cliente y se va a dar de baja
        Instrumentation.ActivityMonitor monitor1 = new Instrumentation.ActivityMonitor(Pantalla_cliente.class.getName(), null, false);
        Activity sec1 = monitor1.waitForActivityWithTimeout(5000);
        onView(withId(R.id.btnBaja)).perform(click());

        //Dentro de dar de baja se pone el correo y se da de baja mal
        String correoaElim = "jua@gmail.com";
        Instrumentation.ActivityMonitor monitor2 = new Instrumentation.ActivityMonitor(DarsedeBaja.class.getName(),null,false);
        Activity sec2 = monitor2.waitForActivityWithTimeout(5000);
        onView(withId(R.id.correoconf)).perform(ViewActions.typeText(correoaElim));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.btnaceptar)).perform(click());
        onView(withId(R.id.activitydardebaja)).check(matches(isDisplayed()));
    }

    @Test
    public void DarsedeBajabtnAtras() {

        //Se inicia sesion como Cliente
        String correo = "juanP@gmail.com";
        String contra = "1234567";
        ActivityScenario<iniciarsesion> smurfSesion = ActivityScenario.launch(iniciarsesion.class);
        onView(withId(R.id.txtCorreo)).perform(ViewActions.typeText(correo));
        onView(withId(R.id.txtcontrasenia)).perform(ViewActions.typeText(contra));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.boton_iniciar_sesion)).perform(click());

        //Se entra en Pantalla Cliente y se va a dar de baja
        Instrumentation.ActivityMonitor monitor1 = new Instrumentation.ActivityMonitor(Pantalla_cliente.class.getName(), null, false);
        Activity sec1 = monitor1.waitForActivityWithTimeout(5000);
        onView(withId(R.id.btnBaja)).perform(click());

        //Dentro de dar de baja se pone el correo y da a volver atras
        Instrumentation.ActivityMonitor monitor2 = new Instrumentation.ActivityMonitor(DarsedeBaja.class.getName(),null,false);
        Activity sec2 = monitor2.waitForActivityWithTimeout(5000);
        onView(withId(R.id.btnatr)).perform(click());

        //Se vuelve a Pantalla Cliente
        Instrumentation.ActivityMonitor monitor3 = new Instrumentation.ActivityMonitor(Pantalla_cliente.class.getName(), null, false);
        Activity sec3 = monitor1.waitForActivityWithTimeout(5000);

        onView(withId(R.id.ACpantallacliente)).check(matches(isDisplayed()));

    }*/

    ///////////////////EDITAR CUENTA/////////////////////
    /*@Test
    public void EditarCuentanombreOK() {

        //Se inicia sesion como Cliente
        String correo = "strayborx@gmail.com";
        String contra = "1234567";
        ActivityScenario<iniciarsesion> smurfSesion = ActivityScenario.launch(iniciarsesion.class);
        onView(withId(R.id.txtCorreo)).perform(ViewActions.typeText(correo));
        onView(withId(R.id.txtcontrasenia)).perform(ViewActions.typeText(contra));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.boton_iniciar_sesion)).perform(click());

        //Se entra en Pantalla Cliente y se va a editar cuenta
        Instrumentation.ActivityMonitor monitor1 = new Instrumentation.ActivityMonitor(Pantalla_cliente.class.getName(), null, false);
        Activity sec1 = monitor1.waitForActivityWithTimeout(5000);
        onView(withId(R.id.btneditarcuenta)).perform(click());

        //Dentro de editar cuenta se pone el nombre que se quiere cambiar
        String nombreeditt = "Alvaro";
        Instrumentation.ActivityMonitor monitor2 = new Instrumentation.ActivityMonitor(DarsedeBaja.class.getName(),null,false);
        Activity sec2 = monitor2.waitForActivityWithTimeout(5000);
        onView(withId(R.id.nombreedit)).perform(ViewActions.typeText(nombreeditt));
        onView(withId(R.id.btnCambiar)).perform(click());

        //Se vuelve a Pantalla Cliente
        Instrumentation.ActivityMonitor monitor3 = new Instrumentation.ActivityMonitor(Pantalla_cliente.class.getName(), null, false);
        Activity sec3 = monitor1.waitForActivityWithTimeout(5000);

        onView(withId(R.id.ACpantallacliente)).check(matches(isDisplayed()));

    }

    @Test
    public void EditarCuentaapellidosOK() {

        //Se inicia sesion como Cliente
        String correo = "strayborx@gmail.com";
        String contra = "1234567";
        ActivityScenario<iniciarsesion> smurfSesion = ActivityScenario.launch(iniciarsesion.class);
        onView(withId(R.id.txtCorreo)).perform(ViewActions.typeText(correo));
        onView(withId(R.id.txtcontrasenia)).perform(ViewActions.typeText(contra));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.boton_iniciar_sesion)).perform(click());

        //Se entra en Pantalla Cliente y se va a editar cuenta
        Instrumentation.ActivityMonitor monitor1 = new Instrumentation.ActivityMonitor(Pantalla_cliente.class.getName(), null, false);
        Activity sec1 = monitor1.waitForActivityWithTimeout(5000);
        onView(withId(R.id.btneditarcuenta)).perform(click());

        //Dentro de editar cuenta se pone el apellido que se quiere cambiar
        String apellidoeditt = "Santi";
        Instrumentation.ActivityMonitor monitor2 = new Instrumentation.ActivityMonitor(DarsedeBaja.class.getName(),null,false);
        Activity sec2 = monitor2.waitForActivityWithTimeout(5000);
        onView(withId(R.id.apellidosedit)).perform(ViewActions.typeText(apellidoeditt));
        onView(withId(R.id.btnCambiar)).perform(click());

        //Se vuelve a Pantalla Cliente
        Instrumentation.ActivityMonitor monitor3 = new Instrumentation.ActivityMonitor(Pantalla_cliente.class.getName(), null, false);
        Activity sec3 = monitor1.waitForActivityWithTimeout(5000);

        onView(withId(R.id.ACpantallacliente)).check(matches(isDisplayed()));

    }

    @Test
    public void EditarCuentabtnAtras() {

        //Se inicia sesion como Cliente
        String correo = "strayborx@gmail.com";
        String contra = "1234567";
        ActivityScenario<iniciarsesion> smurfSesion = ActivityScenario.launch(iniciarsesion.class);
        onView(withId(R.id.txtCorreo)).perform(ViewActions.typeText(correo));
        onView(withId(R.id.txtcontrasenia)).perform(ViewActions.typeText(contra));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.boton_iniciar_sesion)).perform(click());

        //Se entra en Pantalla Cliente y se va a editar cuenta
        Instrumentation.ActivityMonitor monitor1 = new Instrumentation.ActivityMonitor(Pantalla_cliente.class.getName(), null, false);
        Activity sec1 = monitor1.waitForActivityWithTimeout(5000);
        onView(withId(R.id.btneditarcuenta)).perform(click());

        //Dentro de editar cuenta se da al boton atras

        Instrumentation.ActivityMonitor monitor2 = new Instrumentation.ActivityMonitor(DarsedeBaja.class.getName(),null,false);
        Activity sec2 = monitor2.waitForActivityWithTimeout(5000);
        onView(withId(R.id.btnpatras)).perform(click());

        //Se vuelve a Pantalla Cliente
        Instrumentation.ActivityMonitor monitor3 = new Instrumentation.ActivityMonitor(Pantalla_cliente.class.getName(), null, false);
        Activity sec3 = monitor1.waitForActivityWithTimeout(5000);

        onView(withId(R.id.ACpantallacliente)).check(matches(isDisplayed()));

    }

    @Test
    public void camposvacios() {

        //Se inicia sesion como Cliente
        String correo = "strayborx@gmail.com";
        String contra = "1234567";
        ActivityScenario<iniciarsesion> smurfSesion = ActivityScenario.launch(iniciarsesion.class);
        onView(withId(R.id.txtCorreo)).perform(ViewActions.typeText(correo));
        onView(withId(R.id.txtcontrasenia)).perform(ViewActions.typeText(contra));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.boton_iniciar_sesion)).perform(click());

        //Se entra en Pantalla Cliente y se va a editar cuenta
        Instrumentation.ActivityMonitor monitor1 = new Instrumentation.ActivityMonitor(Pantalla_cliente.class.getName(), null, false);
        Activity sec1 = monitor1.waitForActivityWithTimeout(5000);
        onView(withId(R.id.btneditarcuenta)).perform(click());

        //Dentro de editar cuenta se da al editar, pero sin rellenar ningun campo
        Instrumentation.ActivityMonitor monitor2 = new Instrumentation.ActivityMonitor(DarsedeBaja.class.getName(),null,false);
        Activity sec2 = monitor2.waitForActivityWithTimeout(5000);
        onView(withId(R.id.btnCambiar)).perform(click());

        onView(withId(R.id.activityeditusu)).check(matches(isDisplayed()));

    }*/

    ///////////////////HACER RESERVA/////////////////////

    /*@Test
    public void RealizarReservaMesaOK() {

        //Se inicia sesion como Cliente
        String correo = "strayborx@gmail.com";
        String contra = "1234567";
        ActivityScenario<iniciarsesion> smurfSesion = ActivityScenario.launch(iniciarsesion.class);
        onView(withId(R.id.txtCorreo)).perform(ViewActions.typeText(correo));
        onView(withId(R.id.txtcontrasenia)).perform(ViewActions.typeText(contra));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.boton_iniciar_sesion)).perform(click());

        //Se entra en Pantalla Cliente y se va a reservar mesa
        Instrumentation.ActivityMonitor monitor1 = new Instrumentation.ActivityMonitor(Pantalla_cliente.class.getName(), null, false);
        Activity sec1 = monitor1.waitForActivityWithTimeout(3000);
        onView(withId(R.id.btnreservar)).perform(click());

        //Dentro de reservar mesa se seleccionan los datos y se hace la reserva
        Instrumentation.ActivityMonitor monitor2 = new Instrumentation.ActivityMonitor(Reservarmesa.class.getName(), null, false);
        Activity sec2 = monitor2.waitForActivityWithTimeout(11000);
        onView(withId(R.id.btnhacerreserva)).perform(click());

        //Nos envia a pantalla cliente
        Instrumentation.ActivityMonitor monitor3 = new Instrumentation.ActivityMonitor(Pantalla_cliente.class.getName(), null, false);
        Activity sec3 = monitor3.waitForActivityWithTimeout(3000);
        onView(withId(R.id.ACpantallacliente)).check(matches(isDisplayed()));

    }

    @Test
    public void RealizarReservaMesafechavacio() {

        //Se inicia sesion como Cliente
        String correo = "strayborx@gmail.com";
        String contra = "1234567";
        ActivityScenario<iniciarsesion> smurfSesion = ActivityScenario.launch(iniciarsesion.class);
        onView(withId(R.id.txtCorreo)).perform(ViewActions.typeText(correo));
        onView(withId(R.id.txtcontrasenia)).perform(ViewActions.typeText(contra));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.boton_iniciar_sesion)).perform(click());

        //Se entra en Pantalla Cliente y se va a reservar mesa
        Instrumentation.ActivityMonitor monitor1 = new Instrumentation.ActivityMonitor(Pantalla_cliente.class.getName(), null, false);
        Activity sec1 = monitor1.waitForActivityWithTimeout(3000);
        onView(withId(R.id.btnreservar)).perform(click());

        //Dentro de reservar mesa no se selecciona fecha y se hace la reserva
        Instrumentation.ActivityMonitor monitor2 = new Instrumentation.ActivityMonitor(Reservarmesa.class.getName(), null, false);
        Activity sec2 = monitor2.waitForActivityWithTimeout(6000);
        onView(withId(R.id.btnhacerreserva)).perform(click());
        onView(withId(R.id.activityreservarmesa)).check(matches(isDisplayed()));

    }

    @Test
    public void RealizarReservaMesahoravacio() {

        //Se inicia sesion como Cliente
        String correo = "strayborx@gmail.com";
        String contra = "1234567";
        ActivityScenario<iniciarsesion> smurfSesion = ActivityScenario.launch(iniciarsesion.class);
        onView(withId(R.id.txtCorreo)).perform(ViewActions.typeText(correo));
        onView(withId(R.id.txtcontrasenia)).perform(ViewActions.typeText(contra));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.boton_iniciar_sesion)).perform(click());

        //Se entra en Pantalla Cliente y se va a reservar mesa
        Instrumentation.ActivityMonitor monitor1 = new Instrumentation.ActivityMonitor(Pantalla_cliente.class.getName(), null, false);
        Activity sec1 = monitor1.waitForActivityWithTimeout(3000);
        onView(withId(R.id.btnreservar)).perform(click());

        //Dentro de reservar mesa no se selecciona hora y se hace la reserva
        Instrumentation.ActivityMonitor monitor2 = new Instrumentation.ActivityMonitor(Reservarmesa.class.getName(), null, false);
        Activity sec2 = monitor2.waitForActivityWithTimeout(6000);
        onView(withId(R.id.btnhacerreserva)).perform(click());
        onView(withId(R.id.activityreservarmesa)).check(matches(isDisplayed()));

    }

    @Test
    public void RealizarReservaMesabtnAtras() {

        //Se inicia sesion como Cliente
        String correo = "strayborx@gmail.com";
        String contra = "1234567";
        ActivityScenario<iniciarsesion> smurfSesion = ActivityScenario.launch(iniciarsesion.class);
        onView(withId(R.id.txtCorreo)).perform(ViewActions.typeText(correo));
        onView(withId(R.id.txtcontrasenia)).perform(ViewActions.typeText(contra));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.boton_iniciar_sesion)).perform(click());

        //Se entra en Pantalla Cliente y se va a reservar mesa
        Instrumentation.ActivityMonitor monitor1 = new Instrumentation.ActivityMonitor(Pantalla_cliente.class.getName(), null, false);
        Activity sec1 = monitor1.waitForActivityWithTimeout(3000);
        onView(withId(R.id.btnreservar)).perform(click());

        //Dentro de reservar mesa se vuelve atras
        Instrumentation.ActivityMonitor monitor2 = new Instrumentation.ActivityMonitor(Reservarmesa.class.getName(), null, false);
        Activity sec2 = monitor2.waitForActivityWithTimeout(3000);
        onView(withId(R.id.btncanc)).perform(click());
        onView(withId(R.id.ACpantallacliente)).check(matches(isDisplayed()));
    }

    @Test
    public void RealizarReservaMesaIndisponibilidaddeMesas() {
        ////Seleccionar dia, hora y personas igual que dos registros creados
        //Se inicia sesion como Cliente
        String correo = "strayborx@gmail.com";
        String contra = "1234567";
        ActivityScenario<iniciarsesion> smurfSesion = ActivityScenario.launch(iniciarsesion.class);
        onView(withId(R.id.txtCorreo)).perform(ViewActions.typeText(correo));
        onView(withId(R.id.txtcontrasenia)).perform(ViewActions.typeText(contra));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.boton_iniciar_sesion)).perform(click());

        //Se entra en Pantalla Cliente y se va a reservar mesa
        Instrumentation.ActivityMonitor monitor1 = new Instrumentation.ActivityMonitor(Pantalla_cliente.class.getName(), null, false);
        Activity sec1 = monitor1.waitForActivityWithTimeout(3000);
        onView(withId(R.id.btnreservar)).perform(click());

        //Dentro de reservar se hace la reserva de un momento donde no hay disponibilidad de mesas
        Instrumentation.ActivityMonitor monitor2 = new Instrumentation.ActivityMonitor(Reservarmesa.class.getName(), null, false);
        Activity sec2 = monitor2.waitForActivityWithTimeout(11000);
        onView(withId(R.id.btnhacerreserva)).perform(click());
        onView(withId(R.id.activityreservarmesa)).check(matches(isDisplayed()));
    }*/

    @Test
    public void RealizarReservaMesayComidaOK() {

        //Se inicia sesion como Cliente
        String correo = "strayborx@gmail.com";
        String contra = "1234567";
        ActivityScenario<iniciarsesion> smurfSesion = ActivityScenario.launch(iniciarsesion.class);
        onView(withId(R.id.txtCorreo)).perform(ViewActions.typeText(correo));
        onView(withId(R.id.txtcontrasenia)).perform(ViewActions.typeText(contra));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.boton_iniciar_sesion)).perform(click());

        //Se entra en Pantalla Cliente y se va a reservar mesa y comida
        Instrumentation.ActivityMonitor monitor1 = new Instrumentation.ActivityMonitor(Pantalla_cliente.class.getName(), null, false);
        Activity sec1 = monitor1.waitForActivityWithTimeout(2000);
        onView(withId(R.id.btnreservarmyc)).perform(click());

        //Dentro de reservar mesa y comida se seleccionan los datos y se hace la reserva -> seleccionar a mano hora y fecha y comida
        Instrumentation.ActivityMonitor monitor2 = new Instrumentation.ActivityMonitor(reservarcomidaymesa.class.getName(), null, false);
        Activity sec2 = monitor2.waitForActivityWithTimeout(12000);
        onView(withId(R.id.btnreservamesaycomida)).perform(click());

        //Nos envia a pantalla cliente
        Instrumentation.ActivityMonitor monitor3 = new Instrumentation.ActivityMonitor(Pantalla_cliente.class.getName(), null, false);
        Activity sec3 = monitor3.waitForActivityWithTimeout(2000);
        onView(withId(R.id.ACpantallacliente)).check(matches(isDisplayed()));
    }

    @Test
    public void RealizarReservaMesayComidafechavacio() {

        //Se inicia sesion como Cliente
        String correo = "strayborx@gmail.com";
        String contra = "1234567";
        ActivityScenario<iniciarsesion> smurfSesion = ActivityScenario.launch(iniciarsesion.class);
        onView(withId(R.id.txtCorreo)).perform(ViewActions.typeText(correo));
        onView(withId(R.id.txtcontrasenia)).perform(ViewActions.typeText(contra));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.boton_iniciar_sesion)).perform(click());

        //Se entra en Pantalla Cliente y se va a reservar mesa y comida
        Instrumentation.ActivityMonitor monitor1 = new Instrumentation.ActivityMonitor(Pantalla_cliente.class.getName(), null, false);
        Activity sec1 = monitor1.waitForActivityWithTimeout(2000);
        onView(withId(R.id.btnreservarmyc)).perform(click());

        //Dentro de reservar mesa y comida no se selecciona fecha -> seleccionar a mano hora y comida
        Instrumentation.ActivityMonitor monitor2 = new Instrumentation.ActivityMonitor(reservarcomidaymesa.class.getName(), null, false);
        Activity sec2 = monitor2.waitForActivityWithTimeout(5000);
        onView(withId(R.id.btnreservamesaycomida)).perform(click());
        onView(withId(R.id.ACtyvityreserMyC)).check(matches(isDisplayed()));
    }

    @Test
    public void RealizarReservaMesayComidahoravacio() {

        //Se inicia sesion como Cliente
        String correo = "strayborx@gmail.com";
        String contra = "1234567";
        ActivityScenario<iniciarsesion> smurfSesion = ActivityScenario.launch(iniciarsesion.class);
        onView(withId(R.id.txtCorreo)).perform(ViewActions.typeText(correo));
        onView(withId(R.id.txtcontrasenia)).perform(ViewActions.typeText(contra));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.boton_iniciar_sesion)).perform(click());

        //Se entra en Pantalla Cliente y se va a reservar mesa y comida
        Instrumentation.ActivityMonitor monitor1 = new Instrumentation.ActivityMonitor(Pantalla_cliente.class.getName(), null, false);
        Activity sec1 = monitor1.waitForActivityWithTimeout(2000);
        onView(withId(R.id.btnreservarmyc)).perform(click());

        //Dentro de reservar mesa y comida no se selecciona hora -> seleccionar a mano fecha y comida
        Instrumentation.ActivityMonitor monitor2 = new Instrumentation.ActivityMonitor(reservarcomidaymesa.class.getName(), null, false);
        Activity sec2 = monitor2.waitForActivityWithTimeout(5000);
        onView(withId(R.id.btnreservamesaycomida)).perform(click());
        onView(withId(R.id.ACtyvityreserMyC)).check(matches(isDisplayed()));
    }

    @Test
    public void RealizarReservaMesayComidalistacomidavacio() {

        //Se inicia sesion como Cliente
        String correo = "strayborx@gmail.com";
        String contra = "1234567";
        ActivityScenario<iniciarsesion> smurfSesion = ActivityScenario.launch(iniciarsesion.class);
        onView(withId(R.id.txtCorreo)).perform(ViewActions.typeText(correo));
        onView(withId(R.id.txtcontrasenia)).perform(ViewActions.typeText(contra));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.boton_iniciar_sesion)).perform(click());

        //Se entra en Pantalla Cliente y se va a reservar mesa y comida
        Instrumentation.ActivityMonitor monitor1 = new Instrumentation.ActivityMonitor(Pantalla_cliente.class.getName(), null, false);
        Activity sec1 = monitor1.waitForActivityWithTimeout(2000);
        onView(withId(R.id.btnreservarmyc)).perform(click());

        //Dentro de reservar mesa y comida no se selecciona comida -> seleccionar a mano hora y fecha
        Instrumentation.ActivityMonitor monitor2 = new Instrumentation.ActivityMonitor(reservarcomidaymesa.class.getName(), null, false);
        Activity sec2 = monitor2.waitForActivityWithTimeout(12000);
        onView(withId(R.id.btnreservamesaycomida)).perform(click());
        onView(withId(R.id.ACtyvityreserMyC)).check(matches(isDisplayed()));
    }

    @Test
    public void RealizarReservaMesayComidabtnAtras() {

        //Se inicia sesion como Cliente
        String correo = "strayborx@gmail.com";
        String contra = "1234567";
        ActivityScenario<iniciarsesion> smurfSesion = ActivityScenario.launch(iniciarsesion.class);
        onView(withId(R.id.txtCorreo)).perform(ViewActions.typeText(correo));
        onView(withId(R.id.txtcontrasenia)).perform(ViewActions.typeText(contra));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.boton_iniciar_sesion)).perform(click());

        //Se entra en Pantalla Cliente y se va a reservar mesa y comida
        Instrumentation.ActivityMonitor monitor1 = new Instrumentation.ActivityMonitor(Pantalla_cliente.class.getName(), null, false);
        Activity sec1 = monitor1.waitForActivityWithTimeout(2000);
        onView(withId(R.id.btnreservarmyc)).perform(click());

        //Dentro de reservar mesa y comida se va atras
        Instrumentation.ActivityMonitor monitor2 = new Instrumentation.ActivityMonitor(reservarcomidaymesa.class.getName(), null, false);
        Activity sec2 = monitor2.waitForActivityWithTimeout(2000);
        onView(withId(R.id.btnatrss)).perform(click());

        //Nos envia a pantalla cliente
        Instrumentation.ActivityMonitor monitor3 = new Instrumentation.ActivityMonitor(Pantalla_cliente.class.getName(), null, false);
        Activity sec3 = monitor3.waitForActivityWithTimeout(2000);
        onView(withId(R.id.ACpantallacliente)).check(matches(isDisplayed()));
    }

    @Test
    public void RealizarReservaMesayComidaIndisponibilidaddeMesas() {
        ////Seleccionar dia, hora y personas igual que dos registros creados
        //Se inicia sesion como Cliente
        String correo = "strayborx@gmail.com";
        String contra = "1234567";
        ActivityScenario<iniciarsesion> smurfSesion = ActivityScenario.launch(iniciarsesion.class);
        onView(withId(R.id.txtCorreo)).perform(ViewActions.typeText(correo));
        onView(withId(R.id.txtcontrasenia)).perform(ViewActions.typeText(contra));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.boton_iniciar_sesion)).perform(click());

        //Se entra en Pantalla Cliente y se va a reservar mesa y comida
        Instrumentation.ActivityMonitor monitor1 = new Instrumentation.ActivityMonitor(Pantalla_cliente.class.getName(), null, false);
        Activity sec1 = monitor1.waitForActivityWithTimeout(2000);
        onView(withId(R.id.btnreservarmyc)).perform(click());

        //Dentro de reservar se hace la reserva de un momento donde no hay disponibilidad de mesas -> Seleccionar a mano -> 1 de agosto - 12:00 - 2 personas
        Instrumentation.ActivityMonitor monitor2 = new Instrumentation.ActivityMonitor(reservarcomidaymesa.class.getName(), null, false);
        Activity sec2 = monitor2.waitForActivityWithTimeout(18000);
        onView(withId(R.id.btnreservamesaycomida)).perform(click());
        onView(withId(R.id.ACtyvityreserMyC)).check(matches(isDisplayed()));
    }
}