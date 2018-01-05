package sample.jee.bean.jpa;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * @author pkumar on 22/12/17
 * @project javaEESamples
 */

@Entity
@Table(name = "DISTRIBUTION_GROUPING")
@NamedQuery(name = "DistributionGrouping.getDistributionGroupingByName", query = "Select g From DistributionGrouping g Where g.distGroupingDesc=:name")
public class DistributionGrouping implements Serializable {

    private static final long serialVersionUID = -893685548983373394L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DIST_GROUPING_ID")
    private Long distGroupingId;

    @Column(name = "DIST_GROUPING_DESC")
    private String distGroupingDesc;

    @ManyToOne
    @JoinColumn(name = "DIST_GROUPING_TYPE_ID", referencedColumnName = "DIST_GROUPING_TYPE_ID", nullable = false)
    private DistributionGroupingType distributionGroupingType;

    @OneToMany(mappedBy = "distributionGrouping")
    private Collection<DistributionGroupingHierarchy> distributionGroupingHierarchies;

    public Long getDistGroupingId() {
        return distGroupingId;
    }

    public void setDistGroupingId(Long distGroupingId) {
        this.distGroupingId = distGroupingId;
    }

    public String getDistGroupingDesc() {
        return distGroupingDesc;
    }

    public void setDistGroupingDesc(String distGroupingDesc) {
        this.distGroupingDesc = distGroupingDesc;
    }

    public DistributionGroupingType getDistributionGroupingType() {
        return distributionGroupingType;
    }

    public void setDistributionGroupingType(DistributionGroupingType distributionGroupingType) {
        this.distributionGroupingType = distributionGroupingType;
    }

    public Collection<DistributionGroupingHierarchy> getDistributionGroupingHierarchies() {
        return distributionGroupingHierarchies;
    }

    public void setDistributionGroupingHierarchies(Collection<DistributionGroupingHierarchy> distributionGroupingHierarchies) {
        this.distributionGroupingHierarchies = distributionGroupingHierarchies;
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
}
