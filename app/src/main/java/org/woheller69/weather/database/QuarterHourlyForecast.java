package org.woheller69.weather.database;

import android.content.Context;

/**
 * This class is the database model for the forecasts table.
 */
public class QuarterHourlyForecast {

    private int id;
    private int city_id;
    private long timestamp;
    private long forecastFor;
    private int weatherID;
    private float temperature;
    private float windSpeed;
    private float windDirection;
    private float precipitation;

    public QuarterHourlyForecast() {
    }

    public QuarterHourlyForecast(int id, int city_id, long timestamp, long forecastFor, int weatherID, float temperature, float windSpeed, float windDirection, float precipitation) {
        this.id = id;
        this.city_id = city_id;
        this.timestamp = timestamp;
        this.forecastFor = forecastFor;
        this.weatherID = weatherID;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.precipitation = precipitation;
    }

    public float getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(float windDirection) {
        this.windDirection = windDirection;
    }

    public float getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(float speed) {
        this.windSpeed = speed;
    }

    /**
     * @return Returns the ID of the record (which uniquely identifies the record).
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return Returns the date and time for the forecast.
     */
    public long getForecastTime() {
        return forecastFor;
    }

    /**
     * @return Returns the local time for the forecast in UTC epoch
     */
    public long getLocalForecastTime(Context context) {
        SQLiteHelper dbhelper = SQLiteHelper.getInstance(context);
        int timezoneseconds = dbhelper.getCurrentWeatherByCityId(city_id).getTimeZoneSeconds();
        return forecastFor + timezoneseconds * 1000L;
    }

    /**
     * @param forecastFor The point of time for the forecast.
     */
    public void setForecastTime(long forecastFor) {
        this.forecastFor = forecastFor;
    }

    /**
     * @return Returns the point of time when the data was inserted into the database in Unix, UTC.
     */
    public long getTimestamp() {
        return timestamp;
    }

    /**
     * @param timestamp The point of time to set when the data was inserted into the database in
     *                  Unix, UTC.
     */
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    /**
     * @return Returns the weather condition ID.
     */
    public int getWeatherID() {
        return weatherID;
    }

    /**
     * @param weatherID The weather condition ID to set.
     */
    public void setWeatherID(int weatherID) {
        this.weatherID = weatherID;
    }

    /**
     * @return Returns the current temperature in Celsius.
     */
    public float getTemperature() {
        return temperature;
    }

    /**
     * @param temperature The current temperature to set in Celsius.
     */
    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getPrecipitation() { return precipitation; }

    public void setPrecipitation(float precipitation) { this.precipitation = precipitation; }
}
