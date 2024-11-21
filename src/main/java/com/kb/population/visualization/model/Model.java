package com.kb.population.visualization.model;

import java.util.Arrays;
import java.util.List;
    public class Model {
        private String ageGroup;
        private int males;
        private int females;
        private String country;
        private String year;

        // Default constructor
        public Model() {}

        // Constructor with all fields
        public Model(String ageGroup, int males, int females, String country, String year) {
            this.ageGroup = ageGroup;
            this.males = males;
            this.females = females;
            this.country = country;
            this.year = year;
        }

        // Getter and Setter methods
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

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        @Override
        public String toString() {
            return "Model{" +
                    "ageGroup='" + ageGroup + '\'' +
                    ", males=" + males +
                    ", females=" + females +
                    ", country='" + country + '\'' +
                    ", year='" + year + '\'' +
                    '}';
        }
    }
