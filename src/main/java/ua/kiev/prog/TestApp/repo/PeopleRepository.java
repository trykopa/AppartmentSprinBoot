package ua.kiev.prog.TestApp.repo;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.kiev.prog.TestApp.model.App;
import ua.kiev.prog.TestApp.model.People;

import java.util.List;

public interface PeopleRepository extends JpaRepository<People, Long> {
    @Query("SELECT c FROM People c WHERE c.app = :app")
    List<People> findByApp(@Param("app") App app);

    @Query("SELECT COUNT(c) FROM People c WHERE c.app = :app")
    long countByApp(@Param("app") App app);
}
