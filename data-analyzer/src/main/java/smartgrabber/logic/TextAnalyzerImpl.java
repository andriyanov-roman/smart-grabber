package smartgrabber.logic;


public class TextAnalyzerImpl implements ITextAnalyzer {


    public boolean isTextApplicable(String text) {
        if ("Test".equals(text)) {
            return true;
        } else {
            return false;
        }
    }
}
