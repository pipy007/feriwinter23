package si.nkbm.feriwinter.winterdemobackend;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Podjetje {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column
    @NotNull
    private String naziv;

    @Column
    private String naslov;

    @OneToMany
    private List<Oseba> zaposleni;
}
