package com.kb.population.visualization.service;
import com.kb.population.visualization.model.Model;
import ch.qos.logback.classic.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
    public class Servicee {
        private static final int NUM_AGE_GROUPS = 18;
	    private static final int TOTAL_POPULATION = 100_000_000;

	    public List<Model> getPopulationData(String region, String year) {
	        return generateMockPopulationData().stream()
	            .filter(data -> (region == null || data.getCountry().equalsIgnoreCase(region)) &&
	                            (year == null || data.getYear().equalsIgnoreCase(year)))
	            .collect(Collectors.toList());
	    }

	    private List<Model> generateMockPopulationData() {
	        List<Model> populationData = new ArrayList<>();
	        Random random = new Random();
	        String[] country = {"India", "Pakistan", "Bangladesh", "China", "Phillipines", "Vietnam", "Japan", "Srilanka", "Nepal", "Saudi Arabia"};
	        String[] years = {"2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024"};

	        for (String countries : country) {
	            for (String year : years) {
	                for (int ageGroup = 0; ageGroup < NUM_AGE_GROUPS; ageGroup++) {
	                    int males = (int) (TOTAL_POPULATION * 0.5 * random.nextDouble());
	                    int females = TOTAL_POPULATION - males;
	                    String ageGroupStr = getAgeGroupRange(ageGroup);

	                    Model data = new Model();
	                    data.setAgeGroup(ageGroupStr);
	                    data.setMales(males);
	                    data.setFemales(females);
	                    data.setCountry(countries);
	                    data.setYear(year);

	                    populationData.add(data);
	                }
	            }
	        }

	        return populationData;
	    }

	    private String getAgeGroupRange(int ageGroupIndex) {
	        int startAge = ageGroupIndex * 5;
	        int endAge = startAge + 4;
	        return startAge + "-" + endAge;
	}
    }
