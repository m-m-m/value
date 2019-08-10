/*
 * Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */
module net.sf.mmm.value.observable {

  requires transitive net.sf.mmm.value;

  requires transitive net.sf.mmm.event;

  exports net.sf.mmm.value.observable;

  exports net.sf.mmm.value.observable.booleans;

  exports net.sf.mmm.value.observable.comparables;

  exports net.sf.mmm.value.observable.numbers;

  exports net.sf.mmm.value.observable.numbers.bigdecimals;

  exports net.sf.mmm.value.observable.numbers.bigintegers;

  exports net.sf.mmm.value.observable.numbers.bytes;

  exports net.sf.mmm.value.observable.numbers.doubles;

  exports net.sf.mmm.value.observable.numbers.floats;

  exports net.sf.mmm.value.observable.numbers.integers;

  exports net.sf.mmm.value.observable.numbers.longs;

  exports net.sf.mmm.value.observable.numbers.shorts;

  exports net.sf.mmm.value.observable.objects;

  exports net.sf.mmm.value.observable.strings;

  exports net.sf.mmm.value.observable.temporals;

  exports net.sf.mmm.value.observable.temporals.instants;

  exports net.sf.mmm.value.observable.temporals.localdates;

  exports net.sf.mmm.value.observable.temporals.localdatetimes;

}
