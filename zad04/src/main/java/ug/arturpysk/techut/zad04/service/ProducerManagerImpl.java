package ug.arturpysk.techut.zad04.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ug.arturpysk.techut.zad04.domain.Guitar;
import ug.arturpysk.techut.zad04.domain.Owner;
import ug.arturpysk.techut.zad04.domain.Producer;
import ug.arturpysk.techut.zad04.domain.Serial;

@Component
@Transactional
public class ProducerManagerImpl implements ProducerManager {

	@Autowired
	SessionFactory hsf;
	
	@Override
	public void assignGuitar(long guitarId, long producerId) {
		Guitar guitar = (Guitar)hsf.getCurrentSession().get(Guitar.class, guitarId);
		Producer producer = (Producer)hsf.getCurrentSession().get(Producer.class, producerId);
		
		producer.getGuitars().add(guitar);
	}
	
    @Override
    public Producer findById(long id) {
        return (Producer) hsf.getCurrentSession().get(Producer.class, id);
    }
	
	@Override
	public void addProducer(Producer producer) {
		hsf.getCurrentSession().save(producer);
	}
}
