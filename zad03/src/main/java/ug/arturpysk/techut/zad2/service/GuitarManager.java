package ug.arturpysk.techut.zad2.service;

import java.sql.SQLException;
import java.util.List;

import ug.arturpysk.techut.zad2.domain.Guitar;

public interface GuitarManager {
    public void addGuitar(Guitar guitar) throws SQLException;
    public List<Guitar> getAllGuitars() throws SQLException;
    public List<Guitar> getGuitarsCheaperThan(double price);
    public Guitar getGuitarById(int id) throws SQLException;
    public void deleteAllGuitars() throws SQLException;
    public void deleteGuitarById(int id) throws SQLException;
    public boolean addGuitars(List<Guitar> guitars);
}
