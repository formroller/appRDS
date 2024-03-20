package com.example.apprds;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@SpringBootTest
class AppRdsApplicationTests {

    @Autowired
    private DataSource dataSource;

    @DisplayName("시간 확인")
    @Test
    void contextLoads(){
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select now()");

            ResultSet resultSet = preparedStatement.executeQuery();
        ){
            resultSet.next();
            System.out.println(resultSet.getString(1));

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
