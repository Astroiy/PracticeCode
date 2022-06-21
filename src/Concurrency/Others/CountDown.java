package Concurrency.Others;

public class CountDown {
    public static void main(String[] args) {
        var t1 = new Thread(){
            @Override
            public void run() {
                this.setName("炸弹信息##");
                for (int i = 0; i < 10; i++) {
                    System.out.println(getName()+"A点炸弹爆炸剩余时间: "+(9-i));
                    if(i==9){
                        System.out.println("炸弹爆炸，T阵营胜利");
                    }
                }
            }
        };
        var t2 = new Thread(){
            @Override
            public void run() {
                this.setName("拆弹信息##");
                for (int i = 0; i < 6; i++) {
                    System.out.println(getName()+"拆弹完成时间: "+(5-i));
                    if(i==5){
                        t1.stop();
                        System.out.println("炸弹被拆除，CT阵营胜利");
                    }
                }
            }
        };
        var t3 = new Thread(){
            @Override
            public void run() {
                this.setName("T信息##");
                for (int i = 0; i < 4; i++) {
                    System.out.println(getName()+"恐怖分子还剩"+(3-i)+"秒到达A点");
                    if(i==3) {
                        t2.stop();
                        t1.stop();
                        System.out.println("保卫者被爆头,T阵营胜利");
                    }
                }
            }
        };
        var t4 = new Thread(){
            @Override
            public void run() {
                this.setName("游戏信息##");
                for (int i = 0; i < 5; i++) {
                    System.out.println(getName()+"游戏剩余时间: "+(4-i));
                    if(i==4){
                        {
                            t1.stop();
                            t2.stop();
                            t3.stop();
                            System.out.println("游戏结束,CT阵营胜利");
                        }
                    }
                }
            }
        };
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
