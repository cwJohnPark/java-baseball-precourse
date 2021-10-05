package baseball.dto;

import java.util.ArrayList;
import java.util.List;

import baseball.domain.HitResult;
import baseball.domain.HitStatusCount;

public class HitResultDescription {

	private final List<HitStatusDescription> hitStatusDescriptions;

	public HitResultDescription(List<HitStatusDescription> hitStatusDescriptions) {
		this.hitStatusDescriptions = hitStatusDescriptions;
	}

	public static HitResultDescription from(HitResult hitResult) {
		final List<HitStatusCount> hitStatusCounts = HitStatusCount.removeNoCount(hitResult.getHitStatusCountList());
		return new HitResultDescription(HitStatusDescription.from(hitStatusCounts));
	}

	public String getDescription() {
		StringBuilder description = new StringBuilder();
		for (HitStatusDescription hitStatusCount : hitStatusDescriptions) {
			description.append(hitStatusCount.count);
			description.append(hitStatusCount.hitStatus);
			description.append(" ");
		}

		return description.toString();
	}

	private static class HitStatusDescription {
		private int count;
		private String hitStatus;

		public HitStatusDescription(int count, String hitStatus) {
			this.count = count;
			this.hitStatus = hitStatus;
		}

		public static List<HitStatusDescription> from(List<HitStatusCount> hitStatusCounts) {
			final List<HitStatusDescription> descriptions = new ArrayList<>();
			for (HitStatusCount statusCount : hitStatusCounts) {
				descriptions.add(new HitStatusDescription(statusCount.getCount(), statusCount.getHitStatus().getKor()));
			}

			return descriptions;
		}
	}
}
