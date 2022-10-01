package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class AnswerTest {

    @Nested
    @DisplayName("정답 생성 유효성을 검증한다.")
    class 유효성_검증 {
        @Test
        @DisplayName("정답의 값이 모두 1~9 사이의 양의 정수에 속한다.")
        void 양의_정수() {
            // given
            Answer answer = Answer.create();

            int expectedMinValue = 1;
            int expectedMaxValue = 9;

            //then
            for (int ballPosition = BallPosition.MIN_VALUE; ballPosition <= Answer.ANSWER_SIZE; ballPosition++) {
                Ball ball = answer.getBallByPosition(
                        BallPosition.from(ballPosition)
                );

                assertThat(ball.number() >= expectedMinValue && ball.number() <= expectedMaxValue)
                        .isTrue();
            }
        }

        @Test
        @DisplayName("정답의 길이는 3이다.")
        void 정답_개수_3() {
            // given
            Answer answer = Answer.create();
            int answerSize = answer.getBalls().size();

            int expectedSize = 3;

            //then
            assertThat(answerSize).isEqualTo(expectedSize);
        }

        @Test
        @DisplayName("정답은 서로 다른 숫자로 이루어져있다.")
        void 정답_중복_체크() {
            // given
            Answer answer = Answer.create();
            List<Integer> ballValueList = answer.getBallValues();
            Set<Integer> ballValueSet = new HashSet<>(ballValueList);

            //then
            assertThat(ballValueSet).as("List->Set 변환시 사이즈의 변화 여부를 통해 중복값 존재 여부 확인")
                    .hasSameSizeAs(ballValueList);
        }
    }

}
