package dfs;

/**
 * Created by kewang on 18/10/18.
 */
public class AllPossibleIfBlocks {
    private static String part2 = new String("\n}");
    private static String part1 = new String("\nif {");

    private void blank(StringBuilder sb, int count){
        int i = 0;
        while(i < count){
            sb.append("\t");
            i++;
        }
    }

    private void dfs(StringBuilder sb, int part1Total, int part2Total, int part1Count, int part2Count){
        if(part1Total == part1Count && part2Total == part2Count){
            System.out.println(sb.toString());
        }

        if(part1Count > part2Count && part2Count < part2Total){
            blank(sb, part1Count - part2Count);
            sb.append(part2);
            dfs(sb, part1Total, part2Total, part1Count, part2Count + 1);
            sb.delete(sb.length() - part2.length() + 1, sb.length());
        }

        if(part1Count < part1Total){
            blank(sb, part1Count - part2Count);
            sb.append(part1);
            dfs(sb, part1Total, part2Total, part1Count + 1, part2Count);
            sb.delete(sb.length() - part1.length() + 1, sb.length());
        }

    }

    public void printAllIfBlocks(int k){
        StringBuilder sb = new StringBuilder();
        dfs(sb, k, k, 0, 0);
    }

    public static void main(String[] args){
        AllPossibleIfBlocks allPossibleIfBlocks = new AllPossibleIfBlocks();
        allPossibleIfBlocks.printAllIfBlocks(2);
    }

}
