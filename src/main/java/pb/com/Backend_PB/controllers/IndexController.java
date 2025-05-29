package pb.com.Backend_PB.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class IndexController {

  @RequestMapping("/")
  @GetMapping
  public String mainRoute() {
    return "ok";
  }

}
