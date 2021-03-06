package domain.lotto;

import static lotto.domain.lotto.LottoMoney.LOTTO_PURCHASE_MONEY_LACK_ERROR;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import lotto.domain.lotto.LottoMoney;
import lotto.domain.lotto.PurchaseCount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMoneyTest {

    private LottoMoney lottoMoney;

    @BeforeEach
    void setUp() {
        lottoMoney = new LottoMoney(10_000);
    }

    @Test
    @DisplayName("구매가능한 로또 라인 개수를 반환한다.")
    void testGetCanBuyLottoLineCount() {
        assertThat(lottoMoney.getCanBuyLottoLineCount()).isEqualTo(10);
    }

    @Test
    @DisplayName("로또 금액이 음수라면 예외가 발생한다.")
    void lottoMoneyCreateException() {
        assertThatThrownBy(() -> new LottoMoney(-1))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(LOTTO_PURCHASE_MONEY_LACK_ERROR);
    }

    @Test
    @DisplayName("로또 구매 개수만큼 금액이 차감된다.")
    void testSpendLottoLine() {
        PurchaseCount purchaseCount = new PurchaseCount(5);
        assertThat(lottoMoney.spendLottoLine(purchaseCount).getCanBuyLottoLineCount()).isEqualTo(5);
    }

    @Test
    @DisplayName("로또 구매 금액이 부족하면 금액 차감시 예외가 발생한다.")
    void testSpendLottoLineException() {
        PurchaseCount purchaseCount = new PurchaseCount(20);
        assertThatThrownBy(() -> lottoMoney.spendLottoLine(purchaseCount))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(LOTTO_PURCHASE_MONEY_LACK_ERROR);
    }

}