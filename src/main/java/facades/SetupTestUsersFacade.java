package facades;

import entities.Dislike;
import entities.Like;
import entities.Role;
import entities.User;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class SetupTestUsersFacade {

    public static void main(String[] args) {
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        SetupTestUsersFacade setupTestUsersFacade = new SetupTestUsersFacade();
        setupTestUsersFacade.Populate(emf);
    }
    public void Populate(EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();

        // IMPORTAAAAAAAAAANT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        // This breaks one of the MOST fundamental security rules in that it ships with default users and passwords
        // CHANGE the three passwords below, before you uncomment and execute the code below
        // Also, either delete this file, when users are created or rename and add to .gitignore
        // Whatever you do DO NOT COMMIT and PUSH with the real passwords

        User user = new User("user", "MyPassword");
        User user2 = new User("lazzoro", "MyPassword");
        User admin = new User("admin", "MyPassword");
        User both = new User("user_admin", "MyPassword");

        if(admin.getUserPass().equals("test")||user.getUserPass().equals("test")||both.getUserPass().equals("test"))
            throw new UnsupportedOperationException("You have not changed the passwords");

        em.getTransaction().begin();
        Role userRole = new Role("user");
        Role adminRole = new Role("admin");
        user.addRole(userRole);
        user2.addRole(userRole);
        admin.addRole(adminRole);
        both.addRole(userRole);
        both.addRole(adminRole);
        em.persist(userRole);
        em.persist(adminRole);
        em.persist(user);
        em.persist(user2);
        em.persist(admin);
        em.persist(both);
        em.getTransaction().commit();
        System.out.println("PW: " + user.getUserPass());
        System.out.println("Testing user with OK password: " + user.verifyPassword("MyPassword"));
        System.out.println("Testing user with wrong password: " + user.verifyPassword("asdf"));
        System.out.println("Testing user with wrong password: " + user2.verifyPassword("asdf"));
        System.out.println("Created TEST Users");
    }

}
