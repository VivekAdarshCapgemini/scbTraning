import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {

        String str = "Hello,world|Java;Programming";
        StringTokenizer st=new StringTokenizer(str,",|;");
        while (st.hasMoreTokens()){
            System.out.println(st.nextToken());
        }
    }
}