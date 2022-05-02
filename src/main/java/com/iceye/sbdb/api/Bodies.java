package com.iceye.sbdb.api;

public enum Bodies {
    Mercury("Merc"),
    Venus("Venus"),
    Earth("Earth"),
    Mars("Mars"),
    Jupiter("Juptr"),
    Saturn("Satrn"),
    Uranus("Urnus"),
    Neptune("Neptn"),
    Pluto("Pluto"),
    Moon("Moon");
    final String value;
    Bodies(String value)
    {
        this.value= value;
    }
    public String getValue()
    {
        return value;
    }
}
