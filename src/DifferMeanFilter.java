import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DifferMeanFilter{

    public static List<WordSet> execute(WordSet wordSet, Map<String, List<String>> map){
        List<Word> words = wordSet.getWords();
        List<WordSet> stack = new ArrayList<>();
        List<WordSet> ret;

        for(int i = 0; i < words.size(); i++) {
            WordSet ws = new WordSet();
            ws.addWord(words.get(i));
            int currentDepth = ws.getWords().size() - 1;
            while(currentDepth >= 0){
                Word top = ws.getWords().get(currentDepth);
                if(map.containsKey(top.getNorWord())) {
                    ws.getWords().remove(currentDepth);
                    List<String> temp = map.get(top.getNorWord());
                    int offset = 0;
                    for(String s : temp) {
                        boolean flag = false;
                        for(int q = 0; q < words.size(); q++){
                            if(s.equals(words.get(q).getNorWord())) flag = true;
                        }
                        if(!flag) {
                            offset++;
                            ws.getWords().add(new Word(s, s, 0));
                        }
                    }
                    currentDepth += offset - 1;
                }else{
                    currentDepth--;
                }
            }
            stack.add(ws);
        }
        ret = cartesianProduct(stack);
   
        return ret;
    }

    protected static List<WordSet> cartesianProduct(List<WordSet> lists) {
        List<WordSet> resultLists = new ArrayList<>();
        if (lists.size() == 0) {
            resultLists.add(new WordSet());
            return resultLists;
        } else {
            WordSet firstList = lists.get(0);
            List<WordSet> remainingLists = cartesianProduct(lists.subList(1, lists.size()));
            for (Word condition : firstList.getWords()) {
                for (WordSet remainingList : remainingLists) {
                    WordSet resultList = new WordSet();
                    resultList.getWords().add(condition);
                    resultList.getWords().addAll(remainingList.getWords());
                    resultLists.add(resultList);
                }
            }
        }
        return resultLists;
    }

}
