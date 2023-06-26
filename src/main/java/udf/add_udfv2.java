package udf;

import org.apache.hadoop.hive.ql.exec.UDF;

public class add_udfv2 extends UDF {
    public String evaluate( String number) {
        return number + "_hello2";
    }
}
