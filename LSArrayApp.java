


import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.io.File;

public class LSArrayApp{
	// Class Instances
	public static Data[] lsArray = new Data[2976];
	public static String[] s = new String[2976];
	public static String stageDayTime = null;
	public static String areas = null;
	public static String[] dataArray;
	public static String keyConcatenation;
	public static int opCount = 0;

	// Class properties
	public void printAreas(String stage,String day,String startTime){
		this.keyConcatenation = stage+"_"+day+"_"+startTime;
		
		boolean found = false;
		for(int i = 0;i<=2975;i++){
			opCount++;
			if (this.keyConcatenation.equals(s[i].substring(0, s[i].indexOf(" ")))){
				System.out.println(s[i]);
				found = true;
				break;
			}
			
		}
		if(found == false){
			System.out.println("Areas not found!");
		}

	}

	public void printAllAreas(){
		//for(Data ls:lsArray){
		//	System.out.println(ls);
		for(int i = 0;i<=2975;i++){
			System.out.println(s[i]);
		}
		
	}

	//Main method to run the program
	public static void main(String[] args){
		LSArrayApp lsObject = new LSArrayApp();
		Scanner scannerObject = new Scanner(System.in);

		//reading lines from the file
		try{
			File file = new File("Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt");
			
			Scanner scann = new Scanner(file);
			//populating the dataArray

			int index = 0;
			while(scann.hasNextLine()){
				String line = scann.nextLine();
				
				dataArray = line.split(" ",2);
				
				stageDayTime = dataArray[0];
				areas = dataArray[1];
				Data Data = new Data(stageDayTime,areas);
				lsObject.lsArray[index] = Data;
				lsObject.s[index] = lsArray[index].toString();
				
				index++;
			}
		}
		catch(FileNotFoundException e){e.printStackTrace();}
		

		//lsObject.printAllAreas();
		//lsObject.printAreas("8","35","22");
		try{
		if(args.length > 0){
          System.out.println("stage_Day_time                          | Areas");
          lsObject.printAreas(args[0],args[1],args[2]);
          //System.out.println(args[2].toString());
          System.out.println(opCount+" Comparisons.");
          }
          


      
     else{
             
             
                  
                  System.out.println("stage_Day_time                 | Areas");
                  lsObject.printAllAreas();}
                  
          }
          catch(IndexOutOfBoundsException e){e.printStackTrace();}
        }  
    }
  	


