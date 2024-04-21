package com.nhlstenden.windturbines.windturbines;

import com.nhlstenden.windturbines.exception.OverloadException;

public class HAWT extends WindTurbine {
    //Ik heb geen idee wat weerstand en tandwiel in het engels is dus dat heb ik een nederlandse naam gegeven.
    private float weerstandTandWiel;

    /**
     * Constructor of the HAWT class.
     *
     * @param brand             brand of windturbine.
     * @param weerstandTandWiel the weerstand of the wheels of the turbine.
     */
    public HAWT(String brand, float weerstandTandWiel) {
        super(brand);
        this.setWeerstandTandWiel(weerstandTandWiel);

    }

    public float getWeerstandTandWiel() {
        return this.weerstandTandWiel;
    }

    /**
     * sets the weerstand of the wheels of the turbine.
     *
     * @param weerstandTandWiel weerstand of the wheels.
     *                          throws IllegalArgumentException when the weerstand is less than 0.
     */
    public void setWeerstandTandWiel(float weerstandTandWiel) {
        if (weerstandTandWiel < 0) {
            throw new IllegalArgumentException("weerstand is invallid");
        }
        this.weerstandTandWiel = weerstandTandWiel;
    }

    /**
     * Generate energy based on the speed of the wind and the weerstand of the wheels.
     *
     * @param windSpeed the speed of the wind in m/s
     * @return the generated energy in kWh.
     * @throws OverloadException throws Overloading exception when windspeed is more than 30m/s
     */
    @Override
    public float generateEnergy(float windSpeed) throws OverloadException {
        if (windSpeed > 30) {
            throw new OverloadException("windspeed is more than 30 m/s");
        }
        return (windSpeed * 0.004f) / this.getWeerstandTandWiel();
    }
}
