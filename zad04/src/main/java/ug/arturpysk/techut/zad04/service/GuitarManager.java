package ug.arturpysk.techut.zad04.service; 

import java.util.List;

import ug.arturpysk.techut.zad04.domain.Guitar;
import ug.arturpysk.techut.zad04.domain.Owner;

public interface GuitarManager {

    void addGuitar(Guitar guitar);
    
    void updateGuitar(Guitar guitar);

    void deleteGuitar(Guitar guitar);

    List<Guitar> getAllGuitars();

    Guitar findById(long id);
    
    List<Owner> getGuitarOwners(Guitar guitar);
    void assignGuitarAndCase(long guitarId, long caseId);
    void assignOwner(long guitarId, long ownerId);
    void assignSerial(long guitarId, long serialId);
    
}