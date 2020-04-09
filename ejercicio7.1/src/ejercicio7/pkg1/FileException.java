/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio7.pkg1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
public class FileException extends Exception  {

    public FileException() {
    }

    public FileException(String mensaje) {
        super(mensaje);
    }
    public void errorlog() throws FileNotFoundException {
        Date fecha = new Date();
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        this.printStackTrace(pw);
        String sStackTrace = sw.toString(); // stack trace as a string
        DateFormat fechaHora = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy  ");
        try (FileOutputStream errorlog = new FileOutputStream("d:\\log.txt", true)) {
            byte[] strToBytes = sStackTrace.getBytes();
            byte[] mensaje = super.getMessage().getBytes();
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
