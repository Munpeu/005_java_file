package step5_02.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

// 파일 출력 ( File Output , 파일 로드 )

public class FileEx02 {

	public static void main(String[] args) {
		
		File file = new File("ex01.txt"); // 파일 객체 생성
		FileReader fr = null;			  // 파일 읽어오기
		BufferedReader br = null;		  // 텍스트 읽어오기
		
		if(file.exists()) {							// exists() : 파일이 존재하면 true 아니면 false
			try {
				fr = new FileReader(file);
				br = new BufferedReader(fr);
				
				String data = br.readLine();						// readLine() : 한 줄 읽어오기
				System.out.println(data);
				System.out.println();
				
				System.out.println(br.readLine());
				System.out.println();
				
				// 전체 텍스트를 읽어오는 예시
				while(true) {
					data = br.readLine();
					if (data == null) {		//읽어올 데이터가 없으면 null을 반환한다
						break;
					}
					System.out.println(data);
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
