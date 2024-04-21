package com.nhlstenden.windturbines.home;

import com.nhlstenden.windturbines.exception.OverloadException;
import com.nhlstenden.windturbines.heatpump.HeatPump;
import com.nhlstenden.windturbines.smartController.SmartController;
import com.nhlstenden.windturbines.windturbines.WindTurbine;

import java.util.HashSet;

public class Home {
    private HashSet<WindTurbine> windTurbines;
    private HeatPump heatPump;
    private SmartController smartController;


    /**
     * Constructor of the class Home
     *
     * @param heatPump        the heat pump that is in the house.
     * @param smartController the smart controller that is in the house.
     */
    public Home(HeatPump heatPump, SmartController smartController) {
        this.windTurbines = new HashSet<>();
        this.setHeatPump(heatPump);
        this.setSmartController(smartController);
    }

    public HashSet<WindTurbine> getWindTurbines() {
        return this.windTurbines;
    }

    /**
     * Adds a wind-turbine to the home.
     *
     * @param windTurbine the wind-turbine to add.
     * @return false if the wind-turbine is null,
     * or the wind-turbine is already part of the home.
     * true when the wind-turbine is successfully added.
     */
    public boolean addWindTurbine(WindTurbine windTurbine) {
        if (windTurbine == null) {
            return false;
        }
        return this.windTurbines.add(windTurbine);
    }

    public HeatPump getHeatPump() {
        return this.heatPump;
    }

    public void setHeatPump(HeatPump heatPump) {
        if (heatPump == null) {
            throw new IllegalArgumentException("invalid heatPump");
        }
        this.heatPump = heatPump;
    }

    public SmartController getSmartController() {
        return this.smartController;
    }

    public void setSmartController(SmartController smartController) {
        if (smartController == null) {
            throw new IllegalArgumentException("invalid smartController");
        }
        this.smartController = smartController;
    }

    /**
     * Generates heat for the house.
     * loops through all the wind-turbines and generates heat from the energy they produce.
     *
     * @param windSpeed the current windspeed.
     * @return the total generated heat.
     * @throws OverloadException throws overloading exception when the windspeed is more than 30 m/s
     *                           and the total generated energy of a savonius wind-turbine is more than 10 kWh.
     */
    public float generateHeat(float windSpeed) throws OverloadException {
        float energyWindTurbine;
        float totalGeneratedHeat = 0;
        for (WindTurbine windTurbine : windTurbines) {
            energyWindTurbine = windTurbine.generateEnergy(windSpeed);
            totalGeneratedHeat += heatPump.generateHeat(energyWindTurbine);
        }
        return totalGeneratedHeat;
    }
}
