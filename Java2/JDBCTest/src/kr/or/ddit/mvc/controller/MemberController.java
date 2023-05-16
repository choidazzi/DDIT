package kr.or.ddit.mvc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import kr.or.ddit.mvc.service.IMemberService;
import kr.or.ddit.mvc.service.MemberServiceImpl;
import kr.or.ddit.mvc.vo.MemberVO;

public class MemberController {
	private IMemberService service; // Service객체 변수 선언
	private Scanner scan;

	// 생성자
	public MemberController() {
		scan = new Scanner(System.in);
		service = MemberServiceImpl.getInstance(); // Service 객체 생성
	}

	public static void main(String[] args) {
		MemberController mc = new MemberController();
		mc.memberStart();
	}

	// 메뉴를 출력하고 작업번호를 입력받아 반환하는 메서드
	public int displayMenu() {
		System.out.println("------------------------------");
		System.out.println("1. 자료 추가");
		System.out.println("2. 자료 삭제");
		System.out.println("3. 자료 수정");
		System.out.println("4. 전체 자료 출력");
		// 원하는 항목 1개만 수정하기
		System.out.println("5. 자료 수정 2");
		System.out.println("0. 작업 끝");
		System.out.println("------------------------------");

		System.out.print("메뉴 선택 >> ");
		return scan.nextInt();
	}

	// 시작 메서드
	public void memberStart() {
		while (true) {
			int choice = displayMenu();

			switch (choice) {
			// 추가
			case 1:
				insertMember();
				break;
			// 삭제
			case 2:
				deleteMember();
				break;
			// 수정
			case 3:
				updateMember();
				break;
			// 전체 출력
			case 4:
				displayAll();
				break;
			// 자료 수정 2 - 원하는 항목만 수정하기
			case 5:
				updateMember2();
				break;
			// 종료
			case 0:
				System.out.println();
				System.out.println("작업을 마칩니다...");
				return;

			default:
				System.out.println();
				System.out.println("작업 번호를 잘못 입력했습니다. 다시 입력하세요...");
			}
		}
	}


	private void insertMember() {
		System.out.println();
		System.out.println("추가할 회원 정보를 입력하세요...");

		// 회원 ID 가 저장될 변수
		String memId = null;
		int count = 0;
		do {
			System.out.print("회원 ID >>");
			memId = scan.next();

			count = service.getMemberCount(memId);
			if (count > 0) {
				System.out.println(memId + "은(는) 이미 등록된 회원 ID 입니다...");
				System.out.println("다른 회원 ID를 입력해주세요...");
			}
		} while (count > 0);

		System.out.print("회원 Password >>");
		String memPass = scan.next();

		System.out.print("회원 Name >>");
		String memName = scan.next();

		System.out.print("회원 Tel >>");
		String memTel = scan.next();
		scan.nextLine(); // 버퍼 비우기
		System.out.print("회원 Address >>");
		String memAddr = scan.nextLine();

		// 입력 받은 자료를 VO객체에 저장한다.
		MemberVO memVO = new MemberVO();
		memVO.setMemId(memId);
		memVO.setMemPass(memPass);
		memVO.setMemName(memName);
		memVO.setMemTel(memTel);
		memVO.setMemAddr(memAddr);

		// Service에 일을 시켜 자료를 DB에 insert한다.
		int cnt = service.insertMember(memVO);

		if (cnt > 0) {
			System.out.println("insert 성공~!");
		} else {
			System.out.println("insert 실패~!");
		}
	}

	private void deleteMember() {
		System.out.println();
		System.out.println("삭제할 회원 정보를 입력하세요...");
		System.out.print("삭제할 회원 ID >> ");
		String memId = scan.next();

		int cnt = service.deleteMember(memId);

		if (cnt > 0) {
			System.out.println(memId + " : 회원 정보 삭제 성공!");
		} else {
			System.out.println(memId + " : 회원 ID 가 없거나 삭제 실패입니다.");
		}
	}

