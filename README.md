# Population Visualization Dashboard

## Overview
This project visualizes the population pyramid for various countries over the years. Built with Spring Boot for the backend and Chart.js for the frontend, the app allows users to filter data based on region and year, displaying a bar chart for male and female population distribution by age groups.

## Tech Stack

### Frontend
- **HTML, CSS, JavaScript**: Structuring, styling, and creating interactivity
- **Chart.js**: Rendering population pyramid as a bar chart
- **AJAX (Fetch API)**: Dynamically requesting population data from backend

### Backend
- **Spring Boot**: Creating REST API to serve population data
- **Spring MVC**: Handling HTTP requests and responses

## Prerequisites
- **Java** (version 11 or higher)
- **Maven** (or Maven wrapper)
- **Git** (optional)

## Running the Application

* Clone the Repository
```bash
git clone https://github.com/bahalahmad/Population_Visualization.git
```
* Navigate to the project directory
```bash
cd population-visualization
```
* Build and run the Spring Boot application:
  * Using Maven

         mvn spring-boot:run
  * Using the Spring Boot Maven wrapper

         ./mvnw spring-boot:run
    
  * Open the application in your browser: Once the application starts, navigate to  
`[http://localhost:8081]`  to view the population visualization dashboard.

## Accessing the Application

**URL** : `[http://localhost:8081]`

**Available Endpoints** :
`[/api/population]` – Returns population data for the selected region and year (as JSON).



       
      

