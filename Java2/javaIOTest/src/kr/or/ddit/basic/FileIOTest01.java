package kr.or.ddit.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileIOTest01 {
   // 파일의 내용을 읽어와 화면에 출력하는 예제 - 바이트 기반 스트림 이용
   public static void main(String[] args) {
      try {
         // 사용할 스트림 객체 생성하기 ==> 파일을 읽어올 바이트기반 스트림 객체 생성하기
         //      ==> 생성자에 읽어올 파일 정보를 문자열 또는 File객체로 넘겨준다.
      
         // 방법1 ==> 문자열로 지정하기
         //FileInputStream fin = new FileInputStream("e:/d_other/test.txt");
      
         // 방법2 ==> File객체로 지정하기
         File file = new File("/users/choiseoyeon/d_other/test.txt");
       
         FileInputStream fin = new FileInputStream(file);
      
      
         int c;   // 읽어온 데이터를 저장할 변수
         
         while( (c = fin.read() ) != -1) {
            
            // 읽어온 데이터를 화면에 출력하기
            System.out.print( (char)c );
            
         }
         
         fin.close();   // 작업 완료 후 스트링 닫기
      
      
      } catch (IOException e) {
         System.out.println("입출력 오류 : " + e.getMessage());
      }
      

   }

}