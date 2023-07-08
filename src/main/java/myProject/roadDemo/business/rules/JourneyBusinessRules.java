package myProject.roadDemo.business.rules;

import lombok.RequiredArgsConstructor;
import myProject.roadDemo.journey.repo.JourneyRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class JourneyBusinessRules {
    private final JourneyRepository journeyRepository;

    public void checkIfRangeLessThenZero(Double range){



    }
}
