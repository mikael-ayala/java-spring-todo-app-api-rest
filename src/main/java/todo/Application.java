package todo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info = @Info(title = "To Do App API", version = "1", description = "To Do App REST API using Spring"))
@SpringBootApplication
public class Application {
	public String PORT = System.getenv("PORT");
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
