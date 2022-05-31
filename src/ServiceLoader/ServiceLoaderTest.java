package ServiceLoader;

import ServiceLoader.impl.CaesarCipher;


import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Optional;
import java.util.ServiceLoader;

public class ServiceLoaderTest {
    /**声明保存服务实现列表使用的静态常量*/
    public static ServiceLoader<Cipher> cipherLoader = ServiceLoader.load(Cipher.class);
    /**定义选择服务实现的方法*/
    public static Cipher getCipher(int Strength){
        for(Cipher c:cipherLoader){
            if(c.strength()==Strength)
                return c;
        }
        return null;
    }
    public static Optional<Cipher> getCipher2(int Strength){
        return cipherLoader.stream()
                .filter(descr->descr.type()== CaesarCipher.class)
                .findFirst()
                .map(ServiceLoader.Provider::get);
    }

    /**测试服务*/
    public static void main(String[] args) {
           Cipher cipher = getCipher(1);
           var message = "Meet me at the toga party";
           byte[] bytes = cipher.encrypt(message.getBytes(StandardCharsets.UTF_8),new byte[]{1});
           var encrypted = new String(bytes,StandardCharsets.UTF_8);
           System.out.println(encrypted);
           byte[] bytes1 = cipher.decrypt(encrypted.getBytes(StandardCharsets.UTF_8),new byte[]{1});
           var decrypted = new String(bytes1,StandardCharsets.UTF_8);
           System.out.println(decrypted);

           Optional<Cipher> cipher1 = cipherLoader.findFirst();
           System.out.println(cipher1.getClass());
    }
}
