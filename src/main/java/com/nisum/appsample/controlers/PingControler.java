package com.nisum.appsample.controlers;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author programmercito
 */
@RestController
public class PingControler {

    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    public Map<String, String> ping() {
        Map<String, String> map = new HashMap<>();
        map.put("estado", "ok");
        return map;
    }
}
