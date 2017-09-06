package com.darkbit.sample;
import com.darkbit.sample.domain.Profile;
import com.darkbit.sample.repository.ProfileRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class BootApplication implements CommandLineRunner{


	@Autowired
	ProfileRepository profileRepository;




	public static void main(String[] args) {
		SpringApplication.run(BootApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {

		for(int i = 0 ; i < 50; ++i){
			Faker faker = new Faker();
			Profile profile = new Profile();
			profile.setId((long) i);
			profile.setFirstName(faker.name().firstName());
			profile.setLastName(faker.name().lastName());
			profile.setPhoto(faker.internet().avatar());
			profile.setTitle(faker.name().title());
			profile.setAge(faker.random().nextInt(100));
			profileRepository.save(profile);
		}
	}
}
