package p300plus.p1410;

public class Solution {
    public String entityParser(String text) {
        text = text.replace("&apos;","'")
        .replace("&gt;",">")
        .replace("&lt;","<")
        .replace("&frasl;","/")
        .replace("&quot;","\"").replace("&amp;","&");

        return text;
    }
}
