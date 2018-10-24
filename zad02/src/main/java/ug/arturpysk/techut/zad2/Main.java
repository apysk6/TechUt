package ug.arturpysk.techut.zad2;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.*;

import ug.arturpysk.techut.zad2.domain.Guitar;
import ug.arturpysk.techut.zad2.service.GuitarService;

public class Main {
    public static void main(String[] args) throws SQLException, ParseException {

    	
    	Guitar firstGuitar = new Guitar("Gibson", Double.parseDouble("150.00"), new Date(118, 05, 30), true);
    	
    	Guitar secondGuitar = new Guitar("Epiphone", Double.parseDouble("250.00"), new Date(118, 05, 30), false);
    	
        GuitarService gs = new GuitarService();

        gs.addGuitar(firstGuitar);
        gs.addGuitar(secondGuitar);
        
        Guitar guitar = gs.getGuitarById(0);
        System.out.println(guitar.getProducer() + " " + guitar.getPrice() + " " + guitar.getMadeDate() + " " + guitar.getIsReserved());
        gs.deleteAllGuitars();
    }
}