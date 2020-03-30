/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio7.pkg1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
/**
 *
 * @author Alberto Real
 */
public class Ejercicio71 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        mostrarMenu();
    }

    public static void mostrarMenu() throws FileNotFoundException {
        Scanner entrada = new Scanner(System.in);
        System.out.println(" 1 para byte stream\n"
                + " 2 para chart stream\n"
                + " 3 para buffer stream \n"
                + " 4 salir");
        int menu = entrada.nextInt();
        switch (menu) {
            case 1: {
                Scanner texto = new Scanner(System.in);
                bytestream b1 = new bytestream();
                System.out.println("origen");
                String origen = texto.nextLine();
                System.out.println("destino");
                String destino = texto.nextLine();
                b1.readAndWtrite(origen, destino);
                mostrarMenu();
                break;
            }
            case 2: {
                CharacterStreams c1 = new CharacterStreams();
                try {
                    Scanner texto = new Scanner(System.in);
                    System.out.println("origen");
                    String origen = texto.nextLine();
                    System.out.println("destino");
                    String destino = texto.nextLine();
                    c1.readAndPrint(origen);
                    c1.readAndWrite(origen, destino);
                } catch (IOException ex) {
                    System.out.println("error fichero salida");
                    c1.errorlog(ex);
                }
                mostrarMenu();
                break;
            }case 3:{
                      BufferStream b1 = new BufferStream();
                try {
                    Scanner texto = new Scanner(System.in);
                    System.out.println("origen");
                    String origen = texto.nextLine();
                    System.out.println("destino");
                    String destino = texto.nextLine();
                    b1.readAndPrint(origen);
                    b1.readAndWrite(origen, destino);
                } catch (IOException ex) {
                    System.out.println("error fichero salida");
                    b1.errorlog(ex);
                }
                mostrarMenu();
                break;
            }
        }
    }

}
