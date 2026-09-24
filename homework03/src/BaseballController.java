/** 컨트롤러: 뷰의 입력을 모델에 전달하고, 결과를 뷰에 보여주며 게임 진행을 관리한다. */
public class BaseballController {
    private final BaseballModel model;
    private final BaseballView view;

    public BaseballController(BaseballModel model, BaseballView view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        do {
            model.newGame();
            playOneGame();
        } while (view.askNewGame());
    }

    private void playOneGame() {
        while (true) {
            int[] guess = view.readGuess();
            if (guess == null || !model.isValid(guess)) {
                view.showInvalid();
                continue;
            }
            int[] result = model.guess(guess);
            if (model.isWin(result[0])) {
                view.showWin(model.getTryCount());
                return;
            }
            view.showResult(result[0], result[1]);
        }
    }
}
