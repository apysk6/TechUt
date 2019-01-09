package ug.arturpysk.techut.zad04.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ug.arturpysk.techut.zad04.domain.Guitar;

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
    public Guitar findById(long id) {
        return (Guitar)hsf.getCurrentSession().get(Guitar.class, id);
    }
}
