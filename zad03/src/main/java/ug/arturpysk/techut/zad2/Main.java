package ug.arturpysk.techut.zad2;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import ug.arturpysk.techut.zad2.domain.Guitar;
import ug.arturpysk.techut.zad2.service.GuitarService;

public class Main {
    public static void main(String[] args) throws SQLException, ParseException {

    	
    	Guitar firstGuitar = new Guitar("Gibson", Double.parseDouble("150.00"), new Date(118, 05, 30), true);
    	
    	Guitar secondGuitar = new Guitar("Epiphone", Double.parseDouble("250.00"), new Date(118, 05, 30), false);
    	
        GuitarService gs = new GuitarService();
        List<Guitar> guitars = new ArrayList<Guitar>();
        guitars.add(firstGuitar);
        guitars.add(secondGuitar);

        gs.addGuitars(guitars);
        
        //Guitar guitar = gs.getGuitarById(0);
        //System.out.println(guitar.getProducer() + " " + guitar.getPrice() + " " + guitar.getMadeDate() + " " + guitar.getIsReserved());
    
        gs.deleteAllGuitars();
        gs.addGuitars(guitars);
        guitars = gs.getGuitarsCheaperThan(300);
        for (Guitar cheapGuitar : guitars) {
        	System.out.println(cheapGuitar.getProducer() + " " + cheapGuitar.getPrice() + " " + cheapGuitar.getMadeDate() + " " + cheapGuitar.getIsReserved());
        }
    }
}