/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio7.pkg1;

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
public final class  CharacterStreams {

    public CharacterStreams() {
    }

    public static String entrada(String tipo) throws FileException {
        Scanner entrada = new Scanner(System.in);
        System.out.println("introduce ruta del fichero " + tipo + " extension");
        System.out.println("(Ejemplo archivo.txt)");
        String ruta = entrada.nextLine();
        File existe = new File(ruta);
        if (ruta.equals("") || existe.exists() == false) {
            throw new FileException("ruta no valida " + tipo);
        }
        return ruta;
    }

    public static void readAndWrite() throws FileNotFoundException, IOException, FileException {
        int k = 0;
        char inicial = '#';
        char linea = '{';
        String valores[][] = {{}, {"publicacion: "}, {"director: "}, {"durcion: "},
        {"sinopsis: "}, {"reaparto: "}, {"session: "}};
        String texto = " ";
        try (FileReader lector = new FileReader(entrada("entrada"));
        FileWriter escribir =   new FileWriter(entrada("salida"))){
            int unCaracter;
            while ((unCaracter = lector.read()) != -1) {
                texto += ((char) unCaracter);
            }
            for (int i = 0; i < texto.length(); i++) {
                    int textoEntrada;
                    textoEntrada = texto.charAt(i);
                    if (textoEntrada == inicial) {
                        escribir.write(13);
                        escribir.write(10);
                        if (k < valores.length - 1) {
                        } else {
                            k = 0;
                        }
                        k++;
                        escribir.write(13);
                        escribir.write(10);
                        for (int j = 0; j < valores[k].length; j++) {
                            escribir.write(valores[k][j]);
                        }
                    } else if (textoEntrada == linea) {
                        escribir.write(13);
                        escribir.write(10);
                        escribir.write(13);
                        escribir.write(10);
                        escribir.write("----");
                    }
                    escribir.write((texto.charAt(i)));
                }
                escribir.close();
            }catch (IOException exc) {
            System.out.println("error entrada o salida");
        }
        }

    }
