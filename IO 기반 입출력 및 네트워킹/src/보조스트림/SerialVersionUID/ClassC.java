package 보조스트림.SerialVersionUID;

import java.io.Serializable;

public class ClassC implements Serializable {
	int field1;
//	int field2; 를 추가하게 되면 SerialVersionUID가 변경되어 error 발생
}
