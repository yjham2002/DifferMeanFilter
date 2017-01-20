# DifferMeanFilter

:mag: Difference Mean Filter for homonym

- Usage

```java
    public static void main(String[] args){

        WordSet wordSet = new WordSet();
        wordSet.addWord(new Word("일본", "일본", 0));
        wordSet.addWord(new Word("도쿄", "도쿄", 0));

        Map<String,List<String>> map = new HashMap<>();
        map.put("일본",  Arrays.asList(new String[]{"도쿄","오사카", "홋카이도"}));
        map.put("홋카이도",  Arrays.asList(new String[]{"폭설", "산악"}));
        map.put("여행", Arrays.asList(new String[]{"크루즈","배낭여행"}));
        map.put("도쿄", Arrays.asList(new String[]{"신칸센","방사선"}));

        for(WordSet ws : DifferMeanFilter.execute(wordSet, map)){
            for(Word w : ws.getWords()){
                System.out.print(w.getNorWord() + "/");
            }
            System.out.println("");
        }

    }
```