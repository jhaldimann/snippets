package com.mentoring.snippets.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Table(name="USERS")
@Entity(name = "ForeignKeyAssoEntity")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder(toBuilder = true, builderClassName = "Builder")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String username;
    private String password;
    private int enabled;
}
