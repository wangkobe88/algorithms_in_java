package dfs;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * Created by kewang on 29/10/18.
 */

/*
知识点：
* StringBuilder 中删除一个元素是deleteCharAt()
* 从小到大排序直接调用Arrays.sort()即可
*
* 错误1：数组的小循环条件判断必须要包含是否在数组范围内；
* */


public class AllSubsetsII {
    private void subSets(int level, char[] charSet, StringBuilder result, List<String> results) {
        if(level == charSet.length) {
            results.add(result.toString());
            return;
        }

        result.append(charSet[level]);
        subSets(level + 1, charSet, result, results);
        result.deleteCharAt(result.length() - 1);
        while( level < (charSet.length - 1) && charSet[level] == charSet[level + 1]) {
            level += 1;
        }
        subSets(level + 1, charSet, result, results);
    }

    public List<String> subSets(String set) {
        // Write your solution here.
        List<String> results = new ArrayList<String>();
        if(set == null) {
            return results;
        }
        char[] charSet = set.toCharArray();
        Arrays.sort(charSet);
        StringBuilder result = new StringBuilder();
        subSets(0, charSet, result, results);
        return results;
    }
}
