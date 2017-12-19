package sample.demo.database.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by pkumar on 29/6/17.
 */

@Entity
@Table(name = "SM_ROLE")
public class Role implements Serializable {

    @Id
    @Column(name = "ROLE_ID")
    private String roleId;

    @Column(name = "DISPLAYNAME")
    private String displayName;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "WEBFRAMEWORKROLENUMBER")
    private int webframeworkRoleNumber;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getWebframeworkRoleNumber() {
        return webframeworkRoleNumber;
    }

    public void setWebframeworkRoleNumber(int webframeworkRoleNumber) {
        this.webframeworkRoleNumber = webframeworkRoleNumber;
    }
}
