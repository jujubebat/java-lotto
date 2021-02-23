package lotto.domain.lotto;

import static lotto.view.messages.ErrorMessages.LOTTO_LINE_NUMBER_COUNT_ERROR;
import static lotto.view.messages.ErrorMessages.LOTTO_LINE_NUMBER_DUPLICATE_ERROR;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.rank.Rank;

public class LottoLine {

    public static final int LOTTO_NUMBER_COUNT = 6;
    private final List<LottoNumber> lottoNumbers;

    public LottoLine(List<LottoNumber> lottoNumbers) {
        validateSize(lottoNumbers);
        validateDuplicate(lottoNumbers);
        this.lottoNumbers = new ArrayList<>(lottoNumbers);
    }

    public Rank checkLottoLine(WinningLottoLine winningLottoLine) {
        int LottoNumberMatchCount = winningLottoLine.getLottoNumberMatchCount(lottoNumbers);
        boolean hasBonusNumber = winningLottoLine.isContainBonusLottoNumber(lottoNumbers);
        return Rank.getMatchedRank(LottoNumberMatchCount, hasBonusNumber);
    }

    public List<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    public boolean hasLottoNumber(LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }

    private void validateSize(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_LINE_NUMBER_COUNT_ERROR.getMessage());
        }
    }

    private void validateDuplicate(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> set = new HashSet<>(lottoNumbers);
        if (set.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(LOTTO_LINE_NUMBER_DUPLICATE_ERROR.getMessage());
        }
    }

}