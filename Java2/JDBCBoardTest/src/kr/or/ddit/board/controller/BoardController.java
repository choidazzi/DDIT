package kr.or.ddit.board.controller;


import java.util.List;
import java.util.Scanner;

import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.vo.BoardVO;

public class BoardController {
	private BoardService service;
	private Scanner scan;
	
	//Constructor
	public BoardController() {
		scan = new Scanner(System.in);
		service = BoardService.getInstance();
	}
	
	public static void main(String[] args) {
		BoardController bc = new BoardController();
		bc.process();
	}
	//메뉴 출력 메서드 
	public int displayMenu() {
		System.out.println();
		System.out.println("----------------------------------------------------------");
		System.out.printf("  %-5s%-20s%-20s%-10s","No","Title","Writer","Hits");
		System.out.println();
		System.out.println("----------------------------------------------------------");
		List<BoardVO> boardList = service.getAllBoard();
		if (boardList == null || boardList.size() == 0) {
			System.out.println("게시판 글이 존재하지 않습니다.");
		} else {
			for (BoardVO boardVO : boardList) {
				System.out.printf("  %-5d%-20s%-20s%-15d",
									boardVO.getNo(),
									boardVO.getTitle(),
									boardVO.getWriter(),
									boardVO.getCnt());
				System.out.println();
			}
			System.out.println("----------------------------------------------------------");
			System.out.println("	       	메		뉴		");  
			System.out.println("----------------------------------------------------------");
		}
		System.out.println("   1. 새글작성	 2. 게시글보기	 3. 검색	   0. 작업끝");
		System.out.println("----------------------------------------------------------");
		System.out.print("메뉴 선택 >>");
		return scan.nextInt();
	}
	
	
	// 시작 메서드 
	public void process() {
		while (true) {
			int menu = displayMenu();
			
			switch (menu) {
			case 1: insert(); break;
			case 2: select(); break;
			case 3: search(); break;
			case 0: 
				System.out.println();
				System.out.println("작업을 마칩니다.");
				return;
			
			default:
				System.out.println();
				System.out.println("작업 번호를 잘못 입력했습니다. 다시 입력하세요...");				
			}
		}
		
	}

	private void insert() {
		System.out.println("----------------------------------------------------------");
		System.out.println("			새 글 작성하기 		");  
		System.out.println("----------------------------------------------------------");
		System.out.print("Title >> ");
		scan.nextLine();
		String title = scan.nextLine();
		System.out.print("Writer >> ");
		String writer = scan.nextLine();
		System.out.print("Content >> ");
		String content = scan.nextLine();
		
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setWriter(writer);
		vo.setContent(content);
		int cnt  = service.insertBoard(vo);
		
		if (cnt > 0) {
			System.out.println("새 글이 성공적으로 작성되었습니다! ^__^");
		} else {
			System.out.println("새 글 저장에 실패하셨습니다! ㅜ__ ㅠ");
		}
	}

	private void select() {
		System.out.println("----------------------------------------------------------");
		System.out.println("			글 조회하기 		");  
		System.out.println("----------------------------------------------------------");
		System.out.print("No >> ");
		int no = scan.nextInt();
		System.out.println("----------------------------------------------------------");
		
		BoardVO vo = service.getBoard(no);
		if (vo.getTitle() == null) {
			System.out.println("조회하시려는 글이 존재하지 않습니다.");
			return;
		}
		service.increaseHits(no);
		while(true) {
			System.out.printf("%-7s : %-10s\n", "Title",vo.getTitle());
			System.out.printf("%-7s : %-10s\n", "Writer",vo.getWriter());
			System.out.printf("%-7s : %-100s\n", "Content",vo.getContent());
			System.out.printf("%-7s : %-10s\n", "Date",vo.getDate());
			System.out.printf("%-7s : %-10s\n", "Hits",vo.getCnt());
			
			System.out.println("----------------------------------------------------------");
			System.out.println("  1. Update      2. Delete      3. Back To List");  
			System.out.println("----------------------------------------------------------");
			System.out.print("No >> ");
			int select = scan.nextInt();
			
			switch (select) {
			case 1:
				update(no);
				return;
			
			case 2:
				delete(no);
				return;

			case 3:
				System.out.println("----------------------------------------------------------");
				System.out.println("    리스트로 돌아갑니다!");
				System.out.println("----------------------------------------------------------");
				return;

			default:
				System.out.println("----------------------------------------------------------");
				System.out.println("    잘못된 번호를 선택하셨습니다!");
				System.out.println("    다시 선택해주세요!");
				System.out.println("----------------------------------------------------------");
			}
		}
	}

	private void update(int no) {
		System.out.println();
		System.out.println("----------------------------------------------------------");
		System.out.println("    Update Start! ^___^");
		System.out.println("----------------------------------------------------------");
		
		System.out.print("Update Title>>");
		scan.nextLine();//버퍼 비우기 
		String title = scan.nextLine();
		System.out.print("Update Content>>");
		String content = scan.nextLine();
		
		BoardVO vo = new BoardVO();
		
		vo.setNo(no);
		vo.setTitle(title);
		vo.setContent(content);
		
		int cnt = service.updateBoard(vo);
		
		if(cnt>0){
			System.out.println(no + " : Update Success!^__^");
		}else{
			System.out.println(no + " : Update Failed!ㅜ__^");
		}
	}

	private void delete(int no) {
		int cnt = service.deleteBoard(no);
		if(cnt>0){
			System.out.println(no + " : Delete Success!^__^");
		}else{
			System.out.println(no + " : Delete Failed!ㅜ__^");
		}
	}

	private void search() {
		System.out.println();
		System.out.println("----------------------------------------------------------");
		System.out.println("    Search Start! ^___^");
		System.out.println("----------------------------------------------------------");
		System.out.print("Search Title>>");
		scan.nextLine();//버퍼 비우기 ::
		String title = scan.nextLine();
		
		System.out.println("----------------------------------------------------------");
		System.out.printf("%-5s%-20s%-20s%-10s","No","Title","Writer","Hits");
		System.out.println();
		System.out.println("----------------------------------------------------------");
		
		List<BoardVO> searchList = service.searchBoard(title);
		if (searchList == null || searchList.size() == 0) {
			System.out.println("검색하신 글의 목록이 존재하지 않습니다.");
			System.out.println("다시 입력해주세요.");
		} else {
			for (BoardVO vo : searchList) {
				System.out.printf("  %-5d%-20s%-20s%-15d",
						vo.getNo(),
						vo.getTitle(),
						vo.getWriter(),
						vo.getCnt());
						System.out.println();
			}
		}
	}
}
