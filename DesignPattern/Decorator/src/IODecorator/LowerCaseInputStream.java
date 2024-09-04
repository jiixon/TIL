package IODecorator;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class LowerCaseInputStream extends FilterInputStream {
    //InputStream의 추상데코레이터인 FilterInputStream 확장
    public LowerCaseInputStream(InputStream in) {
        super(in);
    }

    //byte값을 읽고 각 byte(문자)를 검사해서 대문자이면 소문자로 변환하는 메소드
    public int read() throws IOException {
        int c = in.read();
        return (c == -1 ? c : Character.toLowerCase((char) c));
    }

    //byte배열을 읽고 각 byte를 검사하여 대문자면 소문자로 변환
    public int read(byte[] b, int off, int len) throws IOException {
        int result = in.read(b, off, len);
        for (int i = off; i < off + result; i++) {
            b[i] = (byte) Character.toLowerCase((char) b[i]);
        }
        return result;
    }

}
