package com.svsa.dashboard.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.svsa.dashboard.dao.UnitDAO;
import com.svsa.dashboard.entities.AssistanceTypesByUnit;
import com.svsa.dashboard.entities.Unit;
import com.svsa.dashboard.exceptions.CryptographyException;
import com.svsa.dashboard.exceptions.DatabaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UnitService {

    @Autowired
    private UnitDAO unitDAO;

    @Autowired
    private CryptographyService cryptographyService;

    public String getActiveUnits() {

        try{
            List<Unit> units = unitDAO.getActiveUnits();

            return encryptingResponse(units);
        }
        catch (SQLException e ){
            e.printStackTrace();
            throw new DatabaseException("Conflito ao buscar Units");
        }
    }

    private String encryptingResponse(List<Unit> units) {

        try{
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonResponse = objectMapper.writeValueAsString(units);

            return cryptographyService.encryptWithAES(jsonResponse);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new CryptographyException("Erro ao Criptografar as Units");
        }
    }
}
