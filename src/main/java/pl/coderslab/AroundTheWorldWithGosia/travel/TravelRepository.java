package pl.coderslab.AroundTheWorldWithGosia.travel;

import org.springframework.stereotype.Repository;
import pl.coderslab.AroundTheWorldWithGosia.user.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class TravelRepository {

    @PersistenceContext
    EntityManager entityManager;

    public Travel create(Travel travel) {
        entityManager.persist(travel);
        return travel;
    }

    public void update(Travel travel) { entityManager.merge(travel);}

    public Travel findById(long id) {
        return entityManager.find(Travel.class, id);
    }

    public void delete(Travel travel) {
        entityManager.remove(entityManager.contains(travel) ?
                travel : entityManager.merge(travel));
    }

    public List<Travel> findAll() {
        Query query = entityManager.createQuery("SELECT b FROM Travel b ORDER BY id DESC");
        return query.getResultList();
    }
}
