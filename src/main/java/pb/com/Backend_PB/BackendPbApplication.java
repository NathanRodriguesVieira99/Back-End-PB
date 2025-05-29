package pb.com.Backend_PB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendPbApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendPbApplication.class, args);
		System.out.println("Server is running on http://localhost:8080 ");
	}

}
