package shopifyadvanced;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ShopifyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopifyApplication.class, args);
	}

}
