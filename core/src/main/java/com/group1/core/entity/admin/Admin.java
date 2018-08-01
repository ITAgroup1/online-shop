package com.group1.core.entity.admin;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "t_admin")
public class Admin implements Serializable {

    @Id
    @GenericGenerator(name = "ug",strategy = "uuid")
    @GeneratedValue(generator = "ug")
    private String id;

    @Column(name = "loginName",nullable = false,length = 255)
    @NotBlank(message = "admin's loginName is null")
    private String loginName;

    @Column(name = "password",nullable = false,length = 255)
    @NotBlank(message = "admin's password is null")
    private String password;

    public Admin() {
    }

    public Admin(@NotBlank(message = "admin's loginName is null") String loginName, @NotBlank(message = "admin's password is null") String password) {
        this.loginName = loginName;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id='" + id + '\'' +
                ", loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Admin admin = (Admin) o;

        if (id != null ? !id.equals(admin.id) : admin.id != null) return false;
        if (loginName != null ? !loginName.equals(admin.loginName) : admin.loginName != null) return false;
        return password != null ? password.equals(admin.password) : admin.password == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (loginName != null ? loginName.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
