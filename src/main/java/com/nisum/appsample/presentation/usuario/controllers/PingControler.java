package com.nisum.appsample.presentation.usuario.controllers;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nisum.appsample.common.WebAdapter;

/**
 * Esta clase proporciona un controlador para el endpoint "/ping". El método
 * "ping" devuelve un mapa con una clave "estado" y un valor "ok".
 * @author programmercito
*/
@WebAdapter
public class PingControler {

    /**
     * Este método devuelve un mapa con una clave "estado" y un valor "ok".
     *
     * @return Un mapa con una clave "estado" y un valor "ok".
     */
    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    public Map<String, String> ping() {
        Map<String, String> map = new HashMap<>();
        map.put("estado", "ok");
        return map;
    }
}
