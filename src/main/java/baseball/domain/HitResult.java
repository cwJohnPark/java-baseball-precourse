package baseball.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class HitResult {
	private final List<HitStatusCount> hitStatusCountList;
	private final boolean isCorrectAnswer;

	public HitResult(List<HitStatusCount> hitStatusCountList, boolean isCorrectAnswer) {
		this.hitStatusCountList = hitStatusCountList;
		this.isCorrectAnswer = isCorrectAnswer;
	}

	public static HitResult emptyResult() {
		return new HitResult(Collections.emptyList(), false);
	}

	public static HitResult createWrongAnswer(List<HitStatusCount> hitStatusCounts) {
		return new HitResult(hitStatusCounts, false);
	}

	public static HitResult of(HitResult hitResult, boolean isCorrectAnswer) {
		return new HitResult(hitResult.getHitStatusCountList(), isCorrectAnswer);
	}

	public List<HitStatusCount> getHitStatusCountList() {
		return hitStatusCountList;
	}

	public boolean isCorrectAnswer() {
		return isCorrectAnswer;
	}

	public HitResult append(HitStatusCount evaluated) {
		final List<HitStatusCount> hitStatusCounts = new ArrayList<>(this.hitStatusCountList);
		hitStatusCounts.add(evaluated);
		return new HitResult(hitStatusCounts, isCorrectAnswer);
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
