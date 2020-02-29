package pl.coderslab.AroundTheWorldWithGosia.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.coderslab.AroundTheWorldWithGosia.abstractEntity.AbstractEntity;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private Long id;

    @Size(min = 2, max = 13)
    @Column(name = "userName")
    private String name;

    @Size(min = 2, max = 21)
    @Column(name = "userFav")
    private String fav;

    @Size(max = 21)
    @Column(name = "userDescribe", columnDefinition = "TEXT")
    private String describe;
}