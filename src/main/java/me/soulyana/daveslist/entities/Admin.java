package me.soulyana.daveslist.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true)
    private String admin;

    @ManyToMany(mappedBy = "rooms", fetch = FetchType.LAZY)
    private Set<Room> admins;

    public Admin() {

    }

    public Admin(String admin) {
        this.admin = admin;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public Set<Room> getAdmins() {
        return admins;
    }

    public void setAdmins(Set<Room> admins) {
        this.admins = admins;
    }
}
