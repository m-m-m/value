/*
 * Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */
/**
 * Provides observable value API and implementation for standard Java types.
 */
module io.github.mmm.value.observable {

  requires transitive io.github.mmm.base;

  requires transitive io.github.mmm.value;

  requires transitive io.github.mmm.event;

  exports io.github.mmm.value.observable;

  exports io.github.mmm.value.observable.booleans;

  exports io.github.mmm.value.observable.comparable;

  exports io.github.mmm.value.observable.container;

  exports io.github.mmm.value.observable.container.collection;

  exports io.github.mmm.value.observable.container.list;

  exports io.github.mmm.value.observable.container.map;

  exports io.github.mmm.value.observable.container.set;

  exports io.github.mmm.value.observable.enumeration;

  exports io.github.mmm.value.observable.locale;

  exports io.github.mmm.value.observable.number;

  exports io.github.mmm.value.observable.number.bigdecimal;

  exports io.github.mmm.value.observable.number.biginteger;

  exports io.github.mmm.value.observable.number.bytes;

  exports io.github.mmm.value.observable.number.doubles;

  exports io.github.mmm.value.observable.number.floats;

  exports io.github.mmm.value.observable.number.integers;

  exports io.github.mmm.value.observable.number.longs;

  exports io.github.mmm.value.observable.number.shorts;

  exports io.github.mmm.value.observable.object;

  exports io.github.mmm.value.observable.pattern;

  exports io.github.mmm.value.observable.string;

  exports io.github.mmm.value.observable.time;

  exports io.github.mmm.value.observable.time.dayofweek;

  exports io.github.mmm.value.observable.time.duration;

  exports io.github.mmm.value.observable.time.instant;

  exports io.github.mmm.value.observable.time.localdate;

  exports io.github.mmm.value.observable.time.localdatetime;

  exports io.github.mmm.value.observable.time.localtime;

  exports io.github.mmm.value.observable.time.month;

  exports io.github.mmm.value.observable.time.offsetdatetime;

  exports io.github.mmm.value.observable.time.offsettime;

  exports io.github.mmm.value.observable.time.year;

  exports io.github.mmm.value.observable.time.zoneddatetime;
}