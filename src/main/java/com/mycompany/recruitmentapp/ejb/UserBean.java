/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.recruitmentapp.ejb;

import com.mycompany.recruitmentapp.common.UserDetails;
import com.mycompany.recruitmentapp.entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Dani
 */
@Stateless
public class UserBean {

    @PersistenceContext
    private EntityManager entityManager;

    public List<UserDetails> getAllUsers() {
        try {
            List<User> users = (List<User>) entityManager.createQuery("SELECT u FROM User u").getResultList();
            return copyUsersToDetails(users);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    public List<UserDetails> copyUsersToDetails(List<User> users) {
        List <UserDetails> detailsList = new ArrayList<>();
        for (User user : users) {
            UserDetails userDetails = new UserDetails(user.getId(),
                    user.getUsername(),
                    user.getEmail(),
                    user.getPosition());
            detailsList.add(userDetails);
        }
        return detailsList;
    }
}
