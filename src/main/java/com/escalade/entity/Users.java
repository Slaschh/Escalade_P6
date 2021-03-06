package com.escalade.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

/**
 * @author Ramesh Fadatare
 */
@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false)
    @NotEmpty()
    private String name;
    @Column(nullable = false, unique = true)
    @NotEmpty
    private String email;
    @Column(nullable = false)
    @NotEmpty
    @Size(min = 4)
    private String password;
    @Column(name = "created_at")
    @CreationTimestamp
    private Date created_at;
    @Column(name = "update_at")
    @CreationTimestamp
    private Date update_at;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "user_role",
            joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")})
    private List<Role> roles;


    @OneToMany(mappedBy = "users")
    private List<Topo> topo;
    @OneToMany(mappedBy = "users")
    private List<Site> site;
    @OneToMany(mappedBy = "users")
    private List<Message> message;
    @OneToMany
    private List<Reservation> reservation;

    public List<Site> getSite() {
        return site;
    }

    public void setSite(List<Site> site) {
        this.site = site;
    }

    public List<Message> getMessage() {

        return message;
    }

    public void setMessage(List<Message> message) {
        this.message = message;
    }

    public List<Reservation> getReservation() {
        return reservation;
    }

    public void setReservation(List<Reservation> reservation) {
        this.reservation = reservation;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date createdAt) {
        this.created_at = createdAt;
    }

    public Date getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Date updateAt) {
        this.update_at = updateAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Topo> getTopo() {
        return topo;
    }

    public void setTopo(List<Topo> topo) {
        this.topo = topo;
    }


    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", createdAt=" + created_at +
                ", roles=" + roles +
                '}';
    }
}