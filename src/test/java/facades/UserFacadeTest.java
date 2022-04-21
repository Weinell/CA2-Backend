package facades;

import entities.Role;
import entities.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import security.errorhandling.AuthenticationException;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.*;

public class UserFacadeTest {

    private static EntityManagerFactory emf;

    @BeforeAll
    static void SetupClass() {
        emf = EMF_Creator.createEntityManagerFactoryForTest();
    }

    @BeforeEach
    void setup() {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.createQuery("delete from Role").executeUpdate();
        em.createQuery("delete from User").executeUpdate();
        em.getTransaction().commit();
        em.close();

        SetupTestUsersFacade setupTestUsersFacade = new SetupTestUsersFacade();
        setupTestUsersFacade.Populate(emf);
    }

    @Test
    void getVerifiedUser() throws AuthenticationException {
        UserFacade userFacade = UserFacade.getUserFacade(emf);
        User u = userFacade.getVeryfiedUser("user", "MyPassword");

        assertNotNull(u);
    }
}
