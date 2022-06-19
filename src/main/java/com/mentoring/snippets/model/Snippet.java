package com.mentoring.snippets.model;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.List;

@Getter @Setter
@ToString
@Table(name="SNIPPET")
@Entity(name = "ForeignKeyAssoAccountEntity")
public class Snippet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    private String text;
    private String category;
    private String language;
    private String username;
}
