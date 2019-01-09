package ug.arturpysk.techut.zad04.service;

import java.util.List;

import ug.arturpysk.techut.zad04.domain.Guitar;

public interface GuitarManager {

    void addGuitar(Guitar guitar);
    
    void updateGuitar(Guitar guitar);

    void deleteGuitar(Guitar guitar);

    List<Guitar> getAllGuitars();

    Guitar findById(long id);
}