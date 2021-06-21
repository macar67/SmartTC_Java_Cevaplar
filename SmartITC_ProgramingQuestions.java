
package smartıtc_programingquestions;

import static java.lang.Integer.min;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SmartITC_ProgramingQuestions {

 
    public static void main(String[] args) {
      
        System.out.println("Merhaba ben Muhammet Acar ");
        System.out.println("Burada bana vermiş olduğunuz assigment sorularını yanıtlamaya çalışacağım");
        System.out.println("---------------------------------------------------------------------------");
    
        System.out.println("Soru 1 ");
        calculateWorkerSalary(45,12);
        System.out.println("-----------------");
        
        System.out.println("Soru 2 ");
        /*
          Bu soruda sıralama algoritması olarak bublesort kullandım.Worst case de o(n2) de çalışıyor fakat implementasyonu "
          kolay ve bu soru özelinde 20 inputluk veri için daha iyi performanslı çalıçan mergeSort yada 
          CountingSort algoritmalarını kullanma gereği duymadım."
          Çünkü çok büyük farklılıklar oluşturmayacak 20 input için.
        */
        
         int[] arr= {2,3,5,4,78,45,124,78,95,76,41,79,100,1,101,101,245,74,12,20};
         bubbleSort(arr);
         System.out.println("Bu soruda sıralama algoritması olarak bublesort kullandım.Worst case de o(n2) de çalışıyor fakat implementasyonu "
                 + "kolay ve bu soru özelinde 20 inputluk veri için daha iyi performanslı çalıçan mergeSort yada CountingSort algoritmalarını kullanma gereği duymadım."
                 + "Çünkü çok büyük farklılıklar oluşturmayacak 20 input için.");
        System.out.println("-----------------");
        
        System.out.println("Soru 3 ");
      
         smartConverter("Eksi Altı Milyon Dört Yüz On iki Bin Yüz Doksan Beş");
         smartConverter("Eksi Beş Milyon Dokuz Yüz Bin iki Yüz Doksan Beş");
         smartConverter("Artı Dört Milyon Dokuz Yüz Bir Bin üç yüz");
         smartConverter("ÜÇ Milyon Dokuz Yüz Bir Bin Yüz Beş");
         smartConverter("dokuz Milyon Dokuz Yüz Bir Bin Yüz Doksan");
        System.out.println("-----------------");
        System.out.println("Soru 4 ");
        int[] arryOfNumbers={9,0,6,7,10,2,3};
        calculateWaterAmount(arryOfNumbers);
        System.out.println("-----------------");
       
        
    }
    public static double calculateWorkerSalary(float workingHour,double salaryPerHour)  {
           double finalSalary;
          if(0<workingHour  && workingHour<40){
              
              finalSalary=workingHour*salaryPerHour;
              System.out.println(finalSalary);
              return finalSalary;
              
        }
          else if(workingHour>40 || workingHour==40){
              finalSalary=workingHour*salaryPerHour*2;
               System.out.println(finalSalary);
              return finalSalary;
        } else{ 
              System.out.println("!!! Eksi Girilen Değerler için  hesaplama yapılmamaktadır !!!");
              return -1;
          }
    }
    public static void bubbleSort(int sortAry[]) {
        boolean change = false;
        do {
           change = false;
           for(int i=1; i<sortAry.length; i++) {
              if( sortAry[i-1] > sortAry[i] ) {
                 int temp = sortAry[i];
                 sortAry[i] = sortAry[i-1];
                 sortAry[i-1] = temp;
                 change = true;
              }
           }
            
        } while(change);
        System.out.println((Arrays.toString(sortAry)));
        
}
    public static void smartConverter(String number){
             number = number.toUpperCase();
            int totalMilyon=0;
            int totalThousand=0;
            int totalThousandCoeff=0;
            int totalNumbers=0;
            int totalNumbersCoeff=0;
            int coeff=1;
            int result =0;
           
      
            String[] parts = number.split(" ");
            String partOfSign = parts[0]; 
            if(partOfSign.toUpperCase().equals("EKSİ")){
                coeff=-1;
            }
            String[] partsOfMillion = number.split("MİLYON");
            List<String> list = Arrays.asList(parts);        
           
            List<String> pureNumbers=list.subList(1,list.size());
            
            
            for(int i=0;i<pureNumbers.size();i++){
             if(pureNumbers.get(i).equals("MİLYON")){
                 for(int j=0;j<i;j++){
                     switch(pureNumbers.get(j)){
                         case "BİR":
                             totalMilyon+=1;
                             break;
                        case "İKİ":
                             totalMilyon+=2;
                             break;    
                        case "ÜÇ":
                             totalMilyon+=3;
                             break;
                        case "DÖRT":
                             totalMilyon+=4;
                             break;  
                        case "BEŞ":
                             totalMilyon+=5;
                             break; 
                        case "ALTI":
                             totalMilyon+=6;
                             break; 
                        case "YEDİ":
                             totalMilyon+=7;
                             break;
                        case "SEKİZ":
                             totalMilyon+=8;
                             break; 
                        case "DOKUZ":
                             totalMilyon+=9;
                             break; 
                        case "ON":
                             totalMilyon+=10;
                             break;    
                     }
                 }
                 totalMilyon*=1000000;
                
                 pureNumbers=pureNumbers.subList(i+1, pureNumbers.size());
                 break;
             }   
             
            }
      
             for(int i=0;i<pureNumbers.size();i++){
                
             if(pureNumbers.get(i).equals("BİN")){
                
                 for(int j=0;j<i;j++){
                   
                    if(j==0 && pureNumbers.get(0).equals("YÜZ")){
                        totalThousand+=100;
                        continue;
                    }
                     switch(pureNumbers.get(j)){
                        case "BİR":
                             totalThousand+=1;
                             break;
                        case "İKİ":
                             totalThousand+=2;
                             break;    
                        case "ÜÇ":
                             totalThousand+=3;
                             break;
                        case "DÖRT":
                             totalThousand+=4;
                             break;  
                        case "BEŞ":
                             totalThousand+=5;
                             break; 
                        case "ALTI":
                             totalThousand+=6;
                             break; 
                        case "YEDİ":
                             totalThousand+=7;
                             break;
                        case "SEKİZ":
                             totalThousand+=8;
                             break; 
                        case "DOKUZ":
                             totalThousand+=9;
                             break; 
                        case "ON":
                             totalThousand+=10;
                             break;    
                        case "YİRMİ":
                             totalThousand+=20;
                             break;  
                        case "OTUZ":
                             totalThousand+=30;
                             break;  
                        case "KIRK":
                             totalThousand+=40;
                             break;  
                        case "ELLİ":
                             totalThousand+=50;
                             break;  
                        case "ALTMIŞ":
                             totalThousand+=60;
                             break;  
                        case "YETMİŞ":
                             totalThousand+=70;
                             break;  
                        case "SEKSEN":
                             totalThousand+=80;
                             break;                                             
                        case "DOKSAN":
                             totalThousand+=90;
                             break; 
                        case "YÜZ":
                             for(int k=0;k<j;k++){
                                    switch(pureNumbers.get(k)){
                                  case "BİR":
                                    totalThousandCoeff+=1;
                                    break;
                               case "İKİ":
                                    totalThousandCoeff+=2;
                                    break;    
                               case "ÜÇ":
                                    totalThousandCoeff+=3;
                                    break;
                               case "DÖRT":
                                    totalThousandCoeff+=4;
                                    break;  
                               case "BEŞ":
                                    totalThousandCoeff+=5;
                                    break; 
                               case "ALTI":
                                    totalThousandCoeff+=6;
                                    break; 
                               case "YEDİ":
                                    totalThousandCoeff+=7;
                                    break;
                               case "SEKİZ":
                                    totalThousandCoeff+=8;
                                    break; 
                               case "DOKUZ":
                                    totalThousandCoeff+=9;
                                    break; 
                                    }
                               }
                             totalThousand=100*totalThousandCoeff;
                             break;         
                     
                     }
                             
                     }
                   totalThousand*=1000;
                    pureNumbers=pureNumbers.subList(i+1, pureNumbers.size());
                 }
               
                   
                
             }   
        
              for(int i=0;i<pureNumbers.size();i++){
                     
                     if(i==0 && pureNumbers.get(0).equals("YÜZ")){
                        totalNumbers+=100;
                        i++;
                    }
                       switch(pureNumbers.get(i)){
                           case "BİR":
                             totalNumbers+=1;
                             break;
                        case "İKİ":
                             totalNumbers+=2;
                             break;    
                        case "ÜÇ":
                             totalNumbers+=3;
                             break;
                        case "DÖRT":
                             totalNumbers+=4;
                             break;  
                        case "BEŞ":
                             totalNumbers+=5;
                             break; 
                        case "ALTI":
                             totalNumbers+=6;
                             break; 
                        case "YEDİ":
                             totalNumbers+=7;
                             break;
                        case "SEKİZ":
                             totalNumbers+=8;
                             break; 
                        case "DOKUZ":
                             totalNumbers+=9;
                             break; 
                        case "ON":
                             totalNumbers+=10;
                             break;    
                        case "YİRMİ":
                             totalNumbers+=20;
                             break;  
                        case "OTUZ":
                             totalNumbers+=30;
                             break;  
                        case "KIRK":
                             totalNumbers+=40;
                             break;  
                        case "ELLİ":
                             totalNumbers+=50;
                             break;  
                        case "ALTMIŞ":
                             totalNumbers+=60;
                             break;  
                        case "YETMİŞ":
                             totalNumbers+=70;
                             break;  
                        case "SEKSEN":
                             totalNumbers+=80;
                             break;                                             
                        case "DOKSAN":
                             totalNumbers+=90;
                             break; 
                        case "YÜZ":
                             for(int k=0;k<i;k++){
                                  switch(pureNumbers.get(k)){
                                case "BİR":
                                  totalNumbersCoeff+=1;
                                  break;
                             case "İKİ":
                                  totalNumbersCoeff+=2;
                                  break;    
                             case "ÜÇ":
                                  totalNumbersCoeff+=3;
                                  break;
                             case "DÖRT":
                                  totalNumbersCoeff+=4;
                                  break;  
                             case "BEŞ":
                                  totalNumbersCoeff+=5;
                                  break; 
                             case "ALTI":
                                  totalNumbersCoeff+=6;
                                  break; 
                             case "YEDİ":
                                  totalNumbersCoeff+=7;
                                  break;
                             case "SEKİZ":
                                  totalNumbersCoeff+=8;
                                  break; 
                             case "DOKUZ":
                                  totalNumbersCoeff+=9;
                                  break; 
                                  }
                             }
                                  totalNumbers=100*totalNumbersCoeff;
                                  break;         
                     
                     
                    }
                     }
                 result=coeff*(totalMilyon+totalThousand+totalNumbers);
                System.out.println(result);
                 }
    public static void calculateWaterAmount(int arr[]){
        
        ArrayList<Integer> arrList = (ArrayList<Integer>) Arrays.stream(arr).boxed().collect(Collectors.toList());  
        int beginningPoint;
        int startIndex=0;
        int stopIndex=0;
        int totalWaterAmount=0;
        boolean prerequest = false;
        
        for(int i=0;i<arrList.size();i++){
          
          for(int j=i;j<arrList.size();j++){
             beginningPoint=arrList.get(i);
            
             if(arrList.get(j)<beginningPoint){
                 
             prerequest = true;
             startIndex = i;
             }
             if(prerequest && arrList.get(j)>beginningPoint){
                 stopIndex=j;
                 totalWaterAmount += calculate(i,j,arrList);
                 i=j;
                 break;
             }
             
         }
         
     }
        System.out.println("Sounç =>>>>>>>>>  "+totalWaterAmount);
   
           
  }
    public static int calculate(int startIndex,int stopIndex,  ArrayList<Integer> arrList){
        int result=0;
        if(startIndex!=0){
             startIndex-=1;
        }
        int maxHeightOfWater=min(arrList.get(startIndex),arrList.get(stopIndex));
        for(int i=startIndex+1;i<stopIndex;i++){
           result += maxHeightOfWater-arrList.get(i);
        }
        return result;
    }
}
       
        



  