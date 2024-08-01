
import java.util.Arrays;

public class encXORPass {

    public static void main(String[] args) {
        test();
    }

    public static void encXORPass(byte[] raw, final int offset, final int size, int key) {
        int stop = size - 8;
        int pos = 4 + offset;
        int edx;
        int ecx = key; // Initial xor key

        while (pos < stop) {
            edx = raw[pos] & 0xFF;
            edx |= (raw[pos + 1] & 0xFF) << 8;
            edx |= (raw[pos + 2] & 0xFF) << 16;
            edx |= (raw[pos + 3] & 0xFF) << 24;

            ecx += edx;

            edx ^= ecx;

            raw[pos++] = (byte) (edx & 0xFF);
            raw[pos++] = (byte) (edx >> 8 & 0xFF);
            raw[pos++] = (byte) (edx >> 16 & 0xFF);
            raw[pos++] = (byte) (edx >> 24 & 0xFF);
        }

        raw[pos++] = (byte) (ecx & 0xFF);
        raw[pos++] = (byte) (ecx >> 8 & 0xFF);
        raw[pos++] = (byte) (ecx >> 16 & 0xFF);
        raw[pos] = (byte) (ecx >> 24 & 0xFF);
        
    }
    
    public static void test() {
        int key = 1572995469;
        int offset = 2;
        byte[] data = {0, 0, 0, 61, -9, -35, -57, 33, -58, 0, 0, 64, -119, -120, -62, -8, -100, 52, -37, -31, 74, -12, -13, -60, 27, -2, 62, 100, 0, 64, -64, 74, -58, -90, -77, -7, -125, -62, -7, -99, -39, 91, 55, -78, -67, 52, 14, 56, -41, -92, 60, -35, 109, 10, 83, -96, -14, -121, 53, -19, 112, -78, -4, 22, -56, -26, -53, -118, 37, -82, 80, 108, -21, 32, 59, 4, 110, -73, -85, -43, 74, 102, 83, 119, -78, -111, -116, -93, -92, 41, -41, -44, 19, -92, 25, 67, 10, -110, 122, 92, -22, -44, 41, -112, 84, -48, 101, -114, 80, -46, 118, 49, 100, -126, -50, -13, -77, 61, -23, -42, -44, 43, 51, 83, 74, -127, -1, 100, -70, -57, 6, 115, 125, 84, -36, -11, 17, -97, -14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -45, 97, -81, -115, -76, 69, -29, 56, -11, -32, 86, -116, -49, -123, 35, 110, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        
        System.out.println (Arrays.toString(data));
        encXORPass( data, offset, data.length, key );
        System.out.println (Arrays.toString(data));
    }

}
