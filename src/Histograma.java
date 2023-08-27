import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.Normalizer;

public class Histograma {
    //Atondo Ojeda Darío Alejandro
    public static void main(String[] args) throws IOException {
        String archivo = "src\\divina_comedia_sp.txt";

        BufferedReader lector = new BufferedReader(new FileReader(archivo));
        String linea;
        StringBuilder texto = new StringBuilder();

        while((linea = lector.readLine()) != null) { //convierte las lineas en un único texto
            texto.append(linea).append(" ");
        }

        String limpio = limpiarTexto(texto.toString()); //se utiliza el método de limpiar para eliminar caracteres especiales
        String[] palabras = dividirPalabras(limpio); //se crea un arreglo donde se almacenan las palabras


       int[] histograma = new int[11];

        //se separan las palabras que no se necesitan para unicamente tomar las de 2 a 10 caracteres
        for (String palabra : palabras) { //se analiza cada palabra del arreglo
            int longitud = palabra.length(); //se almacena la longitud de cada palabra
            if (longitud >= 2 && longitud <= 10) { //se cuentan las palabras de 2 a 10 caracteres
                histograma[longitud]++;
            }
        }


        System.out.println("Longitud de Palabra | Cantidad");
        System.out.println("--------------------|---------");
        for (int longitud = 2; longitud <= 10; longitud ++){ //se recorren las longitudes de 2 a 10 caracteres
            int cantidad = histograma[longitud]; //se obtiene la cantidad de caracteres de x palabra
            System.out.printf("%-19s | %d%n", longitud +
                    " caracteres", cantidad); //se imprime con formato en forma de tabla
        }
    }

    public static String limpiarTexto(String texto){ //método para eliminar los caracteres especiales
        String limpio = Normalizer.normalize(texto, Normalizer.Form.NFD);
        limpio = limpio.replaceAll("[^\\p{ASCII}a-zA-Z0-9 ]", "");
        return limpio;
    }

    public static String[] dividirPalabras(String texto) { //método para dividir el texto en palabras
        return texto.split("\\s+");
    }
}
