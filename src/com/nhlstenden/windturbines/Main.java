package com.nhlstenden.windturbines;

import com.nhlstenden.smartdisplay.dto.Displayable;
import com.nhlstenden.smartdisplay.main.SmartDisplay;
import com.nhlstenden.windturbines.exception.OverloadException;
import com.nhlstenden.windturbines.heatpump.HeatPump;
import com.nhlstenden.windturbines.home.Home;
import com.nhlstenden.windturbines.smartController.SmartController;
import com.nhlstenden.windturbines.smartController.SmartDevice;
import com.nhlstenden.windturbines.windturbines.HAWT;
import com.nhlstenden.windturbines.windturbines.SAVONIUS;
import com.nhlstenden.windturbines.windturbines.WindTurbine;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        //make the home and wind-turbines.
        HeatPump heatPump = new HeatPump(20);
        SmartController smartController = new SmartController();
        Home home = new Home(heatPump, smartController);
        WindTurbine savonius = new SAVONIUS("savonius");
        WindTurbine hawt = new HAWT("hawt", 15);
        smartController.addSmartDevice((SmartDevice) savonius);
        smartController.addSmartDevice(heatPump);
        home.addWindTurbine(savonius);
        home.addWindTurbine(hawt);


        SmartDisplay smartDisplay = new SmartDisplay();
        smartDisplay.setRunButtonAction(value -> {
            //get the windspeed from the input field.
            float windSpeed = (float) value.getValue();
            //try to generate heat and catch the exceptions when they happen.
            try {
                home.generateHeat(windSpeed);
            } catch (OverloadException e) {
                //show the error message on the screen.
                smartDisplay.showError(String.valueOf(e));
            }
            //get the displayables from the smart-controller and show them on the screen.
            Set<Displayable> displayables = smartController.getDisplayables();
            smartDisplay.setMetrics(displayables);
        });
    }
}