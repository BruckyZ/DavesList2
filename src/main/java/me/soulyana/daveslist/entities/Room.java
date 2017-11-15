package me.soulyana.daveslist.entities;

import org.springframework.jdbc.support.incrementer.AbstractDataFieldMaxValueIncrementer;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Size(min=10)
    private String address;

    @NotNull
    @Size(min = 3)
    private String city;

    @NotNull
    @Size(min= 2)
    private String state;

    @NotNull
    @Size(min=1)
    private int price;

    @NotNull
    @Size(min=10)
    private String description;

    @NotNull
    @Size(min=10)
    private String rules;

    @NotNull
    @Size(min=2)
    private boolean wifi;

    @NotNull
    @Size(min=4)
    private String cable;

    @NotNull
    @Size(min=2)
    private boolean privateBTH;

    @NotNull
    @Size(min=2)
    private boolean isRented;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(joinColumns = @JoinColumn(name = "room_id"), inverseJoinColumns = @JoinColumn(name = "admin_id"))
    private Set<Admin> rooms;

    public Room() {
        rooms = new HashSet<>();
    }


    public Room(String address, String city, String state, int price, String description, String rules, boolean wifi, String cable, boolean privateBTH, boolean isRented) {
        this.address = address;
        this.city = city;
        this.state = state;
        this.price = price;
        this.description = description;
        this.rules = rules;
        this.wifi = wifi;
        this.cable = cable;
        this.privateBTH = privateBTH;
        this.isRented = isRented;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }

    public boolean isWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    public String getCable() {
        return cable;
    }

    public void setCable(String cable) {
        this.cable = cable;
    }

    public boolean isPrivateBTH() {
        return privateBTH;
    }

    public void setPrivateBTH(boolean privateBTH) {
        this.privateBTH = privateBTH;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    public Set<Admin> getRooms() {
        return rooms;
    }

    public void setRooms(Set<Admin> rooms) {
        this.rooms = rooms;
    }

    public void addRooms(Admin aRoom) {
        rooms.add(aRoom);
    }
}
