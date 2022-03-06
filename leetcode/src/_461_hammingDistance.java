public class _461_hammingDistance {
    public int hammingDistance(int x, int y) {
        int i = x ^ y;
        return Integer.bitCount(i);
    }
}
