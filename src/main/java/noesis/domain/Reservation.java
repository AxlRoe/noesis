package noesis.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true, builderClassName = "Builder")
@Getter
@Entity
public class Reservation {

    @Id
    String reservationId;
    String checkinDate;
    String checkoutDate;
    Integer guests;

    @ManyToOne
    @JoinColumn(name="accomodationId", nullable=false)
    private Accomodation accomodation;

}
