package btcdemo.btcdemo.security;

import java.util.UUID;

public class IdGenUtils {


    public static String genId(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
