package parser;

public class StringUtil {

    public static String replaceLoop(String s){
        return s.replaceAll("[l|L][o|O][o|O][p|P]", "Loop");
    }

    public static String replaceWhile(String s){
        return s.replaceAll("[w|W][h|H][i|I][l|L][e|E]", "While");
    }

    public static String replaceDo(String s){
        return s.replaceAll("[d|D][o|O]", "Do");
    }

    public static String replaceEnd(String s){
        return s.replaceAll("[e|E][n|N][d|D]", "End");
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

    public static String removeDuplicateSpaces(String s){
        return s.replaceAll("(  )+"," ");
    }

    public static boolean isBlockStart(String s){
        return s.contains("Loop") || s.contains("While");
    }

    public static boolean isBlockEnd(String s){
        return s.contains("End");
    }

}
