package fcfs2;
// to  accsept input from the user
 import java.util.Scanner;
public class Fcfs2 {
 public static void main(String[] args) {
     float avr_w_t=0 ;   // average wating time
     System.out.println("Welcome to Our FCFS CPU Schedual Programming");
     System.out.println("============================================");
        Scanner input=new Scanner(System.in); // input
        System.out.print("please, Enter number of process: ");
        int n=input.nextInt();
        //--------------------------------------
        int Wt[]=new int[n]; // wating time 
        int ct[] = new int [n]; // completion time
        int arr[]=new int [n] ; // arriver time
        int Bt[]=new int[n]; // burst time
        int ta[]=new int[n]; //turn arround time
        // to write process and put the burst time of each process
         for(int i=0;i<n;i++){
            System.out.print("Enter process "+(i+1)+" Brust time: ");
            Bt[i]=input.nextInt(); //  process  number 
        }
         System.out.println("");
         // to print words with space 
         System.out.println("Process "+'\t'+"CPU Brust.T");
         
         for(int j=0;j<n;j++){
            System.out.println("process "+(j+1)+'\t'+ Bt[j]);
         }
         // find the avarage wating time 
         for(int  i = 0 ; i < n ; i++)
         {
             if (i == 0) { //if i=0
                 ct[i] = arr[i] + Bt[i]; //completion time = arriver time + turnarround time
             } else {
                 if (arr[i] > ct[i - 1]) { //if arriver time > completion time -1
                     ct[i] = arr[i] + Bt[i]; //completion time = arriver time + burst time 
                 } else {
                     ct[i] = ct[i - 1] + Bt[i]; // completion time =compltion time -1 + burst time 
                 }
             }
             ta[i] = ct[i] - arr[i];          // turnaround time= completion time- arrival time
             Wt[i] = ta[i] - Bt[i] ;          // waiting time= turnaround time- burst time
             avr_w_t+= Wt[i] ;               // total waiting time 
         }
          System.out.println("");
         System.out.println("The Average Waiting Time is: "+ (avr_w_t/n));         
}}