package com.nhlstenden.windturbines.heatpump;

import com.nhlstenden.smartdisplay.dto.Displayable;
import com.nhlstenden.windturbines.smartController.Information;
import com.nhlstenden.windturbines.smartController.SmartDevice;

public class HeatPump implements SmartDevice, Displayable {
    private float currentTemp;

    /**
     * Constructor for the class HeatPump
     *
     * @param currentTemp the current temperature of the house.
     */
    public HeatPump(float currentTemp) {
        this.setCurrentTemp(currentTemp);
    }


    public float getCurrentTemp() {
        return this.currentTemp;
    }

    /**
     * set the current temperature of the heat pump
     *
     * @param currentTemp the current temperature of the heat pump
     *                    throws illegalArgumentException when the temperature is below 0.
     */
    public void setCurrentTemp(float currentTemp) {
        if (currentTemp < 0) {
            throw new IllegalArgumentException("invalid currentTemp");
        }
        this.currentTemp = currentTemp;
    }

    /**
     * Generates heat with the given energy.
     *
     * @param kWh the given energy to generate heat from.
     * @return the generated heat.
     */
    public float generateHeat(float kWh) {
        float heat = kWh * 0.23f;
        this.setCurrentTemp(this.getCurrentTemp() + heat);
        return heat;
    }

    /**
     * Gets the info from the heat pump
     *
     * @return returns the information about the heat pump.
     */
    @Override
    public Information getInfo() {
        return new Information(this.getCurrentTemp());
    }

    @Override
    public String getTitle() {
        return "Current temperature";
    }

    @Override
    public double getValue() {
        return this.getInfo().getTemp();
    }
}
