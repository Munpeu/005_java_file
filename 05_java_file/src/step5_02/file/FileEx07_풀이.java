package step5_02.file;
//20230208 1410 -

import java.util.Arrays;
import java.util.Scanner;

//# 파일 컨트롤러[2단계] : ATM

public class FileEx07_풀이 {
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		int size = 5;
		int accsCnt = 0;
		int identifier = -1;
		
		String[] accs = new String[size];
		String[]  pws = new String[size];
		int[]  moneys = new int[size];
		
		String fileName = "atm.txt";
		
		while(true) {
			
			System.out.println(Arrays.toString(accs));
			System.out.println(Arrays.toString(pws));
			
			System.out.println("[MEGA ATM]");
			System.out.println("[1]회원가입");
			System.out.println("[2]회원탈퇴");
			System.out.println("[3]로그인");
			System.out.println("[4]로그아웃");
			System.out.println("[5]입금");
			System.out.println("[6]출금");
			System.out.println("[7]이체");
			System.out.println("[8]잔액조회");
			System.out.println("[9]저장");						// 아이디 : 비밀번호 : 금액 저장
			System.out.println("[10]로드");
			System.out.println("[0]종료");
			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
			
			if		(sel == 1) {
				if (identifier != -1) {
					System.out.println("로그아웃 이후 이용");
					continue;
				}
				else {
					if(accsCnt>5) {
						System.out.println("더이상 가입 할 수 없습니다");
						continue;
					}
					else {
						System.out.println("회원가입 할 아이디 입력");
						String regId = scan.next();
						for (int i = 0; i < accsCnt; i++) {
							if(regId.equals(accs[i])) {
								System.out.println("사용중인 아이디입니다");
								break;
							}
						}
						accs[accsCnt] = regId;
						System.out.println("비밀번호를 입력해주십시오");
						String regPs = scan.next();
						pws[accsCnt] = regPs;
						accsCnt ++;									
					}			
				}		
			}
			else if (sel == 2) {
				if(accsCnt == 0) {
					System.out.println("가입된 아이디가 없습니다");
					continue;
				}
				else {
					System.out.println("탈퇴할 아이디를 입렵하십시오");
					String inputId = scan.next();
					for (int i = 0; i < accsCnt; i++) {
						if(inputId.equals(accs[i])) {
							System.out.println("비밀번호를 입력하십시오");
							String inputPs = scan.next();
							if(inputPs.equals(accs[i])) {
								String[] tempId = accs;
								String[] tempPs = pws;
								accs = new String[size];
								pws = new String[size];
								int k = 0;
								for (int j = 0; j < i; j++) {
									accs[k] = tempId[j];
									pws[k] = tempPs[j];
									k++;
								}
								for (int j = i+1; j < tempPs.length; j++) {
									accs[k] = tempId[j];
									pws[k] = tempPs[j];
									k++;
								}
								tempId = null;
								tempPs =null;
								break;
							}
							else {
								System.out.println("비밀번호를 체크하십시오");
								break;
							}
							
						}
						else {
							System.out.println("없는 계정입니다");
							break;
						}
						
					}
					
					
					
					
					
				}
	
			}
			else if (sel == 3) {}
			else if (sel == 4) {}
			else if (sel == 5) {}
			else if (sel == 6) {}
			else if (sel == 7) {}
			else if (sel == 8) {}
			else if (sel == 9) {}
			else if (sel == 10) {}
			else if (sel == 0) {
				break;
			}
			
		}
		
	}
}
