/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio7.pkg1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Alberto Real
 */
public final class bytestream {

    public bytestream() {
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
    
    public static void readAndWtrite() throws FileNotFoundException, FileException {
        int i;
        int k = 0;
        char inicial = '#';
        char linea = '{';
        String valores[][] = {{},{"publicacion: "}, {"director: "}, {"durcion: "},
        {"sinopsis: "}, {"reaparto: "}, {"session: "}};
        try (FileInputStream texto = new FileInputStream(entrada("entrada")); 
                FileOutputStream salida = new FileOutputStream(entrada("salida"))) {
            do {
                i = texto.read();
                if (i != -1) {
                    if ((char) i == inicial) {
                        if (k == 0) {
                            salida.write(45);
                            salida.write(45);
                            salida.write(45);
                            salida.write(45);
                        }
                        salida.write(13);
                        salida.write(10);
                        if (k < valores.length-1) {
                        } else {
                            k = 0;
                        }k++;
                        salida.write(13);
                        salida.write(10);
                        for (int j = 0; j < valores[k].length; j++) {
                            byte[] Stringtobyte = valores[k][j].getBytes();
                            salida.write(Stringtobyte);
                        }
                    } else if ((char) i == linea) {
                        salida.write(13);
                        salida.write(10);
                        salida.write(13);
                        salida.write(10);
                        salida.write(45);
                        salida.write(45);
                        salida.write(45);
                        salida.write(45);
                    } else {
                        salida.write(i);
                    }
                }
            } while (i != -1);
        } catch (IOException exc) {
        }
    }
}
