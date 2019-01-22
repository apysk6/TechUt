package ug.arturpysk.techut.zad04.service;

import java.util.List;

import ug.arturpysk.techut.zad04.domain.Owner;
import ug.arturpysk.techut.zad04.domain.Producer;

public interface ProducerManager {
	void addProducer(Producer producer);
	Producer findById(long producerId);
	
	void assignGuitar(long gutiarId, long producerId);
}
