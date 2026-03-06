package edu.ieselgrao.javadoc;
import java.time.LocalDate;
import static edu.ieselgrao.javadoc.UniverseException.*;

/**
 * La clase Planet representa un planeta y almacena información sobre el,
 * como su nombre, numero de lunas, masa, radio, gravedad y la fecha de la ultima
 * medición del albedo. También indica si tiene anillos, su tipo de planeta y,
 * opcionalmente, su atmosfera.
 * @author Cristina Litago
 * @since 1.0
 */

public class Planet {

    // Constants for minimum values
    private static final double MIN_MASS = 5.97e22;
    private static final double MIN_RADIUS = 500;

    // Attributes
    private String name;
    private int numberOfMoons;
    private double mass;
    private double radius;
    private double gravity;
    private LocalDate lastAlbedoMeasurement;
    private boolean hasRings;
    private Atmosphere atmosphere;
    private PlanetType type;

    /**
     * Este es el constructor basico crea una planetas usando los valores recibidos.
     * @param name repesenta el nombre del planeta que es tipo string
     * @param numberOfMoons numero de lunas que tiene el planeta es de tipo int
     * @param mass masa del planeta es de tipo double
     * @param radius radio del planeta es de tipo double
     * @param gravity gravedad del planeta es de tipo double
     * @param lastAlbedoMeasurement fecha de la última medición del albedo (reflectividad) es de tipo LocalDate
     * @param hasRings indica si el planeta tiene anillos es de tipo boolean
     * @param type PlanetType
     */

    // Basic constructor
    public Planet(String name, int numberOfMoons, double mass, double radius, double gravity, LocalDate lastAlbedoMeasurement, boolean hasRings, PlanetType type) {
        setName(name);
        setNumberOfMoons(numberOfMoons);
        setMass(mass);
        setRadius(radius);
        setGravity(gravity);
        setLastAlbedoMeasurement(lastAlbedoMeasurement);
        setHasRings(hasRings);
        setType(type);

        atmosphere = null;
    }

    /**
     * Este es el constructor esta mas detallado ya que crea una planetas usando los valores recibidos.
     *  Constructor detallado que crea un planeta incluyendo tanto sus propiedades
     *  *como la información completa de su atmosfera. Si ocurre un error al crear la atmosfera,
     *  esta se crea como null.
     * @param name repesenta el nombre del planeta que es tipo string
     * @param numberOfMoons numero de lunas que tiene el planeta es de tipo int
     * @param mass masa del planeta es de tipo double
     * @param radius radio del planeta es de tipo double
     * @param gravity gravedad del planeta es de tipo double
     * @param lastAlbedoMeasurement fecha de la última medición del albedo (reflectividad) es de tipo LocalDate
     * @param hasRings indica si el planeta tiene anillos es de tipo boolean
     * @param type PlanetType
     * Parametros de la atmosfera:
     * @param composition composicion
     * @param lastObservation fecha de la última observacion
     * @param airQuality calidad del aire (escala definida por el sistema)
     * @param pressure presión
     * @param density densidad
     * @param hasClouds indica si la atmósfera contiene nubes
     *
     * @throws UniverseException si al crear el objeto atmosfera da error, lo crea a nulo
     */

