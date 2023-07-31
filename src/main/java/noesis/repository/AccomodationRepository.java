package noesis.repository;

import noesis.domain.Accomodation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccomodationRepository extends CrudRepository<Accomodation, String> {
    Accomodation save(Accomodation entity);
    List<Accomodation> findAllByLocation(String location);
    void delete(Accomodation entity);
}
