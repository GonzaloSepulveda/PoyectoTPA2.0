Trabajo TPA read me

Primero de todo, usted deberá incluir el archivo JAR correspondiente con la librería Json para que el trabajo compile, dicho fichero vendrá adjunto en un fichero zip junto a este fichero de texto y el propio proyecto.

Pasos a seguir para incluir el fichero ( desde IntelliJ ) : 

En la barra lateral izquierda, busca y haz clic en la pestaña "Project" (Proyecto) para abrir la vista del proyecto.


Luego, haz clic con el botón derecho en la carpeta de tu proyecto y selecciona "Open Module Settings" (Abrir configuración del módulo) o simplemente presiona F4.

En la ventana de configuración del módulo, ve a la pestaña "Dependencies" (Dependencias).
Haz clic en el signo "+" para agregar una nueva dependencia.

Desde ahí, escoge la primera opción ( Jar o directorios ) y abre el archivo Jar que le fue enviado, haz click en "apply" y después en "Ok" tras estos pasos, el archivo Json ya estará bien añadido 

Nuestro patrón de diseño empleado fue el patrón conocido como Facade o Fachada, la clase Game_P reune varias clases del proyecto y las utiliza, el cliente usará la función Game_P en vez de las otras clases por individual. 

Nuestro trabajo consta de un juego de carreras, popularmente conocido como "drag racing" 

El juego consta de 10 niveles jugables con dificultad en ascendencia, a su vez, el coche del jugador consta con 3 niveles, la mejora del coche será posible desde el menú de "workshop" 

Para mejorar el coche necesitaras 200 monedas por nivel, usted puede conseguir 50 monedas por cada nivel superado

Existe un archivo Json llamado "money.json" que usted podrá modificar si quiere probar algún nivel superior de el vehículo 

El juego se tendrá que ejecutar desde la clase "Menu". Tras ello, podrás disfrutar del juego completo 

Un saludo. 

Pablo Borderas, Victor Arroyo y Gonzalo Sepúlveda

