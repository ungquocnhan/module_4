package com.exercise.rent_book.config;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {

     static void writeFileCount(String string){
         BufferedWriter bufferedWriter = null;
         try {
             FileWriter fileWriter = new FileWriter(Logger.GHI_LOG);
             bufferedWriter = new BufferedWriter(fileWriter);

             bufferedWriter.write(string + "\n");
             bufferedWriter.newLine();
             bufferedWriter.write(string + "\n");

         }catch (IOException e){
             System.out.println(e.getMessage());
         }
         try {
             if (bufferedWriter != null) {
                 bufferedWriter.close();
             }
         } catch (IOException e) {
             System.out.println(e.getMessage());;
         }
     }

    static void writeFileRent(String string){
        BufferedWriter bufferedWriter = null;
        try {
            FileWriter fileWriter = new FileWriter(Logger.GHI_LOG_RENT);
            bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(string);
            bufferedWriter.newLine();

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        try {
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());;
        }
    }

    static void writeFilePay(String string) {
        BufferedWriter bufferedWriter = null;
        try {
            FileWriter fileWriter = new FileWriter(Logger.GHI_LOG_PAY);
            bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(string);
            bufferedWriter.newLine();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            ;
        }
    }

    static void writeFileException(String string) {
        BufferedWriter bufferedWriter = null;
        try {
            FileWriter fileWriter = new FileWriter(Logger.GHI_LOG_EX);
            bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(string);
            bufferedWriter.newLine();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            ;
        }
    }
}
