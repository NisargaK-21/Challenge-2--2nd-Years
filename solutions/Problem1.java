import java.io.*;
import java.util.*;

public class Problem1 {
    public static void main(String[] args) throws IOException{
        List<String> grid = new ArrayList<>();
        BufferedReader br1=new BufferedReader(new FileReader("inputs/grid.txt"));
        String line;
        while((line=br1.readLine())!=null){
            grid.add(line);
        }
        br1.close();

        BufferedReader br2=new BufferedReader(new FileReader("inputs/directions.txt"));
        String[] dirs=br2.readLine().split(" ");
        br2.close();

        List<String> rotated=new ArrayList<>();
        for(int i=0;i<grid.size();i++){
            String row=grid.get(i);
            String dir=dirs[i];

            if(dir.equals("R")){
                row=row.charAt(row.length()-1)+row.substring(0,row.length()-1);
            }else{
                row=row.substring(1)+row.charAt(0);
            }
            rotated.add(row);

            int mid=rotated.size()/2;
            String midRow=rotated.get(mid);
            int sum=0;
            for(int j=0;j<midRow.length();j++){
                sum+=midRow.charAt(j);
            }
            System.out.println("Clue 1 in decimal format "+sum);
            System.out.println("Clue 1 in hexadecimal format "+Integer.toHexString(sum));
        }
        }
}