package io.github.mmm.value.observable.locale;

import java.util.Locale;

import io.github.mmm.value.observable.AbstractWritableObservableValue;

/// Mock implementation of [ObservableLocaleValue] and [WritableLocaleValue] for testing.
public class LocaleValueMock extends AbstractWritableObservableValue<Locale>
    implements ObservableLocaleValue, WritableLocaleValue {

  private Locale locale;

  @Override
  protected Locale doGet() {

    return this.locale;
  }

  @Override
  protected void doSet(Locale newValue) {

    this.locale = newValue;
  }

}
