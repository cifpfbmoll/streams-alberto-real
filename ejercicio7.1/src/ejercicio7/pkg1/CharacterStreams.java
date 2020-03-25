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
/**
 *
 * @author Alberto Real
 */
public class CharacterStreams {

    public CharacterStreams() {
    }

    public void readAndPrint(String origen) throws FileNotFoundException, IOException {
        int k = 0;
        char inicial = '#';
        char linea = '{';
        String prueba[][] = {{}, {"publicacion: "}, {"director: "}, {"durcion: "},
        {"sinopsis: "}, {"reaparto: "}, {"session: "}};
        File entrada = new File(origen);
        try (FileReader lector = new FileReader(entrada)) {
            int unCaracter;
            while ((unCaracter = lector.read()) != -1) {
                if (unCaracter == inicial) {
                    System.out.println("");
                    if (k < prueba.length - 1) {
                    } else {
                        k = 0;
                    }
                    k++;
                    System.out.println("");
                    for (int j = 0; j < prueba[k].length; j++) {
                        System.out.print(prueba[k][j]);
                    }
                } else if (unCaracter == linea) {
                    System.out.println("");
                    System.out.println("");
                    System.out.print("----");
                }
                System.out.print((char) unCaracter);
            }
            lector.close();
        } catch (IOException exc) {
            System.out.println("error");
        }
    }

    public void readAndWrite(String origen, String destino) throws FileNotFoundException, IOException {
        int k = 0;
        char inicial = '#';
        char linea = '{';
        String prueba[][] = {{}, {"publicacion: "}, {"director: "}, {"durcion: "},
        {"sinopsis: "}, {"reaparto: "}, {"session: "}};
        String texto = " ";
        File entrada = new File(origen);
        try (FileReader lector = new FileReader(entrada)) {
            int unCaracter;
            while ((unCaracter = lector.read()) != -1) {
                texto += ((char) unCaracter);
            }
        } catch (IOException exc) {
            System.out.println("error de entrada");
        }
        File salida = new File(destino);
        try (FileWriter escribir = new FileWriter(salida)) {
            for (int i = 0; i < texto.length(); i++) {
                int textoEntrada;
                textoEntrada = texto.charAt(i);
                if (textoEntrada == inicial) {
                    escribir.write(13);
                    escribir.write(10);
                    if (k < prueba.length - 1) {
                    } else {
                        k = 0;
                    }
                    k++;
                    escribir.write(13);
                    escribir.write(10);
                    for (int j = 0; j < prueba[k].length; j++) {
                        escribir.write(prueba[k][j]);
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
        }catch(IOException exc){
            System.out.println("error de salida");
        }
    }
}
