package wiki.laona.prototype;

/**
 * @author laona
 * @description
 * @date 2022-01-13 09:14
 **/
public class SearchWords {
    private String keyWord;
    private int count;
    private long lastUpdateTime;

    public SearchWords(String keyWord, int count, long lastUpdateTime) {
        this.keyWord = keyWord;
        this.count = count;
        this.lastUpdateTime = lastUpdateTime;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public long getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(long lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
}
