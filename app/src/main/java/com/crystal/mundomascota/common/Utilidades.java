package com.crystal.mundomascota.common;

import android.view.Window;
import android.view.WindowManager;

public class Utilidades {
    public static final String CORREO_ENVIA = "Trabajoscoursera2022@gmail.com";
    public static final String CONTRASENA_ENVIA = "Trabajos2022";

    public static void ocultarBarraEstado(Window window){
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}
