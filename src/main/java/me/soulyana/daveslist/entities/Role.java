package me.soulyana.daveslist.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Role
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique=true)
    private String role;

    @ManyToMany(mappedBy = "roles",fetch=FetchType.LAZY)
    private Set<Room> users;

    public Role() {
    }


    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }

    public Set<Room> getUsers()
    {
        return users;
    }

    public void setUsers(Set<Room> users)
    {
        this.users = users;
    }
}
