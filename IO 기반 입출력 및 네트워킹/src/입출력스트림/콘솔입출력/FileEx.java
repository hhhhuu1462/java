package �ܼ������;

import java.io.File;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileEx {
	
	public static void main(String[] args) throws Exception {
	
		File dir = new File("C:\\lhs\\�����ڷ�\\Dir");
		File file1 = new File("C:\\lhs\\�����ڷ�\\file1.txt");
		File file2 = new File("C:\\lhs\\�����ڷ�\\file2.txt");
		File file3 = new File(new URI("file:///C:/lhs/�����ڷ�/file3.txt")); // ���� ��θ� URI��ü�� �����ؼ� �Ű������� ����
		
		if(dir.exists() == false) { dir.mkdirs(); } // ��λ� ���� ��� ���丮 ����
		if(file1.exists() == false) { file1.createNewFile(); } // ���ο� ���� ����
		if(file2.exists() == false) { file2.createNewFile(); }
		if(file3.exists() == false) { file3.createNewFile(); }
		
		File lhs = new File("C:\\lhs");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd   a   HH:mm");
		File[] contents = lhs.listFiles(); // ���丮�� ���Ե� ��� ��ü�� File �迭�� ����
		
		System.out.println("��¥                �ð�       ����        ũ��           �̸�");
		System.out.println("-----------------------------------------------------------------------------------------------");
		for (File file : contents) {
			System.out.print(sdf.format(new Date(file.lastModified()))); // ������ ���� ��¥
			if(file.isDirectory()) { // ���丮������ ���� ����
				System.out.print("\t<DIR>\t\t\t" + file.getName());
			} else {
				System.out.println("\t\t\t" + file.length() + "\t" + file.getName()); // ������ ũ�� + ������ �̸� ����
			}
			System.out.println();
		}
		
	}
	
}
