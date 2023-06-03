package kr.or.ddit.basic.fileupload.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.basic.fileupload.service.FileInfoServiceImpl;
import kr.or.ddit.basic.fileupload.service.IFileInfoService;
import kr.or.ddit.vo.FileInfoVO;


@WebServlet("/images/imageView.do")
public class ImageView extends HttpServlet {
   private static final long serialVersionUID = 1L;
       


   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("utf-8");
      
      //파라미터로 넘어온 파일 번호를 구한다.
      String strFileno = request.getParameter("fileno");
      int fileNo = Integer.parseInt(strFileno);
            
      //파일 번호를 이용하여 해당 파일 정보를 DB에서 가져온다.
      IFileInfoService service = FileInfoServiceImpl.getInstance();
      FileInfoVO fvo = service.getFileinfo(fileNo);
            
      // 파일이 저장된 폴더 설정
      String uploadPath = "users/choiseoyeon";
            
      //저장될 폴더가 없으면 새로 만든다.
      File f = new File(uploadPath);
      if(!f.exists()) {
         f.mkdirs();
      }
      
      String imagePath = uploadPath + File.separator + fvo.getSave_file_name();
      File imgFile = new File(imagePath);
      
      if(imgFile.exists()) {
         // 파일 입출력을 진행한다.
                  BufferedInputStream bin = null;
                  BufferedOutputStream bout = null;
                  try {
                     // 출력용 스트림 객체 생성(클라이언트로 전송할 스트림) ==> response객체 이용
                     bout = new BufferedOutputStream(response.getOutputStream());
                     
                     // 파일 입력용 스트림 객체 생성
                     bin = new BufferedInputStream(new FileInputStream(imgFile));
                     
                     byte[] temp = new byte[1024];
                     int len = 0;
                     
                     while ((len=bin.read(temp)) > 0) {
                        bout.write(temp, 0, len);
                     }
                     bout.flush();
                     
                     
                  } catch (IOException e) {
                     System.out.println("입출력 오류 : " + e.getMessage());
                  } finally {
                     if(bin != null) try {bin.close(); } catch(IOException e) {}
                     if(bout != null) try {bin.close(); } catch(IOException e) {}
                  }
                  
               } else { // 해당 파일이 없을 때...
                  response.setContentType("text/html; charset=utf-8");
                  response.getWriter().println("<h3>" + fvo.getOrigin_file_name() + " 파일이 존재하지 않습니다.</h3>");
               }
               
      }
      
      


   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      doGet(request, response);
   }

}