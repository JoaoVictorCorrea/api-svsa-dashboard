package com.svsa.dashboard.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.svsa.dashboard.dao.AssistanceTypesByUnitDAO;
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
public class AssistanceTypesService {

    @Autowired
    private UnitDAO unitDAO;

    @Autowired
    private AssistanceTypesByUnitDAO assistanceTypesByUnitDAO;

    @Autowired
    private CryptographyService cryptographyService;

    public String getAssistanceTypes(int year) {

        try{
            List<AssistanceTypesByUnit> assistanceTypesByUnits = new ArrayList<>();
            List<Unit> units = unitDAO.getActiveUnits();

            for(Unit unit: units){

                AssistanceTypesByUnit assistanceTypesByUnit = assistanceTypesByUnitDAO.getAssistanceTypesByUnit(unit.getId(), year);
                assistanceTypesByUnit.setUnit(unit);
                assistanceTypesByUnits.add(assistanceTypesByUnit);
            }

            return encryptingResponse(assistanceTypesByUnits);
        }
        catch (SQLException e ){
            e.printStackTrace();
            throw new DatabaseException("Conflito ao buscar AssistanceTypes");
        }
    }

    private String encryptingResponse(List<AssistanceTypesByUnit> assistanceTypesByUnits) {

        try{
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonResponse = objectMapper.writeValueAsString(assistanceTypesByUnits);

            return cryptographyService.encryptWithAES(jsonResponse);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new CryptographyException("Erro ao Criptografar os AssistanceTypes");
        }
    }
}
