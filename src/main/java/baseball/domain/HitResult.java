package baseball.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class HitResult {
	private final List<HitStatusCount> hitStatusCountList;

	public HitResult(List<HitStatusCount> hitStatusCountList) {
		this.hitStatusCountList = hitStatusCountList;
	}

	public static HitResult emptyResult() {
		return new HitResult(Collections.emptyList());
	}

	public static HitResult createWrongAnswer(List<HitStatusCount> hitStatusCounts) {
		return new HitResult(hitStatusCounts);
	}

	public static HitResult from(HitResult hitResult) {
		return new HitResult(hitResult.getHitStatusCountList());
	}

	public List<HitStatusCount> getHitStatusCountList() {
		return hitStatusCountList;
	}

	public HitResult append(HitStatusCount evaluated) {
		final List<HitStatusCount> hitStatusCounts = new ArrayList<>(this.hitStatusCountList);
		hitStatusCounts.add(evaluated);
		return new HitResult(hitStatusCounts);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		HitResult other = (HitResult)o;

		if (this.hitStatusCountList.size() != other.hitStatusCountList.size()) {
			return false;
		}
		return hitStatusCountList.containsAll(other.hitStatusCountList);
	}

	@Override
	public int hashCode() {
		return Objects.hash(hitStatusCountList);
	}
}
