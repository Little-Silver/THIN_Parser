package parser;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    List<String> lineList = new ArrayList<>();

    public Parser(List<String> lineList) {
        this.lineList = lineList;
        this.lineList = execute();
        this.lineList = adjustSemiColons();
        printList();
    }

    private List<String> execute() {

        List<String> newLineList = new ArrayList<>();
        boolean isStartingLine = true;
        String replaced;
        for (String s : lineList) {
            replaced = s;
            if (isStartingLine) {
                //remove Starting comments / empty lines
                if (!StringUtil.isCommented(replaced) && !replaced.isBlank()) {
                    isStartingLine = false;
                }
            }
            if (!isStartingLine) {
                replaced = StringUtil.xToLowerCase(replaced);
                replaced = StringUtil.replaceDo(replaced);
                replaced = StringUtil.replaceWhile(replaced);
                replaced = StringUtil.replaceEnd(replaced);
                replaced = StringUtil.replaceLoop(replaced);
                replaced = replaced.stripTrailing();
                replaced = StringUtil.removeDuplicateSpaces(replaced);
                newLineList.add(replaced);
            }

        }
        return newLineList;
    }

    private List<String> adjustSemiColons() {

        List<String> newLineList = new ArrayList<>();

        for (int i = 0; i < lineList.size(); i++) {
            String replaced = lineList.get(i);
            replaced = StringUtil.removeSemicolon(replaced);
            replaced = StringUtil.appendSemicolon(replaced);
            if (StringUtil.isBlockStart(replaced)) {
                replaced = StringUtil.removeSemicolon(replaced);
            }
            if (i + 1 < lineList.size() && StringUtil.isBlockEnd(lineList.get(i + 1))) {
                replaced = StringUtil.removeSemicolon(replaced);
            }
            if (i + 1 == lineList.size()){
                replaced = StringUtil.removeSemicolon(replaced);
            }

            newLineList.add(replaced);
        }

        return newLineList;
    }

    private void printList() {
        for (String s : lineList) {
            System.out.println(s);
        }
    }

    public List<String> getLineList() {
        return lineList;
    }
}
