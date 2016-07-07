package com.github.mcilloni.uplink.nano;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

import java.io.IOException;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 0.14.1)",
    comments = "Source: uplink.proto")
public class UplinkGrpc {

  private UplinkGrpc() {}

  public static final String SERVICE_NAME = "protodef.Uplink";

  // Static method descriptors that strictly reflect the proto.
  private static final int ARG_IN_METHOD_EXISTS = 0;
  private static final int ARG_OUT_METHOD_EXISTS = 1;
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<com.github.mcilloni.uplink.nano.UplinkProto.Username,
      com.github.mcilloni.uplink.nano.UplinkProto.BoolResp> METHOD_EXISTS =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "protodef.Uplink", "Exists"),
          io.grpc.protobuf.nano.NanoUtils.<com.github.mcilloni.uplink.nano.UplinkProto.Username>marshaller(
              new NanoFactory<com.github.mcilloni.uplink.nano.UplinkProto.Username>(ARG_IN_METHOD_EXISTS)),
          io.grpc.protobuf.nano.NanoUtils.<com.github.mcilloni.uplink.nano.UplinkProto.BoolResp>marshaller(
              new NanoFactory<com.github.mcilloni.uplink.nano.UplinkProto.BoolResp>(ARG_OUT_METHOD_EXISTS))
          );
  private static final int ARG_IN_METHOD_FRIENDS = 2;
  private static final int ARG_OUT_METHOD_FRIENDS = 3;
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<com.github.mcilloni.uplink.nano.UplinkProto.Empty,
      com.github.mcilloni.uplink.nano.UplinkProto.FriendList> METHOD_FRIENDS =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "protodef.Uplink", "Friends"),
          io.grpc.protobuf.nano.NanoUtils.<com.github.mcilloni.uplink.nano.UplinkProto.Empty>marshaller(
              new NanoFactory<com.github.mcilloni.uplink.nano.UplinkProto.Empty>(ARG_IN_METHOD_FRIENDS)),
          io.grpc.protobuf.nano.NanoUtils.<com.github.mcilloni.uplink.nano.UplinkProto.FriendList>marshaller(
              new NanoFactory<com.github.mcilloni.uplink.nano.UplinkProto.FriendList>(ARG_OUT_METHOD_FRIENDS))
          );
  private static final int ARG_IN_METHOD_LOGIN = 4;
  private static final int ARG_OUT_METHOD_LOGIN = 5;
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<com.github.mcilloni.uplink.nano.UplinkProto.AuthInfo,
      com.github.mcilloni.uplink.nano.UplinkProto.SessInfo> METHOD_LOGIN =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "protodef.Uplink", "Login"),
          io.grpc.protobuf.nano.NanoUtils.<com.github.mcilloni.uplink.nano.UplinkProto.AuthInfo>marshaller(
              new NanoFactory<com.github.mcilloni.uplink.nano.UplinkProto.AuthInfo>(ARG_IN_METHOD_LOGIN)),
          io.grpc.protobuf.nano.NanoUtils.<com.github.mcilloni.uplink.nano.UplinkProto.SessInfo>marshaller(
              new NanoFactory<com.github.mcilloni.uplink.nano.UplinkProto.SessInfo>(ARG_OUT_METHOD_LOGIN))
          );
  private static final int ARG_IN_METHOD_NEW_USER = 6;
  private static final int ARG_OUT_METHOD_NEW_USER = 7;
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<com.github.mcilloni.uplink.nano.UplinkProto.AuthInfo,
      com.github.mcilloni.uplink.nano.UplinkProto.SessInfo> METHOD_NEW_USER =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "protodef.Uplink", "NewUser"),
          io.grpc.protobuf.nano.NanoUtils.<com.github.mcilloni.uplink.nano.UplinkProto.AuthInfo>marshaller(
              new NanoFactory<com.github.mcilloni.uplink.nano.UplinkProto.AuthInfo>(ARG_IN_METHOD_NEW_USER)),
          io.grpc.protobuf.nano.NanoUtils.<com.github.mcilloni.uplink.nano.UplinkProto.SessInfo>marshaller(
              new NanoFactory<com.github.mcilloni.uplink.nano.UplinkProto.SessInfo>(ARG_OUT_METHOD_NEW_USER))
          );
  private static final int ARG_IN_METHOD_NOTIFICATIONS = 8;
  private static final int ARG_OUT_METHOD_NOTIFICATIONS = 9;
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<com.github.mcilloni.uplink.nano.UplinkProto.Empty,
      com.github.mcilloni.uplink.nano.UplinkProto.Notification> METHOD_NOTIFICATIONS =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING,
          generateFullMethodName(
              "protodef.Uplink", "Notifications"),
          io.grpc.protobuf.nano.NanoUtils.<com.github.mcilloni.uplink.nano.UplinkProto.Empty>marshaller(
              new NanoFactory<com.github.mcilloni.uplink.nano.UplinkProto.Empty>(ARG_IN_METHOD_NOTIFICATIONS)),
          io.grpc.protobuf.nano.NanoUtils.<com.github.mcilloni.uplink.nano.UplinkProto.Notification>marshaller(
              new NanoFactory<com.github.mcilloni.uplink.nano.UplinkProto.Notification>(ARG_OUT_METHOD_NOTIFICATIONS))
          );
  private static final int ARG_IN_METHOD_PING = 10;
  private static final int ARG_OUT_METHOD_PING = 11;
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<com.github.mcilloni.uplink.nano.UplinkProto.Empty,
      com.github.mcilloni.uplink.nano.UplinkProto.BoolResp> METHOD_PING =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "protodef.Uplink", "Ping"),
          io.grpc.protobuf.nano.NanoUtils.<com.github.mcilloni.uplink.nano.UplinkProto.Empty>marshaller(
              new NanoFactory<com.github.mcilloni.uplink.nano.UplinkProto.Empty>(ARG_IN_METHOD_PING)),
          io.grpc.protobuf.nano.NanoUtils.<com.github.mcilloni.uplink.nano.UplinkProto.BoolResp>marshaller(
              new NanoFactory<com.github.mcilloni.uplink.nano.UplinkProto.BoolResp>(ARG_OUT_METHOD_PING))
          );

  private static final class NanoFactory<T extends com.google.protobuf.nano.MessageNano>
      implements io.grpc.protobuf.nano.MessageNanoFactory<T> {
    private final int id;

    NanoFactory(int id) {
      this.id = id;
    }

    @java.lang.Override
    public T newInstance() {
      Object o;
      switch (id) {
      case ARG_IN_METHOD_EXISTS:
        o = new com.github.mcilloni.uplink.nano.UplinkProto.Username();
        break;
      case ARG_OUT_METHOD_EXISTS:
        o = new com.github.mcilloni.uplink.nano.UplinkProto.BoolResp();
        break;
      case ARG_IN_METHOD_FRIENDS:
        o = new com.github.mcilloni.uplink.nano.UplinkProto.Empty();
        break;
      case ARG_OUT_METHOD_FRIENDS:
        o = new com.github.mcilloni.uplink.nano.UplinkProto.FriendList();
        break;
      case ARG_IN_METHOD_LOGIN:
        o = new com.github.mcilloni.uplink.nano.UplinkProto.AuthInfo();
        break;
      case ARG_OUT_METHOD_LOGIN:
        o = new com.github.mcilloni.uplink.nano.UplinkProto.SessInfo();
        break;
      case ARG_IN_METHOD_NEW_USER:
        o = new com.github.mcilloni.uplink.nano.UplinkProto.AuthInfo();
        break;
      case ARG_OUT_METHOD_NEW_USER:
        o = new com.github.mcilloni.uplink.nano.UplinkProto.SessInfo();
        break;
      case ARG_IN_METHOD_NOTIFICATIONS:
        o = new com.github.mcilloni.uplink.nano.UplinkProto.Empty();
        break;
      case ARG_OUT_METHOD_NOTIFICATIONS:
        o = new com.github.mcilloni.uplink.nano.UplinkProto.Notification();
        break;
      case ARG_IN_METHOD_PING:
        o = new com.github.mcilloni.uplink.nano.UplinkProto.Empty();
        break;
      case ARG_OUT_METHOD_PING:
        o = new com.github.mcilloni.uplink.nano.UplinkProto.BoolResp();
        break;
      default:
        throw new AssertionError();
      }
      @java.lang.SuppressWarnings("unchecked")
      T t = (T) o;
      return t;
    }
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UplinkStub newStub(io.grpc.Channel channel) {
    return new UplinkStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UplinkBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new UplinkBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static UplinkFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new UplinkFutureStub(channel);
  }

  /**
   */
  public static interface Uplink {

    /**
     */
    public void exists(com.github.mcilloni.uplink.nano.UplinkProto.Username request,
        io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.BoolResp> responseObserver);

    /**
     */
    public void friends(com.github.mcilloni.uplink.nano.UplinkProto.Empty request,
        io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.FriendList> responseObserver);

    /**
     */
    public void login(com.github.mcilloni.uplink.nano.UplinkProto.AuthInfo request,
        io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.SessInfo> responseObserver);

    /**
     */
    public void newUser(com.github.mcilloni.uplink.nano.UplinkProto.AuthInfo request,
        io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.SessInfo> responseObserver);

    /**
     */
    public void notifications(com.github.mcilloni.uplink.nano.UplinkProto.Empty request,
        io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.Notification> responseObserver);

    /**
     */
    public void ping(com.github.mcilloni.uplink.nano.UplinkProto.Empty request,
        io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.BoolResp> responseObserver);
  }

  @io.grpc.ExperimentalApi
  public static abstract class AbstractUplink implements Uplink, io.grpc.BindableService {

    @java.lang.Override
    public void exists(com.github.mcilloni.uplink.nano.UplinkProto.Username request,
        io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.BoolResp> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_EXISTS, responseObserver);
    }

    @java.lang.Override
    public void friends(com.github.mcilloni.uplink.nano.UplinkProto.Empty request,
        io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.FriendList> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_FRIENDS, responseObserver);
    }

    @java.lang.Override
    public void login(com.github.mcilloni.uplink.nano.UplinkProto.AuthInfo request,
        io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.SessInfo> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_LOGIN, responseObserver);
    }

    @java.lang.Override
    public void newUser(com.github.mcilloni.uplink.nano.UplinkProto.AuthInfo request,
        io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.SessInfo> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_NEW_USER, responseObserver);
    }

    @java.lang.Override
    public void notifications(com.github.mcilloni.uplink.nano.UplinkProto.Empty request,
        io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.Notification> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_NOTIFICATIONS, responseObserver);
    }

    @java.lang.Override
    public void ping(com.github.mcilloni.uplink.nano.UplinkProto.Empty request,
        io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.BoolResp> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_PING, responseObserver);
    }

    @java.lang.Override public io.grpc.ServerServiceDefinition bindService() {
      return UplinkGrpc.bindService(this);
    }
  }

  /**
   */
  public static interface UplinkBlockingClient {

    /**
     */
    public com.github.mcilloni.uplink.nano.UplinkProto.BoolResp exists(com.github.mcilloni.uplink.nano.UplinkProto.Username request);

    /**
     */
    public com.github.mcilloni.uplink.nano.UplinkProto.FriendList friends(com.github.mcilloni.uplink.nano.UplinkProto.Empty request);

    /**
     */
    public com.github.mcilloni.uplink.nano.UplinkProto.SessInfo login(com.github.mcilloni.uplink.nano.UplinkProto.AuthInfo request);

    /**
     */
    public com.github.mcilloni.uplink.nano.UplinkProto.SessInfo newUser(com.github.mcilloni.uplink.nano.UplinkProto.AuthInfo request);

    /**
     */
    public java.util.Iterator<com.github.mcilloni.uplink.nano.UplinkProto.Notification> notifications(
        com.github.mcilloni.uplink.nano.UplinkProto.Empty request);

    /**
     */
    public com.github.mcilloni.uplink.nano.UplinkProto.BoolResp ping(com.github.mcilloni.uplink.nano.UplinkProto.Empty request);
  }

  /**
   */
  public static interface UplinkFutureClient {

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.github.mcilloni.uplink.nano.UplinkProto.BoolResp> exists(
        com.github.mcilloni.uplink.nano.UplinkProto.Username request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.github.mcilloni.uplink.nano.UplinkProto.FriendList> friends(
        com.github.mcilloni.uplink.nano.UplinkProto.Empty request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.github.mcilloni.uplink.nano.UplinkProto.SessInfo> login(
        com.github.mcilloni.uplink.nano.UplinkProto.AuthInfo request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.github.mcilloni.uplink.nano.UplinkProto.SessInfo> newUser(
        com.github.mcilloni.uplink.nano.UplinkProto.AuthInfo request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.github.mcilloni.uplink.nano.UplinkProto.BoolResp> ping(
        com.github.mcilloni.uplink.nano.UplinkProto.Empty request);
  }

  public static class UplinkStub extends io.grpc.stub.AbstractStub<UplinkStub>
      implements Uplink {
    private UplinkStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UplinkStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UplinkStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UplinkStub(channel, callOptions);
    }

    @java.lang.Override
    public void exists(com.github.mcilloni.uplink.nano.UplinkProto.Username request,
        io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.BoolResp> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_EXISTS, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void friends(com.github.mcilloni.uplink.nano.UplinkProto.Empty request,
        io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.FriendList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_FRIENDS, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void login(com.github.mcilloni.uplink.nano.UplinkProto.AuthInfo request,
        io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.SessInfo> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_LOGIN, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void newUser(com.github.mcilloni.uplink.nano.UplinkProto.AuthInfo request,
        io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.SessInfo> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_NEW_USER, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void notifications(com.github.mcilloni.uplink.nano.UplinkProto.Empty request,
        io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.Notification> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(METHOD_NOTIFICATIONS, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void ping(com.github.mcilloni.uplink.nano.UplinkProto.Empty request,
        io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.BoolResp> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_PING, getCallOptions()), request, responseObserver);
    }
  }

  public static class UplinkBlockingStub extends io.grpc.stub.AbstractStub<UplinkBlockingStub>
      implements UplinkBlockingClient {
    private UplinkBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UplinkBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UplinkBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UplinkBlockingStub(channel, callOptions);
    }

    @java.lang.Override
    public com.github.mcilloni.uplink.nano.UplinkProto.BoolResp exists(com.github.mcilloni.uplink.nano.UplinkProto.Username request) {
      return blockingUnaryCall(
          getChannel(), METHOD_EXISTS, getCallOptions(), request);
    }

    @java.lang.Override
    public com.github.mcilloni.uplink.nano.UplinkProto.FriendList friends(com.github.mcilloni.uplink.nano.UplinkProto.Empty request) {
      return blockingUnaryCall(
          getChannel(), METHOD_FRIENDS, getCallOptions(), request);
    }

    @java.lang.Override
    public com.github.mcilloni.uplink.nano.UplinkProto.SessInfo login(com.github.mcilloni.uplink.nano.UplinkProto.AuthInfo request) {
      return blockingUnaryCall(
          getChannel(), METHOD_LOGIN, getCallOptions(), request);
    }

    @java.lang.Override
    public com.github.mcilloni.uplink.nano.UplinkProto.SessInfo newUser(com.github.mcilloni.uplink.nano.UplinkProto.AuthInfo request) {
      return blockingUnaryCall(
          getChannel(), METHOD_NEW_USER, getCallOptions(), request);
    }

    @java.lang.Override
    public java.util.Iterator<com.github.mcilloni.uplink.nano.UplinkProto.Notification> notifications(
        com.github.mcilloni.uplink.nano.UplinkProto.Empty request) {
      return blockingServerStreamingCall(
          getChannel(), METHOD_NOTIFICATIONS, getCallOptions(), request);
    }

    @java.lang.Override
    public com.github.mcilloni.uplink.nano.UplinkProto.BoolResp ping(com.github.mcilloni.uplink.nano.UplinkProto.Empty request) {
      return blockingUnaryCall(
          getChannel(), METHOD_PING, getCallOptions(), request);
    }
  }

  public static class UplinkFutureStub extends io.grpc.stub.AbstractStub<UplinkFutureStub>
      implements UplinkFutureClient {
    private UplinkFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UplinkFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UplinkFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UplinkFutureStub(channel, callOptions);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.github.mcilloni.uplink.nano.UplinkProto.BoolResp> exists(
        com.github.mcilloni.uplink.nano.UplinkProto.Username request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_EXISTS, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.github.mcilloni.uplink.nano.UplinkProto.FriendList> friends(
        com.github.mcilloni.uplink.nano.UplinkProto.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_FRIENDS, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.github.mcilloni.uplink.nano.UplinkProto.SessInfo> login(
        com.github.mcilloni.uplink.nano.UplinkProto.AuthInfo request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_LOGIN, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.github.mcilloni.uplink.nano.UplinkProto.SessInfo> newUser(
        com.github.mcilloni.uplink.nano.UplinkProto.AuthInfo request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_NEW_USER, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.github.mcilloni.uplink.nano.UplinkProto.BoolResp> ping(
        com.github.mcilloni.uplink.nano.UplinkProto.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_PING, getCallOptions()), request);
    }
  }

  private static final int METHODID_EXISTS = 0;
  private static final int METHODID_FRIENDS = 1;
  private static final int METHODID_LOGIN = 2;
  private static final int METHODID_NEW_USER = 3;
  private static final int METHODID_NOTIFICATIONS = 4;
  private static final int METHODID_PING = 5;

  private static class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final Uplink serviceImpl;
    private final int methodId;

    public MethodHandlers(Uplink serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_EXISTS:
          serviceImpl.exists((com.github.mcilloni.uplink.nano.UplinkProto.Username) request,
              (io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.BoolResp>) responseObserver);
          break;
        case METHODID_FRIENDS:
          serviceImpl.friends((com.github.mcilloni.uplink.nano.UplinkProto.Empty) request,
              (io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.FriendList>) responseObserver);
          break;
        case METHODID_LOGIN:
          serviceImpl.login((com.github.mcilloni.uplink.nano.UplinkProto.AuthInfo) request,
              (io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.SessInfo>) responseObserver);
          break;
        case METHODID_NEW_USER:
          serviceImpl.newUser((com.github.mcilloni.uplink.nano.UplinkProto.AuthInfo) request,
              (io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.SessInfo>) responseObserver);
          break;
        case METHODID_NOTIFICATIONS:
          serviceImpl.notifications((com.github.mcilloni.uplink.nano.UplinkProto.Empty) request,
              (io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.Notification>) responseObserver);
          break;
        case METHODID_PING:
          serviceImpl.ping((com.github.mcilloni.uplink.nano.UplinkProto.Empty) request,
              (io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.BoolResp>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static io.grpc.ServerServiceDefinition bindService(
      final Uplink serviceImpl) {
    return io.grpc.ServerServiceDefinition.builder(SERVICE_NAME)
        .addMethod(
          METHOD_EXISTS,
          asyncUnaryCall(
            new MethodHandlers<
              com.github.mcilloni.uplink.nano.UplinkProto.Username,
              com.github.mcilloni.uplink.nano.UplinkProto.BoolResp>(
                serviceImpl, METHODID_EXISTS)))
        .addMethod(
          METHOD_FRIENDS,
          asyncUnaryCall(
            new MethodHandlers<
              com.github.mcilloni.uplink.nano.UplinkProto.Empty,
              com.github.mcilloni.uplink.nano.UplinkProto.FriendList>(
                serviceImpl, METHODID_FRIENDS)))
        .addMethod(
          METHOD_LOGIN,
          asyncUnaryCall(
            new MethodHandlers<
              com.github.mcilloni.uplink.nano.UplinkProto.AuthInfo,
              com.github.mcilloni.uplink.nano.UplinkProto.SessInfo>(
                serviceImpl, METHODID_LOGIN)))
        .addMethod(
          METHOD_NEW_USER,
          asyncUnaryCall(
            new MethodHandlers<
              com.github.mcilloni.uplink.nano.UplinkProto.AuthInfo,
              com.github.mcilloni.uplink.nano.UplinkProto.SessInfo>(
                serviceImpl, METHODID_NEW_USER)))
        .addMethod(
          METHOD_NOTIFICATIONS,
          asyncServerStreamingCall(
            new MethodHandlers<
              com.github.mcilloni.uplink.nano.UplinkProto.Empty,
              com.github.mcilloni.uplink.nano.UplinkProto.Notification>(
                serviceImpl, METHODID_NOTIFICATIONS)))
        .addMethod(
          METHOD_PING,
          asyncUnaryCall(
            new MethodHandlers<
              com.github.mcilloni.uplink.nano.UplinkProto.Empty,
              com.github.mcilloni.uplink.nano.UplinkProto.BoolResp>(
                serviceImpl, METHODID_PING)))
        .build();
  }
}
