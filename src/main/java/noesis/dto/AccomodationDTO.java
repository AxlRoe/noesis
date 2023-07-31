package noesis.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import noesis.domain.Accomodation;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true, builderClassName = "Builder")
@Getter
public class AccomodationDTO {

    @NotNull
    private Integer capacity;
    @NotNull
    private String location;

    public static Accomodation from(AccomodationDTO dto) {
        return Accomodation.builder()
                .location(dto.getLocation())
                .capacity(dto.getCapacity())
                .build();
    }

}
