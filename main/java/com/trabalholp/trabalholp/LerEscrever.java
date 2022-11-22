package com.trabalholp.trabalholp;

import java.io.*;
import java.util.ArrayList;

public class LerEscrever {
    static File arquivo = new File("c:/temp/login.txt");
    public static void gravarArquivo(usuario usuario1) {

        try {

            if (arquivo.exists()) {
                arquivo.delete();
            }

            arquivo.createNewFile();



            FileWriter fw = new FileWriter(arquivo, true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(usuario1.getUsuario());
            bw.newLine();
            bw.write(usuario1.getSenha());
            bw.newLine();

            bw.close();
            fw.close();
        }

        catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    public static usuario lerArquivo() {

        usuario usuario1 = new usuario("","");

        try {

            FileReader fr = new FileReader(arquivo);

            BufferedReader br = new BufferedReader(fr);

            String senha = br.readLine();
            String nome = br.readLine();
            usuario1.setUsuario(nome);


            usuario1.setSenha(senha);


            br.close();
            fr.close();
        }

        catch (IOException ex) {
            ex.printStackTrace();
        }


        return usuario1;
    }

    public static void gravarArquivoNotas(usuario usuario1, ArrayList<Nota> notas) {

        try {
            FileOutputStream fos = new FileOutputStream("c:/temp/"+usuario1.getUsuario()+"notas.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(notas);
            oos.close();
            fos.close();
        }

        catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public static ArrayList<Nota> lerArquivoNotas(usuario usuario1) {

        ArrayList<Nota> notas = new ArrayList<>();

        try {
            FileInputStream fis = new FileInputStream("c:/temp/" + usuario1.getUsuario() + "notas.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);

            notas = (ArrayList) ois.readObject();

            ois.close();
            fis.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }

        return notas;

    }

}
