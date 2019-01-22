package test.java.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import ug.arturpysk.techut.zad04.domain.Guitar;
import ug.arturpysk.techut.zad04.domain.Owner;
import ug.arturpysk.techut.zad04.domain.Producer;
import ug.arturpysk.techut.zad04.service.GuitarManager;
import ug.arturpysk.techut.zad04.service.OwnerManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class OwnerManagerTest {
	
	private static final double DELTA = 1e-15;
	
    @Autowired
    OwnerManager om;
    
    @Autowired
    GuitarManager gm;
    
    @Test
    public void addOwnerTest() {
    	Owner owner = new Owner("Adam", "Mickiewicz", 38);

        om.addOwner(owner);

        Owner retrieved = om.findById(owner.getId());

        assertEquals(owner.getId(), retrieved.getId());
    }
    
    @Test
    public void findOwnerByIdTest() {
    	Owner owner = new Owner("Adam", "Mickiewicz", 38);
        om.addOwner(owner);

        long id = owner.getId();

        Owner foundOwner = om.findById(id);

        assertEquals(owner.getId(), foundOwner.getId());
    }
    
    @Test
    public void deleteOwnerTest() {
        List<Owner> ownersBefore = om.getAllOwners();

    	Owner owner = new Owner("Adam", "Mickiewicz", 38);
        om.addOwner(owner);
        om.deleteOwner(owner);

        List<Owner> ownersAfter = om.getAllOwners();

        assertEquals(ownersBefore.size(), ownersAfter.size());
    }
    
    @Test
    public void updateOwnerCheck() {
    	Owner owner = new Owner("Adam", "Mickiewicz", 38);
        om.addOwner(owner);

        int newAge = 22;

        owner.setAge(newAge);

        om.updateOwner(owner);

        assertEquals(owner.getAge(), newAge, DELTA);
    }

    //One-To-Many Test
    @Test
    public void assignGuitarTest() {
    	Owner owner = new Owner("Arthur", "Jenkins", 24);
    	Owner owner2 = new Owner("Michael", "Trevor", 28);
    	
    	Producer producer = new Producer("Gibson");
        Guitar guitar = new Guitar(producer, 500, true);
        
        gm.addGuitar(guitar);
        om.addOwner(owner);
        om.addOwner(owner2);
        
        om.assignGuitar(guitar.getId(), owner.getId());
        om.assignGuitar(guitar.getId(), owner2.getId());
        
        Assert.assertTrue(owner.getAllGuitars().contains(guitar));
        Assert.assertTrue(owner2.getAllGuitars().contains(guitar));
    }
}
