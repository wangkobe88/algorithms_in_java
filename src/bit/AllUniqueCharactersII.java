package bit;

/**
 * Created by kewang on 6/10/18.
 */
public class AllUniqueCharactersII {
    public boolean allUnique(String word) {
        // Write your solution here
        if(word == null){
            return false;
        }

        int[] mask = new int[8];
        for (int i = 0; i < word.length(); i++){
            int pos = word.charAt(i);
            int row = pos/32;
            int col = pos%32;
            if ( (mask[row] & (1 << col)) != 0){
                return false;
            }
            mask[row] |= (1 << col);
        }
        return true;
    }
}
