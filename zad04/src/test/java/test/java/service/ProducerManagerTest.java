package test.java.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import ug.arturpysk.techut.zad04.domain.Guitar;
import ug.arturpysk.techut.zad04.domain.Producer;
import ug.arturpysk.techut.zad04.service.GuitarManager;
import ug.arturpysk.techut.zad04.service.OwnerManager;
import ug.arturpysk.techut.zad04.service.ProducerManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class ProducerManagerTest {

	private static final double DELTA = 1e-15;
	
    @Autowired
    ProducerManager pm;
    
    @Autowired
    GuitarManager gm;
    
    //Many-To-One Test.
    @Test
    public void assignGuitarsTest() {
    	Producer producer = new Producer("Gibson");

        pm.addProducer(producer);
        
        Guitar guitar = new Guitar(400, false);
        Guitar guitar2 = new Guitar(800, true);
        gm.addGuitar(guitar);
        gm.addGuitar(guitar2);
        
        pm.assignGuitar(guitar.getId(), producer.getId());
        pm.assignGuitar(guitar2.getId(), producer.getId());
        
        assertTrue(producer.getGuitars().contains(guitar));
        assertTrue(producer.getGuitars().contains(guitar2));
        assertEquals(2, producer.getGuitars().size());
    }
    
    @Test
    public void addProducerTest() {
    	Producer producer = new Producer("Gibson");

        pm.addProducer(producer);

        Producer retrieved = pm.findById(producer.getId());

        assertEquals(producer.getId(), retrieved.getId());
    }

}
