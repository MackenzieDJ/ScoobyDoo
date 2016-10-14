package scoobydoo.engine.gui;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Creates the text of a enjoyTheGameProgress bar depending on its enjoyTheGameProgress. Here are some
 * examples:<br/>
 * <code> // Sets the text to always display "Hello world"<br/>
 * progressBar.setTextFunction(new IProgressTextFunction.Always("Hello world"));<br/>
 * <br/> // Displays the percentage a enjoyTheGameProgress bar is full<br/>
 * progressBar.setTextFunction(new IProgressTextFunction.Format("Percentage: $% percent full"));<br/>
 * <br/> // Displays the enjoyTheGameProgress and max enjoyTheGameProgress of a enjoyTheGameProgress bar<br/>
 * progressBar.setTextFunction(new IProgressTextFunction.Format("Progress: $p out of $m"));<br/>
 * </code>Of course, custom text functions can be created for more complicated
 * requirements.
 */
public interface IProgressTextFunction {

	String getText(int progress, int maxProgress);

	public static class Always implements IProgressTextFunction {
		private String value;

		public Always(String value) {
			this.value = value;
		}

		@Override
		public String getText(int progress, int maxProgress) {
			return value;
		}
	}

	public static class Format implements IProgressTextFunction {
		private static final Pattern WILDCARD_PATTERN = Pattern.compile("\\$([%pm])");
		private static final DecimalFormat NUMBER_FORMAT = new DecimalFormat("#");

		private String format;

		public Format(String format) {
			this.format = format;
		}

		@Override
		public String getText(int progress, int maxProgress) {
			float percentage = (float) progress * 100 / maxProgress;

			StringBuilder text = new StringBuilder();
			int lastEnd = 0;
			int start;

			Matcher matcher = WILDCARD_PATTERN.matcher(format);
			while (matcher.find()) {
				start = matcher.start();
				if (isEscaped(start)) {
					text.append(format.substring(lastEnd, start - 1));
					text.append(matcher.group());
					lastEnd = matcher.end();
				} else {
					text.append(format.substring(lastEnd, start));

					switch (matcher.group(1).charAt(0)) {
					case '%':
						text.append(NUMBER_FORMAT.format(percentage));
						break;
					case 'p':
						text.append(progress);
						break;
					case 'm':
						text.append(maxProgress);
						break;
					default:
						throw new IllegalStateException("Invalid wildcard " + matcher.group());
					}
					lastEnd = matcher.end();
				}
			}

			if (lastEnd != format.length()) {
				text.append(format.substring(lastEnd));
			}

			for (int index = 0; index < text.length(); index++) {
				if (text.charAt(index) == '\\' && text.charAt(index + 1) == '\\') {
					text.deleteCharAt(index);
				}
			}

			return text.toString();
		}

		private boolean isEscaped(int index) {
			return index > 0 && format.charAt(index - 1) == '\\' && !isEscaped(index - 1);
		}
	}

}
