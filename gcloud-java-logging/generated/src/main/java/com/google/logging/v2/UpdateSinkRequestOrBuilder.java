// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/logging/v2/logging_config.proto

package com.google.logging.v2;

public interface UpdateSinkRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:google.logging.v2.UpdateSinkRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional string sink_name = 1;</code>
   *
   * <pre>
   * The resource name of the sink to update.
   * Example: `"projects/my-project-id/sinks/my-sink-id"`.
   * The updated sink must be provided in the request and have the
   * same name that is specified in `sinkName`.  If the sink does not
   * exist, it is created.
   * </pre>
   */
  java.lang.String getSinkName();
  /**
   * <code>optional string sink_name = 1;</code>
   *
   * <pre>
   * The resource name of the sink to update.
   * Example: `"projects/my-project-id/sinks/my-sink-id"`.
   * The updated sink must be provided in the request and have the
   * same name that is specified in `sinkName`.  If the sink does not
   * exist, it is created.
   * </pre>
   */
  com.google.protobuf.ByteString
      getSinkNameBytes();

  /**
   * <code>optional .google.logging.v2.LogSink sink = 2;</code>
   *
   * <pre>
   * The updated sink, whose name must be the same as the sink
   * identifier in `sinkName`.  If `sinkName` does not exist, then
   * this method creates a new sink.
   * </pre>
   */
  boolean hasSink();
  /**
   * <code>optional .google.logging.v2.LogSink sink = 2;</code>
   *
   * <pre>
   * The updated sink, whose name must be the same as the sink
   * identifier in `sinkName`.  If `sinkName` does not exist, then
   * this method creates a new sink.
   * </pre>
   */
  com.google.logging.v2.LogSink getSink();
  /**
   * <code>optional .google.logging.v2.LogSink sink = 2;</code>
   *
   * <pre>
   * The updated sink, whose name must be the same as the sink
   * identifier in `sinkName`.  If `sinkName` does not exist, then
   * this method creates a new sink.
   * </pre>
   */
  com.google.logging.v2.LogSinkOrBuilder getSinkOrBuilder();
}