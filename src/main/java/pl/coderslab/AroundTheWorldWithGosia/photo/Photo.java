package pl.coderslab.AroundTheWorldWithGosia.photo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;
import pl.coderslab.AroundTheWorldWithGosia.abstractEntity.AbstractEntity;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "photos")
public class Photo extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "photoId")
    private Long id;

    @Size(min = 2)
    @URL
    @Column(name = "photoUrl")
    private String photoUrl;

}
