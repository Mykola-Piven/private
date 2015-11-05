package task.mpiven.votesystem;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import task.mpiven.votesystem.domain.entity.Dish;
import task.mpiven.votesystem.domain.entity.LanchMenu;
import task.mpiven.votesystem.domain.entity.Restaurant;
import task.mpiven.votesystem.domain.repository.DishRepository;
import task.mpiven.votesystem.domain.repository.LanchMenuRepository;
import task.mpiven.votesystem.domain.repository.RestaurantRepository;
import task.mpiven.votesystem.web.view.Constants;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
@EnableWebMvc
public class VoteApplication {
	private static final Logger log = LoggerFactory.getLogger(VoteApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(VoteApplication.class, args);
	}


	@Bean
	public CommandLineRunner createDefaultData(RestaurantRepository restaurantRepository,
			LanchMenuRepository lanchMenuRepository, DishRepository dishRepository) {
		return (args) -> {

			Restaurant pizzaCelentano = new Restaurant("Pizza Celentano");
			LanchMenu menuPizzaCelentano = new LanchMenu(LocalDate.now().format(Constants.DATE_FORMATTER), pizzaCelentano);
			Set<Dish> dishPizzaCelentano = new HashSet<>();

			dishPizzaCelentano.add(new Dish("Pizza Margarita", 55.50, menuPizzaCelentano));
			dishPizzaCelentano.add(new Dish("Vinegret", 11.99, menuPizzaCelentano));
			dishPizzaCelentano.add(new Dish("Blinie", 10.00, menuPizzaCelentano));
			dishPizzaCelentano.add(new Dish("Sauce Caesar", 2.99, menuPizzaCelentano));
			dishPizzaCelentano.add(new Dish("Black Tea", 1.50, menuPizzaCelentano));

			restaurantRepository.save(pizzaCelentano);
			lanchMenuRepository.save(menuPizzaCelentano);
			dishRepository.save(dishPizzaCelentano);

			Restaurant odessa = new Restaurant("Odessa");
			LanchMenu menuOdessa = new LanchMenu(LocalDate.now().format(Constants.DATE_FORMATTER), odessa);
			Set<Dish> dishOdessa = new HashSet<>();

			dishOdessa.add(new Dish("Chicken Soup", 13.50, menuOdessa));
			dishOdessa.add(new Dish("Salad Caprese", 10.99, menuOdessa));
			dishOdessa.add(new Dish("Beef Stroganoff", 25.40, menuOdessa));
			dishOdessa.add(new Dish("French fries", 12.99, menuOdessa));
			dishOdessa.add(new Dish("Black Tea", 1.70, menuOdessa));

			restaurantRepository.save(odessa);
			lanchMenuRepository.save(menuOdessa);
			dishRepository.save(dishOdessa);
		
			// fetch all menus
			log.info("LanchMenu findAll():");
			log.info("-------------------------------");
			for (LanchMenu lanchMenu : lanchMenuRepository.findAll()) {
				log.info(lanchMenu.toString());
			}
			log.info("-------------------------------");
		};
	}
}
