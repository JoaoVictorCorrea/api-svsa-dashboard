package com.svsa.dashboard.controllers;

import com.svsa.dashboard.services.AssistanceTypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("assistanceTypes")
public class AssistanceTypesController {

    @Autowired
    private AssistanceTypesService assistanceTypesService;

    @GetMapping
    public ResponseEntity<String> getAssistanceTypes(@RequestParam(defaultValue = "0") int year){

        String encryptedAssistanceTypes = assistanceTypesService.getAssistanceTypes(year);

        return ResponseEntity.ok(encryptedAssistanceTypes);
    }
}
