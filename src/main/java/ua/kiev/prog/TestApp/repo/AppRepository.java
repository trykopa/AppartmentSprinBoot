package ua.kiev.prog.TestApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.kiev.prog.TestApp.model.App;

public interface AppRepository extends JpaRepository<App, Long> {
}
