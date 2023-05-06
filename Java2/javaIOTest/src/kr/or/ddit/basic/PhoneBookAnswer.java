package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class PhoneBookAnswer {
	private Map<String, PhoneAns> phoneBookMap;
	private Scanner scanner;
	private final String filename = "./src/phone.dat";
	private boolean isChange; // 데이터가 변경되었는지 여부를 나타냄. 데이터가 변경되면 true

	public PhoneBookAnswer() {
		scanner = new Scanner(System.in);
		phoneBookMap = load();
		if (phoneBookMap == null) {
			phoneBookMap = new HashMap<>();
		}
	}

	public static void main(String[] args) {
		new PhoneBookAnswer().phoneBookStart();
	}

	// 프로그램을 시작하는 메서드
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

	// 파일로 저장된 전화번호 정보를 읽어와서 반환하는 메서드
	private HashMap<String, PhoneAns> load() {
		HashMap<String, PhoneAns> pMap = null; // 읽어온 객체를 저장할 변수
		File file = new File(filename);

		if (!file.exists()) { // 읽어올 파일이 없으면 null 반환
			return null;
		}

		ObjectInputStream oIn = null;
		try {
			// 입력용 스트림 객체 생성
			oIn = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));

			// 파일에 저장된 객체 읽어오기
			pMap = (HashMap<String, PhoneAns>) oIn.readObject();
		} catch (Exception e) {
			return null;
		} finally {
			if (oIn != null) {
				try {
					// 사용했던 스트림 닫기
					oIn.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return pMap;
	}

	private void save() {
		ObjectOutputStream oOut = null;
		// 객체 출력용 스트림 객체 생성
		try {
			oOut = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filename)));
			// Map 객체 자체를 저장하기
			oOut.writeObject(phoneBookMap);
			isChange = false;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (oOut != null) {
				try {
					oOut.close();
					System.out.println("저장이 완료되었습니다.");
				} catch (Exception e2) {

				}
			}
		}

	}

	private void search() {
		System.out.println("검색할 전화번호 정보를 입력하세요");
		System.out.print("이름 >> ");
		String name = scanner.next();
		if (!phoneBookMap.containsKey(name)) { // 해당 이름이 없으면
			System.out.println(name + "님의 전화번호 정보가 없습니다.");
		} else { // return을 안하고 싶으면 else로 해도 된다.
			PhoneAns pa = phoneBookMap.get(name);
			System.out.println(name + "님의 전화번호 정보");
			System.out.println("-------------------------");
			System.out.println("이름: " + pa.getName());
			System.out.println("전화번호: " + pa.getTel());
			System.out.println("주소: " + pa.getAddr());
			System.out.println("-------------------------");
		}
		System.out.println();
	}

	private void delete() {
		System.out.println("삭제할 전화번호 정보를 입력하세요");
		System.out.print("이름 >> ");
		String name = scanner.next();
		if (!phoneBookMap.containsKey(name)) { // 해당 이름이 없으면
			System.out.println(name + "님의 전화번호 정보가 없습니다.");
			return;
		}

		phoneBookMap.remove(name); // key값(이름)을 이용해 삭제한다
		System.out.println(name + "님의 전화번호 정보가 삭제되었습니다");
		isChange = true;
	}

	// 전화번호 정보를 수정하는 메서드
	private void update() {
		System.out.println("수정할 전화번호 정보를 입력하세요");
		System.out.print("이름 >> ");
		String name = scanner.next();
		if (!phoneBookMap.containsKey(name)) { // 해당 이름이 없으면
			System.out.println(name + "님의 전화번호 정보가 없습니다.");
			return;
		}

		System.out.print("새로운 전화번호 >> ");
		String tel = scanner.next();

		System.out.print("새로운 주소 >> ");
		String addr = scanner.next();

		// 같은 키값에 새로운 전하번호 정보를 저장한다.
		phoneBookMap.put(name, new PhoneAns(name, tel, addr));
		System.out.println(name + "님의 정보를 변경했습니다.");
		isChange = true;

	}

	// 전체 전화번호 정보를 출력하는 메서드
	private void displayAll() {
		Set<String> keySet = phoneBookMap.keySet();
		System.out.println("-----------------------------------------------");
		System.out.println("번호     이름         전화번호            주소");
		System.out.println("-----------------------------------------------");

		if (phoneBookMap.size() == 0) {
			System.out.println("등록된 전화번호 정보가 하나도 없습니다");
		} else {
			int no = 0; // 번호 출력용 변수
			Iterator<String> iterator = keySet.iterator();
			while (iterator.hasNext()) {
				no++;
				String name = iterator.next();
				PhoneAns pa = phoneBookMap.get(name);
				System.out.println(no + "\t" + pa.getName() + "\t" + pa.getTel() + "\t" + pa.getAddr());
			}
		}
		System.out.println("-----------------------------------------------");
		System.out.println("출력 끝");
	}

	// 새로운 전화번호 정보를 등록하는 메서드
	private void insert() {
		System.out.println("새롭게 등록할 전화번호 정보를 입력하세요.");
		System.out.print("이름 >> ");
		String name = scanner.next();

		// 이미 등록된 사람인지 검사하기
		if (phoneBookMap.containsKey(name)) {
			System.out.println(name + "님은 이미 등록된 사람입니다.");
			return;
		}

		System.out.print("전화번호 >> ");
		String tel = scanner.next();
		System.out.print("주소 >> ");
		String addr = scanner.next();

		phoneBookMap.put(name, new PhoneAns(name, tel, addr));

		System.out.println(name + "님의 전화번호 등록이 완료되었습니다.");
		isChange = true;
	}

	// 메뉴를 출력하고 작업번호를 입력받아 반환하는 메서드
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
}

class PhoneAns implements Serializable {
	private String name;
	private String tel;
	private String addr;

	public PhoneAns(String name, String tel, String addr) {
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

}
