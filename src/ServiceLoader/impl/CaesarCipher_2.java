package ServiceLoader.impl;

import ServiceLoader.Cipher;

public class CaesarCipher_2 implements Cipher {
    public byte[] encrypt(byte[] source,byte[] key){
        var result = new byte[source.length];
        for(int i=0;i<source.length;i++){
            result[i] = (byte) (source[i]+key[0]+1);
        }
        return result;

    }
    public byte[] decrypt(byte[] source,byte[] key){
        return encrypt(source,new byte[]{(byte)-(key[0]+1)});

    }
    public int strength(){
        return 2;
    };
}
