package step5_02.file;
//20230208 1300 - 1355

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

//# 파일 컨트롤러[1단계] : 벡터

public class FileEx06_풀이 {
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		int[] vector = null;
		
		int elementCnt = 0;
		
		FileWriter fw = null;
		
		
		while (true) {
			
			System.out.println("[벡터 컨트롤러]");
			System.out.println("[1]추가하기");
			System.out.println("[2]삭제하기");
			System.out.println("[3]저장하기");
			System.out.println("[4]로드하기");
			System.out.println("[5]종료하기");
			
			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
			 
			if		(sel == 1) {
				System.out.println("숫자 입력");
				int input  =  scan.nextInt();
				if (vector==null) {
					vector = new int[1];
					vector[0] = input;
				}
				else if(vector != null) {
					int[] temp = vector;
					vector = new int[temp.length +1];
					for (int i = 0; i < temp.length; i++) {
						vector[i] = temp[i];
					}
					vector[temp.length] = input;
					
					temp = null;
				}
				System.out.println(Arrays.toString(vector));
			}

			else if (sel == 2) {
				if(vector==null) {
					System.out.println("삭제할 데이터가 없습니다");
					continue;
				}
				else if (vector.length == 1) {
					vector = null;
				}
				else {
					System.out.println("몇 번째 데이터를 삭제하십겠습니까");
					int input = scan.nextInt();
					int[] temp = vector;
					int j =0;
					vector = new int[temp.length-1];
					for (int i = 0; i < input; i++) {
						vector[j++] = temp[i];
					}
					for (int i = input+1; i < temp.length; i++) {
						vector[j++] = temp[i];
					}
					System.out.println(Arrays.toString(vector));		
					temp = null;
				}
			}
				
			else if (sel == 3) {
				if (vector == null) {
					continue;
				}
				else {
					try {
						String fileName = "vector.txt";
						fw = new FileWriter(fileName);
						
						for(int i = 0; i < vector.length;i++) {
							fw.write(vector[i] + "/");
							
						}
					}catch (IOException e) {
						e.printStackTrace();}
					finally {
						try {fw.close();} catch (IOException e) {e.printStackTrace();}
					}		
				}		
			}
				
			else if (sel == 4) {
				File file = new File("vector.txt"); 
				FileReader fr = null;			  
				BufferedReader br = null;	
				
				if(file.exists()) {
					try {
						
						fr = new FileReader(file);
						br = new BufferedReader(fr);	
						String data = br.readLine();
						
						String temp[] = data.split("/");
						vector = new int[temp.length];
						for (int i = 0; i < temp.length; i++) {
							int ntemp = Integer.parseInt(temp[i]);
							vector[i] = ntemp;
						}
							System.out.println(Arrays.toString(vector));
						temp =null;
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						try {br.close();} catch (IOException e) {e.printStackTrace();}			// 마지막에 생성한 객체 순으로 close한다
						try {fr.close();} catch (IOException e) {e.printStackTrace();}
					}
					
				}
				
				
				
				
				
				
			}
			else if (sel == 5) {
				System.out.println("프로그램 종료");
				break;
			}
			
		}
		
	}
}