	private void updateMember() {
		System.out.println();
		System.out.println("수정할 회원 정보를 입력하세요...");
		System.out.print("회원 ID >>");
		String memId = scan.next();
		int count = service.getMemberCount(memId);

		if (count == 0) {// 회원이 없을 때...
			System.out.println(memId + "은(는) 존재하지 않는 회원 ID 입니다.");
			System.out.println("수정 작업을 종료합니다.");
			return;
		}

		System.out.println();
		System.out.print("새로운 비밀번호 >> ");
		String newMemPass = scan.next();
		System.out.print("새로운 회원 이름 >> ");
		String newMemName = scan.next();
		System.out.print("새로운 전화번호 >> ");
		String newMemTel = scan.next();
		scan.nextLine(); // 입력 버퍼 비우기
		System.out.print("새로운 주소 >> ");
		String newMemAddr = scan.nextLine();

		// 입력받은 데이터를 VO객체에 저장한다.
		MemberVO memVO = new MemberVO(memId, newMemPass, newMemName, newMemTel, newMemAddr);
		int cnt = service.updateMember(memVO);

		if (cnt > 0) {
			System.out.println(memId + " : 회원 정보 수정이 완료되었습니다.");
		} else {
			System.out.println(memId + " : 회원 정보 수정에 실패했습니다.");
		}
	}
	
	private void updateMember2() {
		System.out.println();
		System.out.println("수정할 회원 정보를 입력하세요...");
		System.out.print("회원 ID >>");
		String memId = scan.next();
		
		int count = service.getMemberCount(memId);
		
		if (count == 0) {// 회원이 없을 때...
			System.out.println(memId + "은(는) 존재하지 않는 회원 ID 입니다.");
			System.out.println("수정 작업을 종료합니다.");
			return;
		}
		int num;								//수정을 원하는 항목의 선택 번호가 저장될 변
		String updateField = null;		// 수정할 컬럼명이 저장될 변수  
		String updateTitle = null;		// 입력할 때 보여줄 제목 
		
		do {
			System.out.println();
			System.out.println("수정할 항목을 선택하세요.");
			System.out.println("1. 비밀번호 		2. 회원이름 		3. 전화번호 		4. 회원주소 ");
			System.out.println("========================================");
			System.out.print("수정 항목 선택 >>");
			num = scan.nextInt();
			
			switch (num) {
			case 1: updateField = "mem_pass"; updateTitle = "비밀번호"; break;
			case 2: updateField = "mem_name"; updateTitle = "회원이름"; break;
			case 3: updateField = "mem_tel"; updateTitle = "전화번호"; break;
			case 4: updateField = "mem_addr"; updateTitle = "회원주소"; break;
			default: System.out.println("수정할 항목을 잘못 선택했습니다. 다시 선택하세요...");
				
			}
		} while (num < 1 || num > 4);
		scan.nextLine(); // 입력 버퍼 비우기 
		System.out.println();
		System.out.println("수정할" + updateTitle + ">>");
		String updateData = scan.nextLine();	// 수정할 데이터 입력 
		
		// 수정할 데이터를 Map에 추가한다.
		Map<String, String> map = new HashMap<>();
		map.put("memid", memId);	// 회원 ID 셋팅
		map.put("field", updateField);	// 수정할 컬럼명 셋팅 
		map.put("data", updateData);	// 수정할 데이터 셋팅 
		
		int cnt = service.updateMember2(map);
		if (cnt > 0) {
			System.out.println(memId + " : 회원 정보 수정이 완료되었습니다.");
		} else {
			System.out.println(memId + " : 회원 정보 수정에 실패했습니다.");
		}
	}
	
	
	private void displayAll() {
		System.out.println();
		System.out.println("======= =============== ==== 전체 정보 출력=== =============== ======= ========");
		System.out.println("ID   비밀번호    이름      전화번호      주소    ");
		System.out.println("======= ======= =============== ======= =============== ======= ========");

		// 전체 회원 목록을 가져온다.
		List<MemberVO> memList = service.getAllMemeber();

		if (memList == null || memList.size() == 0) {
			System.out.println("회원 목록이 하나도 없습니다...");
		} else {
			// List의 데이터 개수만큼 반복해서 데이터를 출력한다.
			for (MemberVO memVO : memList) {
				System.out.println(memVO.getMemId() + "   " + memVO.getMemPass() + "      " + memVO.getMemName()
						+ "      " + memVO.getMemTel() + "      " + memVO.getMemAddr());
			}
		}
	}
}
