package noesis.repository;

import noesis.domain.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, String> {
    Reservation save(Reservation entity);
    Reservation findByReservationId(String reservationId);
    List<Reservation> findAll();
    void delete(Reservation entity);
}
