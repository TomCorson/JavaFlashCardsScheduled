package com.example.schedulingtasks;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.ThreadLocalRandom;

public class FactRetriever {

    Connection connection = ConnectionFactory.getConnection();


    public String retrieveRandomFact(){
        int tableSize = getTableSize();
        int randomId = randomId(tableSize);
        return  findById(randomId);
    }

    public String findById(Integer id)  {
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from Facts where id=" + id+";");
            if(rs.next()){
                return extractFactFromResultSet(rs);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    private String extractFactFromResultSet(ResultSet rs) throws SQLException {
        FlashCard fc = new FlashCard();
        fc.setId(rs.getInt("id"));
        fc.setFact(rs.getString("fact"));
        return fc.getFact();
    }

    public Integer getTableSize(){
        Integer size = 0;
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select count(*) from Facts;");
            while (rs.next()){
                size= rs.getInt(1);
            }
            return size;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return size;
    }

    public Integer randomId(Integer tableSize){
        return ThreadLocalRandom.current().nextInt(1, tableSize +1);

    }

}
