package heap;

import java.util.*;

/**
 * Created by kewang on 31/10/18.
 */
//本算法是错误的。
public class MaximumProductOfWordLengthsSimpler {

    boolean isValid(char[] s1, char[] s2){
        for(int i = 0; i < 26; i++) {
            if(s1[i] == 1 &&s1[i] == s2[i]){
                return false;
            }
        }
        return true;
    }

    private Map<Integer,char[]> buildStringMap(String[] words) {
        Map<Integer,char[]> strMap = new HashMap<Integer,char[]>();
        for(int i = 0; i < words.length; i++) {
            char[] set = new char[26];
            for (char c : words[i].toCharArray()) {
                set[c - 'a'] = 1;
            }
            strMap.put(i, set);
        }
        return strMap;
    }

    public int maxProduct(String[] words) {
        if(words == null || words.length < 2) {
            return 0;
        }


        Arrays.sort(words, new Comparator<String>() {
            public int compare(String s1, String s2) {
                if(s1.length() > s2.length()) {
                    return -1;
                } else if (s1.length() < s2.length()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        // 1:0 2:0 2:1 3:0,3:1,3:2
        // 问题是2:1与3:0无法确定顺序。

        Map<Integer,char[]> strMap = buildStringMap(words);
        for (int i = 0; i < words.length; i++) {
            //System.out.println("i:" + words[i]);
            for (int j = 0; j <= i - 1; j++) {
                System.out.println("i:" + String.valueOf(i) + " j:" + String.valueOf(j));
                //System.out.println("j:" + words[j]);
                if(isValid(strMap.get(i),strMap.get(j))) {
                    System.out.println("ok:" + words[i] + " " + words[j]);
                    return words[i].length() * words[j].length();
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        MaximumProductOfWordLengthsSimpler m = new MaximumProductOfWordLengthsSimpler();
        //m.maxProduct(new String[] {"eae","ea","aaf","bda","fcf","dc","ac","ce","cefde","dabae"});
        m.maxProduct(new String[] {"ccd",
                "accaceddeeeaefc",
                "bcaffa",
                "bbcfafbb",
                "accacfebbabbeedfbfdb",
                "beddecbffcdaededdaefdedfdea",
                "cf",
                "ddafdcbd",
                "bbafacebacaefdaffccebddff",
                "ebccffcddbeddccacceccaec",
                "becfbfdccdfdeadfbfaddbcded",
                "cbabeaaeabefedbaeaedc",
                "dfadbbdbead",
                "cafaefdcd",
                "eccdbfceafeeeacfcddc",
                "dbabbcdbb",
                "abfbfbffcbebde",
                "cfaadaa",
                "fc",
                "faebcabb",
                "adbacebabcaaccbdeaffff",
                "aeaefccf",
                "dbacbeeabdbcdfccabebaecfef",
                "ecdadeefcaddffaececffa",
                "defcabf",
                "abbcecbccbdaebaecaefabed",
                "dfeeebcbaaefc",
                "aecccbcbbdddb",
                "dcfabacec",
                "fccfbacbacddeaaea",
                "dfdbfacbacbecb",
                "cbfeebdbfecb",
                "cffaacacbde",
                "aafd",
                "bdcebbbebd",
                "afeffadcfcdacfba",
                "dafeefbcdfaffcfacee",
                "dcbbebfbedafedcdbab",
                "cafaf",
                "bcbcccfdebdd",
                "efaaaacccff",
                "cffbead",
                "ebcfccfcddffdec",
                "fffdfdcec",
                "beeafefbdfa",
                "cdfdbccfbaaeffcabab",
                "ddadcbabbcb",
                "decfaeabbecebaebeaddedae",
                "cdcbfffbebae",
                "aeccefcbcbbddfdc",
                "ffefedaf",
                "cddbabccafaffeafeedcbedbdad",
                "eddeeccfedcefadfdfebfacb",
                "aca",
                "ffdcafaddcddf",
                "ef",
                "bbbbffe",
                "ffccfebabaadcffacbbb",
                "cbdeddfddffacbeeeebafebabda",
                "ddeecb",
                "cffdc",
                "edcffcebadf",
                "becbcadcafddcfbbeeddbfffcab",
                "abcbaceeaeaddd",
                "cfeffceebfaeefadaaccfa",
                "eaccddb",
                "caeafbfafecd",
                "becaafdbaadbfecfdfde",
                "ecabaaeafbfbcbadaac",
                "bdcdffcfaeebeedfdfddfaf",
                "dbbfbaeecbfcdebad",
                "cceecddeeecdbde",
                "beec",
                "adbcfdbfdbccdcffffbcffbec",
                "bbbbfe",
                "cdaedaeaad",
                "dadbfeafadd",
                "fcacaaebcedfbfbcddfc",
                "ceecfedceac",
                "dada",
                "ccfdaeffbcfcc",
                "eadddbbbdfa",
                "beb",
                "fcaaedadabbbeacabefdabe",
                "dfcddeeffbeec",
                "defbdbeffebfceaedffbfee",
                "cffadadfbaebfdbadebc",
                "fbbadfccbeffbdeabecc",
                "bdabbffeefeccb",
                "bdeeddc",
                "afcbacdeefbcecff",
                "cfeaebbbadacbced",
                "edfddfedbcfecfedb",
                "faed",
                "cbcdccfcbdebabc",
                "efb",
                "dbddadfcddbd",
                "fbaefdfebeeacbdfbdcdddcbefc",
                "cbbfaccdbffde",
                "adbcabaffebdffad"});
    }

}
