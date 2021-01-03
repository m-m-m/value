/*
 * Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */
/**
 * Provides observable value API and implementation for standard Java types.
 */
module io.github.mmm.value.observable {

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

  exports io.github.mmm.value.observable.temporal;

  exports io.github.mmm.value.observable.temporal.instant;

  exports io.github.mmm.value.observable.temporal.localdate;

  exports io.github.mmm.value.observable.temporal.localdatetime;

  exports io.github.mmm.value.observable.temporal.localtime;

  exports io.github.mmm.value.observable.temporal.offsetdatetime;

  exports io.github.mmm.value.observable.temporal.offsettime;

  exports io.github.mmm.value.observable.temporal.zoneddatetime;
}