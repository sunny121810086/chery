package udf;

import org.apache.hadoop.hive.ql.exec.UDF;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TopnUDF extends UDF {
    public String[] evaluate(String str, String sep1, String sep2, int a, int b) {
        String[] topN = new String[b];
        try {
            if (!str.isEmpty()) {
                List<String> list = Arrays.asList(str.split(sep2));
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    String value = it.next();
                    for (int i = 0; i < topN.length; i++) {
                        if (topN[i] == null) {
                            topN[i] = value;
                            break;
                        } else {
                            String lastValue = topN[i];
                            if (Integer.parseInt(value.split(sep1)[a]) >= Integer.parseInt(lastValue.split(sep1)[a])) {
                                for (int j = topN.length - 1; j > i; j--) {
                                    topN[j] = topN[j - 1];
                                }
                                topN[i] = value;
                                break;
                            }
                        }
                    }
                }
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return topN;
    }
}
