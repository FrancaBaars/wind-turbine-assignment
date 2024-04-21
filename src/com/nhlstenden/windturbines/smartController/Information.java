package com.nhlstenden.windturbines.smartController;

public class Information {
    private float temp;
    private float kWh;
    private float windSpeed;

    /**
     * Constructor for the Information class.
     *
     * @param temp the temperature of the heat pump/home in Celsius.
     */
    public Information(float temp) {
        this.setTemp(temp);
    }

    /**
     * Constructor of the Information class.
     *
     * @param kWh       the energy in kWh.
     * @param windSpeed the windspeed in m/s
     */
    public Information(float kWh, float windSpeed) {
        this.setkWh(kWh);
        this.setWindSpeed(windSpeed);
    }

    public float getTemp() {
        return this.temp;
    }

    /**
     * sets the temperature.
     *
     * @param temp temperature in Celsius.
     *             throws IllegalArgumentException when the temp is lower than 0.
     */
    public void setTemp(float temp) {
        if (temp < 0) {
            throw new IllegalArgumentException("invalid temp");
        }
        this.temp = temp;
    }

    public float getkWh() {
        return this.kWh;
    }

    /**
     * sets the energy.
     *
     * @param kWh the energy in kWh.
     *            throws IllegalArgumentException when the energy is lower than 0.
     */
    public void setkWh(float kWh) {
        if (kWh < 0) {
            throw new IllegalArgumentException("invalid kWh");
        }
        this.kWh = kWh;
    }

    public float getWindSpeed() {
        return this.windSpeed;
    }

    /**
     * sets the windspeed
     *
     * @param windSpeed windspeed in m/s
     *                  throws IllegalArgumentException when the speed is lower than 0
     */
    public void setWindSpeed(float windSpeed) {
        if (windSpeed < 0) {
            throw new IllegalArgumentException("invalid windSpeed");
        }
        this.windSpeed = windSpeed;
    }
}


