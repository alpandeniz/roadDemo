package myProject.roadDemo.core.config;

import myProject.roadDemo.journey.mapper.JourneyMapper;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeneralConfiguration {
    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }
    @Bean
    public JourneyMapper createJourneyMapper(){
        return new JourneyMapper();
    }

}
