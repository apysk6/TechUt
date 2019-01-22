package ug.arturpysk.techut.zad04.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ug.arturpysk.techut.zad04.domain.Guitar;
import ug.arturpysk.techut.zad04.domain.Owner;

@Component
@Transactional
public class OwnerManagerImpl implements OwnerManager {

	@Autowired
    SessionFactory hsf;

    @Override
    public void addOwner(Owner owner) {
        hsf.getCurrentSession().save(owner);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Owner> getAllOwners() {
        return hsf.getCurrentSession().getNamedQuery("owner.all").list();
    }

    @Override
    public Owner findById(long id) {
        return (Owner) hsf.getCurrentSession().get(Owner.class, id);
    }

    @Override
    public void updateOwner(Owner owner) {
        hsf.getCurrentSession().update(owner);
    }

    @Override
    public void deleteOwner(Owner owner) {
        hsf.getCurrentSession().delete(owner);
    }
    
    @Override
    public void assignGuitar(Long guitarId, Long ownerId) {
        Guitar guitar = (Guitar) hsf.getCurrentSession().get(Guitar.class, guitarId);
        Owner owner = (Owner) hsf.getCurrentSession().get(Owner.class, ownerId);
        owner.getAllGuitars().add(guitar);
    }
}
