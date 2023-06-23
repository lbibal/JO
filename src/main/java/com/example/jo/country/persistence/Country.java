package com.example.jo.country.persistence;

public class Country {
    private final String name;
    private final String region;
    private final String[] languages;
    private final String maps;
    private final int population;
    private final String flag;
    private final String capital;

    public Country(String name, String region, String[] languages, String maps, int population, String flag, String capital) {
        this.name = name;
        this.region = region;
        this.languages = languages.clone(); // Utiliser une copie défensive pour les tableaux mutables
        this.maps = maps;
        this.population = population;
        this.flag = flag;
        this.capital = capital;
    }

    public String getName() {
        return this.name;
    }

    public String getRegion() {
        return this.region;
    }

    public String[] getLanguages() {
        return this.languages.clone(); // Utiliser une copie défensive pour les tableaux mutables
    }

    public String getConcatenatedLanguages() {
        return String.join(" ", this.getLanguages());
    }

    public String getMaps() {
        return this.maps;
    }

    public int getPopulation() {
        return this.population;
    }

    public String getFlag() {
        return this.flag;
    }

    public String getCapital() {
        return this.capital;
    }
}