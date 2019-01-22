package ug.arturpysk.techut.zad04.service;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ug.arturpysk.techut.zad04.domain.Guitar;
import ug.arturpysk.techut.zad04.domain.Producer;
import ug.arturpysk.techut.zad04.domain.Serial;

@Component
@Transactional
public class SerialManagerImpl implements SerialManager {
	
	@Autowired
	SessionFactory hsf;
	
    @Override
    public Serial findBySerial(long serialNumber) {
    	Query query = hsf.getCurrentSession().createQuery("from Serial where serialNumber=:serial");
    	query.setParameter("serial", serialNumber);
    	
    	Serial receivedSerial = (Serial)query.uniqueResult();
    	
    	return receivedSerial;
    }
    
    @Override
    public Serial findById(long id) {
        return (Serial) hsf.getCurrentSession().get(Serial.class, id);
    }
	
	@Override
	public void addSerial(Serial serial) {
		hsf.getCurrentSession().save(serial);
	}

}
