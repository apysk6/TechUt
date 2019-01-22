package ug.arturpysk.techut.zad04.service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ug.arturpysk.techut.zad04.domain.Bag;
import ug.arturpysk.techut.zad04.domain.Guitar;

@Component
@Transactional
public class BagManagerImpl implements BagManager {
	
    @Autowired
    SessionFactory hsf;
	
    @Override
    public void addBag(Bag guitarBag) {
        hsf.getCurrentSession().save(guitarBag);
    }
}
