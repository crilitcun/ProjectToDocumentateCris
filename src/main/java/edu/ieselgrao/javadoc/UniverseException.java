package edu.ieselgrao.javadoc;

/**
 * Excepción personalizada del proyecto.
 * Se usa para errores relacionados con planetas, atmósferas o sistemas solares.
 * @author Cristina Litago
 * @since 1.0
 */
public class UniverseException extends IllegalArgumentException {

    // Constants for error messages
    /** Mensaje de error cuando el nombre del planeta es nulo o vacío. */
    public static final String INVALID_PLANET_NAME = "[ERROR] Name cannot be null or empty";
    /** Mensaje de error cuando el numero de lunas no puede ser negativo. */
    public static final String INVALID_NUMBER_OF_MOONS = "[ERROR] Number of moons cannot be negative";
    /** Mensaje de error cuando la masa no puede ser menor que 10 e 23 kg. */
    public static final String INVALID_MASS = "[ERROR] Mass cannot be less than 10e23 kg";
    /** Mensaje de error cuando el radio no puede ser menor que 500 km. */
    public static final String INVALID_PLANET_RADIUS = "[ERROR] Radius cannot be less than 500 km";
    /** Mensaje de error cuando la gravedad no puede ser negativa o cero. */
    public static final String INVALID_GRAVITY = "[ERROR] Gravity cannot be negative or zero";
    /** Mensaje de error cuando la ultima medición del albedo no puede ser nula ni estar en el futuro. */
    public static final String INVALID_LAST_ALBEDO_MEASUREMENT = "[ERROR] Last albedo measurement cannot be null or in the future";
    /** Mensaje de error cuando el tipo de planeta no valido" */
    public static final String INVALID_PLANET_TYPE = "[ERROR] Invalid planet type";

    // Constants for error messages
    /** Mensaje de error cuando la composicion no puede ser nula ni estar vacia. */
    public static final String INVALID_COMPOSITION = "[ERROR] Composition cannot be null or empty";
    /** Mensaje de error cuando la ultima observacion no puede ser nula ni estar en el futuro. */
    public static final String INVALID_LAST_OBSERVATION = "[ERROR] Last observation cannot be null or in the future";
    /** Mensaje de error cuando la presion no puede ser negativa. */
    public static final String INVALID_PRESSURE = "[ERROR] Pressure cannot be negative";
    /** Mensaje de error cuando la densidad no puede ser negativa. */
    public static final String INVALID_DENSITY = "[ERROR] Density cannot be negative";

    /** Mensaje de error cuando el nombre del sistema solar no puede ser nulo, contener solo espacios o tener menos de 3 caracteres.. */
    public static final String INVALID_SOLAR_SYSTEM_NAME = "[ERROR] Name cannot be null, contain only spaces or have less than 3 characters";
    /** Mensaje de error cuando el numero de estrellas no puede ser menor que 1. */
    public static final String INVALID_NUMBER_OF_STARS = "[ERROR] Number of stars cannot be less than 1";
    /** Mensaje de error cuando el radio no puede ser menor o igual que 0. */
    public static final String INVALID_SOLAR_SYSTEM_RADIUS = "[ERROR] Radius cannot be less or equal to 0";
    /** Mensaje de error cuando la fecha de registro no puede ser nula ni estar en el futuro. */
    public static final String INVALID_REGISTRATION_DATE = "[ERROR] Registration date cannot be null or in the future";
    /** Mensaje de error cuando la fecha del ultimo planeta añadido no puede estar en el futuro.. */
    public static final String INVALID_LAST_PLANET_ADDED = "[ERROR] Last planet date added cannot be in the future";
    /** Mensaje de error cuando se ha alcanzado el numero máximo de planetas. */
    public static final String INVALID_MAX_PLANETS = "[ERROR] Maximum number of planets reached";
    /** Mensaje de error cuando el planeta no puede ser nulo." */
    public static final String PLANET_NULL = "[ERROR] Planet cannot be null";
    /** Mensaje de error cuando este planeta ya existe." */
    public static final String PLANET_ALREADY_EXISTS = "[ERROR] This planet already exists";
    /** Mensaje de error cuando este planeta no existe. */
    public static final String PLANET_NOT_FOUND = "[ERROR] This planet does not exist";

    /**
     * Crea una excepción con el mensaje indicado.
     * @param message texto del error
     */
    public UniverseException(String message) {
        super(message);
    }
}
