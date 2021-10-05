package baseball.domain;

import java.util.Objects;

public class HitStatus {

	private final String eng;
	private final String kor;

	public HitStatus(String eng, String kor) {
		this.eng = eng;
		this.kor = kor;
	}

	public static HitStatus of(String eng, String kor) {
		return new HitStatus(eng, kor);
	}

	public String getEng() {
		return eng;
	}

	public String getKor() {
		return kor;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		HitStatus hitStatus = (HitStatus)o;
		return Objects.equals(eng, hitStatus.eng) && Objects.equals(kor, hitStatus.kor);
	}

	@Override
	public int hashCode() {
		return Objects.hash(eng, kor);
	}
}
