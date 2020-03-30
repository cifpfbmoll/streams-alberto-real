/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio7.pkg1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.StringWriter;
import java.io.PrintWriter;

/**
 *
 * @author Alberto Real
 */
public class bytestream {

    public bytestream() {
    }

    public void readAndWtrite(String origen, String destino) throws FileNotFoundException {
        int i;
        int k = 0;
        char inicial = '#';
        char linea = '{';
        String valores[][] = {{},{"publicacion: "}, {"director: "}, {"durcion: "},
        {"sinopsis: "}, {"reaparto: "}, {"session: "}};
        try (FileInputStream entrada = new FileInputStream(origen); 
                FileOutputStream salida = new FileOutputStream(destino)) {
            do {
                i = entrada.read();
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
            System.out.println("error de fichero origen ");
            errorlog(exc);
        }
    }

    public void errorlog(IOException exc) throws FileNotFoundException {
        Date fecha = new Date();
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        exc.printStackTrace(pw);
        String sStackTrace = sw.toString(); // stack trace as a string
        DateFormat fechaHora = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy  ");
        try (FileOutputStream errorlog = new FileOutputStream("D:\\log.txt", true)) {
            byte[] strToBytes = sStackTrace.getBytes();
            byte[] fechatobyte = fechaHora.format(fecha).getBytes();
            errorlog.write(13);
            errorlog.write(10);
            errorlog.write(fechatobyte);
            errorlog.write(strToBytes);
        } catch (IOException es) {
            System.out.println("error");
        }
    }
}
