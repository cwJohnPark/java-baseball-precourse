package baseball.dto;

import java.util.ArrayList;
import java.util.List;

import baseball.domain.HitResult;
import baseball.domain.HitStatusCount;

public class HitResultDescription {

	private final List<HitStatusDescription> hitStatusDescriptions;
	private final boolean doDisplayCount;
	private final boolean isEqualToAnswer;

	public HitResultDescription(List<HitStatusDescription> hitStatusDescriptions,
		boolean doDisplayCount,
		boolean isEqualToAnswer) {
		this.hitStatusDescriptions = hitStatusDescriptions;
		this.doDisplayCount = doDisplayCount;
		this.isEqualToAnswer = isEqualToAnswer;
	}

	public static HitResultDescription createWrongAnswerWithNoCountDisplay(HitResult hitResult) {
		return from(hitResult, false, false);
	}

	public static HitResultDescription createCorrectAnswer(HitResult hitResult) {
		return from(hitResult, true, true);
	}

	public static HitResultDescription createWrongAnswer(HitResult hitResult) {
		return from(hitResult, false, true);
	}

	public static HitResultDescription from(HitResult hitResult, boolean isEqualToAnswer, boolean doDisplayCount) {
		final List<HitStatusCount> hitStatusCounts = HitStatusCount.removeNoCount(hitResult.getHitStatusCountList());
		return new HitResultDescription(HitStatusDescription.from(hitStatusCounts), doDisplayCount, isEqualToAnswer);
	}

	public String getDescription() {
		StringBuilder description = new StringBuilder();
		for (HitStatusDescription hitStatusCount : hitStatusDescriptions) {
			description.append(doDisplayCount ? hitStatusCount.count : "");
			description.append(hitStatusCount.hitStatus);
			description.append(" ");
		}

		return description.toString();
	}

	public boolean isEqualToAnswer() {
		return isEqualToAnswer;
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
