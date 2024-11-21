package com.kb.population.visualization.model;

import java.util.Arrays;
import java.util.List;
    public class Model {
        private String ageGroup;
        private int males;
        private int females;

        // Constructor
        public Model(String ageGroup, int males, int females) {
            this.ageGroup = ageGroup;
            this.males = males;
            this.females = females;
        }


        public Model() {}


        public String getAgeGroup() {
            return ageGroup;
        }

        public void setAgeGroup(String ageGroup) {
            this.ageGroup = ageGroup;
        }

        public int getMales() {
            return males;
        }

        public void setMales(int males) {
            this.males = males;
        }

        public int getFemales() {
            return females;
        }

        public void setFemales(int females) {
            this.females = females;
        }

        @Override
        public String toString() {
            return "Model{" +
                    "ageGroup='" + ageGroup + '\'' +
                    ", males=" + males +
                    ", females=" + females +
                    '}';
        }
    }
