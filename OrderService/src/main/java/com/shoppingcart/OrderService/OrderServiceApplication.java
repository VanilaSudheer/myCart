package com.shoppingcart.OrderService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OrderServiceApplication {
	@Autowired
	private ClientRegistrationRepository clientRegistrationRepository;

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		RestTemplate restTemplate
				= new RestTemplate();
		restTemplate.setInterceptors(
				Arrays.asList(
						new RestTemplateInterceptor(
								clientManager(clientRegistrationRepository
										,oAuth2AuthorizedClientRepository))));
		return restTemplate;
	}

}
