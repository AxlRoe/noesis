package noesis.dto;

import lombok.*;
import noesis.domain.Reservation;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true, builderClassName = "Builder")
@Getter
public class ReservationDTO {

    @NotNull
    private String checkinDate;
    @NotNull
    private String checkoutDate;

    @NotNull
    private Integer guests;

    public static Reservation from(ReservationDTO dto) {
        return Reservation.builder()
                .checkinDate(dto.checkinDate)
                .checkoutDate(dto.checkoutDate)
                .guests(dto.getGuests())
                .build();
    }

}
