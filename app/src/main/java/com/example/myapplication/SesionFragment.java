package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class SesionFragment extends Fragment implements Response.Listener<JSONObject>, Response.ErrorListener {

    RequestQueue rq;
    JsonRequest<JSONObject> jrq;
    EditText cajaCorreo, cajaContrasenia;
    Button btnIniciarSesion;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_sesion, container, false);
        View vista = inflater.inflate(R.layout.fragment_sesion, container, false);
        cajaCorreo= vista.findViewById(R.id.editTextUsuario);
        cajaContrasenia = vista.findViewById(R.id.editTextContrasenia);
        btnIniciarSesion= vista.findViewById(R.id.boton_iniciar_sesion);
        rq = Volley.newRequestQueue(requireContext());

        btnIniciarSesion.setOnClickListener(view -> iniciarSesion());

        return vista;
    }

    @Override
    public void onResponse(JSONObject response) {
        Usuario usu = new Usuario();
        Toast.makeText(getContext(),"Se ha encontrado el usuario con correo" + cajaCorreo.getText().toString(), Toast.LENGTH_SHORT).show();
        JSONArray jsonArray = response.optJSONArray("datos");
        JSONObject jsonObjectson;
        try {
            assert jsonArray != null;
            jsonObjectson = jsonArray.getJSONObject(0);
            usu.setId_usuario(jsonObjectson.optInt("id_usuario"));
            usu.setNombre(jsonObjectson.optString("nombre"));
            usu.setApellidos(jsonObjectson.optString("apellidos"));
            usu.setContrasenia(jsonObjectson.optString("contrasenia"));
            usu.setCorreo(jsonObjectson.optString("correo"));
            usu.setTelefono(jsonObjectson.optInt("telefono"));
            usu.setRol(jsonObjectson.optInt("rol"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(getContext(),"No se encontró el usuario" + error.toString(), Toast.LENGTH_SHORT).show();
    }


    private void iniciarSesion(){
        /*conexión a un url por http y con el archivo con el que hemos almacenado la consuta sql, al que enviamos los parametros que van alimentar
        esa consulta, en este caso el correo y la contrasenia*/
        String url ="http://192.168.68.106/login/sesion.php?correo=" + cajaCorreo.getText().toString() + "&contrasenia=" + cajaContrasenia.getText().toString();
        jrq= new JsonObjectRequest(Request.Method.GET, url, null,this,this);
        rq.add(jrq);
    }
}