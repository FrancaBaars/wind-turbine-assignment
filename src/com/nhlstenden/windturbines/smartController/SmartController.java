package com.nhlstenden.windturbines.smartController;

import com.nhlstenden.smartdisplay.dto.Displayable;

import java.util.HashSet;
import java.util.Set;

public class SmartController {
    private HashSet<SmartDevice> smartDevices;

    /**
     * Constructor of the SmartController class.
     */
    public SmartController() {
        this.smartDevices = new HashSet<>();
    }

    public HashSet<SmartDevice> getSmartDevices() {
        return this.smartDevices;
    }

    /**
     * add a smart device to the smart controller.
     *
     * @param smartDevice smart device.
     * @return false when smart device is null,
     * when smart device is already added to the smart-controller.
     * true when the smart device is successfully added.
     */
    public boolean addSmartDevice(SmartDevice smartDevice) {
        if (smartDevice == null) {
            return false;
        }
        return this.smartDevices.add(smartDevice);
    }

    /**
     * gets all the displayables from the smart-devices in the home.
     *
     * @return HashSet with displayables.
     */
    public Set<Displayable> getDisplayables() {
        HashSet<Displayable> displayables = new HashSet<>();
        for (SmartDevice smartDevice : smartDevices) {
            if (smartDevice instanceof Displayable) {
                displayables.add((Displayable) smartDevice);
            }
        }
        return displayables;
    }
}
