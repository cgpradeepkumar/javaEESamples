package sample.jee.bean.jpa;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * @author pkumar on 28/12/17
 * @project javaEESamples
 */

@Entity
@Table(name = "DISTRIBUTION_GROUPING_TYPE")
@NamedQuery(name = "DistributionGroupingType.getDistributionGroupingTypeByName", query = "Select t From DistributionGroupingType t Where t.distGroupingTypeDesc=:name")
public class DistributionGroupingType implements Serializable {

    private static final long serialVersionUID = 1793716796744921404L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DIST_GROUPING_TYPE_ID")
    private Long distGroupingTypeId;

    @Column(name = "DIST_GROUPING_TYPE_DESC")
    private String distGroupingTypeDesc;

    @OneToMany(mappedBy = "distributionGroupingType")
    private Collection<DistributionGrouping> distributionGroupings;

    public Long getDistGroupingTypeId() {
        return distGroupingTypeId;
    }

    public void setDistGroupingTypeId(Long distGroupingTypeId) {
        this.distGroupingTypeId = distGroupingTypeId;
    }

    public String getDistGroupingTypeDesc() {
        return distGroupingTypeDesc;
    }

    public void setDistGroupingTypeDesc(String distGroupingTypeDesc) {
        this.distGroupingTypeDesc = distGroupingTypeDesc;
    }

    public Collection<DistributionGrouping> getDistributionGroupings() {
        return distributionGroupings;
    }

    public void setDistributionGroupings(Collection<DistributionGrouping> distributionGroupings) {
        this.distributionGroupings = distributionGroupings;
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