    // Detailed constructor with atmosphere
    public Planet(String name, int numberOfMoons, double mass, double radius, double gravity, LocalDate lastAlbedoMeasurement, boolean hasRings, PlanetType type, String composition, LocalDate lastObservation, int airQuality, double pressure, double density, boolean hasClouds) {
        setName(name);
        setNumberOfMoons(numberOfMoons);
        setMass(mass);
        setRadius(radius);
        setGravity(gravity);
        setLastAlbedoMeasurement(lastAlbedoMeasurement);
        setHasRings(hasRings);
        setType(type);

        try {
            setAtmosphere(composition, lastObservation, airQuality, pressure, density, hasClouds);
        } catch (UniverseException e) {
            this.atmosphere = null;
        }
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    /**
     * Asigna el nombre del planeta.
     *
     * @param name nombre del planeta, no puede ser nulo ni estar vacío
     * @throws UniverseException si el nombre es nulo o vacío
     */

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new UniverseException(INVALID_PLANET_NAME);
        }
        this.name = name;
    }

    public int getNumberOfMoons() {
        return numberOfMoons;
    }

    /**
     * Asigna el numero de lunas del planeta.
     *
     * @param numberOfMoons numero de lunas, debe ser 0 o mayor
     * @throws UniverseException si el numero de lunas es negativo
     */

    public void setNumberOfMoons(int numberOfMoons) {
        if (numberOfMoons < 0) {
            throw new UniverseException(INVALID_NUMBER_OF_MOONS);
        }
        this.numberOfMoons = numberOfMoons;
    }

    public double getMass() {
        return mass;
    }

    /**
     * Asigna la masa del planeta.
     *
     * @param mass masa del planeta, debe ser mayor o igual que MIN_MASS
     * @throws UniverseException si la masa es menor que el valor minimo permitido
     */

    public void setMass(double mass) {
        if (mass < MIN_MASS) {
            throw new UniverseException(INVALID_MASS);
        }
        this.mass = mass;
    }
    public double getRadius() {
        return radius;
    }

    /**
     * Asigna el radio del planeta.
     *
     * @param radius radio del planeta, debe ser mayor o igual que MIN_RADIUS
     * @throws UniverseException si el radio es menor que el minimo permitido
     */

    public void setRadius(double radius) {
        if (radius < MIN_RADIUS) {
            throw new UniverseException(INVALID_PLANET_RADIUS);
        }
        this.radius = radius;
    }
    public double getGravity() {
        return gravity;
    }

    /**
     * Establece la gravedad superficial del planeta.
     *
     * @param gravity gravedad, debe ser mayor que 0
     * @throws UniverseException si la gravedad es menor o igual que 0
     */

    public void setGravity(double gravity) {
        if (gravity <= 0) {
            throw new UniverseException(INVALID_GRAVITY);
        }
        this.gravity = gravity;
    }
    public LocalDate getLastAlbedoMeasurement() {
        return lastAlbedoMeasurement;
    }

    /**
     * Establece la fecha de la ultima medición del albedo del planeta.
     *
     * @param lastAlbedoMeasurement fecha de la medicion, no puede ser nula ni ser mayor de la actual
     * @throws UniverseException si la fecha es nula o posterior a la fecha actual
     */

    public void setLastAlbedoMeasurement(LocalDate lastAlbedoMeasurement) {
        // last albedo measurement is allowed to be today (LocalDate.now())
        if (lastAlbedoMeasurement == null || lastAlbedoMeasurement.isAfter(LocalDate.now())) {
            throw new UniverseException(INVALID_LAST_ALBEDO_MEASUREMENT);
        }
        this.lastAlbedoMeasurement = lastAlbedoMeasurement;
    }
    public boolean hasRings() {
        return hasRings;
    }
    /**
     * Indica si el planeta posee anillos.
     *
     * @param hasRings planeta tiene anillos true, en caso contrario false
     */

    public void setHasRings(boolean hasRings) {
        this.hasRings = hasRings;
    }
    public Atmosphere getAtmosphere() {
        return atmosphere;
    }
    /**
     * Establece la atmosfera del planeta creando un nuevo objeto ,llamdo Atmosphere.
     *
     * @param composition composición
     * @param lastObservation fecha de la ultima observación
     * @param airQuality calidad del aire
     * @param pressure presión
     * @param density densidad
     * @param hasClouds indica si hay nubes
     */

    public void setAtmosphere(String composition, LocalDate lastObservation, int airQuality, double pressure, double density, boolean hasClouds) {
        // Can propagate UniverseException
        atmosphere = new Atmosphere(composition, lastObservation, airQuality, pressure, density, hasClouds);
    }

    public PlanetType getType() {
        return type;
    }
    /**
     * Establece el tipo de planeta.
     *
     * @param type tipo del planeta, no puede ser nulo
     * @throws UniverseException si es nulo
     */

    public void setType(PlanetType type) {
        if (type == null) {
            throw new UniverseException(INVALID_PLANET_TYPE);
        }
        this.type = type;
    }

}
