# WeatherApp Server

This is a Spring Boot application for retrieving weather forecasts based on location using RESTful APIs.

## Endpoints

### 1. Get Forecast Summary by Location Name
   - **Endpoint**: `/summary/{location}`
   - **Method**: GET
   - **Description**: Retrieves the forecast summary for the specified location.
   - **Parameters**:
     - `location`: The name of the location for which the forecast summary is requested.
   - **Response**: Returns the forecast summary for the specified location.

### 2. Get Hourly Forecast by Longitude and Latitude
   - **Endpoint**: `/hourly/{lon}/{lat}`
   - **Method**: GET
   - **Description**: Retrieves the hourly forecast for the specified longitude and latitude coordinates.
   - **Parameters**:
     - `lon`: The longitude coordinate of the location.
     - `lat`: The latitude coordinate of the location.
   - **Response**: Returns the hourly forecast for the specified location.

## Technologies Used
- Java
- Spring Boot
- RestTemplate

## Setup and Usage
1. Clone the repository.
2. Import the project into your IDE.
3. Run the application.
4. Access the endpoints using appropriate HTTP requests.

## Usage Examples
- Get forecast summary by location name:
