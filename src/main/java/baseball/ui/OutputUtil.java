package baseball.ui;

import baseball.model.Result;

import java.util.ArrayList;
import java.util.List;

public class OutputUtil {
    private OutputUtil() {
    }

    public static void printResult(Result result) {
        int strike = result.getStrike();
        int ball = result.getBall();

        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return;
        }

        List<String> resultMessages = new ArrayList<>();

        if (ball > 0) {
            resultMessages.add(ball + "볼");
        }

        if (strike > 0) {
            resultMessages.add(strike + "스트라이크");
        }

        System.out.println(String.join(" ", resultMessages));

    }
}