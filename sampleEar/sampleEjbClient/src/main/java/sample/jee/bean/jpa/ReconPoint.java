package sample.jee.bean.jpa;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author pkumar on 18/12/17
 * @project javaEESamples
 */

@Entity
@Table(name = "FJCMSRCPPF")
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

        private String grpNo;

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
    }
}
