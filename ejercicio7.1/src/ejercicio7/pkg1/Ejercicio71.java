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
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 *
 * @author Alberto Real
 */
public class Ejercicio71 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        // TODO code application logic here
        mostrarMenu();
    }

    public static void mostrarMenu() throws FileNotFoundException, IOException, ClassNotFoundException {
        Scanner entrada = new Scanner(System.in);
        System.out.println(" 1 para byte stream\n"
                + " 2 para chart stream\n"
                + " 3 para buffer stream \n"
                + " 4 objetos\n "
                + " 5 salir ");
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
                    String error = "la ruta introducida para el fichero de destino es \n"
                            + "incorrecta o insesistente";
                    c1.errorlog(ex, error);
                }
                mostrarMenu();
                break;
            }
            case 3: {
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
                    String error = "la ruta introducida para el fichero de destino es "
                            + "incorrecta o insesistente";
                    b1.errorlog(ex, error);
                }
                mostrarMenu();
                break;
            }
            case 4: {
                submenu();
            }
        }
    }

    public static void printPelis(String objeto) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream objetoFile = null;
        File fichero = new File(objeto);
        FileInputStream Finput = new FileInputStream(fichero);
        objetoFile = new ObjectInputStream(Finput);
        for (int i = 0; i < 2; i++) {
            Pelicula p1 = (Pelicula) objetoFile.readObject();
            System.out.println("nombre : " + p1.getNombre());
        }
    }

    public static void ficheroObjeto(String entrada) throws FileNotFoundException, IOException {
        File objeto = new File("d:\\objeto.obj");
        FileOutputStream Fout = new FileOutputStream(objeto);
        ObjectOutputStream objetoFile = new ObjectOutputStream(Fout);
        BufferStream b1 = new BufferStream();
        String[] print = {};
        print = b1.pelicula(entrada);
        for (int i = 0; i < print.length / 7; i++) {
            int k = i * 7;
            Pelicula p1 = new Pelicula(print[0 + k], print[1 + k], print[2 + k], print[3 + k], print[4 + k], print[5 + k], print[6 + k]);
            objetoFile.writeObject(p1);
        }
    }

    public static void submenu() throws IOException, ClassNotFoundException {
        Scanner entrada = new Scanner(System.in);
        System.out.println(" 1 lectura linea a linea y escritura con objetos\n"
                + " 2 lectura de objetos y escritura de objetos\n"
                + " 3 lectura de obejtos y presentacion \n"
                + " 4 new objeto por teclado \n"
                + " 5 volver al menu anterior");
        int menu = entrada.nextInt();
        switch (menu) {
            case 1: {
                ficheroObjeto("C:\\entrada.txt");
                submenu();
                break;
            }
            case 2: {
                break;
            }
            case 3: {
                printPelis("d:\\objeto.obj");
                submenu();
                break;
            }
        }

    }
}
