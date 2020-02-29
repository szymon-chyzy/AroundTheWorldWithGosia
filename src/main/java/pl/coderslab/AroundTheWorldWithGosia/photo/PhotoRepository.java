package pl.coderslab.AroundTheWorldWithGosia.photo;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository("photoRepository")
@Transactional
public class PhotoRepository {

    @PersistenceContext
    EntityManager entityManager;

    public Photo create(Photo photo) {
        entityManager.persist(photo);
        return photo;
    }

    public void update(Photo photo) { entityManager.merge(photo);}

    public Photo findById(long id) {
        return entityManager.find(Photo.class, id);
    }

    public void delete(Photo photo) {
        entityManager.remove(entityManager.contains(photo) ?
                photo : entityManager.merge(photo));
    }

    public List<Photo> findAll() {
        Query query = entityManager.createQuery("SELECT b FROM Photo b ORDER BY id DESC");
        return query.getResultList();
    }
}