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

## API Specifications

**Endpoint** : `[/api/population]`

**Method**: GET

This endpoint returns the population data for the selected country and year in JSON format.

### Query Parameters:

**region**  – The region for which the population data is required (e.g., India, Pakistan, etc.).

**year**  – The year for which the population data is required (e.g., 2014, 2015, etc.).

### Sample Request

```bash
GET http://localhost:8081/api/population?region=India&year=2014
```
### Sample Response

```bash
[
  {
    "ageGroup": "0-4",
    "males": 25000000,
    "females": 24000000
  },
  {
    "ageGroup": "5-9",
    "males": 23000000,
    "females": 22000000
  },
  {
    "ageGroup": "10-14",
    "males": 21000000,
    "females": 20000000
  },
  {
    "ageGroup": "15-19",
    "males": 22000000,
    "females": 21000000
  },
  ...
]
```
## How It Works
###  Frontend:
The frontend allows users to select a region and year to filter the population data.
When a user clicks the "Apply Filters" button, it sends a request to the backend API (/api/population) with the selected filters.

The backend returns the population data for the specified region and year, which is then used to generate the population pyramid chart.

### Backend:
The backend handles requests to the `[/api/population]` endpoint, retrieving the corresponding population data from a database or static source.
The data is returned as a JSON response, which the frontend uses to display the population pyramid chart.

       
      

