package pb.com.Backend_PB.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pb.com.Backend_PB.entities.Game;
import pb.com.Backend_PB.useCases.GameUseCases;

@RestController
@RequestMapping("/game")
public class GameController {
  private final GameUseCases gameUseCases;

  public GameController(GameUseCases gameUseCases) {
    this.gameUseCases = gameUseCases;
  };

  @GetMapping
  public List<Game> getAll() {
    return gameUseCases.getAll();
  }

  @PostMapping
  public Game create(@RequestBody Game game) {
    return gameUseCases.save(game);
  }

}
