package ug.arturpysk.techut.zad04.service;

import ug.arturpysk.techut.zad04.domain.Producer;
import ug.arturpysk.techut.zad04.domain.Serial;

public interface SerialManager {
	void addSerial(Serial serial);
	Serial findById(long serialId);
	Serial findBySerial(long serialNumber);
}
