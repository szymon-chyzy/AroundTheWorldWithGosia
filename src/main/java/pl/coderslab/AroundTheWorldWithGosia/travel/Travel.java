package pl.coderslab.AroundTheWorldWithGosia.travel;

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
@Table(name = "travels")
public class Travel extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Size(min = 2)
    @Column(name = "place")
    private String place;

//    @Column(name = "date")
//    private LocalDateTime date;

    @Size(max = 2000)
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Size(max = 2000)
    @Column(name = "curio", columnDefinition = "TEXT")
    private String curio;

    @Size(min = 2)
    @URL
    @Column(name = "landscapeUrl")
    private String landscapeUrl;

 /*   @NotEmpty(groups = {TravelValidationGroup.class})
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "travel_users", joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "userId"))
    private List<User> users = new ArrayList<>();
*/
}
