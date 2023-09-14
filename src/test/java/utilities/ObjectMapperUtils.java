package utilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperUtils {

    // NOTE: <T> T(Generic)--> Herhangi bir veri type'ini temsil eder.(joker eleman gibi)
    // NOTE: Class<T> --> Herhangi bir class'i temsil eder.
    // readValue() methodu birinci parametre'de aldigi String datayi ikinci parametre'de berlirttigimiz data type'ina cevirir.

    public static <T> T convertJsonToJava(String json, Class<T> cls) { //Generic method olusturuldu, tum pojo class'lar tarafindan kullanilabilir
        try {
            return new ObjectMapper().readValue(json,cls); // Exception'i burada handle etmek icin try/catch kullanildi
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
