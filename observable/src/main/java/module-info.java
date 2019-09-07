/*
 * Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */
module net.sf.mmm.value.observable {

  requires transitive net.sf.mmm.value;

  requires transitive net.sf.mmm.event;

  exports net.sf.mmm.value.observable;

  exports net.sf.mmm.value.observable.booleans;

  exports net.sf.mmm.value.observable.comparable;

  exports net.sf.mmm.value.observable.container;

  exports net.sf.mmm.value.observable.container.collection;

  exports net.sf.mmm.value.observable.container.list;

  exports net.sf.mmm.value.observable.container.map;

  exports net.sf.mmm.value.observable.container.set;

  exports net.sf.mmm.value.observable.number;

  exports net.sf.mmm.value.observable.number.bigdecimal;

  exports net.sf.mmm.value.observable.number.biginteger;

  exports net.sf.mmm.value.observable.number.bytes;

  exports net.sf.mmm.value.observable.number.doubles;

  exports net.sf.mmm.value.observable.number.floats;

  exports net.sf.mmm.value.observable.number.integers;

  exports net.sf.mmm.value.observable.number.longs;

  exports net.sf.mmm.value.observable.number.shorts;

  exports net.sf.mmm.value.observable.object;

  exports net.sf.mmm.value.observable.string;

  exports net.sf.mmm.value.observable.temporal;

  exports net.sf.mmm.value.observable.temporal.instant;

  exports net.sf.mmm.value.observable.temporal.localdate;

  exports net.sf.mmm.value.observable.temporal.localdatetime;

}
