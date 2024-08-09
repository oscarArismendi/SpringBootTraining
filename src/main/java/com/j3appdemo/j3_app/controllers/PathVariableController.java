package com.j3appdemo.j3_app.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.j3appdemo.j3_app.models.dto.ParamsDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/demovar")
public class PathVariableController {
    @Value("${app.name}")
    private String name;
    @Value("${app.version}")
    private String version;
    @Value("${app.listwords}")
    private String[] listwords;
    @Value("${app.listaroles}")
    private List<String> lstroles;
    @Value("${app.message}")
    private String message;
    @Value("#{'${app.listaroles}'.split(',')}")
    private List<String> customlstroles;
    @Value("#{'${app.listaroles}'.toUpperCase().split(',')}")
    private List<String> customlstrolesMayuscula;
    @Value("#{${app.inventory}}")
    private Map<String,Object> inventory;
    @Value("#{${app.inventory}.product}")
    private String producName;
    @Value("#{T(java.lang.Integer).parseInt(${app.inventory}['price']) *T(java.lang.Integer).parseInt(${app.inventory}['stock'])}")
    private Long totalInv;

    @GetMapping("/greetings/{message}")
    public ParamsDto greetings(@PathVariable String message) {
        ParamsDto param = new ParamsDto();
        param.setMessage(message);
        return param;
    }

    @GetMapping("/valores")
    public Map<String,Object> valores(){
    Map<String,Object> json = new HashMap<>();
        json.put("name", name);
        json.put("version",version);
        json.put("listwords",listwords);
        json.put("lstroles",lstroles);
        json.put("clstroles", customlstroles);
        json.put("clstrolesMayus", customlstrolesMayuscula);
        json.put("inventory", inventory);
        json.put("product name",producName);
        json.put("valor", totalInv);
        json.put("message",message);
        return json;
    }

}
