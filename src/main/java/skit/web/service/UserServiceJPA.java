package skit.web.service;

import skit.web.entity.Account;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
public class UserServiceJPA implements UserService{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addUser(Account user) {
        if (user == null) throw new UserServiceException("No user to add");
        entityManager.persist(user);
    }

    @Override
    public void payForDisk(String username, int payment) {
        if (payment < 0) throw new UserServiceException("Invalid payment");
        entityManager.createNamedQuery("Account.AddPayment").setParameter("payment", payment).setParameter("username", username).executeUpdate();
    }

}
