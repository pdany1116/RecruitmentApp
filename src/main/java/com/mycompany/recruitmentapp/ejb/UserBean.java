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

    public void createUser(String description, String firstName, String lastName, String internalFunction, String phone, String email, String passwordSha256, String position, String username) {
        User user = new User();
        user.setDescription(description);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setInternalFunction(internalFunction);
        user.setPhone(phone);
        user.setEmail(email);
        user.setPassword(passwordSha256);
        user.setPosition(position);
        user.setUsername(username);

        entityManager.persist(user);
    }

    public UserDetails findById(Integer userId) {
        User user = entityManager.find(User.class, userId);
        return new UserDetails(user.getId(),
                user.getDescription(),
                user.getFirstName(),
                user.getLastName(),
                user.getInternalFunction(),
                user.getPhone(),
                user.getEmail(),
                user.getPosition(),
                user.getUsername());
    }

    public List<UserDetails> getAllUsers() {
        try {
            List<User> users = (List<User>) entityManager.createQuery("SELECT u FROM User u").getResultList();
            return copyUsersToDetails(users);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    public List<UserDetails> copyUsersToDetails(List<User> users) {
        List<UserDetails> detailsList = new ArrayList<>();
        for (User user : users) {
            UserDetails userDetails = new UserDetails(user.getId(),
                    user.getDescription(),
                    user.getFirstName(),
                    user.getLastName(),
                    user.getInternalFunction(),
                    user.getPhone(),
                    user.getEmail(),
                    user.getPosition(),
                    user.getUsername());
            detailsList.add(userDetails);
        }
        return detailsList;
    }

    public void updateUser(Integer userId, String description, String firstName, String lastName, String email, String internalFunction, String phone, String position) {
        User user = entityManager.find(User.class, userId);
        user.setDescription(description);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setInternalFunction(internalFunction);
        user.setPhone(phone);
        user.setEmail(email);
        user.setPosition(position);
    }

    public void deleteUsersByIds(List<Integer> userIds) {
        for (Integer userId : userIds) {
            User user = entityManager.find(User.class, userId);
            entityManager.remove(user);
        }
    }
}
