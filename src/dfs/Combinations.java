package dfs;
import java.util.List;
import java.util.ArrayList;
/**
 * Created by kewang on 28/10/18.
 */
/*
* 注意：
* 主函数看成是第0层
* 第一层处理顺序第一个元素（第0个元素）；
* 当超出最后一层即到了n+1层后，判断并直接返回；
*
* 错误1：
* 当结果是对象的List，尤其是容器的List的时候，一定要处理对象拷贝问题。
*
* */

public class Combinations {
    public void combine(int n, int k, int level, List<Integer> result, List<List<Integer>> results) {
        if(level == (n + 1)) {
            if(result.size() == k){
                results.add(new ArrayList<Integer>(result));
            }
            return;
        }
        result.add(level);
        combine(n, k, level + 1, result, results);
        result.remove(result.size() - 1);
        combine(n, k, level + 1, result, results);
    }

    public List<List<Integer>> combine(int n, int k) {
        // Write your solution here
        List<Integer> result = new ArrayList<Integer>();
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        combine(n, k, 1, result, results);
        return results;
    }

    public static void main(String[] args){
        Combinations combinations = new Combinations();
        List<List<Integer>> results = combinations.combine(4,2);
        for(List<Integer> result : results) {
            for(Integer re : result) {
                System.out.print(re);
            }
            System.out.println();

        }
    }
}
