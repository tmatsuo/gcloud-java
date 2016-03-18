// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/protobuf/api.proto

package com.google.protobuf;

public interface MethodOrBuilder extends
    // @@protoc_insertion_point(interface_extends:google.protobuf.Method)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional string name = 1;</code>
   *
   * <pre>
   * The simple name of this method.
   * </pre>
   */
  java.lang.String getName();
  /**
   * <code>optional string name = 1;</code>
   *
   * <pre>
   * The simple name of this method.
   * </pre>
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>optional string request_type_url = 2 [ctype = STRING_PIECE];</code>
   *
   * <pre>
   * A URL of the input message type.
   * </pre>
   */
  java.lang.String getRequestTypeUrl();
  /**
   * <code>optional string request_type_url = 2 [ctype = STRING_PIECE];</code>
   *
   * <pre>
   * A URL of the input message type.
   * </pre>
   */
  com.google.protobuf.ByteString
      getRequestTypeUrlBytes();

  /**
   * <code>optional bool request_streaming = 3;</code>
   *
   * <pre>
   * If true, the request is streamed.
   * </pre>
   */
  boolean getRequestStreaming();

  /**
   * <code>optional string response_type_url = 4 [ctype = STRING_PIECE];</code>
   *
   * <pre>
   * The URL of the output message type.
   * </pre>
   */
  java.lang.String getResponseTypeUrl();
  /**
   * <code>optional string response_type_url = 4 [ctype = STRING_PIECE];</code>
   *
   * <pre>
   * The URL of the output message type.
   * </pre>
   */
  com.google.protobuf.ByteString
      getResponseTypeUrlBytes();

  /**
   * <code>optional bool response_streaming = 5;</code>
   *
   * <pre>
   * If true, the response is streamed.
   * </pre>
   */
  boolean getResponseStreaming();

  /**
   * <code>repeated .google.protobuf.Option options = 6;</code>
   *
   * <pre>
   * Any metadata attached to the method.
   * </pre>
   */
  java.util.List<com.google.protobuf.Option> 
      getOptionsList();
  /**
   * <code>repeated .google.protobuf.Option options = 6;</code>
   *
   * <pre>
   * Any metadata attached to the method.
   * </pre>
   */
  com.google.protobuf.Option getOptions(int index);
  /**
   * <code>repeated .google.protobuf.Option options = 6;</code>
   *
   * <pre>
   * Any metadata attached to the method.
   * </pre>
   */
  int getOptionsCount();
  /**
   * <code>repeated .google.protobuf.Option options = 6;</code>
   *
   * <pre>
   * Any metadata attached to the method.
   * </pre>
   */
  java.util.List<? extends com.google.protobuf.OptionOrBuilder> 
      getOptionsOrBuilderList();
  /**
   * <code>repeated .google.protobuf.Option options = 6;</code>
   *
   * <pre>
   * Any metadata attached to the method.
   * </pre>
   */
  com.google.protobuf.OptionOrBuilder getOptionsOrBuilder(
      int index);

  /**
   * <code>optional .google.protobuf.Syntax syntax = 7;</code>
   *
   * <pre>
   * The source syntax of this method.
   * </pre>
   */
  int getSyntaxValue();
  /**
   * <code>optional .google.protobuf.Syntax syntax = 7;</code>
   *
   * <pre>
   * The source syntax of this method.
   * </pre>
   */
  com.google.protobuf.Syntax getSyntax();
}