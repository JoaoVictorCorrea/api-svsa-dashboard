package com.svsa.dashboard.dao.database;

import com.svsa.dashboard.exceptions.DatabaseException;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class DatabaseConnection {

    private static Connection connection;

    private static String url;
    private static String username;
    private static String password;

    @Value("${jdbc.url}")
    private String injectedUrl;

    @Value("${jdbc.username}")
    private String injectedUsername;

    @Value("${jdbc.password}")
    private String injectedPassword;

    @PostConstruct
    public void init() {
        // Inicializar os valores estáticos
        url = this.injectedUrl;
        username = this.injectedUsername;
        password = this.injectedPassword;
    }

    public static Connection getConnection(){

        //se não houver alguma conexão
        if(connection == null){

            try{
                //estabelecendo uma conexao com o banco conforme as informações lá do application.properties
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
                throw new DatabaseException("Erro de conexão com banco de dados. Consulte o administrador.");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        return connection;
    }
}
