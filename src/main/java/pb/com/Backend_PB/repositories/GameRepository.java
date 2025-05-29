package pb.com.Backend_PB.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pb.com.Backend_PB.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> {
  List<Game> findByCategory(String category);
}
