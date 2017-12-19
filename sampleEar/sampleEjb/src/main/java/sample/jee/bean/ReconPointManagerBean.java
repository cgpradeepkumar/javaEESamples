package sample.jee.bean;

import sample.jee.bean.jpa.ReconPoint;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author pkumar on 18/12/17
 * @project javaEESamples
 */

@Stateless(name = "reconPointManagerBean", mappedName = "sample/ReconPointManagerBean")
public class ReconPointManagerBean implements ReconPointManagerRemote {

    @PersistenceContext(name = "sample.db2.pu")
    private EntityManager entityManager;

    @Override
    public List<ReconPoint> findAll() {

        if(entityManager == null) {
            System.out.println("EntityManager cannot be null");
        } else {
            System.out.println("EntityManager is not null");
        }


        return null;
    }
}
