import java.util.Scanner;

/** 뷰: 콘솔 입출력만 담당한다. 게임 규칙은 모른다. GUI로 바꿀 땐 이 클래스만 교체한다. */
public class BaseballView {
    private final Scanner sc = new Scanner(System.in);

    /** 숫자 3개를 입력받는다. 숫자가 아니거나 개수가 다르면 null. */
    public int[] readGuess() {
        System.out.print("[0-9]까지 숫자 3개를 입력하시오: ");
        String[] tokens = sc.nextLine().trim().split("\\s+");
        if (tokens.length != BaseballModel.SIZE) return null;
        int[] guess = new int[tokens.length];
        try {
            for (int i = 0; i < tokens.length; i++) guess[i] = Integer.parseInt(tokens[i]);
        } catch (NumberFormatException e) {
            return null;
        }
        return guess;
    }

    public void showResult(int strike, int ball) {
        System.out.println("S: " + strike + ", B: " + ball);
    }

    public void showWin(int tryCount) {
        System.out.println("사용자 승 (" + tryCount + "번 만에 맞춤)");
    }

    public void showInvalid() {
        System.out.println("서로 다른 0~9 숫자 3개를 공백으로 구분해 입력하세요.");
    }

    public boolean askNewGame() {
        while (true) {
            System.out.print("새 게임(y/n)? ");
            String s = sc.nextLine().trim();
            if (s.equalsIgnoreCase("y")) return true;
            if (s.equalsIgnoreCase("n")) return false;
        }
    }
}
