package test.java.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import ug.arturpysk.techut.zad04.domain.Guitar;
import ug.arturpysk.techut.zad04.domain.Producer;
import ug.arturpysk.techut.zad04.domain.Serial;
import ug.arturpysk.techut.zad04.service.ProducerManager;
import ug.arturpysk.techut.zad04.service.SerialManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class SerialManagerTest {

	private static final double DELTA = 1e-15;
	
    @Autowired
    SerialManager sm;
    
    @Test
    public void addSerialTest() {
    	Serial serial = new Serial(1234);

        sm.addSerial(serial);

        Serial retrieved = sm.findById(serial.getId());

        assertEquals(serial.getId(), retrieved.getId());
    }
    
    @Test
    public void findBySerialTest() {
    	Serial serial = new Serial(1234);
    	Serial serial2 = new Serial(1235);
    	
    	sm.addSerial(serial);
    	sm.addSerial(serial2);
    	
    	Serial received = sm.findBySerial(serial.getSerialNumber());
    	assertEquals(serial, received);
    }
}
