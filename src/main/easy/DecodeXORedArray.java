package main.easy;

@SuppressWarnings("unused")
public class DecodeXORedArray {
    public int[] decode(int[] encoded, int first) {
        int[] original = new int[encoded.length + 1];
        original[0] = first;

        for (int i = 1; i < original.length; i++)
            original[i] = encoded[i - 1] ^ original[i - 1];

        return original;
    }
}
