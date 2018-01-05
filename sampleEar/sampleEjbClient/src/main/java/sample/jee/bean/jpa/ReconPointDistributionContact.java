package sample.jee.bean.jpa;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author pkumar on 21/12/17
 * @project javaEESamples
 */

@Entity
@Table(name = "FJRCPDISTCONPF")
public class ReconPointDistributionContact implements Serializable {

    private static final long serialVersionUID = 8381467861001378396L;

    @EmbeddedId
    private PK pk;

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "GRPNO", nullable = false), @JoinColumn(name = "RCPNO", nullable = false), @JoinColumn(name = "DISTCODE", nullable = false)})
    private ReconPointDistribution reconPointDistribution;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "DIST_GROUPING_HIERARCHY_ID")
    private DistributionGroupingHierarchy distributionGroupingHierarchy;

    public ReconPointDistributionContact() {
        super();
        setPk(new PK());
    }

    public ReconPointDistributionContact(String grpNo, Integer rcpNo, String distCode, Integer crmId, Integer contactId) {
        this();
        getPk().setGrpNo(grpNo);
        getPk().setRcpNo(rcpNo);
        getPk().setDistCode(distCode);
        getPk().setCrmId(crmId);
        getPk().setContactId(contactId);
    }

    public PK getPk() {
        return pk;
    }

    public void setPk(PK pk) {
        this.pk = pk;
    }

    public ReconPointDistribution getReconPointDistribution() {
        return reconPointDistribution;
    }

    public void setReconPointDistribution(ReconPointDistribution reconPointDistribution) {
        this.reconPointDistribution = reconPointDistribution;
    }

    public DistributionGroupingHierarchy getDistributionGroupingHierarchy() {
        return distributionGroupingHierarchy;
    }

    public void setDistributionGroupingHierarchy(DistributionGroupingHierarchy distributionGroupingHierarchy) {
        this.distributionGroupingHierarchy = distributionGroupingHierarchy;
    }

    @Embeddable
    public static class PK implements Serializable, Cloneable {

        private static final long serialVersionUID = 2069690373065636301L;

        @Column(name = "GRPNO")
        private String grpNo;

        @Column(name = "RCPNO")
        private Integer rcpNo;

        @Column(name = "DISTCODE")
        private String distCode;

        @Column(name = "CRMID")
        private Integer crmId;

        @Column(name = "CONTACTID")
        private Integer contactId;

        public PK() {
            super();
        }

        public PK(String grpNo, Integer rcpNo, String distCode, Integer crmId, Integer contactId) {
            super();
            setGrpNo(grpNo);
            setRcpNo(rcpNo);
            setDistCode(distCode);
            setCrmId(crmId);
            setContactId(contactId);
        }

        public String getGrpNo() {
            return grpNo;
        }

        public void setGrpNo(String grpNo) {
            this.grpNo = grpNo;
        }

        public Integer getRcpNo() {
            return rcpNo;
        }

        public void setRcpNo(Integer rcpNo) {
            this.rcpNo = rcpNo;
        }

        public String getDistCode() {
            return distCode;
        }

        public void setDistCode(String distCode) {
            this.distCode = distCode;
        }

        public Integer getCrmId() {
            return crmId;
        }

        public void setCrmId(Integer crmId) {
            this.crmId = crmId;
        }

        public Integer getContactId() {
            return contactId;
        }

        public void setContactId(Integer contactId) {
            this.contactId = contactId;
        }

        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this);
        }

        @Override
        public int hashCode() {
            return HashCodeBuilder.reflectionHashCode(this);
        }

        @Override
        public boolean equals(Object obj) {
            return EqualsBuilder.reflectionEquals(this, obj);
        }
    }
}
