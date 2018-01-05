package sample.jee.bean.jpa;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * @author pkumar on 21/12/17
 * @project javaEESamples
 */

@Entity
@Table(name = "FJRCPDISTPF")
public class ReconPointDistribution implements Serializable {

    private static final long serialVersionUID = -62252128436033493L;

    @EmbeddedId
    private PK pk;

    @Column(name = "DISTMEDIUM")
    private String distMedium;

    @Column(name = "MODIFYUSER")
    private String modifyName;

    @Column(name = "MODIFYDATE")
    private Timestamp modifyDate;

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "GRPNO", nullable = false), @JoinColumn(name = "RCPNO", nullable = false)})
    private ReconPoint reconPoint;

    @OneToMany(mappedBy = "reconPointDistribution", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Collection<ReconPointDistributionContact> reconPointDistributionContacts;

    public ReconPointDistribution() {
        super();
        setPk(new PK());
        setDistMedium("EMAIL");
    }

    public ReconPointDistribution(String grpNo, Integer rcpNo, String distCode, String distMedium) {
        this();
        getPk().setGrpNo(grpNo);
        getPk().setRcpNo(rcpNo);
        getPk().setDistCode(distCode);
        setDistMedium(distMedium);
    }

    public PK getPk() {
        return pk;
    }

    public void setPk(PK pk) {
        this.pk = pk;
    }

    public String getDistMedium() {
        return distMedium;
    }

    public void setDistMedium(String distMedium) {
        this.distMedium = distMedium;
    }

    public String getModifyName() {
        return modifyName;
    }

    public void setModifyName(String modifyName) {
        this.modifyName = modifyName;
    }

    public Timestamp getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Timestamp modifyDate) {
        this.modifyDate = modifyDate;
    }

    public ReconPoint getReconPoint() {
        return reconPoint;
    }

    public void setReconPoint(ReconPoint reconPoint) {
        this.reconPoint = reconPoint;
    }

    public Collection<ReconPointDistributionContact> getReconPointDistributionContacts() {
        return reconPointDistributionContacts;
    }

    public void setReconPointDistributionContacts(Collection<ReconPointDistributionContact> reconPointDistributionContacts) {
        this.reconPointDistributionContacts = reconPointDistributionContacts;
    }

    @Embeddable
    public static class PK implements Serializable, Cloneable {

        private static final long serialVersionUID = 1065730316729077592L;

        @Column(name = "GRPNO")
        private String grpNo;

        @Column(name = "RCPNO")
        private Integer rcpNo;

        @Column(name = "DISTCODE")
        private String distCode;

        public PK() {
            super();
        }

        public PK(String grpNo, Integer rcpNo, String distCode) {
            this();
            setGrpNo(grpNo);
            setRcpNo(rcpNo);
            setDistCode(distCode);
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
