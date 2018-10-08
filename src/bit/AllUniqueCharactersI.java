package bit;

/**
 * Created by kewang on 6/10/18.
 */
public class AllUniqueCharactersI {
    public boolean allUnique(String word) {
        // Write your solution here
        if(word == null){
            return false;
        }

        int mask = 0;
        for (int i = 0; i < word.length(); i++){
            int pos = word.charAt(i) - 'a';
            if ( (mask & (1<< pos)) != 0){
                return false;
            }
            mask |= (1<<pos);
        }
        return true;
    }
}
