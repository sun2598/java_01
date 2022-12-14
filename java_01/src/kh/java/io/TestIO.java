package kh.java.io;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestIO {

	public static void main(String[] args) {

		// File 객체 생성 : File f = new File("파일 경로");
		
		String dir = "C:/data/test/files"; // 디렉토리
		
		
		String fileName = "a.txt"; // project폴더 바로 아래에 생김
		String fullFileName = dir + "/" + fileName;
		System.out.println(fullFileName); // C:/data/test/files/a.txt
		
		
		// mkdirs() : 경로상에 없는 디렉토리 '모두' 만들기
		// mkdir() : 마지막 최종 디렉토리 '하나' 만들기
		File f2 = new File(dir);
		if(!f2.exists()) {
			f2.mkdirs();
		}
		
//		// createNewFile() : 파일 생성하기
//		File f1 = new File(fullFileName); // 파일 '객체' 생성 (파일이 생성되는게 아님)
//		try {
//			f1.createNewFile();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		
		
		
		
		
		// 선언은 try문 '밖'에!!!
		FileOutputStream fos = null; // 기반
		FileOutputStream fos2 = null; // 기반
		File f3 = null;
		BufferedOutputStream bos = null; // 보조
		BufferedOutputStream bos2 = null; // 보조 (fos2 기반)
		
		try {
			// FileInputStream : 모든 종류의 파일 읽기 (파일이 이미 존재해야함)
//			FileInputStream fis = new FileInputStream(fullFileName);
//			System.out.println(fis.read()); // .read() : 파일 내용 읽기
			
			// FileOutputStream : 파일 만들면서 출력 -> createNewFile()로 파일 생성하지 않아도됨.
			fos = new FileOutputStream("C:/data/test/files/b.txt", true); // true : 기존 파일에 이어서 작성
			fos.write(65); // .write(내용) : 파일에 내용 적기
			
			fos2 = new FileOutputStream(new File("C:/data/test/files/c.txt"), true);
			fos2.write(66);
			
			
			// 보조스트림 : 매개인자로 기반스트림을 넣어야함
			bos = new BufferedOutputStream(new FileOutputStream("C:/data/test/files/d.txt", true));
			bos.write(67);
			bos.flush(); // Buffered~어쩌구 사용시 버퍼에 잔류하는 모든 문자열 출력해야함. 그래야 적힘
			
			bos2 = new BufferedOutputStream(fos2);
			bos2.write(68);
			bos2.flush(); 
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(bos2 != null) bos2.close(); // close() : 반드시 finally문 안에!!!
				if(bos != null) bos.close(); // close() 하는 순서 : 선언 순서의 반대!!!!!!!
				if(fos2 != null) fos2.close(); 
				if(fos != null) fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
		
		
		

		
		
		
		
		
		
		
		
		
		
		
		
	}

}
