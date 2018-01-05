package sample.jee.bean;

import sample.jee.bean.jpa.DistributionGrouping;
import sample.jee.bean.jpa.DistributionGroupingHierarchy;
import sample.jee.bean.jpa.DistributionGroupingType;

import javax.ejb.Remote;

/**
 * @author pkumar on 28/12/17
 * @project javaEESamples
 */

@Remote
public interface DistributionGroupingManager {

    public static final String JNDI_NAME = "sample/DistributionGroupingManagerBean";

    public DistributionGrouping findDistributionGrouping(String name);

    public DistributionGroupingType findDistributionGroupingType(String name);

    public DistributionGroupingHierarchy findDistributionGroupingHierarchyByDistGroupingId(Long distGroupingId);
}
