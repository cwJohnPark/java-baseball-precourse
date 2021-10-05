package baseball.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HitStatusCount {

	private final int count;
	private final HitStatus hitStatus;

	public HitStatusCount(int count, HitStatus hitStatus) {
		this.hitStatus = hitStatus;
		this.count = count;
	}

	public static HitStatusCount of(int count, HitStatus status) {
		return new HitStatusCount(count, status);
	}

	public static List<HitStatusCount> removeNoCount(List<HitStatusCount> statusCounts) {
		List<HitStatusCount> removedNotCountList = new ArrayList<>(statusCounts);
		removedNotCountList.removeIf((hitStatusCount -> hitStatusCount.getCount() < 1));

		return removedNotCountList;
	}

	public HitStatus getHitStatus() {
		return hitStatus;
	}

	public int getCount() {
		return count;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		HitStatusCount that = (HitStatusCount)o;
		return count == that.count && Objects.equals(hitStatus, that.hitStatus);
	}

	@Override
	public int hashCode() {
		return Objects.hash(count, hitStatus);
	}

}
