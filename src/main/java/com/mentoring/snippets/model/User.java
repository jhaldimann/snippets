package com.mentoring.snippets.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter @Setter
@ToString
@Table(name="USERS")
@Entity(name = "ForeignKeyAssoEntity")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String username;
    private String password;
    private Boolean enabled;
}
