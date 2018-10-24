package ug.arturpysk.techut.zad2.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ug.arturpysk.techut.zad2.domain.Guitar;

public class GuitarService {
    private final String URL = "jdbc:hsqldb:hsql://localhost/workdb";
    private final Connection connection;
    private final Statement statement;
    private final String CREATE_TABLE_SQL = "CREATE TABLE Guitar (id bigint GENERATED BY DEFAULT AS IDENTITY, producer VARCHAR(30), price DOUBLE, madeDate DATE)";
    private boolean tableExists = false;

    public GuitarService() throws SQLException {
        connection = DriverManager.getConnection(URL);
        statement = connection.createStatement();

        ResultSet rs = connection.getMetaData().getTables(null, null, null, null);

        while (rs.next()) {
            if ("Guitar".equalsIgnoreCase(rs.getString("table_name"))) {
                tableExists = true;
                break;
            }
        }

        if (!tableExists) {
            statement.executeUpdate(CREATE_TABLE_SQL);
        }
    }

    public void addGuitar(Guitar guitar) throws SQLException {
        String addGuitar = "INSERT INTO Guitar(producer, price, madeDate) VALUES('" + guitar.getProducer() + "', '" + guitar.getPrice() + "', '" + guitar.getMadeDate() + "')";

        statement.executeUpdate(addGuitar);
    }

    public void showAllGuitars() throws SQLException {
        String allGuitars = "SELECT * FROM Guitar";

        ResultSet rs = statement.executeQuery(allGuitars);

        while (rs.next()) {
            System.out.println("Producer: " + rs.getString("producer") + "\nPrice: " + rs.getDouble("price") + "\nMade date: " + rs.getDate("madeDate") + "\n");
        }
    }

    public void removeGuitars() throws SQLException {
        String removeGuitars = "DELETE FROM Guitar";

        statement.executeQuery(removeGuitars);
    }
}