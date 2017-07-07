package br.com.meublog.model.connection;

import javax.persistence.EntityManager;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author fernando
 */
public class ConnectionTest {

    private final EntityManager entityManager;

    public ConnectionTest() {
        entityManager = DBConnection.newInstance().getEntityManager();
    }

    @Test
    public void hasValidConnection() {
        Assert.assertNotNull(entityManager);
        Assert.assertTrue(entityManager.isOpen());
    }
}
