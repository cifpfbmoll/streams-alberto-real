/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio7.pkg1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


/**
 *
 * @author Alberto Real
 */
public final class BufferStream {

    public  BufferStream() {
    }
    
    
    public static String entrada(String tipo) throws FileException {
        Scanner entrada = new Scanner(System.in);
        System.out.println("introduce ruta del fichero "+tipo +" extension");
        System.out.println("(Ejemplo archivo.txt)");
        String ruta = entrada.nextLine();
        File existe = new File(ruta);
        if(ruta.equals("")||existe.exists()==false){
            throw new FileException("ruta no valida " +tipo );
        }
        return ruta;
    }
    
    public static void readAndWrite() throws IOException, FileException {
        int k = 0;
        String linea = "";
        String test = "";
        String valores[][] = {{}, {"publicacion: "}, {"director: "}, {"durcion: "},
        {"sinopsis: "}, {"reaparto: "}, {"session: "}};
        try (BufferedReader lector = new BufferedReader(new FileReader(entrada("entrada")));
        BufferedWriter escritura = new BufferedWriter(new FileWriter(entrada("salida")))) {
            linea = lector.readLine();
            lector.close();
                for (int i = 0; i < linea.length(); i++) {
                    test += linea.charAt(i);
                    if (linea.charAt(i) == '{') {
                        test += "\r\n";
                        test += "-----";

                    } else if (linea.charAt(i) == '#') {
                        //test += "\r\n";
                        if (k < valores.length - 1) {
                        } else {
                            k = 0;
                        }
                        k++;
                        for (int j = 0; j < valores[k].length; j++) {
                            test += "\r\n";
                            test += valores[k][j];
                        }
                    }
                }
                escritura.write(test);
                escritura.close();
            } catch (IOException esc) {
                System.out.println("error entrada o salida");
            }
       
    }

    public String[] pelicula(String entrada) throws FileNotFoundException, IOException {
        String[] salida = null;
        File texto = new File(entrada);
        try (BufferedReader lector = new BufferedReader(new FileReader(texto))) {
            boolean finArchivo = false;
            String linea = "";
            String[] finLinea = null;
            while (!finArchivo) {
                linea = lector.readLine();
                if (linea != null) {
                    finLinea = linea.split("[\\{#]");
                } else {
                    finArchivo = true;
                }
            }
            salida = finLinea;
        } catch (FileNotFoundException exc) {
           // throw new FileException();
        }
        return salida;
    }

}
