package com.inf5153.api.models;

public enum Institution {
    NONE(""),
    ST_MARY_HOSPITAL_CENTER("St. Mary's Hospital Center"),
    LACHINE_HOSPITAL("MUHC"),
    LASALLE_HOSPITAL("LaSalle Hospital"),
    VERDUN_HOSPITAL("Verdun Hospital"),
    SACRE_COEUR_DE_MONTREAL("Sacré-Coeur de Montréal Hospital"),
    FLEURY_HOSPITAL("Fleury Hospital"),
    MONTREAL_GENERAL_HOSPITAL("Montreal General Hospital (MUHC)"),
    LAKESHORE_GENERAL_HOSPITAL("Lakeshore General Hospital"),
    JEWEISH_GENERAL_HOSPITAL("Jewish General Hospital"),
    JEAN_TALON_HOSPITAL("Jean-Talon Hospital"),
    MAISONNEUVE_ROSEMONT_HOSPITAL("Maisonneuve-Rosemont Hospital"),
    NOTRE_DAME_HOSPITAL("Notre-Dame Hospital"),
    ROYAL_VICTORIA_HOSPITAL("Royal Victoria Hospital (MUHC)"),
    SAINT_LUC_HOSPITAL("Saint-Luc Hospital"),
    SANTA_CABRINI_HOSPITAL("Santa Cabrini Hospital"),
    HOTEL_DIEU("Hôtel-Dieu (CHUM)"),
    MONTREAL_HEART_INSTITUTE("Montreal Heart Institute"),
    MONTREAL_CHEST_INSTITUTE("Montreal Chest Institute (MUHC)"),
    MONTREAL_NEUROLOGICAL_HOSPITAL("Montreal Neurological Hospital (MUHC)");

    private String name;

    Institution (String institution){ this.name = institution; }

    public String institutionShow() { return name; }
}
