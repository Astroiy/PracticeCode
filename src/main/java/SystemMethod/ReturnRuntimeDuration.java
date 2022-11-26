package SystemMethod;

public class ReturnRuntimeDuration {
    public static void main(String[] args) {
        String s ="";
        System.out.println(System.currentTimeMillis());
        long now = System.currentTimeMillis();
        for(int i=0;i<50000;i++){
            s+="i";
        }
        System.out.println("拼接用时: "+(System.currentTimeMillis()-now)+"毫秒");
    }
    public static class Test{
        public static void main(String[] args) {
            StringBuilder builder = new StringBuilder();
            long now = System.currentTimeMillis();
            for(int i=0;i<50000;i++){
                builder.append("i");
            }
            System.out.println("拼接用时: "+(System.currentTimeMillis()-now)+"毫秒");
        }
    }
}
