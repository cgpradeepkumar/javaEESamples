package sample.jee.bean.jpa;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * @author pkumar on 22/12/17
 * @project javaEESamples
 */

@Entity
@Table(name = "DISTRIBUTION_GROUPING_HIERARCHY")
@NamedQuery(name = "DistributionGroupingHierarchy.getDistributionGroupingHierarchyByDistGroupingId", query = "Select h From DistributionGroupingHierarchy h Where h.distributionGrouping.distGroupingId=:distGroupingId")
public class DistributionGroupingHierarchy implements Serializable {

    private static final long serialVersionUID = 4798713630450013719L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DIST_GROUPING_HIERARCHY_ID")
    private Integer distributionGroupingHierarchyId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "DIST_GROUPING_ID", referencedColumnName = "DIST_GROUPING_ID")
    private DistributionGrouping distributionGrouping;

    @OneToMany(mappedBy = "parentDistributionGroupingHierarchy", fetch = FetchType.EAGER)
    private Collection<DistributionGroupingHierarchy> childDistributionGroupingHierarchies;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "DIST_GROUPING_PARENT_ID", referencedColumnName = "DIST_GROUPING_HIERARCHY_ID")
    private DistributionGroupingHierarchy parentDistributionGroupingHierarchy;

    @OneToMany(mappedBy = "distributionGroupingHierarchy", fetch = FetchType.EAGER)
    private Collection<ReconPointDistributionContact> reconPointDistributionContacts;

    public Integer getDistributionGroupingHierarchyId() {
        return distributionGroupingHierarchyId;
    }

    public void setDistributionGroupingHierarchyId(Integer distributionGroupingHierarchyId) {
        this.distributionGroupingHierarchyId = distributionGroupingHierarchyId;
    }

    public DistributionGrouping getDistributionGrouping() {
        return distributionGrouping;
    }

    public void setDistributionGrouping(DistributionGrouping distributionGrouping) {
        this.distributionGrouping = distributionGrouping;
    }

    public Collection<DistributionGroupingHierarchy> getChildDistributionGroupingHierarchies() {
        return childDistributionGroupingHierarchies;
    }

    public void setChildDistributionGroupingHierarchies(Collection<DistributionGroupingHierarchy> childDistributionGroupingHierarchies) {
        this.childDistributionGroupingHierarchies = childDistributionGroupingHierarchies;
    }

    public DistributionGroupingHierarchy getParentDistributionGroupingHierarchy() {
        return parentDistributionGroupingHierarchy;
    }

    public void setParentDistributionGroupingHierarchy(DistributionGroupingHierarchy parentDistributionGroupingHierarchy) {
        this.parentDistributionGroupingHierarchy = parentDistributionGroupingHierarchy;
    }

    public Collection<ReconPointDistributionContact> getReconPointDistributionContacts() {
        return reconPointDistributionContacts;
    }

    public void setReconPointDistributionContacts(Collection<ReconPointDistributionContact> reconPointDistributionContacts) {
        this.reconPointDistributionContacts = reconPointDistributionContacts;
    }
}
