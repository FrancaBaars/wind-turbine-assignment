package com.nhlstenden.windturbines.windturbines;

import com.nhlstenden.windturbines.exception.OverloadException;

public abstract class WindTurbine {
    protected String brand;

    /**
     * Constructor of the wind-turbine class.
     *
     * @param brand brand of the wind-turbine.
     */
    public WindTurbine(String brand) {
        this.setBrand(brand);
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        if (brand == null || brand.isEmpty()) {
            throw new IllegalArgumentException("brand is invalid");
        }
        this.brand = brand;
    }

    /**
     * \
     * Generates energy with the given windspeed.
     *
     * @param windSpeed windspeed in m/s
     * @return the generated energy.
     * @throws OverloadException throws overloadException
     */
    public abstract float generateEnergy(float windSpeed) throws OverloadException;
}
