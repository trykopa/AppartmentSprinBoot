package ua.kiev.prog.TestApp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ua.kiev.prog.TestApp.model.App;
import ua.kiev.prog.TestApp.model.People;
import ua.kiev.prog.TestApp.service.PeopleService;

@SpringBootApplication
public class TestAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(final PeopleService peopleService) {
		return new CommandLineRunner() {
			@Override
			public void run(String... strings) throws Exception {
				App app = new App("Test");
				App appTwo = new App("Test2");
				People people;
				People peopleTwo;
				peopleService.addApp(app);
				peopleService.addApp(appTwo);

				for (int i = 0; i < 10; i++) {
					people = new People(app, "Other" + i);
					peopleService.addPeople(people);
				}

				for (int i = 0; i < 10; i++) {
					peopleTwo = new People(appTwo, "OtherTwo" + i);
					peopleService.addPeople(peopleTwo);
				}
			}
		};
	}
}
