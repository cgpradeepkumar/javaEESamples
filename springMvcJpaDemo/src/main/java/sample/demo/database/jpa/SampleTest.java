package sample.demo.database.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "SAMPLE_TEST")
public class SampleTest implements Serializable {

    @Id
    @Column(name = "TECH_ID")
    private Integer techId;

    @Column(name = "TECH_NAME")
    private String techName;

    @Column(name = "TECH_DESC")
    private String techDesc;

    @Column(name = "TECH_TYPE")
    private String techType;

    @Column(name = "PROVIDER")
    private String provider;

    public Integer getTechId() {
        return techId;
    }

    public void setTechId(Integer techId) {
        this.techId = techId;
    }

    public String getTechName() {
        return techName;
    }

    public void setTechName(String techName) {
        this.techName = techName;
    }

    public String getTechDesc() {
        return techDesc;
    }

    public void setTechDesc(String techDesc) {
        this.techDesc = techDesc;
    }

    public String getTechType() {
        return techType;
    }

    public void setTechType(String techType) {
        this.techType = techType;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }
}
