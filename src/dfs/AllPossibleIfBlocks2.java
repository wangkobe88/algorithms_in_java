package dfs;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by kewang on 18/10/18.
 */

public class AllPossibleIfBlocks2 {
    private static String part2 = new String("}");
    private static String part1 = new String("if {");

    private String blankString(int count){
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while( i < count ){
            sb.append("\t ");
            i++;
        }
        return sb.toString();
    }

    private void printSequence(List<Integer> seqence){
        int part1Count = 0;
        int part2Count = 0;
        StringBuilder sb = new StringBuilder();
        for(Integer partNumber: seqence){
            //System.out.println(partNumber);

            if(partNumber == 2){
                sb.append(blankString(part1Count - part2Count - 1));
                part2Count++;
                sb.append(part2);
            } else{
                sb.append(blankString(part1Count - part2Count));
                sb.append(part1);
                part1Count++ ;
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private void dfs(List<Integer> seqence, int part1Total, int part2Total, int part1Count, int part2Count){
        if(part1Total == part1Count && part2Total == part2Count){
            printSequence(seqence);
        }

        if(part1Count > part2Count && part2Count < part2Total){
            seqence.add(2);
            dfs(seqence, part1Total, part2Total, part1Count, part2Count + 1);
            seqence.remove(seqence.size() - 1);
        }

        if(part1Count < part1Total){
            seqence.add(1);
            dfs(seqence, part1Total, part2Total, part1Count + 1, part2Count);
            seqence.remove(seqence.size() - 1);
        }

    }

    public void printAllIfBlocks(int k){
        List<Integer> sequence = new ArrayList<Integer>();
        dfs(sequence, k, k, 0, 0);
    }

    public static void main(String[] args){
        AllPossibleIfBlocks2 allPossibleIfBlocks = new AllPossibleIfBlocks2();
        allPossibleIfBlocks.printAllIfBlocks(3);
    }
}
