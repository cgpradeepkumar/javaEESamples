package sample.jee.bean;

import sample.jee.bean.jpa.ReconPoint;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * @author pkumar on 18/12/17
 * @project javaEESamples
 */

@Stateless(name = "ReconPointManagerBean", mappedName = "sample/ReconPointManagerBean")
public class ReconPointManagerBean implements ReconPointManagerRemote {

    @PersistenceContext(unitName = "sample.db2.pu")
    private EntityManager entityManager;

    @Override
    public List<ReconPoint> findAll() {

        if(entityManager == null) {
            System.out.println("EntityManager cannot be null");
        } else {
            System.out.println("EntityManager is not null");
        }

        Query query = entityManager.createNamedQuery("ReconPoint.findAll");
        List<ReconPoint> reconPointList = query.getResultList();

        return reconPointList;
    }

    @Override
    public ReconPoint find(String grpNo, Integer rcpNo) {

        ReconPoint reconPoint = entityManager.find(ReconPoint.class, new ReconPoint.PK(grpNo, rcpNo));
        return reconPoint;
    }

    @Override
    public ReconPoint save(ReconPoint reconPoint) {

        reconPoint = entityManager.merge(reconPoint);

        return reconPoint;
    }
}
