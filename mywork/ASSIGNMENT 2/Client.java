/*CLIENT CLASS*/
import java.net.*;
import java.io.*;
import java.util.Scanner;  // Import the Scanner class
import java.util.*;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;


import java.util.Calendar; 
import java.util.GregorianCalendar; 
import java.util.concurrent.*;



import java.io.IOException;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.io.File; 
import java.io.IOException;
import java.io.*;
import java.util.*;
import java.text.MessageFormat;


import java.io.File;
import java.nio.file.*;









public class Client
{
            public static void main(String args[])throws Exception
            {
              run();
            }

            public static void run()
            {         


                Calendar start = Calendar.getInstance();
               
                Calendar end = Calendar.getInstance();
              

//LOGIC FOR FILE DISPLAY 

            try{           
                 String dirPath = "C:\\Users\\dell\\Desktop\\clientfolder\\";
            //     String dirPathServer = "C:\\Users\\dell\\Desktop\\codes\\networklab\\Serverfolder\\";

                  File dir = new File(dirPath);
                  String[] files = dir.list();
                  if (files.length == 0) {
                      System.out.println("The directory is empty");
                  } 
                  else 
                  {
                  System.out.println("---------CLIENT SIDE FILES---------:\n");
                    for (String aFile : files) {
                      System.out.println(aFile);
                         }

                  }
                  
                
                   Scanner sc = new Scanner(System.in);
                  //int option  = sc.nextInt();

               
             




// PART A)

      //SUBPART A.1      

//logic to transfer filename over stream
Date startDate = start.getTime();
long startTime = startDate.getTime();


                  System.out.println("ENTER THE NAME OF FILE YOU WANT TO DOWNLOAD SERVERSIDE:");
                  String choiceclient  = sc.nextLine();

                 InetAddress ip = InetAddress.getByName("127.0.0.1");  
                  DatagramSocket ds = new DatagramSocket();  
                  
int tranfer1 =  choiceclient.length();

                  DatagramPacket dp = new DatagramPacket(choiceclient.getBytes(), choiceclient.length(), ip, 3000);  
                  ds.send(dp);  
                  ds.close(); 

  //    //SUBPART A.4     


                  byte receiveData1[]=new byte[1024  * 500];
                   DatagramSocket dsoc=new DatagramSocket(1000);
                 //   dsoc.setReceiveBufferSize(1024 * 1000 * 50);  
               //  System.out.println("reicevr Buffer size: "+dsoc.getReceiveBufferSize());  

                // FileOutputStream outee=new FileOutputStream(dirPath + choiceclient);
                    
                  // String FILEPATH = "D:\\sample.jpg"; 
                   File file = new File(dirPath + choiceclient);

                  OutputStream outee  = new FileOutputStream(file); 

               // FileWriter outee = new FileWriter(new File(dirPath + choiceclient));


 Date endDate = end.getTime();
 long endTime = endDate.getTime();
                  System.out.println("FILE HAS BEEN SUCCESFULLY DOWNLOADED TO :" + dirPath);                  
                  
                  

               try {
                     int counterwhile = 0;  

         
                  while(counterwhile  < 1)
                        {
                        DatagramPacket dpac=new DatagramPacket(receiveData1,receiveData1.length);
                        dsoc.receive(dpac);
                        //String words = new String(dpac.getData(),0,dpac.getLength(),"UTF-8"); 
                        
                        outee.write(receiveData1); 

                       // outee.write(words.getBytes());

                        counterwhile+=1;

                        }
                }
                catch (Exception e) {
                    System.out.println("Error while recieve: "+e);
                }

                 
     
 int receive1 = receiveData1.length;
                  //  double socktime = dsoc.getSoTimeout();
                    dsoc.close();  

                //  System.out.println("socket time client file :" + time);                  

        //}

                 
//PART B)

//logic for decoding the choice sent over stream

    //SUBPART B.2      
                DatagramSocket ds1 = new DatagramSocket(5000);  
                byte[] buf1 = new byte[1024];  
                DatagramPacket dp1 = new DatagramPacket(buf1, 1024);  
                ds1.receive(dp1);  
               String choiceserver = new String(dp1.getData(), 0, dp1.getLength());  

  int receive2 =  choiceserver.length();

              //System.out.println(choice);  
                ds1.close();  
                



    //SUBPART B.3  
                      










            byte b[]=new byte[1024 * 1000 * 50];  //51200000 Bytes = 48.828125 MB
                FileInputStream f=new FileInputStream(dirPath + choiceserver);
                byte[] arrayfile = Files.readAllBytes(Paths.get(dirPath + choiceserver));                

                DatagramSocket dsoc1=new DatagramSocket();
                
             //  System.out.println("actual bytes to send: "+arrayfile);  

             //  System.out.println("byte total size: "+arrayfile.length);  
     
             //  byte SmallerByteArr[] = new byte[1024*60];  
           //   byte SmallerByteArr0[] = new byte[1024*60];  
           //    byte SmallerByteArr1[] = new byte[1024*60];  
          //     byte SmallerByteArr2[] = new byte[1024*60];  

            // int chunk = 1024*60;  // chunk size
           //  int len = arrayfile.length;
              int counter = 0;
int transfer2 = arrayfile.length;

             dsoc1.send(new DatagramPacket(arrayfile,arrayfile.length,InetAddress.getLocalHost(),6000));

           //   SmallerByteArr = Arrays.copyOfRange(arrayfile,counter, chunk);
            //  SmallerByteArr0= Arrays.copyOfRange(arrayfile,chunk, chunk + chunk);
            //   SmallerByteArr1 = Arrays.copyOfRange(arrayfile, chunk + chunk, chunk+chunk+chunk);   
             //  SmallerByteArr2 = Arrays.copyOfRange(arrayfile, len - len % chunk, len);
           /// /       
               // f.close();


             //  dsoc.send(new DatagramPacket(SmallerByteArr,SmallerByteArr.length,InetAddress.getLocalHost(),1000));
             //  dsoc.send(new DatagramPacket(SmallerByteArr0,SmallerByteArr1.length,InetAddress.getLocalHost(),1000));
            //   dsoc.send(new DatagramPacket(SmallerByteArr1,SmallerByteArr1.length,InetAddress.getLocalHost(),1000));
            //    dsoc.send(new DatagramPacket(SmallerByteArr2,SmallerByteArr2.length,InetAddress.getLocalHost(),1000));

                dsoc1.close();  










  
   
              
            

//LOG FILE CODE
               Logger logger = Logger.getLogger("MyLog");  

                 FileHandler fh;  

                  // This block configure the logger with handler and formatter  
                  fh = new FileHandler("ClientLogFile.log");  
                   logger.addHandler(fh);

                  SimpleFormatter formatter = new SimpleFormatter();  
                    fh.setFormatter(formatter); 
                 int a = 5; 
                 //String aVariable = "of ponies";

                 int transfer = tranfer1 + transfer2;
                 int recieve = receive1+ receive2;
                 long diffTime = endTime - startTime;



                 long duration = (endTime - startTime);  //Total execution time in milli seconds

                  String stringqwer = MessageFormat.format(" START TIME {0} || END TIME: {1}|| TRANSFERRED BYTES: {2}  || RECIEVED BYTES  : {3} || SOCKET_ACTIVE_TIME : {4}milliseconds" 
                    ,startDate,endDate,transfer,recieve,duration); 
                // the following statement is used to log any messages  
                // String a ="ACTIVITY     || START TIME   || END TIME  ||  NoOfBytesTransffered || SOCKETTIME ";
                 // logger.info(a);  
                  logger.info(stringqwer);  














                 }

                 catch (Exception e)
                  {
                 System.out.println(e.toString());
                  }

             



            }

}
