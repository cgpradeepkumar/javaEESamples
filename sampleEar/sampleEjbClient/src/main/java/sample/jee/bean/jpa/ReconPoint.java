package sample.jee.bean.jpa;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author pkumar on 18/12/17
 * @project javaEESamples
 */

@Entity
@Table(name = "FJCMSRCPPF")
@NamedQuery(name = "ReconPoint.findAll", query = "Select rcp From ReconPoint rcp")
public class ReconPoint implements Serializable {

    @EmbeddedId
    private PK pk;

    @Column(name = "MODIFYUSER")
    private String modifyName;

    @Column(name = "MODIFYDATE")
    private Timestamp modifyDate;

    public PK getPk() {
        return pk;
    }

    public void setPk(PK pk) {
        this.pk = pk;
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

    @Embeddable
    public static class PK implements Serializable, Cloneable {

        @Column(name = "GRPNO")
        private String grpNo;

        @Column(name = "RCPNO")
        private Integer rcpNo;

        public PK() {
            super();
        }

        public PK(String grpNo, Integer rcpNo) {
            this();
            setGrpNo(grpNo);
            setRcpNo(rcpNo);
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
