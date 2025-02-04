package com.svsa.dashboard.dao;

import com.svsa.dashboard.dao.database.DatabaseConnection;
import com.svsa.dashboard.entities.ViolenceSituationsTypesByUnit;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ViolenceSituationsTypesByUnitDAO {

    public ViolenceSituationsTypesByUnit getViolenceSituationsTypesByUnit(Long id, int year) throws SQLException {

        String sql = "";

        if(year == 0){
            sql = "SELECT"
                    + "    SUM(qtd_ABUSO_OU_E_VIOLENCIA_SEXUAL) AS total_qtd_ABUSO_OU_E_VIOLENCIA_SEXUAL, "
                    + "    SUM(qtd_VIOLENCIA_FISICA) AS total_qtd_VIOLENCIA_FISICA, "
                    + "    SUM(qtd_VIOLENCIA_PSICOLOGICA) AS total_qtd_VIOLENCIA_PSICOLOGICA, "
                    + "    SUM(qtd_NEGLIGENCIA_CONTRA_CRIANÇA) AS total_qtd_NEGLIGENCIA_CONTRA_CRIANÇA,"
                    + "    SUM(qtd_ATO_INFRACIONAL) AS total_qtd_ATO_INFRACIONAL, "
                    + "	   SUM(qtd_OPEN) AS total_qtd_OPEN,	"
                    + "	   SUM(qtd_CLOSED) AS total_qtd_CLOSED	"
                    + "FROM"
                    + "    ("
                    + "        SELECT"
                    + "            SUM(CASE WHEN sv.situacao = 'ABUSO_OU_E_VIOLENCIA_SEXUAL' THEN 1 ELSE 0 END) AS qtd_ABUSO_OU_E_VIOLENCIA_SEXUAL,"
                    + "            SUM(CASE WHEN sv.situacao = 'VIOLENCIA_FISICA' THEN 1 ELSE 0 END) AS qtd_VIOLENCIA_FISICA, "
                    + "            SUM(CASE WHEN sv.situacao = 'VIOLENCIA_PSICOLOGICA' THEN 1 ELSE 0 END) AS qtd_VIOLENCIA_PSICOLOGICA, "
                    + "            SUM(CASE WHEN sv.situacao = 'NEGLIGENCIA_CONTRA_CRIANÇA' THEN 1 ELSE 0 END) AS qtd_NEGLIGENCIA_CONTRA_CRIANÇA, "
                    + "            SUM(CASE WHEN sv.situacao = 'ATO_INFRACIONAL' THEN 1 ELSE 0 END) AS qtd_ATO_INFRACIONAL, "
                    + "            SUM(CASE WHEN sv.dataEncerramento IS NULL AND sv.situacao IN ('ABUSO_OU_E_VIOLENCIA_SEXUAL', 'VIOLENCIA_FISICA', 'VIOLENCIA_PSICOLOGICA', 'NEGLIGENCIA_CONTRA_CRIANÇA', 'ATO_INFRACIONAL') THEN 1 ELSE 0 END) AS qtd_OPEN, "
                    + "            SUM(CASE WHEN sv.dataEncerramento IS NOT NULL AND sv.situacao IN ('ABUSO_OU_E_VIOLENCIA_SEXUAL', 'VIOLENCIA_FISICA', 'VIOLENCIA_PSICOLOGICA', 'NEGLIGENCIA_CONTRA_CRIANÇA', 'ATO_INFRACIONAL') THEN 1 ELSE 0 END) AS qtd_CLOSED "
                    + "        FROM "
                    + "            situacaoviolencia sv "
                    + "            INNER JOIN pessoa p ON sv.codigo_pessoa = p.codigo "
                    + "            INNER JOIN familia f ON p.codigo_familia = f.codigo "
                    + "            INNER JOIN prontuario pr ON f.codigo_prontuario = pr.codigo "
                    + "            LEFT JOIN prontuario pr_v ON pr.prontuario_vinculado = pr_v.codigo AND pr_v.codigo_unidade = ? "
                    + "            INNER JOIN unidade u ON pr.codigo_unidade = u.codigo "
                    + "        WHERE "
                    + "            sv.tenant_id = 1 "
                    + "            AND (pr.codigo_unidade = ? OR pr_v.codigo_unidade = ? ) "
                    + "        ) AS subquery";
        }
        else{
            sql = "SELECT"
                    + "    SUM(qtd_ABUSO_OU_E_VIOLENCIA_SEXUAL) AS total_qtd_ABUSO_OU_E_VIOLENCIA_SEXUAL, "
                    + "    SUM(qtd_VIOLENCIA_FISICA) AS total_qtd_VIOLENCIA_FISICA, "
                    + "    SUM(qtd_VIOLENCIA_PSICOLOGICA) AS total_qtd_VIOLENCIA_PSICOLOGICA, "
                    + "    SUM(qtd_NEGLIGENCIA_CONTRA_CRIANÇA) AS total_qtd_NEGLIGENCIA_CONTRA_CRIANÇA,"
                    + "    SUM(qtd_ATO_INFRACIONAL) AS total_qtd_ATO_INFRACIONAL, "
                    + "	   SUM(qtd_OPEN) AS total_qtd_OPEN,	"
                    + "	   SUM(qtd_CLOSED) AS total_qtd_CLOSED	"
                    + "FROM"
                    + "    ("
                    + "        SELECT"
                    + "            SUM(CASE WHEN sv.situacao = 'ABUSO_OU_E_VIOLENCIA_SEXUAL' THEN 1 ELSE 0 END) AS qtd_ABUSO_OU_E_VIOLENCIA_SEXUAL,"
                    + "            SUM(CASE WHEN sv.situacao = 'VIOLENCIA_FISICA' THEN 1 ELSE 0 END) AS qtd_VIOLENCIA_FISICA, "
                    + "            SUM(CASE WHEN sv.situacao = 'VIOLENCIA_PSICOLOGICA' THEN 1 ELSE 0 END) AS qtd_VIOLENCIA_PSICOLOGICA, "
                    + "            SUM(CASE WHEN sv.situacao = 'NEGLIGENCIA_CONTRA_CRIANÇA' THEN 1 ELSE 0 END) AS qtd_NEGLIGENCIA_CONTRA_CRIANÇA, "
                    + "            SUM(CASE WHEN sv.situacao = 'ATO_INFRACIONAL' THEN 1 ELSE 0 END) AS qtd_ATO_INFRACIONAL, "
                    + "            SUM(CASE WHEN sv.dataEncerramento IS NULL AND sv.situacao IN ('ABUSO_OU_E_VIOLENCIA_SEXUAL', 'VIOLENCIA_FISICA', 'VIOLENCIA_PSICOLOGICA', 'NEGLIGENCIA_CONTRA_CRIANÇA', 'ATO_INFRACIONAL') THEN 1 ELSE 0 END) AS qtd_OPEN, "
                    + "            SUM(CASE WHEN sv.dataEncerramento IS NOT NULL AND sv.situacao IN ('ABUSO_OU_E_VIOLENCIA_SEXUAL', 'VIOLENCIA_FISICA', 'VIOLENCIA_PSICOLOGICA', 'NEGLIGENCIA_CONTRA_CRIANÇA', 'ATO_INFRACIONAL') THEN 1 ELSE 0 END) AS qtd_CLOSED "
                    + "        FROM "
                    + "            situacaoviolencia sv "
                    + "            INNER JOIN pessoa p ON sv.codigo_pessoa = p.codigo "
                    + "            INNER JOIN familia f ON p.codigo_familia = f.codigo "
                    + "            INNER JOIN prontuario pr ON f.codigo_prontuario = pr.codigo "
                    + "            LEFT JOIN prontuario pr_v ON pr.prontuario_vinculado = pr_v.codigo AND pr_v.codigo_unidade = ? "
                    + "            INNER JOIN unidade u ON pr.codigo_unidade = u.codigo "
                    + "        WHERE "
                    + "            sv.tenant_id = 1 "
                    + "            AND YEAR(sv.data) = ? "
                    + "            AND (pr.codigo_unidade = ? OR pr_v.codigo_unidade = ? ) "
                    + "        ) AS subquery";
        }

        try{
            Connection connection = DatabaseConnection.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            if(year == 0){
                preparedStatement.setLong(1, id);
                preparedStatement.setLong(2, id);
                preparedStatement.setLong(3, id);
            }
            else{
                preparedStatement.setLong(1, id);
                preparedStatement.setInt(2, year);
                preparedStatement.setLong(3, id);
                preparedStatement.setLong(4, id);
            }

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){

                return new ViolenceSituationsTypesByUnit(
                        resultSet.getInt("total_qtd_ABUSO_OU_E_VIOLENCIA_SEXUAL"),
                        resultSet.getInt("total_qtd_VIOLENCIA_FISICA"),
                        resultSet.getInt("total_qtd_VIOLENCIA_PSICOLOGICA"),
                        resultSet.getInt("total_qtd_NEGLIGENCIA_CONTRA_CRIANÇA"),
                        resultSet.getInt("total_qtd_ATO_INFRACIONAL"),
                        resultSet.getInt("total_qtd_OPEN"),
                        resultSet.getInt("total_qtd_CLOSED")
                );
            }

            return null;

        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
}
