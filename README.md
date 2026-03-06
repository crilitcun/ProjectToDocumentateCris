En esta actividad, documentaremos el código adjunto. Generaremos una documentación con JavaDoc, y subiremos el repositorio a GitHub.
Además, crearemos una *Github Page* con la documentación visible y accesible en Internet.

Debes de documentar:

- Clases Atmosphere, Planet y UniverseException
- Atributos públicos, incluidos *setters*
- Constructores y métodos públicos

No hace falta que documentes:

- La clase SolarSystem y la clase PlanetType, para ahorrar carga de trabajo
- Atributos y métodos privados
- Los **getters**, ya que es evidente qué hacen.

Se que es algo inusual documentar un código que no has hecho tu. Pero el objetivo principal es usar JavaDoc.
Aun así, **quiero que escribáis vosotros los comentarios**.
Esto quiere decir que no podéis usar IA para generar los comentarios JavaDoc.
Explicad con vuestras palabras qué hace cada cosa (no espero que deis mucha información, ni que os cueste mucho tiempo escribirlos)

Una vez documentado,
- Genera la documentación con Tools>Generate JavaDOC. **Excluye los tests**.
Crea una carpeta en la raiz del repositorio "/docs/" en la que generar los docs.
- De manera opcional, personaliza los estilos
- Sube el repositorio original a github, de manera pública. Pequeña ayuda/recordatorio:

```bash
git init
git add .
git commit -m "Documentacion añadida"
git remote add origin "https://github..."
git push origin main # or master
# También puedes usar GitKraken o Sourcetree
```
- **Crea una github pages**: GitHub nos deja crear páginas gratuitas en internet. Ves a ajustes del repositorio->pages y selecciona "/docs" como raiz de tu página. Comprueba que se ha creado la página correctamente.

Me entregarás el link al respositorio original. Edita este README con un link a la documentación (a tu pagina de github pages) 


Aquí tenéis un ejemplo de cómo comentar. Usad el idioma que prefiráis.
```Java

/**
 * @author alvaro ruiz (poneos como autor@s si queréis)
 */
public class Planet {
    ...
/**
 * Sets the number of moons 
 * (Es obvio, pero nuestra documentación para esta actividad va a ser obvia)
 * @param numberOfMoons         the number of Moons of the planet
 * @throws UniverseException    if number of moons is less than 0
 * 
 * Si el contexto lo requiere, podéis usar también las etiquetas {@link OtherClass}
 * o @return 'explicacion del valor devuelto'
 */

public void setNumberOfMoons(int numberOfMoons) {
    if (numberOfMoons < 0) {
        throw new UniverseException(INVALID_NUMBER_OF_MOONS);
    }
    this.numberOfMoons = numberOfMoons;
}
```
