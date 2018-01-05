package sample.jee.bean;

import sample.jee.bean.jpa.DistributionGrouping;
import sample.jee.bean.jpa.DistributionGroupingHierarchy;
import sample.jee.bean.jpa.DistributionGroupingType;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * @author pkumar on 28/12/17
 * @project javaEESamples
 */

@Stateless(name = "DistributionGroupingManagerBean", mappedName = "sample/DistributionGroupingManagerBean")
public class DistributionGroupingManagerBean implements DistributionGroupingManager {

    @PersistenceContext(unitName = "sample.db2.pu")
    private EntityManager entityManager;

    @Override
    public DistributionGrouping findDistributionGrouping(String name) {

        Query query = entityManager.createNamedQuery("DistributionGrouping.getDistributionGroupingByName");
        query.setParameter("name", name);
        DistributionGrouping distributionGrouping = (DistributionGrouping) query.getSingleResult();
        return distributionGrouping;
    }

    @Override
    public DistributionGroupingType findDistributionGroupingType(String name) {

        Query query = entityManager.createNamedQuery("DistributionGroupingType.getDistributionGroupingTypeByName");
        query.setParameter("name", name);
        DistributionGroupingType distributionGroupingType = (DistributionGroupingType) query.getSingleResult();
        return distributionGroupingType;
    }

    @Override
    public DistributionGroupingHierarchy findDistributionGroupingHierarchyByDistGroupingId(Long distGroupingId) {

        Query query = entityManager.createNamedQuery("DistributionGroupingHierarchy.getDistributionGroupingHierarchyByDistGroupingId");
        query.setParameter("distGroupingId", distGroupingId);
        DistributionGroupingHierarchy distributionGroupingHierarchy = (DistributionGroupingHierarchy) query.getSingleResult();
        return distributionGroupingHierarchy;
    }
}
