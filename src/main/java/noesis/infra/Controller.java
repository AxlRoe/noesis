package noesis.infra;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import noesis.domain.Accomodation;
import noesis.domain.Reservation;
import noesis.dto.AccomodationDTO;
import noesis.dto.ReservationDTO;
import noesis.repository.AccomodationRepository;
import noesis.repository.ReservationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(value = "/")
@AllArgsConstructor
public class Controller {
    private ReservationRepository reservationRepository;
    private AccomodationRepository accomodationRepository;

    @PostMapping(value = "accomodation")
    public ResponseEntity<?> insertAccomodation(@Valid @RequestBody AccomodationDTO accomodationDTO) {
        Accomodation accomodation = AccomodationDTO.from(accomodationDTO);
        accomodation = accomodation.toBuilder()
                .accomodationId(UUID.randomUUID().toString())
                .build();

        accomodationRepository.save(accomodation);
        return ResponseEntity.ok(accomodation);
    }

    @PostMapping(value = "reservation/book/{accomodationid}")
    public ResponseEntity<?> book(@Valid @RequestBody ReservationDTO reservationDTO, @PathVariable String accomodationid) {

        Accomodation accomodation = accomodationRepository.findById(accomodationid)
        .orElse(null);

        Reservation reservation = ReservationDTO.from(reservationDTO);
        reservation = reservation.toBuilder()
                .reservationId(UUID.randomUUID().toString())
                .accomodation(accomodation)
                .build();

        reservationRepository.save(reservation);
        return ResponseEntity.ok(reservation);
    }

    @GetMapping(value = "accomodation/{location}")
    public ResponseEntity<?> searchAccomodation(@Valid @PathVariable String location) {
        return ResponseEntity.ok(accomodationRepository.findAllByLocation(location));
    }

    @GetMapping(value = "reservation/{reservationid}")
    public ResponseEntity<?> searchReservation(@Valid @PathVariable String reservationid) {
        return ResponseEntity.ok(reservationRepository.findByReservationId(reservationid));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> handleException(ConstraintViolationException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
