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
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Alberto Real
 */
public class BufferStream {

    public BufferStream() {
    }

    public void readAndPrint(String entrada) throws IOException {
        int k = 0;
        String valores[][] = {{"----"}, {"publicacion: "}, {"director: "}, {"durcion: "},
        {"sinopsis: "}, {"reaparto: "}, {"session: "}};
        File texto = new File(entrada);
        try (BufferedReader lector = new BufferedReader(new FileReader(texto))) {
            boolean finArchivo = false;
            String linea = "";
            String[] finLinea = null;
            while (!finArchivo) {
                linea = lector.readLine();
                if (linea != null) {
                    finLinea = linea.split("[\\{#]");
                    for (int i = 0; i < finLinea.length; i++) {
                        for (int j = 0; j < valores[k].length; j++) {
                            System.out.print(valores[k][j]);
                        }
                        if (k == 6) {
                            k = 0;
                        } else {
                            k++;
                        }
                        System.out.println(finLinea[i]);
                    }
                } else {
                    finArchivo = true;
                }
            }
            lector.close();
        } catch (IOException exc) {
            String error = "la ruta introducida para el fichero de destino es \n"
                    + "incorrecta o insesistente";
            errorlog(exc, error);
        }
    }

    public void readAndWrite(String entrada, String destino) throws IOException {
        int k = 0;
        String linea = "";
        String test = "";
        String valores[][] = {{}, {"publicacion: "}, {"director: "}, {"durcion: "},
        {"sinopsis: "}, {"reaparto: "}, {"session: "}};
        File texto = new File(entrada);
        try (BufferedReader lector = new BufferedReader(new FileReader(texto))) {
            linea = lector.readLine();
            lector.close();
            File salida = new File(destino);
            if (salida.exists() == false) {
                throw new FileNotFoundException();
            }
            try (BufferedWriter escritura = new BufferedWriter(new FileWriter(salida))) {
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
                System.out.println("error salida");
            }
        } catch (IOException exc) {
            System.out.println("error de fichero");
            String error = "la ruta introducida para el fichero de destino es \n"
                    + "incorrecta o insesistente";
            errorlog(exc, error);
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
            errorlog(exc, "error entrada");
        }
        return salida;
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
