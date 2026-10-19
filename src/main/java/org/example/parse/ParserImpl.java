package org.example.parse;

public class ParserImpl implements Parser {
    @Override
    public int[] parseArray(String s) {
        String trimmed = s.strip();
        if (trimmed.isBlank()) {
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