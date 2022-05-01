package com.mentoring.snippets.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter @Setter
@ToString
@Table(name="MEMBER")
@Entity(name = "ForeignKeyAssoEntity")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    private String username;
    private String password;
}
