import java.util.Random;

/** 모델: 게임 규칙과 데이터만 담당한다.  */
public class BaseballModel {
    public static final int SIZE = 3;

    private final Random random = new Random();
    private int[] balls = new int[SIZE];
    private int tryCount;

    public BaseballModel() {
        newGame();
    }

    /** 서로 다른 숫자 3개를 새로 뽑고 시도 횟수를 초기화한다. */
    public void newGame() {
        boolean[] used = new boolean[10];
        for (int i = 0; i < SIZE; i++) {
            int n;
            do {
                n = random.nextInt(10);
            } while (used[n]);
            used[n] = true;
            balls[i] = n;
        }
        tryCount = 0;
    }

    /** 입력이 규칙에 맞는지 검사한다: 길이 3, 각 숫자 0~9, 서로 다름. */
    public boolean isValid(int[] guess) {
        if (guess == null || guess.length != SIZE) return false;
        boolean[] seen = new boolean[10];
        for (int g : guess) {
            if (g < 0 || g > 9 || seen[g]) return false;
            seen[g] = true;
        }
        return true;
    }

    /** 추측을 판정하고 시도 횟수를 1 늘린다. 유효하지 않은 입력이면 예외. */
    public int[] guess(int[] guess) {
        if (!isValid(guess)) throw new IllegalArgumentException("invalid guess");
        int strike = 0, ball = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (guess[i] == balls[j]) {
                    if (i == j) strike++;
                    else ball++;
                }
            }
        }
        tryCount++;
        return new int[] { strike, ball };
    }

    public boolean isWin(int strike) {
        return strike == SIZE;
    }

    public int getTryCount() {
        return tryCount;
    }
}
