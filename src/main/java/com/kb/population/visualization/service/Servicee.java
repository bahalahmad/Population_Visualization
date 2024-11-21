package com.kb.population.visualization.service;
import com.kb.population.visualization.model.Model;
import ch.qos.logback.classic.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

    @Service
    public class Servicee {
        private static final Logger logger = (Logger) LoggerFactory.getLogger(Servicee.class);
        private static final int NUM_AGE_GROUPS = 18;
        private static final int TOTAL_POPULATION = 100_000_000;

        public List<Model> getPopulationData() {
            return generateMockPopulationData();
        }
        private List<Model> generateMockPopulationData() {
            List<Model> populationData = new ArrayList<>();
            Random random = new Random();


            for (int ageGroup = 0; ageGroup < NUM_AGE_GROUPS; ageGroup++) {

                int males = (int) (TOTAL_POPULATION * 0.5 * random.nextDouble());
                int females = TOTAL_POPULATION - males;

                String ageGroupStr = getAgeGroupRange(ageGroup);


                Model data = new Model();
                data.setAgeGroup(ageGroupStr);
                data.setMales(males);
                data.setFemales(females);


                populationData.add(data);

                logger.info("Age Group: {}, Males: {}, Females: {}", data.getAgeGroup(), data.getMales(), data.getFemales());
            }

            return populationData;
        }
        private String getAgeGroupRange(int ageGroupIndex) {
            int startAge = ageGroupIndex * 5;
            int endAge = startAge + 4;  // age groups like "0-4", "5-9", "10-14", etc.
            return startAge + "-" + endAge;
        }
    }
