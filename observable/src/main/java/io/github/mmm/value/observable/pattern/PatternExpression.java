package io.github.mmm.value.observable.pattern;

import java.util.regex.Pattern;

import io.github.mmm.value.observable.Expression;
import io.github.mmm.value.observable.comparable.ComparableExpression;

/**
 * {@link ComparableExpression} with {@link String} {@link #get() value}.
 *
 * @since 1.0.0
 */
public interface PatternExpression extends ObservablePatternValue, Expression<Pattern> {

}
