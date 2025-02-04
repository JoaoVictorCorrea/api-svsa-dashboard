package com.svsa.dashboard.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.svsa.dashboard.dao.UnitDAO;
import com.svsa.dashboard.dao.ViolenceSituationsTypesByUnitDAO;
import com.svsa.dashboard.entities.AssistanceTypesByUnit;
import com.svsa.dashboard.entities.Unit;
import com.svsa.dashboard.entities.ViolenceSituationsTypesByUnit;
import com.svsa.dashboard.exceptions.CryptographyException;
import com.svsa.dashboard.exceptions.DatabaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ViolenceSituationsTypesService {

    @Autowired
    private UnitDAO unitDAO;

    @Autowired
    private ViolenceSituationsTypesByUnitDAO violenceSituationsTypesByUnitDAO;

    @Autowired
    private CryptographyService cryptographyService;

    public String getViolenceSituationsTypes(int year) {

        try{
            List<ViolenceSituationsTypesByUnit> violenceSituationsTypesByUnits = new ArrayList<>();
            List<Unit> units = unitDAO.getActiveUnits();

            for(Unit unit: units){

                ViolenceSituationsTypesByUnit violenceSituationsTypesByUnit = violenceSituationsTypesByUnitDAO.getViolenceSituationsTypesByUnit(unit.getId(), year);
                violenceSituationsTypesByUnit.setUnit(unit);
                violenceSituationsTypesByUnits.add(violenceSituationsTypesByUnit);
            }

            return encryptingResponse(violenceSituationsTypesByUnits);
        }
        catch (SQLException e ){
            e.printStackTrace();
            throw new DatabaseException("Conflito ao buscar ViolenceSituationsTypes");
        }
    }

    private String encryptingResponse(List<ViolenceSituationsTypesByUnit> violenceSituationsTypesByUnits) {

        try{
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonResponse = objectMapper.writeValueAsString(violenceSituationsTypesByUnits);

            return cryptographyService.encryptWithAES(jsonResponse);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new CryptographyException("Erro ao Criptografar os ViolenceSituationsTypes");
        }
    }
}
