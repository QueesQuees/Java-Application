import java.util.Scanner;

public class LuckyNumber {
    public static int sum_play = 0;
    public static int sum_times = 0;
    public static String best_game = "";
    public static void main(String[] args) {
        play();
    }
    public static void play2(int answer) {
        int times = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Số bạn chọn : ");
        int number = sc.nextInt();
        while(number != answer){

            if(number < answer) {
                System.out.println("Số bạn chọn nhỏ hơn rồi");
                System.out.print("Bạn chọn số :");
                times++;
                number = sc.nextInt();
            }else if (number > answer) {
                System.out.println("Số bạn chọn lớn hơn rồi");
                System.out.print("Bạn chọn số :");
                times++;
                number = sc.nextInt();
            }
        }
        if (number == answer){
            times++;
            System.out.println("Bạn chọn đúng sau "+ times +" lần");
            sum_play ++;
            sum_times += times;
            best_game += times;
            if(sum_play == 9) {
                report();
            }
        }


        System.out.print("Bạn có muốn chơi tiếp?(Yes or No) ");
        String play_again = sc.next();
        String yes = play_again.toUpperCase();
        if (yes.equals("YES") || yes.equals("Y")) {
            play();
        }else {
            report();
        }
    }
    public static void play() {
        int answer = (int)(Math.random()*101);
        System.out.println("Chọn một số trong khoảng 0 và 100 nhé.");
        play2(answer);
    }

    public static void report() {
        System.out.println("Tổng số lần chơi là " + sum_play);
        System.out.println("tổng số lần dự đoán "+ sum_times);
        System.out.println("Số dự đoán trung bình mỗi lượt " + (double)(sum_times)/sum_play);
        char answer = '9';
        for(int i = 0; i < best_game.length()-1 ; i++ ) {
            if(answer > best_game.charAt(i)) {
                answer = best_game.charAt(i);
            }
        }
        System.out.println("best game is "+ answer);

    }
}
