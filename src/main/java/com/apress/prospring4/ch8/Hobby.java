package com.apress.prospring4.ch8;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "hobby")
public class Hobby {
    private String hobbyId;

    private Set<Contact> contacts = new HashSet<Contact>();

    @Id
    @Column(name = "HOBBY_ID")
    public String getHobbyId() {
        return hobbyId;
    }

    public void setHobbyId(String hobbyId) {
        this.hobbyId = hobbyId;
    }

    public String toStirng() {
        return "Hobby :" + getHobbyId();
    }

    @ManyToMany
    @JoinTable(name = "contact_hobby_detail",
    joinColumns = @JoinColumn(name = "HOBBY_ID"),
    inverseJoinColumns = @JoinColumn(name = "CONTACT_ID"))
    public Set<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }

}
