package lotto;

import lotto.domain.lotto.LottoController;

public class Application {

    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        lottoController.run();
    }

}