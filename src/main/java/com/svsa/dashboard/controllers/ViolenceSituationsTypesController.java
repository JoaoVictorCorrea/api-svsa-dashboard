package com.svsa.dashboard.controllers;

import com.svsa.dashboard.services.ViolenceSituationsTypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("violenceSituationsTypes")
public class ViolenceSituationsTypesController {

    @Autowired
    private ViolenceSituationsTypesService violenceSituationsTypesService;

    @GetMapping
    public ResponseEntity<String> getAssistanceTypes(@RequestParam(defaultValue = "0") int year){

        String encryptedViolenceSituationsTypes = violenceSituationsTypesService.getViolenceSituationsTypes(year);

        return ResponseEntity.ok(encryptedViolenceSituationsTypes);
    }
}
