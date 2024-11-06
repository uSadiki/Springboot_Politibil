package com.example.politibil.Enums;

public enum OppdragType {
    PATRULJERER("Patruljering"),
    AKTIV_BILJAKT("Aktiv biljakt"),
    INNBRUDD("Innbrudd"),
    TRAFIKKULYKKE("Trafikkulykke"),
    STASJONERT("Stasjonert"),
    REDNING("Redning"),
    BRANN("Brann"),
    SPESIELLE_OPERASJONER("Spesielle operasjoner");

    private final String visningsnavn;

    OppdragType(String visningsnavn) {
        this.visningsnavn = visningsnavn;
    }

    @Override
    public String toString() {
        return visningsnavn;
    }
}