import java.util.*;

public class WordSet {
    private String gid = null ;
    private String orgKeyword = null ;
    private String norKeyword = null ;
    private int maxWordLen = 0 ;
    private List<Word> words = new ArrayList<Word>() ;
    private double weight = 0.0 ;

    public WordSet(){}

    public WordSet clone(){
        WordSet wordSet = new WordSet() ;

        wordSet.orgKeyword	= this.orgKeyword ;
        wordSet.norKeyword	= this.norKeyword ;
        wordSet.maxWordLen	= this.maxWordLen ;
        wordSet.weight 		= this.weight ;

        List<Word> newWords = new ArrayList<Word>() ;

        for(Word word : words)
        {
            newWords.add(word) ;
        }

        wordSet.setWords(newWords) ;

        return wordSet ;
    }

    public String getNorKeyword()
    {
        return norKeyword;
    }

    public void setNorKeyword(String norKeyword)
    {
        this.norKeyword = norKeyword;
    }

    public String getOrgKeyword()
    {
        return orgKeyword;
    }

    public void setOrgKeyword(String orgKeyword)
    {
        this.orgKeyword = orgKeyword;
    }

    public double getWeight()
    {
        return weight;
    }

    public void setWeight(double weight)
    {
        this.weight = weight;
    }

    public void addWord(Word word)
    {
        words.add(word) ;
    }

    public int getMaxWordLen()
    {
        return maxWordLen;
    }

    public void setMaxWordLen(int maxWordLen)
    {
        this.maxWordLen = maxWordLen;
    }

    public List<Word> getWords()
    {
        return words;
    }

    public void setWords(List<Word> words)
    {
        this.words = words;
    }

}
