package com.svsa.dashboard.controllers;

import com.svsa.dashboard.services.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("units")
public class UnitController {

    @Autowired
    private UnitService unitService;

    @GetMapping
    public ResponseEntity<String> getActiveUnits(){

        String encryptedActiveUnits = unitService.getActiveUnits();

        return ResponseEntity.ok(encryptedActiveUnits);
    }
}
