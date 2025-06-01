package pb.com.Backend_PB;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;

import pb.com.Backend_PB.entities.Game;

@SpringBootTest
@AutoConfigureMockMvc
class BackendPbApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void testCreateGame() throws Exception {
		Game game = new Game();
		game.setName("Minecraft");
		game.setCategory("Open World");
		game.setImage_url("https://cdn2.steamgriddb.com/thumb/c5c70b4f428fe909028e1e0872be4ba8.jpg");
		game.setDeveloper("Mojang");
		game.setRelease_date("2011-11-18");
		game.setPrice(29.99);

		mockMvc.perform(post("/game")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(game)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name").value("Minecraft"));
	}

	@Test
	void testGetAllGames() throws Exception {
		mockMvc.perform(get("/game"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}

	@Test
	void testFindByCategory() throws Exception {
		mockMvc.perform(get("/game/category/Sandbox"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}

	// @Test
	// void testDuplicateGameInsertionBlocked() throws Exception {
	// 	Game game = new Game();
	// 	game.setName("Valorant");
	// 	game.setCategory("FPS");
	// 	game.setImage_url("https://cdn2.steamgriddb.com/thumb/c5c70b4f428fe909028e1e0872be4ba8.jpg");
	// 	game.setDeveloper("Riot Games");
	// 	game.setRelease_date("2020-06-02");
	// 	game.setPrice(0.00);

	// 	// essa deve funcionar
	// 	mockMvc.perform(post("/game")
	// 			.contentType(MediaType.APPLICATION_JSON)
	// 			.content(objectMapper.writeValueAsString(game)))
	// 			.andExpect(status().isOk());

	// 	// essa deve falhar por ser igual
	// 	mockMvc.perform(post("/game")
	// 			.contentType(MediaType.APPLICATION_JSON)
	// 			.content(objectMapper.writeValueAsString(game)))
	// 			.andExpect(status().is5xxServerError());
	// }
}