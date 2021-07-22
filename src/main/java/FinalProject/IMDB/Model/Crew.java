package FinalProject.IMDB.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "crew")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Crew {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String info;
    private String role;
    private String birth;

    @ManyToMany(mappedBy = "crew")
    private Set<Movie> movies = new HashSet<>();

}