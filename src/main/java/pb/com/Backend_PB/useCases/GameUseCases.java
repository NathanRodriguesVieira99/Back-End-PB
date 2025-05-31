package pb.com.Backend_PB.useCases;

import java.util.List;

import org.springframework.stereotype.Service;

import pb.com.Backend_PB.entities.Game;
import pb.com.Backend_PB.repositories.GameRepository;

@Service
public class GameUseCases {
    private final GameRepository gameRepository;

    public GameUseCases(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<Game> getAll() {
        return gameRepository.findAll();
    }

    public List<Game> findByCategory(String category) {
        return gameRepository.findByCategory(category);
    }

    public Game save(Game game) {
        return gameRepository.save(game);
    }
}
