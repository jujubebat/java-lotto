package lotto.domain.lotto;

import lotto.domain.lotto.exception.IllegalLottoNumberException;

import java.util.*;

public class LottoNumber {
    public static final int MAXIMUM_NUMBER = 45;
    public static final int MINIMUM_NUMBER = 1;
    private static Map<Integer, LottoNumber> lottoNumbers = new HashMap<>();

    static {
        for (int i = 1; i <= MAXIMUM_NUMBER; i++) {
            lottoNumbers.put(i, new LottoNumber(i));
        }
    }

    private final int number;

    public LottoNumber(int number) throws IllegalLottoNumberException {
        if (number < MINIMUM_NUMBER || number > MAXIMUM_NUMBER) {
            throw new IllegalLottoNumberException("로또 숫자는 1이상 45이하여야 합니다.");
        }
        this.number = number;
    }

    public static List<LottoNumber> convertToLottoNumbers(List<Integer> numbers) {
        List<LottoNumber> returnList = new ArrayList<>();
        for (int number : numbers) {
            returnList.add(lottoNumbers.get(number));
        }
        return returnList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    public int getNumber() {
        return number;
    }
}