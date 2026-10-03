package org.example.parse;

public class Parser implements ParserInterface {
    @Override
    public int[] parseArray(String s) {
        String trimmed = s.trim();
        if (trimmed.isEmpty()) {
            return new int[0];
        }
        String[] arrayS = trimmed.split("[,;\\s]+");
        int[] arrInt = new int[arrayS.length];
        for (int i = 0; i < arrayS.length; ++i) {
            arrInt[i] = Integer.parseInt(arrayS[i]);
        }
        return arrInt;
    }
}