/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algo_tests_wfxml;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

/**
 *
 * @author Sam
 */
public class FXMLDocumentController implements Initializable {

    public ArrayList<String> dataBaseStrings = new ArrayList<>(); //database containing names
    public ArrayList<String> dataBaseIntegers = new ArrayList<>(); //database containing integers
    public ObservableList<String> ol = FXCollections.observableArrayList();
    public ListView<String> listView = new ListView<>();
    public boolean isListViewSet = false;
    public String curDB;
    
    public void initialize(URL url, ResourceBundle rb) {
      //Databases are created
      dataBaseStrings.add("Carl");
      dataBaseStrings.add("Steve");
      dataBaseStrings.add("Mark");
      dataBaseStrings.add("Alex");
      dataBaseStrings.add("Martha");
      dataBaseStrings.add("Stewart");
      dataBaseStrings.add("Todd");
      dataBaseStrings.add("Max");
      dataBaseStrings.add("Tyler");
      dataBaseStrings.add("Zack");
      dataBaseStrings.add("Gary");
      dataBaseStrings.add("Carly");
      dataBaseStrings.add("Tyler");
      dataBaseStrings.add("Elyas");
      dataBaseStrings.add("Idoit");
      dataBaseStrings.add("Justin");
      System.out.println("Database Strings set!");
      Random ran = new Random();
      for(int i = 0; i<16; i++){
          String temp = ""+ran.nextInt(100);
          dataBaseIntegers.add(temp);
      }
      System.out.println("Database Integers set!");
    }
    
    //Button Actions
    public void stringDatabaseButtonClicked(){
       if(!isListViewSet){
        curDB = "string";
        for(String x: dataBaseStrings)
            ol.add(x);
        listView.setItems(ol);
        isListViewSet = true;
       }
    }
    public void integerDatabaseButtonClicked(){
       if(!isListViewSet){
       curDB = "integer";
       for (String x: dataBaseIntegers)
           ol.add(x);
       listView.setItems(ol);
       isListViewSet = true;
       }
    }
    public void resetButtonClicked(){
        curDB = "";
        listView.getItems().clear();
        ol.clear();
        randomizeInts();
        isListViewSet = false;
    }
    public void bucketSortButtonClicked(){
        if(!isListViewSet)
            System.out.println("No List has been set!");
        else
            bucketSort(curDB);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    //Alogrithm Methods
    public void bucketSort(String selectDB){
        ObservableList<String> newList = FXCollections.observableArrayList();
        if(selectDB.equals("string")){
          int size = 26; //26 letters in the Alphabet
          String[] temp = new String[size];
          for(int i = 0; i < size; i++)
              temp[i] = "*";
          for (String x: dataBaseStrings){
              int numOfAlph = checkAlphaNumber(x);
              temp = updatedTempBuS(temp,numOfAlph,x);
          }
          for(String x : temp){
              if(!x.equals("*"))
                  newList.add(x);
          }
          listView.setItems(newList);
        }
        
        
        
        
        else if(selectDB.equals("integer")){
            int size = 100; //100 possible items
            String[] temp = new String[size];
            for(int i =0; i<100; i++){
                temp[i] = "*";
            }
            for(String x : dataBaseIntegers){
                int curr = Integer.parseInt(x);
                if(!x.equals("99") && !temp[curr].equals("*")){
                    for(int i = curr+1; i<100; i++)
                         if(temp[i].equals("*")){
                             temp[i] = x;
                             break;
                         }
                }
                else
                    temp[curr] = x;
            }
            for(String x : temp)
                if(!x.equals("*")){
                    newList.add(x);
                }
            listView.setItems(newList);
        }
    }
    
    
    public String bubbleSort(){
        return null;
    }
    
    
    public String selectionSort(){
        return null;
    }
    
    
    public String insertionSort(){
        return null;
    }
    
    
    public String mergeSort(){
        return null;
    }
    
    
    
    
    
    
    
    
    //Helper Methods
    private void randomizeInts() {
       dataBaseIntegers.clear();
       Random ran = new Random();
      for(int i = 0; i<16; i++){
          String temp = ""+ran.nextInt(100);
          dataBaseIntegers.add(temp);
      }
    }

    private Integer checkAlphaNumber(String x) {
       String firstLetter = x.substring(0,1);
       if(firstLetter.equals("A"))
           return 0;
       if(firstLetter.equals("B"))
           return 1;
       if(firstLetter.equals("C"))
           return 2;
       if(firstLetter.equals("D"))
           return 3;
       if(firstLetter.equals("E"))
           return 4;
       if(firstLetter.equals("F"))
           return 5;
       if(firstLetter.equals("G"))
           return 6;
       if(firstLetter.equals("H"))
           return 7;
       if(firstLetter.equals("I"))
           return 8;
       if(firstLetter.equals("J"))
           return 9;
       if(firstLetter.equals("K"))
           return 10;
       if(firstLetter.equals("L"))
           return 11;
       if(firstLetter.equals("M"))
           return 12;
       if(firstLetter.equals("N"))
           return 13;
       if(firstLetter.equals("O"))
           return 14;
       if(firstLetter.equals("P"))
           return 15;
       if(firstLetter.equals("Q"))
           return 16;
       if(firstLetter.equals("R"))
           return 17;
       if(firstLetter.equals("S"))
           return 18;
       if(firstLetter.equals("T"))
           return 19;
       if(firstLetter.equals("U"))
           return 20;
       if(firstLetter.equals("V"))
           return 21;
       if(firstLetter.equals("W"))
           return 22;
       if(firstLetter.equals("X"))
           return 23;
       if(firstLetter.equals("Y"))
           return 24;
       if(firstLetter.equals("Z"))
           return 25;
       return 0;
    }

    private String[] updatedTempBuS(String[] temp, int numOfAlph, String x) {
        String[] newTemp = temp;
        if(numOfAlph != 25 && !temp[numOfAlph].equals("*")){
            for(int i = numOfAlph+1; i < 26; i++){
               if(newTemp[i].equals("*")){
                   newTemp[i] = x;
                   return newTemp;
               }
            }
        }
        else
            newTemp[numOfAlph] = x;
            
        
        return newTemp;
    }
}
