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

import ug.arturpysk.techut.zad04.domain.Guitar;
import ug.arturpysk.techut.zad04.domain.Producer;
import ug.arturpysk.techut.zad04.service.GuitarManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class GuitarManagerTest {
	
	private static final double DELTA = 1e-15;

    @Autowired
    GuitarManager gm;

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
}
