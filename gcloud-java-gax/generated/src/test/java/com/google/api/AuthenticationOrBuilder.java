// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/api/auth.proto

package com.google.api;

public interface AuthenticationOrBuilder extends
    // @@protoc_insertion_point(interface_extends:google.api.Authentication)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .google.api.AuthenticationRule rules = 3;</code>
   *
   * <pre>
   * Individual rules for authentication.
   * </pre>
   */
  java.util.List<com.google.api.AuthenticationRule> 
      getRulesList();
  /**
   * <code>repeated .google.api.AuthenticationRule rules = 3;</code>
   *
   * <pre>
   * Individual rules for authentication.
   * </pre>
   */
  com.google.api.AuthenticationRule getRules(int index);
  /**
   * <code>repeated .google.api.AuthenticationRule rules = 3;</code>
   *
   * <pre>
   * Individual rules for authentication.
   * </pre>
   */
  int getRulesCount();
  /**
   * <code>repeated .google.api.AuthenticationRule rules = 3;</code>
   *
   * <pre>
   * Individual rules for authentication.
   * </pre>
   */
  java.util.List<? extends com.google.api.AuthenticationRuleOrBuilder> 
      getRulesOrBuilderList();
  /**
   * <code>repeated .google.api.AuthenticationRule rules = 3;</code>
   *
   * <pre>
   * Individual rules for authentication.
   * </pre>
   */
  com.google.api.AuthenticationRuleOrBuilder getRulesOrBuilder(
      int index);

  /**
   * <code>repeated .google.api.AuthProvider providers = 4;</code>
   *
   * <pre>
   * Defines a set of authentication providers that a service supports.
   * </pre>
   */
  java.util.List<com.google.api.AuthProvider> 
      getProvidersList();
  /**
   * <code>repeated .google.api.AuthProvider providers = 4;</code>
   *
   * <pre>
   * Defines a set of authentication providers that a service supports.
   * </pre>
   */
  com.google.api.AuthProvider getProviders(int index);
  /**
   * <code>repeated .google.api.AuthProvider providers = 4;</code>
   *
   * <pre>
   * Defines a set of authentication providers that a service supports.
   * </pre>
   */
  int getProvidersCount();
  /**
   * <code>repeated .google.api.AuthProvider providers = 4;</code>
   *
   * <pre>
   * Defines a set of authentication providers that a service supports.
   * </pre>
   */
  java.util.List<? extends com.google.api.AuthProviderOrBuilder> 
      getProvidersOrBuilderList();
  /**
   * <code>repeated .google.api.AuthProvider providers = 4;</code>
   *
   * <pre>
   * Defines a set of authentication providers that a service supports.
   * </pre>
   */
  com.google.api.AuthProviderOrBuilder getProvidersOrBuilder(
      int index);
}