/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio7.pkg1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        String valores[][] = {{}, {"publicacion: "}, {"director: "}, {"durcion: "},
        {"sinopsis: "}, {"reaparto: "}, {"session: "}};
        File entrada = new File(origen);
        try (FileReader lector = new FileReader(entrada)) {
            int unCaracter;
            while ((unCaracter = lector.read()) != -1) {
                if (unCaracter == inicial) {
                    unCaracter=0;
                    System.out.println("");
                    if (k < valores.length - 1) {
                    } else {
                        k = 0;
                    }
                    k++;
                    System.out.println("");
                    for (int j = 0; j < valores[k].length; j++) {
                        System.out.print(valores[k][j]);
                    }
                } else if (unCaracter == linea) {
                    unCaracter=0;
                    System.out.println("");
                    System.out.println("");
                    System.out.print("----");
                }
                System.out.print((char) unCaracter);
            }
            lector.close();
        } catch (IOException exc) {
              String error = "la ruta introducida para el fichero de destino es \n"
                    + "incorrecta o insesistente";
            errorlog(exc,error);
            System.out.println("error");
        }
    }
    public void readAndWrite(String origen, String destino) throws FileNotFoundException, IOException {
        int k = 0;
        char inicial = '#';
        char linea = '{';
        String valores[][] = {{}, {"publicacion: "}, {"director: "}, {"durcion: "},
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
             String error = "la ruta introducida para el fichero de destino es \n"
                    + "incorrecta o insesistente";
            errorlog(exc,error);
        }
        File salida = new File(destino);
         if (salida.exists()==false){
                throw new FileNotFoundException();
            }
        try (FileWriter escribir = new FileWriter(salida)) {
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
        } catch (IOException exc) {
              String error = "la ruta introducida para el fichero de destino es \n"
                    + "incorrecta o insesistente";
            errorlog(exc,error);
            System.out.println("error de salida");
        }
    }
    public void errorlog(IOException exc, String error) throws FileNotFoundException {
        Date fecha = new Date();
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        exc.printStackTrace(pw);
        String sStackTrace = sw.toString(); // stack trace as a string
        DateFormat fechaHora = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy  ");
        try (FileOutputStream errorlog = new FileOutputStream("D:\\log.txt", true)) {
            byte[] strToBytes = sStackTrace.getBytes();
            byte[] mensaje = error.getBytes();
            byte[] fechatobyte = fechaHora.format(fecha).getBytes();
            errorlog.write(13);
            errorlog.write(10);
            errorlog.write(fechatobyte);
            errorlog.write(mensaje);
            errorlog.write(13);
            errorlog.write(10);
            errorlog.write(strToBytes);
        } catch (IOException es) {
            System.out.println("error añadido al log");
        }
    }
}
