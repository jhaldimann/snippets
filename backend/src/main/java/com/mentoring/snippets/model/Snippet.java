package com.mentoring.snippets.model;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Getter @Setter
@ToString
@Table(name="SNIPPET")
@Entity(name = "ForeignKeyAssoAccountEntity")
@AllArgsConstructor
@RequiredArgsConstructor
@Builder(toBuilder = true, builderClassName = "Builder")
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
