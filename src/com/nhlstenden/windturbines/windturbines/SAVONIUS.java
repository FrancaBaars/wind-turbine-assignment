package com.nhlstenden.windturbines.windturbines;

import com.nhlstenden.smartdisplay.dto.Displayable;
import com.nhlstenden.windturbines.exception.OverloadException;
import com.nhlstenden.windturbines.smartController.Information;
import com.nhlstenden.windturbines.smartController.SmartDevice;

public class SAVONIUS extends WindTurbine implements SmartDevice, Displayable {
    private float totalGeneratedEnergy;
    private float lastWindSpeed;

    /**
     * Constructor of the SAVONIUS class.
     *
     * @param brand brand of the windturbine
     */
    public SAVONIUS(String brand) {
        super(brand);
        this.setLastWindSpeed(0);
        this.setTotalGeneratedEnergy(0);
    }

    public float getTotalGeneratedEnergy() {
        return this.totalGeneratedEnergy;
    }

    public void setTotalGeneratedEnergy(float totalGeneratedEnergy) {
        if (this.totalGeneratedEnergy >= 0) {
            this.totalGeneratedEnergy = totalGeneratedEnergy;
        }
    }

    public float getLastWindSpeed() {
        return this.lastWindSpeed;
    }

    public void setLastWindSpeed(float lastWindSpeed) {
        if (lastWindSpeed >= 0) {
            this.lastWindSpeed = lastWindSpeed;
        }
    }

    /**
     * Generate energy based on the speed of the wind.
     *
     * @param windSpeed the speed of the wind in m/s
     * @return the generated energy in kWh.
     * @throws OverloadException throws Overloading exception when the total generated energy is more than 10 kWh
     */
    @Override
    public float generateEnergy(float windSpeed) throws OverloadException {
        float energy = windSpeed * 0.002f;
        if (totalGeneratedEnergy + energy > 10) {
            throw new OverloadException("total generated energy is more than 10 kWh");
        }
        this.setLastWindSpeed(windSpeed);
        this.setTotalGeneratedEnergy(this.getTotalGeneratedEnergy() + energy);
        return energy;
    }

    /**
     * Gets the info from the wind turbine.
     *
     * @return returns the information about SAVONIUS
     */
    @Override
    public Information getInfo() {
        return new Information(this.getTotalGeneratedEnergy(), this.getLastWindSpeed());
    }

    @Override
    public String getTitle() {
        return "Total generated energy savonius wind-turbine";
    }

    @Override
    public double getValue() {
        return this.getInfo().getkWh();
    }
}
