package ug.arturpysk.techut.zad04.service;

import java.util.List;

import ug.arturpysk.techut.zad04.domain.Owner;

public interface OwnerManager {

    void addOwner(Owner owner);
    void updateOwner(Owner owner);
    void deleteOwner(Owner owner);
    List<Owner> getAllOwners();
    Owner findById(long id);

    void assignGuitar(Long guitarId, Long ownerId);
}
