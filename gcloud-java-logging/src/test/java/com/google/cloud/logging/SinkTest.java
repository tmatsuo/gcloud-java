/*
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.logging;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.createStrictMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.google.cloud.logging.SinkInfo.Destination.BucketDestination;
import com.google.cloud.logging.SinkInfo.Destination.DatasetDestination;
import com.google.cloud.logging.SinkInfo.VersionFormat;
import com.google.common.util.concurrent.Futures;

import org.junit.After;
import org.junit.Test;

import java.util.concurrent.ExecutionException;

public class SinkTest {

  private static final String NAME = "sink";
  private static final String FILTER =
      "logName=projects/my-projectid/logs/syslog AND severity>=ERROR";
  private static final VersionFormat VERSION = VersionFormat.V1;
  private static final String NEW_NAME = "newSink";
  private static final String NEW_FILTER =
      "logName=projects/my-projectid/logs/syslog";
  private static final VersionFormat NEW_VERSION = VersionFormat.V2;
  private static final BucketDestination BUCKET_DESTINATION = BucketDestination.of("bucket");
  private static final DatasetDestination DATASET_DESTINATION = DatasetDestination.of("dataset");
  private static final SinkInfo SINK_INFO = SinkInfo.builder(NAME, BUCKET_DESTINATION)
      .filter(FILTER)
      .versionFormat(VERSION)
      .build();
  private final Logging serviceMockReturnsOptions = createStrictMock(Logging.class);
  private final LoggingOptions mockOptions = createMock(LoggingOptions.class);
  private Logging pubsub;
  private Sink expectedSink;
  private Sink sink;

  private void initializeExpectedSink(int optionsCalls) {
    expect(serviceMockReturnsOptions.options()).andReturn(mockOptions).times(optionsCalls);
    replay(serviceMockReturnsOptions);
    pubsub = createStrictMock(Logging.class);
    expectedSink = new Sink(serviceMockReturnsOptions, new Sink.BuilderImpl(SINK_INFO));
  }

  private void initializeSink() {
    sink = new Sink(pubsub, new Sink.BuilderImpl(SINK_INFO));
  }

  @After
  public void tearDown() throws Exception {
    verify(pubsub, serviceMockReturnsOptions);
  }

  @Test
  public void testBuilder() {
    initializeExpectedSink(2);
    replay(pubsub);
    SinkInfo builtSink = expectedSink.toBuilder()
        .name(NEW_NAME)
        .filter(NEW_FILTER)
        .destination(DATASET_DESTINATION)
        .versionFormat(NEW_VERSION)
        .build();
    assertEquals(NEW_NAME, builtSink.name());
    assertEquals(DATASET_DESTINATION, builtSink.destination());
    assertEquals(NEW_FILTER, builtSink.filter());
    assertEquals(NEW_VERSION, builtSink.versionFormat());
  }

  @Test
  public void testToBuilder() {
    initializeExpectedSink(2);
    replay(pubsub);
    compareSink(expectedSink, expectedSink.toBuilder().build());
  }

  @Test
  public void testReload() {
    initializeExpectedSink(2);
    SinkInfo updatedInfo = SINK_INFO.toBuilder().filter(NEW_FILTER).build();
    Sink expectedSink =
        new Sink(serviceMockReturnsOptions, new SinkInfo.BuilderImpl(updatedInfo));
    expect(pubsub.options()).andReturn(mockOptions);
    expect(pubsub.getSink(NAME)).andReturn(expectedSink);
    replay(pubsub);
    initializeSink();
    Sink updatedSink = sink.reload();
    compareSink(expectedSink, updatedSink);
  }

  @Test
  public void testReloadNull() {
    initializeExpectedSink(1);
    expect(pubsub.options()).andReturn(mockOptions);
    expect(pubsub.getSink(NAME)).andReturn(null);
    replay(pubsub);
    initializeSink();
    assertNull(sink.reload());
  }

  @Test
  public void testReloadAsync() throws ExecutionException, InterruptedException {
    initializeExpectedSink(2);
    SinkInfo updatedInfo = SINK_INFO.toBuilder().filter(NEW_FILTER).build();
    Sink expectedSink = new Sink(serviceMockReturnsOptions, new SinkInfo.BuilderImpl(updatedInfo));
    expect(pubsub.options()).andReturn(mockOptions);
    expect(pubsub.getSinkAsync(NAME))
        .andReturn(Futures.immediateFuture(expectedSink));
    replay(pubsub);
    initializeSink();
    Sink updatedSink = sink.reloadAsync().get();
    compareSink(expectedSink, updatedSink);
  }

  @Test
  public void testReloadAsyncNull() throws ExecutionException, InterruptedException {
    initializeExpectedSink(1);
    expect(pubsub.options()).andReturn(mockOptions);
    expect(pubsub.getSinkAsync(NAME)).andReturn(Futures.<Sink>immediateFuture(null));
    replay(pubsub);
    initializeSink();
    assertNull(sink.reloadAsync().get());
  }

  @Test
  public void testUpdate() {
    initializeExpectedSink(2);
    SinkInfo updatedInfo = SINK_INFO.toBuilder().filter(NEW_FILTER).build();
    Sink expectedSink = new Sink(serviceMockReturnsOptions, new SinkInfo.BuilderImpl(updatedInfo));
    expect(pubsub.options()).andReturn(mockOptions);
    expect(pubsub.update(updatedInfo)).andReturn(expectedSink);
    replay(pubsub);
    initializeSink();
    Sink updatedSink = sink.update(updatedInfo);
    compareSink(expectedSink, updatedSink);
  }

  @Test
  public void testUpdateAsync() throws ExecutionException, InterruptedException {
    initializeExpectedSink(2);
    SinkInfo updatedInfo = SINK_INFO.toBuilder().filter(NEW_FILTER).build();
    Sink expectedSink = new Sink(serviceMockReturnsOptions, new SinkInfo.BuilderImpl(updatedInfo));
    expect(pubsub.options()).andReturn(mockOptions);
    expect(pubsub.updateAsync(updatedInfo)).andReturn(Futures.immediateFuture(expectedSink));
    replay(pubsub);
    initializeSink();
    Sink updatedSink = sink.updateAsync(updatedInfo).get();
    compareSink(expectedSink, updatedSink);
  }

  @Test
  public void testDeleteTrue() {
    initializeExpectedSink(1);
    expect(pubsub.options()).andReturn(mockOptions);
    expect(pubsub.deleteSink(NAME)).andReturn(true);
    replay(pubsub);
    initializeSink();
    assertTrue(sink.delete());
  }

  @Test
  public void testDeleteFalse() {
    initializeExpectedSink(1);
    expect(pubsub.options()).andReturn(mockOptions);
    expect(pubsub.deleteSink(NAME)).andReturn(false);
    replay(pubsub);
    initializeSink();
    assertFalse(sink.delete());
  }

  @Test
  public void testDeleteAsyncTrue() throws ExecutionException, InterruptedException {
    initializeExpectedSink(1);
    expect(pubsub.options()).andReturn(mockOptions);
    expect(pubsub.deleteSinkAsync(NAME)).andReturn(Futures.immediateFuture(true));
    replay(pubsub);
    initializeSink();
    assertTrue(sink.deleteAsync().get());
  }

  @Test
  public void testDeleteAsyncFalse() throws ExecutionException, InterruptedException {
    initializeExpectedSink(1);
    expect(pubsub.options()).andReturn(mockOptions);
    expect(pubsub.deleteSinkAsync(NAME)).andReturn(Futures.immediateFuture(false));
    replay(pubsub);
    initializeSink();
    assertFalse(sink.deleteAsync().get());
  }

  private void compareSink(Sink expected, Sink value) {
    assertEquals(expected, value);
    assertEquals(expected.name(), value.name());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
