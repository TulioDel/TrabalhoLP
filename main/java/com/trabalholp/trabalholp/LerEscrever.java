package com.trabalholp.trabalholp;

import java.io.*;

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

}
