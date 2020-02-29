package pl.coderslab.AroundTheWorldWithGosia.user;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserRepository {

    @PersistenceContext
    EntityManager entityManager;

    public User create(User user) {
        entityManager.persist(user);
        return user;
    }

    public void update(User user) { entityManager.merge(user);}

    public User findById(long id) {
        return entityManager.find(User.class, id);
    }

    public void delete(User user) {
        entityManager.remove(entityManager.contains(user) ?
                user : entityManager.merge(user));
    }

    public List<User> findAll() {
        Query query = entityManager.createQuery("SELECT b FROM User b ORDER BY id DESC");
        return query.getResultList();
    }
}
