package wiki.laona.prototype;

import com.sun.org.apache.xpath.internal.compiler.Keywords;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author laona
 * @description
 * @date 2022-01-13 09:13
 **/
public class Demo1 {
    private ConcurrentHashMap<String, SearchWords> currentKeyWords = new ConcurrentHashMap<String, SearchWords>();
    private long lastUpdateTime = -1;

    public void refresh() { 
        List<SearchWords> toBeUpdatedSearchWords = getSearchWords(lastUpdateTime);
        long maxNewUpdateTime = lastUpdateTime;
        for (SearchWords searchWord : toBeUpdatedSearchWords) {
            if (searchWord.getLastUpdateTime() > maxNewUpdateTime) {
                maxNewUpdateTime = searchWord.getLastUpdateTime();
            }
            if (currentKeyWords.containsKey(searchWord.getKeyWord())) {
                currentKeyWords.replace(searchWord.getKeyWord(), searchWord);
            }else {
                currentKeyWords.put(searchWord.getKeyWord(), searchWord);
            }
        }
        
        lastUpdateTime = maxNewUpdateTime;
    }
    
    public void refreshByDeepCopy() {
        // deep copy
        HashMap<String, SearchWords> newKeyWords = new HashMap<>();
        for (Map.Entry<String, SearchWords> entry : currentKeyWords.entrySet()) {
            SearchWords searchWord = entry.getValue();
            SearchWords newSearchWord = new SearchWords(searchWord.getKeyWord(), searchWord.getCount(), searchWord.getLastUpdateTime());
            newKeyWords.put(entry.getKey(), newSearchWord);
        }

        List<SearchWords> toBeUpdateSearchWords = getSearchWords(lastUpdateTime);
        long maxNewUpdatedTime = lastUpdateTime;
        for (SearchWords searchWord : toBeUpdateSearchWords) {
            if (searchWord.getLastUpdateTime() > maxNewUpdatedTime) {
                maxNewUpdatedTime = searchWord.getLastUpdateTime();
            }
            if (newKeyWords.containsKey(searchWord.getKeyWord())) {
                SearchWords oldSearchWord = newKeyWords.get(searchWord.getKeyWord());
                oldSearchWord.setCount(searchWord.getCount());
                oldSearchWord.setLastUpdateTime(maxNewUpdatedTime);
            }
        }
    }

    /**
     * 从数据库取出更新时间 > lastUpdateTime 的数据，放入到 currentKeyWords 中
     *
     * @param lastUpdateTime 更新时间
     * @return <code> currentKeyWords </code>
     */
    private List<SearchWords> getSearchWords(long lastUpdateTime) {
        return Collections.emptyList();
    }
}
