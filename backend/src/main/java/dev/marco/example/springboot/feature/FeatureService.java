package dev.marco.example.springboot.feature;

import org.springframework.stereotype.Service;

/**
 * Simple service for example purposes
 */
@Service
public class FeatureService {

    public Integer getSum(Integer valueA, Integer valueB) {
        return valueA + valueB;
    }
}
