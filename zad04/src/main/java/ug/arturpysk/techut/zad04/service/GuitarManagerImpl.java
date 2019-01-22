 package ug.arturpysk.techut.zad04.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ug.arturpysk.techut.zad04.domain.Bag;
import ug.arturpysk.techut.zad04.domain.Guitar;
import ug.arturpysk.techut.zad04.domain.Owner;
import ug.arturpysk.techut.zad04.domain.Serial;

@Component
@Transactional
public class GuitarManagerImpl implements GuitarManager {

    @Autowired
    SessionFactory hsf;

    @Override
    public void addGuitar(Guitar guitar) {
        hsf.getCurrentSession().save(guitar);
    }
    
    @Override
    public void updateGuitar(Guitar guitar) {
        hsf.getCurrentSession().update(guitar);
    }

    @Override
    public void deleteGuitar(Guitar guitar) {
        hsf.getCurrentSession().delete(guitar);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Guitar> getAllGuitars() {
        return hsf.getCurrentSession().getNamedQuery("guitar.all").list();
    }

    @Override
    public List<Owner> getGuitarOwners(Guitar guitar) {
    	guitar = (Guitar)hsf.getCurrentSession().get(Guitar.class, guitar.getId());
    	List<Owner> owners = new ArrayList<Owner>(guitar.getOwners());
    	
    	return owners;
    }
    
    @Override
    public void assignOwner(long guitarId, long ownerId) {
    	Guitar guitar = findById(guitarId);
    	Owner owner = (Owner)hsf.getCurrentSession().get(Owner.class, ownerId);
    	
    	guitar.getOwners().add(owner);
    }
    
    @Override
    public void assignGuitarAndCase(long guitarId, long caseId) {
    	Guitar guitar = findById(guitarId);
    	Bag guitarCase = (Bag)hsf.getCurrentSession().get(Bag.class, caseId);
    	
    	guitar.getCases().add(guitarCase);
    }
    
    @Override
    public void assignSerial(long guitarId, long serialId) {
    	Guitar guitar = (Guitar)hsf.getCurrentSession().get(Guitar.class, guitarId);
    	Serial serial = (Serial)hsf.getCurrentSession().get(Serial.class, serialId);
    	
    	guitar.setSerial(serial);
    }
    
    @Override
    public Guitar findById(long id) {
        return (Guitar)hsf.getCurrentSession().get(Guitar.class, id);
    }
    
}
