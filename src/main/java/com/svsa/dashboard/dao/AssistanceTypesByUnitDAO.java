package com.svsa.dashboard.dao;

import com.svsa.dashboard.dao.database.DatabaseConnection;
import com.svsa.dashboard.entities.AssistanceTypesByUnit;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class AssistanceTypesByUnitDAO {

    public AssistanceTypesByUnit getAssistanceTypesByUnit(Long id, int year) throws SQLException {

        String sql = "";

        if(year == 0){
            sql = "SELECT"
                    + "    SUM(qtd_atendimento_recepcao) AS total_qtd_atendimento_recepcao, "
                    + "    SUM(qtd_atendimento_social) AS total_qtd_atendimento_social, "
                    + "    SUM(qtd_atualizacao_cadunico) AS total_qtd_atualizacao_cadunico, "
                    + "    SUM(qtd_cadastramento_cadunico) AS total_qtd_cadastramento_cadunico, "
                    + "    SUM(qtd_visita_domiciliar) AS total_qtd_visita_domiciliar "
                    + "FROM "
                    + "    ( "
                    + "        SELECT "
                    + "            SUM(CASE WHEN la.codigoAuxiliar = 'ATENDIMENTO_RECEPCAO' THEN 1 ELSE 0 END) AS qtd_atendimento_recepcao, "
                    + "            SUM(CASE WHEN la.codigoAuxiliar = 'ATENDIMENTO_SOCIAL' THEN 1 ELSE 0 END) AS qtd_atendimento_social, "
                    + "            SUM(CASE WHEN la.codigoAuxiliar = 'ATUALIZACAO_CADUNICO' THEN 1 ELSE 0 END) AS qtd_atualizacao_cadunico, "
                    + "            SUM(CASE WHEN la.codigoAuxiliar = 'CADASTRAMENTO_CADUNICO' THEN 1 ELSE 0 END) AS qtd_cadastramento_cadunico, "
                    + "            SUM(CASE WHEN la.codigoAuxiliar = 'VISITA_DOMICILIAR' THEN 1 ELSE 0 END) AS qtd_visita_domiciliar "
                    + "        FROM "
                    + "            listaatendimento la "
                    + "        WHERE "
                    + "            la.statusAtendimento = 'ATENDIDO' "
                    + "            AND la.codigo_unidade = ? "
                    + "            AND la.tenant_id = 1 "
                    + " "
                    + "        UNION ALL "
                    + " "
                    + "        SELECT "
                    + "            SUM(CASE WHEN af.codigoAuxiliar = 'ATENDIMENTO_RECEPCAO' THEN 1 ELSE 0 END) AS qtd_atendimento_recepcao, "
                    + "            SUM(CASE WHEN af.codigoAuxiliar = 'ATENDIMENTO_SOCIAL' THEN 1 ELSE 0 END) AS qtd_atendimento_social, "
                    + "            SUM(CASE WHEN af.codigoAuxiliar = 'ATUALIZACAO_CADUNICO' THEN 1 ELSE 0 END) AS qtd_atualizacao_cadunico, "
                    + "            SUM(CASE WHEN af.codigoAuxiliar = 'CADASTRAMENTO_CADUNICO' THEN 1 ELSE 0 END) AS qtd_cadastramento_cadunico, "
                    + "            SUM(CASE WHEN af.codigoAuxiliar = 'VISITA_DOMICILIAR' THEN 1 ELSE 0 END) AS qtd_visita_domiciliar "
                    + "        FROM "
                    + "            agendamentofamiliar af "
                    + "        WHERE  "
                    + "            af.statusAtendimento = 'ATENDIDO' "
                    + "            AND af.codigo_unidade = ? "
                    + "            AND af.tenant_id = 1 "
                    + "    ) AS combined_results";
        }
        else{
            sql = "SELECT"
                    + "    SUM(qtd_atendimento_recepcao) AS total_qtd_atendimento_recepcao, "
                    + "    SUM(qtd_atendimento_social) AS total_qtd_atendimento_social, "
                    + "    SUM(qtd_atualizacao_cadunico) AS total_qtd_atualizacao_cadunico, "
                    + "    SUM(qtd_cadastramento_cadunico) AS total_qtd_cadastramento_cadunico, "
                    + "    SUM(qtd_visita_domiciliar) AS total_qtd_visita_domiciliar "
                    + "FROM "
                    + "    ( "
                    + "        SELECT "
                    + "            SUM(CASE WHEN la.codigoAuxiliar = 'ATENDIMENTO_RECEPCAO' THEN 1 ELSE 0 END) AS qtd_atendimento_recepcao, "
                    + "            SUM(CASE WHEN la.codigoAuxiliar = 'ATENDIMENTO_SOCIAL' THEN 1 ELSE 0 END) AS qtd_atendimento_social, "
                    + "            SUM(CASE WHEN la.codigoAuxiliar = 'ATUALIZACAO_CADUNICO' THEN 1 ELSE 0 END) AS qtd_atualizacao_cadunico, "
                    + "            SUM(CASE WHEN la.codigoAuxiliar = 'CADASTRAMENTO_CADUNICO' THEN 1 ELSE 0 END) AS qtd_cadastramento_cadunico, "
                    + "            SUM(CASE WHEN la.codigoAuxiliar = 'VISITA_DOMICILIAR' THEN 1 ELSE 0 END) AS qtd_visita_domiciliar "
                    + "        FROM "
                    + "            listaatendimento la "
                    + "        WHERE "
                    + "            la.statusAtendimento = 'ATENDIDO' "
                    + "            AND la.codigo_unidade = ? "
                    + "            AND YEAR(la.dataAtendimento) = ? "
                    + "            AND la.tenant_id = 1 "
                    + " "
                    + "        UNION ALL "
                    + " "
                    + "        SELECT "
                    + "            SUM(CASE WHEN af.codigoAuxiliar = 'ATENDIMENTO_RECEPCAO' THEN 1 ELSE 0 END) AS qtd_atendimento_recepcao, "
                    + "            SUM(CASE WHEN af.codigoAuxiliar = 'ATENDIMENTO_SOCIAL' THEN 1 ELSE 0 END) AS qtd_atendimento_social, "
                    + "            SUM(CASE WHEN af.codigoAuxiliar = 'ATUALIZACAO_CADUNICO' THEN 1 ELSE 0 END) AS qtd_atualizacao_cadunico, "
                    + "            SUM(CASE WHEN af.codigoAuxiliar = 'CADASTRAMENTO_CADUNICO' THEN 1 ELSE 0 END) AS qtd_cadastramento_cadunico, "
                    + "            SUM(CASE WHEN af.codigoAuxiliar = 'VISITA_DOMICILIAR' THEN 1 ELSE 0 END) AS qtd_visita_domiciliar "
                    + "        FROM "
                    + "            agendamentofamiliar af "
                    + "        WHERE  "
                    + "            af.statusAtendimento = 'ATENDIDO' "
                    + "            AND af.codigo_unidade = ? "
                    + "            AND YEAR(af.dataAtendimento) = ? "
                    + "            AND af.tenant_id = 1 "
                    + "    ) AS combined_results";
        }

        try{
            Connection connection = DatabaseConnection.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            if(year == 0){
                preparedStatement.setLong(1, id);
                preparedStatement.setLong(2, id);
            }
            else{
                preparedStatement.setLong(1, id);
                preparedStatement.setInt(2, year);
                preparedStatement.setLong(3, id);
                preparedStatement.setInt(4, year);
            }

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){

                return new AssistanceTypesByUnit(
                        resultSet.getInt("total_qtd_atendimento_recepcao"),
                        resultSet.getInt("total_qtd_atendimento_social"),
                        resultSet.getInt("total_qtd_atualizacao_cadunico"),
                        resultSet.getInt("total_qtd_cadastramento_cadunico"),
                        resultSet.getInt("total_qtd_visita_domiciliar")
                );
            }

            return null;

        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
}