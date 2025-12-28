package io.github.mmm.value.observable.locale;

import java.util.Locale;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test of {@link ObservableLocaleValue} and {@link WritableLocaleValue}.
 */
class LocaleValueTest extends Assertions {

  /** Test of basics */
  @Test
  void test() {

    LocaleValueMock localeValue = new LocaleValueMock();
    assertThat(localeValue.getValueClass()).isSameAs(Locale.class);
    assertThat(localeValue.getSafe()).isSameAs(Locale.ROOT);
    assertThat(localeValue.get()).isNull();
    localeValue.set(Locale.GERMAN);
    assertThat(localeValue.get()).isSameAs(Locale.GERMAN);
    assertThat(localeValue.getSafe()).isSameAs(Locale.GERMAN);
    localeValue.setAsString("en_GB");
    assertThat(localeValue.getAsString()).isEqualTo("en_GB");
    assertThat(localeValue.toString()).isEqualTo("LocaleValueMock[value=en_GB]");

  }

}
