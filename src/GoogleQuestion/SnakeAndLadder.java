package GoogleQuestion;

import java.util.Scanner;

public class SnakeAndLadder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String table[] = new String[100];
        for (int i = 0; i < 100; i++) {
            table[i] = i + 1 + "";
        }
        int ladderPositions[] = new int[100];
        int snakePositions[] = new int[100];

        for (int i = 0; i < 100; i++) {
            ladderPositions[i] = -1;
            snakePositions[i] = -1;
        }

        ladderPositions[6] = 34;
        ladderPositions[12] = 28;
        ladderPositions[52] = 89;
        snakePositions[19] = 4;
        snakePositions[42] = 21;
        snakePositions[88] = 39;

        int dice = 0;
        int player1position = 0;
        for (player1position = 0; player1position < table.length; ) {
            System.out.println("press enter key = "+Math.random());
            try {
                String ss = sc.next();
            } catch (Exception e) {
            }
            dice = (int) (Math.random()*10);
            for(;!(dice>=1&&dice<=6);) {
                dice = (int) (Math.random()*10);
            }
            if (player1position + dice <= 100) {
                player1position = player1position + dice;

                if (ladderPositions[player1position - 1] != -1) {
                    player1position = ladderPositions[player1position - 1] + 1;
                }
                if (snakePositions[player1position - 1] != -1) {
                    player1position = snakePositions[player1position - 1] + 1;
                }
                int c1 = 10;
                int t = 0;
                int a = (table.length) / 10;
                ;
                for (int i = table.length; i > 0; ) {
                    if (player1position == i) {
                        System.out.print("*" + i + " ");
                    } else {
                        System.out.print(i + " ");
                    }
                    t++;
                    if (c1 % 2 == 0) {
                        i--;
                    } else {
                        i++;
                    }
                    if (t == 10) {
                        System.out.println();
                        c1--;
                        t = 0;
                        if (c1 % 2 == 0) {
                            i = i - 11;
                        } else {
                            i = i - 9;
                        }
                    }
                }
            }
        }
    }
}
