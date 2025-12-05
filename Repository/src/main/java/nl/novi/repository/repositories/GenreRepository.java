package nl.novi.repository.repositories;

import nl.novi.repository.entities.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<GenreEntity, Long> {

    GenreEntity findByName(String name);

}



