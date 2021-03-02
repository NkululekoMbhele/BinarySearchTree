 import java.util.Scanner;
 import java.io.BufferedReader;
 import java.io.FileReader;
 import java.io.FileNotFoundException;
 import java.io.IOException;

public class LSBSTApp{


    Data data = new Data(null,null);
    public static String stageDayTime;
    public static String areas;
    public static String[] dataArray;
    public static int opCount;
    static LSBSTApp lsObject;
    public static String keyConcatenation;
     
   static BinarySearchTree<Data> BST = new BinarySearchTree<Data>();
   static BinarySearchTree<String> BSTS = new BinarySearchTree<String>();
   
   
   public void printAllAreas(){
      BSTS.inOrder();
   }
   
   public void insert(Data dObject){
   
      BST.insert(dObject);
      BSTS.insert(dObject.toString());
   
   }
   
   public void printAreas(String stageDayTime){

      //String stageDT = stageDayTime.substring(0,stageDayTime.indexOf("_"));  
      System.out.println(BSTS.find(stageDayTime));

      System.out.println(BSTS.getCount()+" Comparisons.");
      //BSTS.setCount();
   
   }//KK

   public void printAreass(String stage,String day,String startTime){

      this.keyConcatenation = stage+"_"+day+"_"+startTime;
      System.out.println(BSTS.find(this.keyConcatenation));

      System.out.println(BSTS.getCount()+" Comparisons.");
    

      
    }


   public static void main(String [] args){
   
       lsObject = new LSBSTApp();
       Scanner scannerObject = new Scanner(System.in);
        
             
     try{   
      // reading the lines from file
        String file = "Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt";
        FileReader powerData = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(powerData);
        String line = bufferedReader.readLine();         
                    
        // populating the BST
        
        //
        while((line = bufferedReader.readLine())!=null){
            dataArray = line.split(" ",2);
            
            
            stageDayTime = dataArray[0];
            areas = dataArray[1];
            Data data = new Data(stageDayTime,areas);
            //lsObject.insert(Data);
            //System.out.println(stageDayTime);/////////////////
            //lsObject.BST.insert(Data);
            lsObject.BSTS.insert(data.toString());
            //lsObject.BST.insert(Data);
         //   System.out.println(lsObject.BST.find(Data));
          //  System.out.println("");

          
         }    
       }
     catch(FileNotFoundException e){ e.printStackTrace();}
     catch(IOException a){a.printStackTrace();}

        if(args.length >0){
          System.out.println("stage_Day_ime                         | Areas");
          lsObject.printAreass(args[0],args[1],args[2]);
          
          }  
          else{   

             System.out.println("stage_Day_time                         | Areas");
                        lsObject.printAllAreas();
          }
        }  
         
        
   


}