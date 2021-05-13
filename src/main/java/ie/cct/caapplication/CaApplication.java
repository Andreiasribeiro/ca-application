package ie.cct.caapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("ie.cct*")

public class CaApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(CaApplication.class, args);
	}

}
