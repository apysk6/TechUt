package test.java.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import ug.arturpysk.techut.zad04.domain.Bag;
import ug.arturpysk.techut.zad04.domain.Guitar;
import ug.arturpysk.techut.zad04.domain.Owner;
import ug.arturpysk.techut.zad04.domain.Producer;
import ug.arturpysk.techut.zad04.domain.Serial;
import ug.arturpysk.techut.zad04.service.CaseManager;
import ug.arturpysk.techut.zad04.service.GuitarManager;
import ug.arturpysk.techut.zad04.service.OwnerManager;
import ug.arturpysk.techut.zad04.service.SerialManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class GuitarManagerTest {
	
	private static final double DELTA = 1e-15;

    @Autowired
    GuitarManager gm;
    
    @Autowired
    OwnerManager om;

    @Autowired
    SerialManager sm;
    
    @Autowired
    CaseManager cm;
    
    @Test
    public void addGuitarTest() {
    	Producer producer = new Producer("Gibson");
        Guitar guitar = new Guitar(producer, 500, true);

        gm.addGuitar(guitar);

        Guitar retrieved = gm.findById(guitar.getId());

        assertEquals(guitar.getId(), retrieved.getId());
    }

    @Test
    public void findGuitarByIdTest() {
    	Producer producer = new Producer("Gibson");
        Guitar guitar = new Guitar(producer, 500, true);
        gm.addGuitar(guitar);

        long id = guitar.getId();

        Guitar foundGuitar = gm.findById(id);

        assertEquals(guitar.getId(), foundGuitar.getId());
    }

    @Test
    public void deleteGuitarTest() {
        List<Guitar> guitarsBefore = gm.getAllGuitars();

    	Producer producer = new Producer("Gibson");
        Guitar guitar = new Guitar(producer, 500, true);
        gm.addGuitar(guitar);
        gm.deleteGuitar(guitar);

        List<Guitar> guitarsAfter = gm.getAllGuitars();

        assertEquals(guitarsBefore.size(), guitarsAfter.size());
    }
    
    //One-To-Many Test
    @Test
    public void guitarOwnersCheck() {
    	Producer producer = new Producer("Gibson");
        Guitar guitar = new Guitar(producer, 500, true);
        gm.addGuitar(guitar);
        
    	Owner owner = new Owner("Arthur", "Jenkins", 24);
    	Owner owner2 = new Owner("Donald", "McDonald", 21);
    	
    	om.addOwner(owner);
    	om.addOwner(owner2);
    	
    	gm.assignOwner(guitar.getId(), owner.getId());
    	
    	List<Owner> owners = gm.getGuitarOwners(guitar);
    	assertEquals(1, owners.size());
    	
    	gm.assignOwner(guitar.getId(), owner2.getId());
    	owners = gm.getGuitarOwners(guitar);
    	assertEquals(2, owners.size());
    }

    @Test
    public void updateGuitarCheck() {
    	Producer producer = new Producer("Gibson");
        Guitar guitar = new Guitar(producer, 500, true);
        gm.addGuitar(guitar);

        double newPrice = 1;

        guitar.setPrice(newPrice);

        gm.updateGuitar(guitar);

        assertEquals(guitar.getPrice(), newPrice, DELTA);
    }
    
    //One-To-One Test
    @Test
    public void assignSerialTest() {
    	Serial serial = new Serial(1234);
    	sm.addSerial(serial);
    	
    	Producer producer = new Producer("Gibson");
        Guitar guitar = new Guitar(producer, 500, true);
        gm.addGuitar(guitar);
        
        gm.assignSerial(guitar.getId(), serial.getId());
        
        assertEquals(guitar.getSerial().getSerialNumber(), serial.getSerialNumber());
    }
    
    //Many-To-Many Test
    @Test
    public void assignGuitarAndCasesTest() {
    	Bag guitarCase = new Bag("blue", 100, 200);
    	Bag guitarCase2 = new Bag("yellow", 200, 300);
    	
        Guitar guitar = new Guitar(500, true);
        Guitar guitar2 = new Guitar(800, true);
        
        gm.addGuitar(guitar);
        gm.addGuitar(guitar2);
        
        cm.addCase(guitarCase);
        cm.addCase(guitarCase2);
        
        gm.assignGuitarAndCase(guitar.getId(), guitarCase.getId());
        gm.assignGuitarAndCase(guitar.getId(), guitarCase2.getId());
        gm.assignGuitarAndCase(guitar2.getId(), guitarCase.getId());
        gm.assignGuitarAndCase(guitar2.getId(), guitarCase2.getId());
        
        assertEquals(2, guitar.getCases().size());
        assertEquals(2, guitar2.getCases().size());
    }
    
}
