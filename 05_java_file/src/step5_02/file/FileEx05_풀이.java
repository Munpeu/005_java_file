package step5_02.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

//# 파일 로드하기 : 연습문제


public class FileEx05_풀이 {

	public static void main(String[] args) {
		
		
		// 4번 연습문제에서 작성된 텍스트파일을 읽어들여와 아래 배열에 저장하시오.
		
		String[] names = new String[3];			// momk , megait , github
		String[] pws   = new String[3];			// 1111 , 2222   , 3333
		int[] moneys   = new int[3];			// 20000, 30000 , 40000
		
		String fileName = "fileTest02.txt";
		
		File file = new File(fileName);
		FileReader fr = null;
		BufferedReader br = null; 
		
		if(file.exists()) {
			try {
				fr = new FileReader(file);
				br = new BufferedReader(fr);
				
				String data = " ";
				int count = 0;
				
				while(true) {
					
					data = br.readLine();
					System.out.println(data);
					if(data == null)break;
					
					String[] dataSplit = data.split("/");		

				}
				
				
				
				
				
				
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
			try {br.close();} catch (IOException e) {e.printStackTrace();}			// 마지막에 생성한 객체 순으로 close한다
			try {fr.close();} catch (IOException e) {e.printStackTrace();}
			}
		
		}
		
	}
}
