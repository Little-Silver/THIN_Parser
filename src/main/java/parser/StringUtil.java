package parser;

public class StringUtil {

    private static final String KEYWORD_LOOP = "Loop";
    private static final String KEYWORD_WHILE = "While";
    private static final String KEYWORD_END = "End";
    private static final String KEYWORD_DO = "Do";

    private StringUtil(){

    }

    public static String replaceLoop(String s){
        return s.replaceAll("[l|L][o|O][o|O][p|P]", KEYWORD_LOOP);
    }

    public static String replaceWhile(String s){
        return s.replaceAll("[w|W][h|H][i|I][l|L][e|E]", KEYWORD_WHILE);
    }

    public static String replaceDo(String s){
        return s.replaceAll("[d|D][o|O]", KEYWORD_DO);
    }

    public static String replaceEnd(String s){
        return s.replaceAll("[e|E][n|N][d|D]", KEYWORD_END);
    }

    public static String removeSemicolon(String s){
        return s.replaceAll(";","");
    }

    public static String appendSemicolon(String s){
        return s + ";";
    }

    public static boolean isCommented(String s){
        return s.startsWith("//");
    }

    public static boolean isBlockStart(String s){
        return s.contains(KEYWORD_LOOP) || s.contains(KEYWORD_WHILE);
    }

    public static boolean isBlockEnd(String s){
        return s.contains(KEYWORD_END);
    }

    public static String xToLowerCase(String s){
        return s.replaceAll("X", "x");
    }

}
