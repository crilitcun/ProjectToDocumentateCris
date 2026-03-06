package edu.ieselgrao.javadoc;
import java.time.LocalDate;

import static edu.ieselgrao.javadoc.UniverseException.*;



/**
 * La clase atmosfera controla los recursos atmosfericos de un planeta.
 * Almacena y compueba datos como composición, la fecha de ultima observacion,
 * la calidad del aire, la presion, la densidad y si tiene nubes.
 * @author Cristina Litago
 * @since 1.0
 */

public class Atmosphere {

    // Attributes
    private String composition;
    private LocalDate lastObservation;
    private int airQuality;
    private double pressure;
    private double density;
    private boolean hasClouds;

    /**
     * Este es el constructor crea una atmosfera usando los valores recibidos.
     * @param composition repesenta de que esta compuesto es de tipo string
     * @param lastObservation fecha de última observación es de tipo localDate
     * @param airQuality valor de calidad del aire es de tipo int
     * @param pressure presión es de tipo double
     * @param density densidad es de tipo double
     * @param hasClouds indicador de si tiene nubes es de tipo boolean
     * @throws UniverseException se lanza cuando composicion es nulo o esta vacio
     * lastObservation es nulo o esta vacio y la fecha es inferior a la actual,
     * pressure es menor a 0
     * density es menor a 0
     */

    // Constructor
    public Atmosphere(String composition, LocalDate lastObservation, int airQuality, double pressure, double density, boolean hasClouds) {
        setComposition(composition);
        setLastObservation(lastObservation);
        setAirQuality(airQuality);
        setPressure(pressure);
        setDensity(density);
        setHasClouds(hasClouds);
    }

    // Getters and setters
    public String getComposition() {
        return composition;
    }

    /**
     * Este metodo modifica la composicion de la atmosfera.
     * No permite valores nulos nivacío caracteres permitidos entre a y la z minuscula y mayuscula , entre 0 y 9 y espacio
     * @param composition de que esta compuesta la atmosfera
     * @throws UniverseException composition se igual a null o composition eliminamos espacios vacios
     * y comprobamos que si esta vacio o contiene caracteres entre a y la z minuscula y mayuscula entre 0 y 9
     */

    public void setComposition(String composition) {
        if (composition == null || composition.trim().isEmpty() || !composition.matches("[a-zA-Z0-9, ]+")) {
            throw new UniverseException(INVALID_COMPOSITION);
        }
        this.composition = composition;
    }

    public LocalDate getLastObservation() {
        return lastObservation;
    }

    /**
     * Este metodo actualiza la fecha de ultima observacion.
     * La fecha no puede ser nula ni posterior a la fecha actual.
     * @param lastObservation, fecha de última observación es de dito localDate
     * @throws UniverseException se lanza cuando la lastObservation es igual a nula y lastObservation es
     * posterior a la actual
     */


    public void setLastObservation(LocalDate lastObservation) {
        // LocalDate.now() can be setted
        if (lastObservation == null || lastObservation.isAfter(LocalDate.now())) {
            throw new UniverseException(INVALID_LAST_OBSERVATION);
        }
        this.lastObservation = lastObservation;
    }

    public int getAirQuality() {
        return airQuality;
    }

    /**
     * Este metodo modifica la calidad del aire
     * Sus valores permitidos son entre 0 y 100
     * @param airQuality , calidad del aire
     */

    public void setAirQuality(int airQuality) {
        // Adjust to range [0, 100]
        if (airQuality < 0) {
            this.airQuality = 0;
        } else if (airQuality > 100) {
            this.airQuality = 100;
        } else {
            this.airQuality = airQuality;
        }
    }


    public double getPressure() {
        return pressure;
    }

    /**
     * Este metodo modifica la presión atmosferica.
     * No puede ser negativa.
     * @param pressure , presin es de tipo double
     * @throws UniverseException se lanza cuando el valor es negativo
     */

    public void setPressure(double pressure) {
        if (pressure < 0) {
            throw new UniverseException(INVALID_PRESSURE);
        }
        this.pressure = pressure;
    }

    public double getDensity() {
        return density;
    }

    /**
     * Este metodo modifica la densidad de la atmosfera.
     * No puede ser negativa.
     * @param density, densidad en de tipo double
     * @throws UniverseException se lanza cuando el valor es negativo
     */


    public void setDensity(double density) {
        if (density < 0) {
            throw new UniverseException(INVALID_DENSITY);
        }
        this.density = density;
    }
    public boolean hasClouds() {
        return hasClouds;
    }

    /**
     * Este metodo devulve si tiene nubes
     * @param hasClouds,  boolean
     */

    public void setHasClouds(boolean hasClouds) {
        this.hasClouds = hasClouds;
    }

}
