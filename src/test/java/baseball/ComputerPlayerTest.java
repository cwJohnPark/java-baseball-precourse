package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ComputerPlayerTest {

    @Test
    void selectComputerPlayersBaseBalls() {
        final int expectedBaseBallCount = 3;
        ComputerPlayer computerPlayer = new ComputerPlayer();

        computerPlayer.setRandomBaseBalls();

        BaseBalls baseBalls = computerPlayer.getBaseBalls();

        assertThat(baseBalls.isSizeOf(expectedBaseBallCount)).isTrue();
    }

}
