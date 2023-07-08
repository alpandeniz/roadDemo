package myProject.roadDemo.config;

import myProject.roadDemo.entities.concretes.journeyMapper.JourneyMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeneralConfiguration {

    @Bean
    public JourneyMapper createJourneyMapper(){
        return new JourneyMapper();
    }

}
