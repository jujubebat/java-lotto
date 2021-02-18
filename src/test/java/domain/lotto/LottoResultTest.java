package domain.lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import lotto.domain.Rank;
import lotto.domain.lotto.LottoResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultTest {

    @Test
    @DisplayName("원하는 등수 개수를 제대로 찾아내는지 테스트")
    public void find_wanted_number_of_rank() {
        LottoResult lottoResult = new LottoResult(
            Arrays.asList(Rank.FIFTH, Rank.FIFTH, Rank.FIFTH, Rank.SECOND));
        assertThat(lottoResult.findNumberOfRank(Rank.FIRST)).isEqualTo(0);
        assertThat(lottoResult.findNumberOfRank(Rank.SECOND)).isEqualTo(1);
        assertThat(lottoResult.findNumberOfRank(Rank.THIRD)).isEqualTo(0);
        assertThat(lottoResult.findNumberOfRank(Rank.FOURTH)).isEqualTo(0);
        assertThat(lottoResult.findNumberOfRank(Rank.FIFTH)).isEqualTo(3);
    }

    @Test
    @DisplayName("수익률을 계산한다")
    public void calculate_profit_rate() {
        LottoResult lottoResult = new LottoResult(
            Arrays.asList(Rank.FIFTH, Rank.NO_MATCH, Rank.NO_MATCH,
                Rank.NO_MATCH, Rank.NO_MATCH, Rank.NO_MATCH, Rank.NO_MATCH, Rank.NO_MATCH,
                Rank.NO_MATCH, Rank.NO_MATCH,
                Rank.NO_MATCH, Rank.NO_MATCH, Rank.NO_MATCH, Rank.NO_MATCH));
        double profitRate = lottoResult.calculateProfitRate(14000);
        assertThat(profitRate).isEqualTo(5000 / 14000f);

    }
}