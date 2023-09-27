package com.example.mvc_boot.DAO;

import com.example.mvc_boot.model.User;
import org.springframework.stereotype.Repository;

import jakarta.persistence.*;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDAO{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    public User getUserById(Long id) {
        TypedQuery<User> typedQuery = entityManager.createQuery("SELECT u FROM User u WHERE u.id = :id",User.class);
        typedQuery.setParameter("id", id);
        return typedQuery.getSingleResult();
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void delete(Long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public void updateUser(Long id, User updateUser) {
        User user = entityManager.find(User.class, id);
        user.setFirstName(updateUser.getFirstName());
        user.setLastName(updateUser.getLastName());
        user.setGender(updateUser.getGender());
        user.setNationality(updateUser.getNationality());
        entityManager.persist(user);
    }
}
