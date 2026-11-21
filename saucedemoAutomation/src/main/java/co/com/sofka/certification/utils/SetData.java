
package co.com.sofka.certification.utils;

import java.util.List;
import java.util.Map;

import static co.com.sofka.certification.utils.Constants.PATH_FILE;
import static co.com.sofka.certification.utils.Constants.QUERY;

public class SetData {

    private SetData() {}

    public static List<Map<String, String>> fromExcel(String sheet, String idTest) {
        return GetData.deExcel(
                PATH_FILE,
                String.format(QUERY, sheet, idTest)
        );
    }
}
