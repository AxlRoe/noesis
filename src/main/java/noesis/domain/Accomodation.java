package noesis.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true, builderClassName = "Builder")
@Getter
@Entity
public class Accomodation {

    @Id
    private String accomodationId;
    private Integer capacity;
    private String location;

    @OneToMany(mappedBy="accomodation")
    private Set<Reservation> reservations;

}
