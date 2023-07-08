package myProject.roadDemo.core.config;

import myProject.roadDemo.journey.mapper.JourneyMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeneralConfiguration {

    @Bean
    public JourneyMapper createJourneyMapper(){
        return new JourneyMapper();
    }

}
