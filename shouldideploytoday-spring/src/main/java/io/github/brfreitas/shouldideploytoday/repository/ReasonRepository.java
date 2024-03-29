package io.github.brfreitas.shouldideploytoday.repository;

import io.github.brfreitas.shouldideploytoday.model.Reason;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReasonRepository extends CrudRepository<Reason, Long> {

    @Query(value = "SELECT * FROM REASONS ORDER BY RANDOM() limit 1", nativeQuery = true)
    public Optional<Reason> findRandom();

}
