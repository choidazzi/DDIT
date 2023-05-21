package chapter15;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class PhoneBookTest {
	private Map<String, PhoneBook> phoneBookMap;
	private Scanner scanner;
	private final String fileName = "./src/phone.dat";
	private boolean isChange;				//데이터의 변경 여부 (변경되면 true)
	
	
	public PhoneBookTest() {
		scanner = new Scanner(System.in);
		
	}
	
	// main
	public static void main(String[] args) {
		new PhoneBookTest().phoneBookStart();
	}

	public void phoneBookStart() {
		System.out.println("==========================");
		System.out.println("  전 화 번 호 관 리 프 로 그 램  ");
		System.out.println("==========================");
		System.out.println();
		while (true) {
			int choice = displayMenu();

			switch (choice) {
			case 1: // 등록
				insert();
				break;
			case 2: // 수정
				update();
				break;
			case 3: // 삭제
				delete();
				break;
			case 4: // 검색
				search();
				break;
			case 5: // 전체 출력
				displayAll();
				break;
			case 6: // 저장
				save();
				break;
			case 0: // 프로그램 종료
				if (isChange == true) {
					save();
				}
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
			}
		}
		
	}
	// 메뉴 출력 
	private int displayMenu() {
		System.out.println();
		System.out.println("==== 메   뉴 ===");
		System.out.println("1. 전화번호 등록");
		System.out.println("2. 전화번호 수정");
		System.out.println("3. 전화번호 삭제");
		System.out.println("4. 전화번호 검색");
		System.out.println("5. 전화번호 전체출력");
		System.out.println("6. 전화번호 저장");
		System.out.println("0. 프로그램 종료");
		System.out.println("번호 입력 >> ");
		return scanner.nextInt();
	}

	private void insert() {
		System.out.println("새롭게 등록할 전화번호 정보 입력");
		System.out.print("이름 >>");
		String name = scanner.next();
		
		// 이미 등록 됐는지? 
		if (phoneBookMap.containsKey(name)) {
			System.out.println(name + "님은 이미 등록된 사람입니다.");
			return;
		}
		
		System.out.print("전화번호 >>");
		String tel = scanner.next();
		
		System.out.print("주소 >>");
		String addr = scanner.next();
		
		phoneBookMap.put(name, new PhoneBook(name,tel,addr));
		System.out.println(name + "님의 전화번호 등록이 완료되었습니다.");
		
		isChange = true;
	}

	private void update() {
		System.out.println("수정할 전화번호 정보를 입력하세요.");
		System.out.print("이름>> ");
		String name = scanner.next();
		
		if (!phoneBookMap.containsKey(name)) {	//해당 이름이 없으면 
			System.out.println(name + "님의 전화번호 정보가 없습니다.");
			return;
		}
		
		System.out.print("new 전화번호 >>");
		String tel = scanner.next();
		
		System.out.print("new 주소 >>");
		String addr = scanner.next();
		
		phoneBookMap.put(name, new PhoneBook(name,tel,addr));
		System.out.println(name + "님의 전화번호 수정이 완료되었습니다.");
		
		isChange = true;
	}

	private void delete() {
		System.out.println("삭제할 전화번호 정보를 입력하세요.");
		System.out.print("이름>>");
		String name = scanner.next();
		
		if (!phoneBookMap.containsKey(name)) {
			System.out.println(name + "님의 전화번호가 없습니다.");
			return;
		}
		
		phoneBookMap.remove(name);
System.out.println(name + "님의 전화번호 삭제가 완료되었습니다.");
		
		isChange = true;
	}

	private void search() {
		System.out.println("검색할 전화번호 정보를 입력하세요.");
		System.out.print("이름>> ");
		String name = scanner.next();
		
		if (!phoneBookMap.containsKey(name)) {
			System.out.println(name + "님의 전화번호가 없습니다.");
			return;
		} else {
			PhoneBook pb = phoneBookMap.get(name);
			System.out.println(name + "님의 전화번호 정보");
			System.out.println("===========================");
			System.out.println(" 이름: " + pb.getName());
			System.out.println(" 전화번호: " + pb.getTel());
			System.out.println(" 주소: " + pb.getAddr());
			System.out.println("===========================");
		}
		
	}

	private void displayAll() {
		Set<String> keySet = phoneBookMap.keySet();
		System.out.println("============ 전체 정보 출력 ============");
		
		if (phoneBookMap.size() == 0) {
			System.out.println("등록된 전화번호 정보가 없습니다.");
		} else {
			int no = 0;	//번호 출력용 
			Iterator<String> it = keySet.iterator();
			while (it.hasNext()) {
				no++;
				String name = it.next();
				PhoneBook pb = phoneBookMap.get(name);
				System.out.printf("%-5d%-15s%-15s%-15s",no,name,pb.getTel(),pb.getAddr());
			}
		}
		System.out.println();
		System.out.println("==================== 출력끝 ! ====================");
	}

	private void save() {
		//객체 출력용 스트림 객체 생성 
		ObjectOutputStream oOut = null;
		try {
			oOut = new ObjectOutputStream(
						new BufferedOutputStream(
								new FileOutputStream(fileName)));
			oOut.writeObject(phoneBookMap);
			isChange = false;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (oOut != null) {
				try {
					oOut.close();
					System.out.println("저장 완료!");
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
		
	}
	
}

class PhoneBook implements Serializable {
	private String name;
	private String tel;
	private String addr;
	
	public PhoneBook() {
		// TODO Auto-generated constructor stub
	}

	public PhoneBook(String name, String tel, String addr) {
		super();
		this.name = name;
		this.tel = tel;
		this.addr = addr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "PhoneBook [name=" + name + ", tel=" + tel + ", addr=" + addr + "]";
	}
	
	
}
