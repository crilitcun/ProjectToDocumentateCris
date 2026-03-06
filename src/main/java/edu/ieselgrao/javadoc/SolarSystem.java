package edu.ieselgrao.javadoc;
import java.time.LocalDate;

import static edu.ieselgrao.javadoc.UniverseException.*;

public class SolarSystem {

    private static final int MIN_NAME_LENGTH = 3;

    // Private atributtes
    private final int MAX_PLANETS;
    private int id;
    private static int nextId = 1;
    private String name;
    private int numberOfStars;
    private double radius;
    private LocalDate registrationDate;
    private LocalDate lastPlanetAdded;
    private int numPlanets;
    private int sumMoons;
    private Planet[] planets;

    public SolarSystem(String name, int numberOfStars, double radius, LocalDate registrationDate, int maxPlanets) {
        setName(name);
        setNumberOfStars(numberOfStars);
        setRadius(radius);
        setRegistrationDate(registrationDate);
        MAX_PLANETS = maxPlanets;
        planets = new Planet[MAX_PLANETS];
        setId();
        incNextId();
        numPlanets = 0;
        sumMoons = 0;

    }

    public int getId() {
        return id;
    }
    public void setId() {
        id = nextId;
    }
    public static int getNextId() {
        return nextId;
    }
    public static void incNextId() {
        nextId++;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        if (name == null || name.trim().length() < MIN_NAME_LENGTH) {
            throw new UniverseException(INVALID_SOLAR_SYSTEM_NAME);
        }
        this.name = name.trim();
    }
    public int getNumberOfStars() {
        return numberOfStars;
    }
    public void setNumberOfStars(int numberOfStars) {
        if (numberOfStars < 1) {
            throw new UniverseException(INVALID_NUMBER_OF_STARS);
        }
        this.numberOfStars = numberOfStars;
    }
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        if (radius <= 0) {
            throw new UniverseException(INVALID_SOLAR_SYSTEM_RADIUS);
        }
        this.radius = radius;
    }
    public LocalDate getRegistrationDate() {
        return registrationDate;
    }
    public void setRegistrationDate(LocalDate registrationDate) {
         if (registrationDate == null || registrationDate.isAfter(LocalDate.now())) {
             throw new UniverseException(INVALID_REGISTRATION_DATE);
         }
         this.registrationDate = registrationDate;
    }
    public LocalDate getLastPlanetAdded() {
        return lastPlanetAdded;
    }
    public void setLastPlanetAdded(LocalDate lastPlanetAdded) {
        // If last planet is null no planet is updated but no exception is thrown
        if (lastPlanetAdded != null) {
            if (lastPlanetAdded.isAfter(LocalDate.now())) {
                throw new UniverseException(INVALID_LAST_PLANET_ADDED);
            }
            this.lastPlanetAdded = lastPlanetAdded;
        }
    }
    public int getDaysFromLastPlanetAdded() {
        if (lastPlanetAdded == null) {
            return -1;
        }
        return lastPlanetAdded.until(LocalDate.now()).getDays();
    }

    public int getMaxPlanets(){
        return MAX_PLANETS;
    }
    public Planet[] getPlanets(){
        return planets;
    }
    public int getNumPlanets() {
        return numPlanets;
    }
    public int findPlanet(Planet planet){

        if (planet == null) {
            throw new NullPointerException(PLANET_NULL);
        }
        for (int i = 0; i < MAX_PLANETS; i++) {
             if (planet.equals(planets[i])) { // equals method is inherited from object
                 return i;
             }
        }
        // If planet is not found, return -1
        return -1;
    }
    public int findFirstEmptySlot(){
        for (int i = 0; i < MAX_PLANETS; i++) {
            if (planets[i] == null) {
                return i;
            }
        }
        return -1;
    }
    public boolean containsPlanet(Planet planet){
        // Exception can be thrown from findPlanet method
        return findPlanet(planet) != -1;
    }
    public void addPlanet(Planet planet, LocalDate addedDate){
        if (containsPlanet(planet)){ // comparison can throw exception if planet is null
            throw new UniverseException(PLANET_ALREADY_EXISTS);
        }

        int slot = findFirstEmptySlot();
        if (slot == -1) {
            throw new IllegalStateException(INVALID_MAX_PLANETS);
        }

        setLastPlanetAdded(addedDate);

        planets[slot] = planet;
        numPlanets++;
        sumMoons += planet.getNumberOfMoons();
    }

    public void removePlanet(Planet planet){
        int index = findPlanet(planet); // Can throw PLANET_NULL exception
        if (index == -1) {
            throw new UniverseException(PLANET_NOT_FOUND);
        }
        planets[index] = null;
        numPlanets--;
    }
    public double getAverageMoonsByPlanet(){
        // Avoid dividing by 0
        if (numPlanets == 0) {
            return 0;
        }
        return (double) sumMoons / numPlanets;
    }





}
