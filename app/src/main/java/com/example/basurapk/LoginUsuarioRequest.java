package com.example.basurapk;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;

public class LoginUsuarioRequest extends StringRequest {


        private static final String ruta = "https://basurapk.com/webservices/loginEncargado.php";


        private Map<String, String> parametros;

        public LoginUsuarioRequest(String usuario, String contra, Response.Listener<String> listener){
            super(Request.Method.POST, ruta, listener, null);
            parametros = new HashMap<>();
            parametros.put("Usuario",usuario);
            parametros.put("Contrasena",contra);
        }
        protected Map<String, String> getParams() {
            return parametros;
        }

    }




