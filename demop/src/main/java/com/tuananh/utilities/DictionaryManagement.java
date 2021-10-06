package com.tuananh.utilities;

import com.tuananh.entities.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class DictionaryManagement {
  public void insertFromCommandline() {
    Scanner scanner = new Scanner(System.in);
    int numberOfVocabulary = scanner.nextInt();
    scanner.nextLine();

    for (int i = 0; i < numberOfVocabulary; i++) {
      String wordTarget = scanner.nextLine();
      String wordExplain = scanner.nextLine();

      Word word = new Word(wordTarget, wordExplain);
      VariableManagement.D.listWords.add(word);
    }

    scanner.close();
  }

  public void insertFromFile() {
    try {
      File dictionary = new File("src/main/java/com/tuananh/resource/dictionaries.txt");
      BufferedReader reader = new BufferedReader(new FileReader(dictionary));

      String data = "";
      try {
        while ((data = reader.readLine()) != null) {
          if (data.equals("")) {
            continue;
          }
          System.out.println(data);
          String[] temp = data.split("\\+");

          String wordTarget = temp[0];
          String wordExplain = temp[1];
          // for (int i = 0; i < temp.length; i++) {
          //   if (i == 0) {
          //     wordTarget = temp[i];
          //   }
          //   wordExplain = temp[i];
          // }
          Word word = new Word(wordTarget, wordExplain);
          VariableManagement.D.listWords.add(word);
        }
        reader.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  public void dictionaryLookup() {
    Scanner scanner = new Scanner(System.in);
    String word = scanner.nextLine();
    
    String result = null;
    for (int i = 0; i < VariableManagement.D.listWords.size(); i++) {
      String target = VariableManagement.D.listWords.get(i).getWordTarget();
      if (word.equals(target)) {
        result = VariableManagement.D.listWords.get(i).getWordExplain();
        break;
      }
    }

    if (result != null) {
      System.out.println(word + ": " + result);
    } else {
      System.out.println(word + " doesn't exist in dictionary");
    }

    scanner.close();
  }

  public void addWord() {
    System.out.println("adding...");
    Scanner scanner = new Scanner(System.in);
    
    if (scanner.hasNextLine()) {
      String wordTarget = scanner.nextLine();
      String wordExplain = scanner.nextLine();
      VariableManagement.D.listWords.add(new Word(wordTarget, wordExplain));
      System.out.println("added");
    }

    scanner.close();
  }

  public void dictionaryEdit() {

  }
}