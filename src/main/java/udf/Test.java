package udf;

public class Test {
    public static void main(String[] args) {
        String str = "10001:8:95#10001:9:90#10002:10:85#10003:11:80#10004:11:99";
        String[] topn = new TopnUDF().evaluate(str, ":", "#", 2, 3);
        for (int i = 0; i < topn.length; i++) {
            System.out.println(topn[i]);
        }

        String res = new add_udf().evaluate("aa");
        System.out.println("res: "+res);
    }
}
