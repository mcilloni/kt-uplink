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
  private static final int ARG_IN_METHOD_ACCEPT_FRIENDSHIP = 0;
  private static final int ARG_OUT_METHOD_ACCEPT_FRIENDSHIP = 1;
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<com.github.mcilloni.uplink.nano.UplinkProto.Name,
      com.github.mcilloni.uplink.nano.UplinkProto.BoolResp> METHOD_ACCEPT_FRIENDSHIP =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "protodef.Uplink", "AcceptFriendship"),
          io.grpc.protobuf.nano.NanoUtils.<com.github.mcilloni.uplink.nano.UplinkProto.Name>marshaller(
              new NanoFactory<com.github.mcilloni.uplink.nano.UplinkProto.Name>(ARG_IN_METHOD_ACCEPT_FRIENDSHIP)),
          io.grpc.protobuf.nano.NanoUtils.<com.github.mcilloni.uplink.nano.UplinkProto.BoolResp>marshaller(
              new NanoFactory<com.github.mcilloni.uplink.nano.UplinkProto.BoolResp>(ARG_OUT_METHOD_ACCEPT_FRIENDSHIP))
          );
  private static final int ARG_IN_METHOD_ACCEPT_INVITE = 2;
  private static final int ARG_OUT_METHOD_ACCEPT_INVITE = 3;
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<com.github.mcilloni.uplink.nano.UplinkProto.ID,
      com.github.mcilloni.uplink.nano.UplinkProto.BoolResp> METHOD_ACCEPT_INVITE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "protodef.Uplink", "AcceptInvite"),
          io.grpc.protobuf.nano.NanoUtils.<com.github.mcilloni.uplink.nano.UplinkProto.ID>marshaller(
              new NanoFactory<com.github.mcilloni.uplink.nano.UplinkProto.ID>(ARG_IN_METHOD_ACCEPT_INVITE)),
          io.grpc.protobuf.nano.NanoUtils.<com.github.mcilloni.uplink.nano.UplinkProto.BoolResp>marshaller(
              new NanoFactory<com.github.mcilloni.uplink.nano.UplinkProto.BoolResp>(ARG_OUT_METHOD_ACCEPT_INVITE))
          );
  private static final int ARG_IN_METHOD_CONVERSATIONS = 4;
  private static final int ARG_OUT_METHOD_CONVERSATIONS = 5;
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<com.github.mcilloni.uplink.nano.UplinkProto.Empty,
      com.github.mcilloni.uplink.nano.UplinkProto.ConversationList> METHOD_CONVERSATIONS =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "protodef.Uplink", "Conversations"),
          io.grpc.protobuf.nano.NanoUtils.<com.github.mcilloni.uplink.nano.UplinkProto.Empty>marshaller(
              new NanoFactory<com.github.mcilloni.uplink.nano.UplinkProto.Empty>(ARG_IN_METHOD_CONVERSATIONS)),
          io.grpc.protobuf.nano.NanoUtils.<com.github.mcilloni.uplink.nano.UplinkProto.ConversationList>marshaller(
              new NanoFactory<com.github.mcilloni.uplink.nano.UplinkProto.ConversationList>(ARG_OUT_METHOD_CONVERSATIONS))
          );
  private static final int ARG_IN_METHOD_EXISTS = 6;
  private static final int ARG_OUT_METHOD_EXISTS = 7;
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<com.github.mcilloni.uplink.nano.UplinkProto.Name,
      com.github.mcilloni.uplink.nano.UplinkProto.BoolResp> METHOD_EXISTS =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "protodef.Uplink", "Exists"),
          io.grpc.protobuf.nano.NanoUtils.<com.github.mcilloni.uplink.nano.UplinkProto.Name>marshaller(
              new NanoFactory<com.github.mcilloni.uplink.nano.UplinkProto.Name>(ARG_IN_METHOD_EXISTS)),
          io.grpc.protobuf.nano.NanoUtils.<com.github.mcilloni.uplink.nano.UplinkProto.BoolResp>marshaller(
              new NanoFactory<com.github.mcilloni.uplink.nano.UplinkProto.BoolResp>(ARG_OUT_METHOD_EXISTS))
          );
  private static final int ARG_IN_METHOD_FRIENDS = 8;
  private static final int ARG_OUT_METHOD_FRIENDS = 9;
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
  private static final int ARG_IN_METHOD_INVITES = 10;
  private static final int ARG_OUT_METHOD_INVITES = 11;
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<com.github.mcilloni.uplink.nano.UplinkProto.Empty,
      com.github.mcilloni.uplink.nano.UplinkProto.InviteList> METHOD_INVITES =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "protodef.Uplink", "Invites"),
          io.grpc.protobuf.nano.NanoUtils.<com.github.mcilloni.uplink.nano.UplinkProto.Empty>marshaller(
              new NanoFactory<com.github.mcilloni.uplink.nano.UplinkProto.Empty>(ARG_IN_METHOD_INVITES)),
          io.grpc.protobuf.nano.NanoUtils.<com.github.mcilloni.uplink.nano.UplinkProto.InviteList>marshaller(
              new NanoFactory<com.github.mcilloni.uplink.nano.UplinkProto.InviteList>(ARG_OUT_METHOD_INVITES))
          );
  private static final int ARG_IN_METHOD_LOGIN = 12;
  private static final int ARG_OUT_METHOD_LOGIN = 13;
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
  private static final int ARG_IN_METHOD_MESSAGES = 14;
  private static final int ARG_OUT_METHOD_MESSAGES = 15;
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<com.github.mcilloni.uplink.nano.UplinkProto.FetchOpts,
      com.github.mcilloni.uplink.nano.UplinkProto.MessageList> METHOD_MESSAGES =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "protodef.Uplink", "Messages"),
          io.grpc.protobuf.nano.NanoUtils.<com.github.mcilloni.uplink.nano.UplinkProto.FetchOpts>marshaller(
              new NanoFactory<com.github.mcilloni.uplink.nano.UplinkProto.FetchOpts>(ARG_IN_METHOD_MESSAGES)),
          io.grpc.protobuf.nano.NanoUtils.<com.github.mcilloni.uplink.nano.UplinkProto.MessageList>marshaller(
              new NanoFactory<com.github.mcilloni.uplink.nano.UplinkProto.MessageList>(ARG_OUT_METHOD_MESSAGES))
          );
  private static final int ARG_IN_METHOD_NEW_CONVERSATION = 16;
  private static final int ARG_OUT_METHOD_NEW_CONVERSATION = 17;
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<com.github.mcilloni.uplink.nano.UplinkProto.Name,
      com.github.mcilloni.uplink.nano.UplinkProto.ID> METHOD_NEW_CONVERSATION =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "protodef.Uplink", "NewConversation"),
          io.grpc.protobuf.nano.NanoUtils.<com.github.mcilloni.uplink.nano.UplinkProto.Name>marshaller(
              new NanoFactory<com.github.mcilloni.uplink.nano.UplinkProto.Name>(ARG_IN_METHOD_NEW_CONVERSATION)),
          io.grpc.protobuf.nano.NanoUtils.<com.github.mcilloni.uplink.nano.UplinkProto.ID>marshaller(
              new NanoFactory<com.github.mcilloni.uplink.nano.UplinkProto.ID>(ARG_OUT_METHOD_NEW_CONVERSATION))
          );
  private static final int ARG_IN_METHOD_NEW_USER = 18;
  private static final int ARG_OUT_METHOD_NEW_USER = 19;
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
  private static final int ARG_IN_METHOD_NOTIFICATIONS = 20;
  private static final int ARG_OUT_METHOD_NOTIFICATIONS = 21;
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
  private static final int ARG_IN_METHOD_PING = 22;
  private static final int ARG_OUT_METHOD_PING = 23;
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
  private static final int ARG_IN_METHOD_RECEIVED_REQUESTS = 24;
  private static final int ARG_OUT_METHOD_RECEIVED_REQUESTS = 25;
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<com.github.mcilloni.uplink.nano.UplinkProto.Empty,
      com.github.mcilloni.uplink.nano.UplinkProto.FriendList> METHOD_RECEIVED_REQUESTS =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "protodef.Uplink", "ReceivedRequests"),
          io.grpc.protobuf.nano.NanoUtils.<com.github.mcilloni.uplink.nano.UplinkProto.Empty>marshaller(
              new NanoFactory<com.github.mcilloni.uplink.nano.UplinkProto.Empty>(ARG_IN_METHOD_RECEIVED_REQUESTS)),
          io.grpc.protobuf.nano.NanoUtils.<com.github.mcilloni.uplink.nano.UplinkProto.FriendList>marshaller(
              new NanoFactory<com.github.mcilloni.uplink.nano.UplinkProto.FriendList>(ARG_OUT_METHOD_RECEIVED_REQUESTS))
          );
  private static final int ARG_IN_METHOD_REQUEST_FRIENDSHIP = 26;
  private static final int ARG_OUT_METHOD_REQUEST_FRIENDSHIP = 27;
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<com.github.mcilloni.uplink.nano.UplinkProto.Name,
      com.github.mcilloni.uplink.nano.UplinkProto.BoolResp> METHOD_REQUEST_FRIENDSHIP =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "protodef.Uplink", "RequestFriendship"),
          io.grpc.protobuf.nano.NanoUtils.<com.github.mcilloni.uplink.nano.UplinkProto.Name>marshaller(
              new NanoFactory<com.github.mcilloni.uplink.nano.UplinkProto.Name>(ARG_IN_METHOD_REQUEST_FRIENDSHIP)),
          io.grpc.protobuf.nano.NanoUtils.<com.github.mcilloni.uplink.nano.UplinkProto.BoolResp>marshaller(
              new NanoFactory<com.github.mcilloni.uplink.nano.UplinkProto.BoolResp>(ARG_OUT_METHOD_REQUEST_FRIENDSHIP))
          );
  private static final int ARG_IN_METHOD_SEND_INVITE = 28;
  private static final int ARG_OUT_METHOD_SEND_INVITE = 29;
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<com.github.mcilloni.uplink.nano.UplinkProto.Invite,
      com.github.mcilloni.uplink.nano.UplinkProto.BoolResp> METHOD_SEND_INVITE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "protodef.Uplink", "SendInvite"),
          io.grpc.protobuf.nano.NanoUtils.<com.github.mcilloni.uplink.nano.UplinkProto.Invite>marshaller(
              new NanoFactory<com.github.mcilloni.uplink.nano.UplinkProto.Invite>(ARG_IN_METHOD_SEND_INVITE)),
          io.grpc.protobuf.nano.NanoUtils.<com.github.mcilloni.uplink.nano.UplinkProto.BoolResp>marshaller(
              new NanoFactory<com.github.mcilloni.uplink.nano.UplinkProto.BoolResp>(ARG_OUT_METHOD_SEND_INVITE))
          );
  private static final int ARG_IN_METHOD_SEND_MESSAGE = 30;
  private static final int ARG_OUT_METHOD_SEND_MESSAGE = 31;
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<com.github.mcilloni.uplink.nano.UplinkProto.NewMsgReq,
      com.github.mcilloni.uplink.nano.UplinkProto.NewMsgResp> METHOD_SEND_MESSAGE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "protodef.Uplink", "SendMessage"),
          io.grpc.protobuf.nano.NanoUtils.<com.github.mcilloni.uplink.nano.UplinkProto.NewMsgReq>marshaller(
              new NanoFactory<com.github.mcilloni.uplink.nano.UplinkProto.NewMsgReq>(ARG_IN_METHOD_SEND_MESSAGE)),
          io.grpc.protobuf.nano.NanoUtils.<com.github.mcilloni.uplink.nano.UplinkProto.NewMsgResp>marshaller(
              new NanoFactory<com.github.mcilloni.uplink.nano.UplinkProto.NewMsgResp>(ARG_OUT_METHOD_SEND_MESSAGE))
          );
  private static final int ARG_IN_METHOD_SENT_REQUESTS = 32;
  private static final int ARG_OUT_METHOD_SENT_REQUESTS = 33;
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<com.github.mcilloni.uplink.nano.UplinkProto.Empty,
      com.github.mcilloni.uplink.nano.UplinkProto.FriendList> METHOD_SENT_REQUESTS =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "protodef.Uplink", "SentRequests"),
          io.grpc.protobuf.nano.NanoUtils.<com.github.mcilloni.uplink.nano.UplinkProto.Empty>marshaller(
              new NanoFactory<com.github.mcilloni.uplink.nano.UplinkProto.Empty>(ARG_IN_METHOD_SENT_REQUESTS)),
          io.grpc.protobuf.nano.NanoUtils.<com.github.mcilloni.uplink.nano.UplinkProto.FriendList>marshaller(
              new NanoFactory<com.github.mcilloni.uplink.nano.UplinkProto.FriendList>(ARG_OUT_METHOD_SENT_REQUESTS))
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
      case ARG_IN_METHOD_ACCEPT_FRIENDSHIP:
        o = new com.github.mcilloni.uplink.nano.UplinkProto.Name();
        break;
      case ARG_OUT_METHOD_ACCEPT_FRIENDSHIP:
        o = new com.github.mcilloni.uplink.nano.UplinkProto.BoolResp();
        break;
      case ARG_IN_METHOD_ACCEPT_INVITE:
        o = new com.github.mcilloni.uplink.nano.UplinkProto.ID();
        break;
      case ARG_OUT_METHOD_ACCEPT_INVITE:
        o = new com.github.mcilloni.uplink.nano.UplinkProto.BoolResp();
        break;
      case ARG_IN_METHOD_CONVERSATIONS:
        o = new com.github.mcilloni.uplink.nano.UplinkProto.Empty();
        break;
      case ARG_OUT_METHOD_CONVERSATIONS:
        o = new com.github.mcilloni.uplink.nano.UplinkProto.ConversationList();
        break;
      case ARG_IN_METHOD_EXISTS:
        o = new com.github.mcilloni.uplink.nano.UplinkProto.Name();
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
      case ARG_IN_METHOD_INVITES:
        o = new com.github.mcilloni.uplink.nano.UplinkProto.Empty();
        break;
      case ARG_OUT_METHOD_INVITES:
        o = new com.github.mcilloni.uplink.nano.UplinkProto.InviteList();
        break;
      case ARG_IN_METHOD_LOGIN:
        o = new com.github.mcilloni.uplink.nano.UplinkProto.AuthInfo();
        break;
      case ARG_OUT_METHOD_LOGIN:
        o = new com.github.mcilloni.uplink.nano.UplinkProto.SessInfo();
        break;
      case ARG_IN_METHOD_MESSAGES:
        o = new com.github.mcilloni.uplink.nano.UplinkProto.FetchOpts();
        break;
      case ARG_OUT_METHOD_MESSAGES:
        o = new com.github.mcilloni.uplink.nano.UplinkProto.MessageList();
        break;
      case ARG_IN_METHOD_NEW_CONVERSATION:
        o = new com.github.mcilloni.uplink.nano.UplinkProto.Name();
        break;
      case ARG_OUT_METHOD_NEW_CONVERSATION:
        o = new com.github.mcilloni.uplink.nano.UplinkProto.ID();
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
      case ARG_IN_METHOD_RECEIVED_REQUESTS:
        o = new com.github.mcilloni.uplink.nano.UplinkProto.Empty();
        break;
      case ARG_OUT_METHOD_RECEIVED_REQUESTS:
        o = new com.github.mcilloni.uplink.nano.UplinkProto.FriendList();
        break;
      case ARG_IN_METHOD_REQUEST_FRIENDSHIP:
        o = new com.github.mcilloni.uplink.nano.UplinkProto.Name();
        break;
      case ARG_OUT_METHOD_REQUEST_FRIENDSHIP:
        o = new com.github.mcilloni.uplink.nano.UplinkProto.BoolResp();
        break;
      case ARG_IN_METHOD_SEND_INVITE:
        o = new com.github.mcilloni.uplink.nano.UplinkProto.Invite();
        break;
      case ARG_OUT_METHOD_SEND_INVITE:
        o = new com.github.mcilloni.uplink.nano.UplinkProto.BoolResp();
        break;
      case ARG_IN_METHOD_SEND_MESSAGE:
        o = new com.github.mcilloni.uplink.nano.UplinkProto.NewMsgReq();
        break;
      case ARG_OUT_METHOD_SEND_MESSAGE:
        o = new com.github.mcilloni.uplink.nano.UplinkProto.NewMsgResp();
        break;
      case ARG_IN_METHOD_SENT_REQUESTS:
        o = new com.github.mcilloni.uplink.nano.UplinkProto.Empty();
        break;
      case ARG_OUT_METHOD_SENT_REQUESTS:
        o = new com.github.mcilloni.uplink.nano.UplinkProto.FriendList();
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
    public void acceptFriendship(com.github.mcilloni.uplink.nano.UplinkProto.Name request,
        io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.BoolResp> responseObserver);

    /**
     */
    public void acceptInvite(com.github.mcilloni.uplink.nano.UplinkProto.ID request,
        io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.BoolResp> responseObserver);

    /**
     */
    public void conversations(com.github.mcilloni.uplink.nano.UplinkProto.Empty request,
        io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.ConversationList> responseObserver);

    /**
     */
    public void exists(com.github.mcilloni.uplink.nano.UplinkProto.Name request,
        io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.BoolResp> responseObserver);

    /**
     */
    public void friends(com.github.mcilloni.uplink.nano.UplinkProto.Empty request,
        io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.FriendList> responseObserver);

    /**
     */
    public void invites(com.github.mcilloni.uplink.nano.UplinkProto.Empty request,
        io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.InviteList> responseObserver);

    /**
     */
    public void login(com.github.mcilloni.uplink.nano.UplinkProto.AuthInfo request,
        io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.SessInfo> responseObserver);

    /**
     */
    public void messages(com.github.mcilloni.uplink.nano.UplinkProto.FetchOpts request,
        io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.MessageList> responseObserver);

    /**
     */
    public void newConversation(com.github.mcilloni.uplink.nano.UplinkProto.Name request,
        io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.ID> responseObserver);

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

    /**
     */
    public void receivedRequests(com.github.mcilloni.uplink.nano.UplinkProto.Empty request,
        io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.FriendList> responseObserver);

    /**
     */
    public void requestFriendship(com.github.mcilloni.uplink.nano.UplinkProto.Name request,
        io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.BoolResp> responseObserver);

    /**
     */
    public void sendInvite(com.github.mcilloni.uplink.nano.UplinkProto.Invite request,
        io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.BoolResp> responseObserver);

    /**
     */
    public void sendMessage(com.github.mcilloni.uplink.nano.UplinkProto.NewMsgReq request,
        io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.NewMsgResp> responseObserver);

    /**
     */
    public void sentRequests(com.github.mcilloni.uplink.nano.UplinkProto.Empty request,
        io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.FriendList> responseObserver);
  }

  @io.grpc.ExperimentalApi
  public static abstract class AbstractUplink implements Uplink, io.grpc.BindableService {

    @java.lang.Override
    public void acceptFriendship(com.github.mcilloni.uplink.nano.UplinkProto.Name request,
        io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.BoolResp> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ACCEPT_FRIENDSHIP, responseObserver);
    }

    @java.lang.Override
    public void acceptInvite(com.github.mcilloni.uplink.nano.UplinkProto.ID request,
        io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.BoolResp> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ACCEPT_INVITE, responseObserver);
    }

    @java.lang.Override
    public void conversations(com.github.mcilloni.uplink.nano.UplinkProto.Empty request,
        io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.ConversationList> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CONVERSATIONS, responseObserver);
    }

    @java.lang.Override
    public void exists(com.github.mcilloni.uplink.nano.UplinkProto.Name request,
        io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.BoolResp> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_EXISTS, responseObserver);
    }

    @java.lang.Override
    public void friends(com.github.mcilloni.uplink.nano.UplinkProto.Empty request,
        io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.FriendList> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_FRIENDS, responseObserver);
    }

    @java.lang.Override
    public void invites(com.github.mcilloni.uplink.nano.UplinkProto.Empty request,
        io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.InviteList> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_INVITES, responseObserver);
    }

    @java.lang.Override
    public void login(com.github.mcilloni.uplink.nano.UplinkProto.AuthInfo request,
        io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.SessInfo> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_LOGIN, responseObserver);
    }

    @java.lang.Override
    public void messages(com.github.mcilloni.uplink.nano.UplinkProto.FetchOpts request,
        io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.MessageList> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_MESSAGES, responseObserver);
    }

    @java.lang.Override
    public void newConversation(com.github.mcilloni.uplink.nano.UplinkProto.Name request,
        io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.ID> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_NEW_CONVERSATION, responseObserver);
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

    @java.lang.Override
    public void receivedRequests(com.github.mcilloni.uplink.nano.UplinkProto.Empty request,
        io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.FriendList> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_RECEIVED_REQUESTS, responseObserver);
    }

    @java.lang.Override
    public void requestFriendship(com.github.mcilloni.uplink.nano.UplinkProto.Name request,
        io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.BoolResp> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_REQUEST_FRIENDSHIP, responseObserver);
    }

    @java.lang.Override
    public void sendInvite(com.github.mcilloni.uplink.nano.UplinkProto.Invite request,
        io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.BoolResp> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SEND_INVITE, responseObserver);
    }

    @java.lang.Override
    public void sendMessage(com.github.mcilloni.uplink.nano.UplinkProto.NewMsgReq request,
        io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.NewMsgResp> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SEND_MESSAGE, responseObserver);
    }

    @java.lang.Override
    public void sentRequests(com.github.mcilloni.uplink.nano.UplinkProto.Empty request,
        io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.FriendList> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SENT_REQUESTS, responseObserver);
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
    public com.github.mcilloni.uplink.nano.UplinkProto.BoolResp acceptFriendship(com.github.mcilloni.uplink.nano.UplinkProto.Name request);

    /**
     */
    public com.github.mcilloni.uplink.nano.UplinkProto.BoolResp acceptInvite(com.github.mcilloni.uplink.nano.UplinkProto.ID request);

    /**
     */
    public com.github.mcilloni.uplink.nano.UplinkProto.ConversationList conversations(com.github.mcilloni.uplink.nano.UplinkProto.Empty request);

    /**
     */
    public com.github.mcilloni.uplink.nano.UplinkProto.BoolResp exists(com.github.mcilloni.uplink.nano.UplinkProto.Name request);

    /**
     */
    public com.github.mcilloni.uplink.nano.UplinkProto.FriendList friends(com.github.mcilloni.uplink.nano.UplinkProto.Empty request);

    /**
     */
    public com.github.mcilloni.uplink.nano.UplinkProto.InviteList invites(com.github.mcilloni.uplink.nano.UplinkProto.Empty request);

    /**
     */
    public com.github.mcilloni.uplink.nano.UplinkProto.SessInfo login(com.github.mcilloni.uplink.nano.UplinkProto.AuthInfo request);

    /**
     */
    public com.github.mcilloni.uplink.nano.UplinkProto.MessageList messages(com.github.mcilloni.uplink.nano.UplinkProto.FetchOpts request);

    /**
     */
    public com.github.mcilloni.uplink.nano.UplinkProto.ID newConversation(com.github.mcilloni.uplink.nano.UplinkProto.Name request);

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

    /**
     */
    public com.github.mcilloni.uplink.nano.UplinkProto.FriendList receivedRequests(com.github.mcilloni.uplink.nano.UplinkProto.Empty request);

    /**
     */
    public com.github.mcilloni.uplink.nano.UplinkProto.BoolResp requestFriendship(com.github.mcilloni.uplink.nano.UplinkProto.Name request);

    /**
     */
    public com.github.mcilloni.uplink.nano.UplinkProto.BoolResp sendInvite(com.github.mcilloni.uplink.nano.UplinkProto.Invite request);

    /**
     */
    public com.github.mcilloni.uplink.nano.UplinkProto.NewMsgResp sendMessage(com.github.mcilloni.uplink.nano.UplinkProto.NewMsgReq request);

    /**
     */
    public com.github.mcilloni.uplink.nano.UplinkProto.FriendList sentRequests(com.github.mcilloni.uplink.nano.UplinkProto.Empty request);
  }

  /**
   */
  public static interface UplinkFutureClient {

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.github.mcilloni.uplink.nano.UplinkProto.BoolResp> acceptFriendship(
        com.github.mcilloni.uplink.nano.UplinkProto.Name request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.github.mcilloni.uplink.nano.UplinkProto.BoolResp> acceptInvite(
        com.github.mcilloni.uplink.nano.UplinkProto.ID request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.github.mcilloni.uplink.nano.UplinkProto.ConversationList> conversations(
        com.github.mcilloni.uplink.nano.UplinkProto.Empty request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.github.mcilloni.uplink.nano.UplinkProto.BoolResp> exists(
        com.github.mcilloni.uplink.nano.UplinkProto.Name request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.github.mcilloni.uplink.nano.UplinkProto.FriendList> friends(
        com.github.mcilloni.uplink.nano.UplinkProto.Empty request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.github.mcilloni.uplink.nano.UplinkProto.InviteList> invites(
        com.github.mcilloni.uplink.nano.UplinkProto.Empty request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.github.mcilloni.uplink.nano.UplinkProto.SessInfo> login(
        com.github.mcilloni.uplink.nano.UplinkProto.AuthInfo request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.github.mcilloni.uplink.nano.UplinkProto.MessageList> messages(
        com.github.mcilloni.uplink.nano.UplinkProto.FetchOpts request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.github.mcilloni.uplink.nano.UplinkProto.ID> newConversation(
        com.github.mcilloni.uplink.nano.UplinkProto.Name request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.github.mcilloni.uplink.nano.UplinkProto.SessInfo> newUser(
        com.github.mcilloni.uplink.nano.UplinkProto.AuthInfo request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.github.mcilloni.uplink.nano.UplinkProto.BoolResp> ping(
        com.github.mcilloni.uplink.nano.UplinkProto.Empty request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.github.mcilloni.uplink.nano.UplinkProto.FriendList> receivedRequests(
        com.github.mcilloni.uplink.nano.UplinkProto.Empty request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.github.mcilloni.uplink.nano.UplinkProto.BoolResp> requestFriendship(
        com.github.mcilloni.uplink.nano.UplinkProto.Name request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.github.mcilloni.uplink.nano.UplinkProto.BoolResp> sendInvite(
        com.github.mcilloni.uplink.nano.UplinkProto.Invite request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.github.mcilloni.uplink.nano.UplinkProto.NewMsgResp> sendMessage(
        com.github.mcilloni.uplink.nano.UplinkProto.NewMsgReq request);

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.github.mcilloni.uplink.nano.UplinkProto.FriendList> sentRequests(
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
    public void acceptFriendship(com.github.mcilloni.uplink.nano.UplinkProto.Name request,
        io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.BoolResp> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ACCEPT_FRIENDSHIP, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void acceptInvite(com.github.mcilloni.uplink.nano.UplinkProto.ID request,
        io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.BoolResp> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ACCEPT_INVITE, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void conversations(com.github.mcilloni.uplink.nano.UplinkProto.Empty request,
        io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.ConversationList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CONVERSATIONS, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void exists(com.github.mcilloni.uplink.nano.UplinkProto.Name request,
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
    public void invites(com.github.mcilloni.uplink.nano.UplinkProto.Empty request,
        io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.InviteList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_INVITES, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void login(com.github.mcilloni.uplink.nano.UplinkProto.AuthInfo request,
        io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.SessInfo> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_LOGIN, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void messages(com.github.mcilloni.uplink.nano.UplinkProto.FetchOpts request,
        io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.MessageList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_MESSAGES, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void newConversation(com.github.mcilloni.uplink.nano.UplinkProto.Name request,
        io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.ID> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_NEW_CONVERSATION, getCallOptions()), request, responseObserver);
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

    @java.lang.Override
    public void receivedRequests(com.github.mcilloni.uplink.nano.UplinkProto.Empty request,
        io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.FriendList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_RECEIVED_REQUESTS, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void requestFriendship(com.github.mcilloni.uplink.nano.UplinkProto.Name request,
        io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.BoolResp> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_REQUEST_FRIENDSHIP, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void sendInvite(com.github.mcilloni.uplink.nano.UplinkProto.Invite request,
        io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.BoolResp> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SEND_INVITE, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void sendMessage(com.github.mcilloni.uplink.nano.UplinkProto.NewMsgReq request,
        io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.NewMsgResp> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SEND_MESSAGE, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void sentRequests(com.github.mcilloni.uplink.nano.UplinkProto.Empty request,
        io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.FriendList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SENT_REQUESTS, getCallOptions()), request, responseObserver);
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
    public com.github.mcilloni.uplink.nano.UplinkProto.BoolResp acceptFriendship(com.github.mcilloni.uplink.nano.UplinkProto.Name request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ACCEPT_FRIENDSHIP, getCallOptions(), request);
    }

    @java.lang.Override
    public com.github.mcilloni.uplink.nano.UplinkProto.BoolResp acceptInvite(com.github.mcilloni.uplink.nano.UplinkProto.ID request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ACCEPT_INVITE, getCallOptions(), request);
    }

    @java.lang.Override
    public com.github.mcilloni.uplink.nano.UplinkProto.ConversationList conversations(com.github.mcilloni.uplink.nano.UplinkProto.Empty request) {
      return blockingUnaryCall(
          getChannel(), METHOD_CONVERSATIONS, getCallOptions(), request);
    }

    @java.lang.Override
    public com.github.mcilloni.uplink.nano.UplinkProto.BoolResp exists(com.github.mcilloni.uplink.nano.UplinkProto.Name request) {
      return blockingUnaryCall(
          getChannel(), METHOD_EXISTS, getCallOptions(), request);
    }

    @java.lang.Override
    public com.github.mcilloni.uplink.nano.UplinkProto.FriendList friends(com.github.mcilloni.uplink.nano.UplinkProto.Empty request) {
      return blockingUnaryCall(
          getChannel(), METHOD_FRIENDS, getCallOptions(), request);
    }

    @java.lang.Override
    public com.github.mcilloni.uplink.nano.UplinkProto.InviteList invites(com.github.mcilloni.uplink.nano.UplinkProto.Empty request) {
      return blockingUnaryCall(
          getChannel(), METHOD_INVITES, getCallOptions(), request);
    }

    @java.lang.Override
    public com.github.mcilloni.uplink.nano.UplinkProto.SessInfo login(com.github.mcilloni.uplink.nano.UplinkProto.AuthInfo request) {
      return blockingUnaryCall(
          getChannel(), METHOD_LOGIN, getCallOptions(), request);
    }

    @java.lang.Override
    public com.github.mcilloni.uplink.nano.UplinkProto.MessageList messages(com.github.mcilloni.uplink.nano.UplinkProto.FetchOpts request) {
      return blockingUnaryCall(
          getChannel(), METHOD_MESSAGES, getCallOptions(), request);
    }

    @java.lang.Override
    public com.github.mcilloni.uplink.nano.UplinkProto.ID newConversation(com.github.mcilloni.uplink.nano.UplinkProto.Name request) {
      return blockingUnaryCall(
          getChannel(), METHOD_NEW_CONVERSATION, getCallOptions(), request);
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

    @java.lang.Override
    public com.github.mcilloni.uplink.nano.UplinkProto.FriendList receivedRequests(com.github.mcilloni.uplink.nano.UplinkProto.Empty request) {
      return blockingUnaryCall(
          getChannel(), METHOD_RECEIVED_REQUESTS, getCallOptions(), request);
    }

    @java.lang.Override
    public com.github.mcilloni.uplink.nano.UplinkProto.BoolResp requestFriendship(com.github.mcilloni.uplink.nano.UplinkProto.Name request) {
      return blockingUnaryCall(
          getChannel(), METHOD_REQUEST_FRIENDSHIP, getCallOptions(), request);
    }

    @java.lang.Override
    public com.github.mcilloni.uplink.nano.UplinkProto.BoolResp sendInvite(com.github.mcilloni.uplink.nano.UplinkProto.Invite request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SEND_INVITE, getCallOptions(), request);
    }

    @java.lang.Override
    public com.github.mcilloni.uplink.nano.UplinkProto.NewMsgResp sendMessage(com.github.mcilloni.uplink.nano.UplinkProto.NewMsgReq request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SEND_MESSAGE, getCallOptions(), request);
    }

    @java.lang.Override
    public com.github.mcilloni.uplink.nano.UplinkProto.FriendList sentRequests(com.github.mcilloni.uplink.nano.UplinkProto.Empty request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SENT_REQUESTS, getCallOptions(), request);
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
    public com.google.common.util.concurrent.ListenableFuture<com.github.mcilloni.uplink.nano.UplinkProto.BoolResp> acceptFriendship(
        com.github.mcilloni.uplink.nano.UplinkProto.Name request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ACCEPT_FRIENDSHIP, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.github.mcilloni.uplink.nano.UplinkProto.BoolResp> acceptInvite(
        com.github.mcilloni.uplink.nano.UplinkProto.ID request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ACCEPT_INVITE, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.github.mcilloni.uplink.nano.UplinkProto.ConversationList> conversations(
        com.github.mcilloni.uplink.nano.UplinkProto.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CONVERSATIONS, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.github.mcilloni.uplink.nano.UplinkProto.BoolResp> exists(
        com.github.mcilloni.uplink.nano.UplinkProto.Name request) {
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
    public com.google.common.util.concurrent.ListenableFuture<com.github.mcilloni.uplink.nano.UplinkProto.InviteList> invites(
        com.github.mcilloni.uplink.nano.UplinkProto.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_INVITES, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.github.mcilloni.uplink.nano.UplinkProto.SessInfo> login(
        com.github.mcilloni.uplink.nano.UplinkProto.AuthInfo request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_LOGIN, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.github.mcilloni.uplink.nano.UplinkProto.MessageList> messages(
        com.github.mcilloni.uplink.nano.UplinkProto.FetchOpts request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_MESSAGES, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.github.mcilloni.uplink.nano.UplinkProto.ID> newConversation(
        com.github.mcilloni.uplink.nano.UplinkProto.Name request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_NEW_CONVERSATION, getCallOptions()), request);
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

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.github.mcilloni.uplink.nano.UplinkProto.FriendList> receivedRequests(
        com.github.mcilloni.uplink.nano.UplinkProto.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_RECEIVED_REQUESTS, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.github.mcilloni.uplink.nano.UplinkProto.BoolResp> requestFriendship(
        com.github.mcilloni.uplink.nano.UplinkProto.Name request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_REQUEST_FRIENDSHIP, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.github.mcilloni.uplink.nano.UplinkProto.BoolResp> sendInvite(
        com.github.mcilloni.uplink.nano.UplinkProto.Invite request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SEND_INVITE, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.github.mcilloni.uplink.nano.UplinkProto.NewMsgResp> sendMessage(
        com.github.mcilloni.uplink.nano.UplinkProto.NewMsgReq request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SEND_MESSAGE, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.github.mcilloni.uplink.nano.UplinkProto.FriendList> sentRequests(
        com.github.mcilloni.uplink.nano.UplinkProto.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SENT_REQUESTS, getCallOptions()), request);
    }
  }

  private static final int METHODID_ACCEPT_FRIENDSHIP = 0;
  private static final int METHODID_ACCEPT_INVITE = 1;
  private static final int METHODID_CONVERSATIONS = 2;
  private static final int METHODID_EXISTS = 3;
  private static final int METHODID_FRIENDS = 4;
  private static final int METHODID_INVITES = 5;
  private static final int METHODID_LOGIN = 6;
  private static final int METHODID_MESSAGES = 7;
  private static final int METHODID_NEW_CONVERSATION = 8;
  private static final int METHODID_NEW_USER = 9;
  private static final int METHODID_NOTIFICATIONS = 10;
  private static final int METHODID_PING = 11;
  private static final int METHODID_RECEIVED_REQUESTS = 12;
  private static final int METHODID_REQUEST_FRIENDSHIP = 13;
  private static final int METHODID_SEND_INVITE = 14;
  private static final int METHODID_SEND_MESSAGE = 15;
  private static final int METHODID_SENT_REQUESTS = 16;

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
        case METHODID_ACCEPT_FRIENDSHIP:
          serviceImpl.acceptFriendship((com.github.mcilloni.uplink.nano.UplinkProto.Name) request,
              (io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.BoolResp>) responseObserver);
          break;
        case METHODID_ACCEPT_INVITE:
          serviceImpl.acceptInvite((com.github.mcilloni.uplink.nano.UplinkProto.ID) request,
              (io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.BoolResp>) responseObserver);
          break;
        case METHODID_CONVERSATIONS:
          serviceImpl.conversations((com.github.mcilloni.uplink.nano.UplinkProto.Empty) request,
              (io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.ConversationList>) responseObserver);
          break;
        case METHODID_EXISTS:
          serviceImpl.exists((com.github.mcilloni.uplink.nano.UplinkProto.Name) request,
              (io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.BoolResp>) responseObserver);
          break;
        case METHODID_FRIENDS:
          serviceImpl.friends((com.github.mcilloni.uplink.nano.UplinkProto.Empty) request,
              (io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.FriendList>) responseObserver);
          break;
        case METHODID_INVITES:
          serviceImpl.invites((com.github.mcilloni.uplink.nano.UplinkProto.Empty) request,
              (io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.InviteList>) responseObserver);
          break;
        case METHODID_LOGIN:
          serviceImpl.login((com.github.mcilloni.uplink.nano.UplinkProto.AuthInfo) request,
              (io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.SessInfo>) responseObserver);
          break;
        case METHODID_MESSAGES:
          serviceImpl.messages((com.github.mcilloni.uplink.nano.UplinkProto.FetchOpts) request,
              (io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.MessageList>) responseObserver);
          break;
        case METHODID_NEW_CONVERSATION:
          serviceImpl.newConversation((com.github.mcilloni.uplink.nano.UplinkProto.Name) request,
              (io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.ID>) responseObserver);
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
        case METHODID_RECEIVED_REQUESTS:
          serviceImpl.receivedRequests((com.github.mcilloni.uplink.nano.UplinkProto.Empty) request,
              (io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.FriendList>) responseObserver);
          break;
        case METHODID_REQUEST_FRIENDSHIP:
          serviceImpl.requestFriendship((com.github.mcilloni.uplink.nano.UplinkProto.Name) request,
              (io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.BoolResp>) responseObserver);
          break;
        case METHODID_SEND_INVITE:
          serviceImpl.sendInvite((com.github.mcilloni.uplink.nano.UplinkProto.Invite) request,
              (io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.BoolResp>) responseObserver);
          break;
        case METHODID_SEND_MESSAGE:
          serviceImpl.sendMessage((com.github.mcilloni.uplink.nano.UplinkProto.NewMsgReq) request,
              (io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.NewMsgResp>) responseObserver);
          break;
        case METHODID_SENT_REQUESTS:
          serviceImpl.sentRequests((com.github.mcilloni.uplink.nano.UplinkProto.Empty) request,
              (io.grpc.stub.StreamObserver<com.github.mcilloni.uplink.nano.UplinkProto.FriendList>) responseObserver);
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
          METHOD_ACCEPT_FRIENDSHIP,
          asyncUnaryCall(
            new MethodHandlers<
              com.github.mcilloni.uplink.nano.UplinkProto.Name,
              com.github.mcilloni.uplink.nano.UplinkProto.BoolResp>(
                serviceImpl, METHODID_ACCEPT_FRIENDSHIP)))
        .addMethod(
          METHOD_ACCEPT_INVITE,
          asyncUnaryCall(
            new MethodHandlers<
              com.github.mcilloni.uplink.nano.UplinkProto.ID,
              com.github.mcilloni.uplink.nano.UplinkProto.BoolResp>(
                serviceImpl, METHODID_ACCEPT_INVITE)))
        .addMethod(
          METHOD_CONVERSATIONS,
          asyncUnaryCall(
            new MethodHandlers<
              com.github.mcilloni.uplink.nano.UplinkProto.Empty,
              com.github.mcilloni.uplink.nano.UplinkProto.ConversationList>(
                serviceImpl, METHODID_CONVERSATIONS)))
        .addMethod(
          METHOD_EXISTS,
          asyncUnaryCall(
            new MethodHandlers<
              com.github.mcilloni.uplink.nano.UplinkProto.Name,
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
          METHOD_INVITES,
          asyncUnaryCall(
            new MethodHandlers<
              com.github.mcilloni.uplink.nano.UplinkProto.Empty,
              com.github.mcilloni.uplink.nano.UplinkProto.InviteList>(
                serviceImpl, METHODID_INVITES)))
        .addMethod(
          METHOD_LOGIN,
          asyncUnaryCall(
            new MethodHandlers<
              com.github.mcilloni.uplink.nano.UplinkProto.AuthInfo,
              com.github.mcilloni.uplink.nano.UplinkProto.SessInfo>(
                serviceImpl, METHODID_LOGIN)))
        .addMethod(
          METHOD_MESSAGES,
          asyncUnaryCall(
            new MethodHandlers<
              com.github.mcilloni.uplink.nano.UplinkProto.FetchOpts,
              com.github.mcilloni.uplink.nano.UplinkProto.MessageList>(
                serviceImpl, METHODID_MESSAGES)))
        .addMethod(
          METHOD_NEW_CONVERSATION,
          asyncUnaryCall(
            new MethodHandlers<
              com.github.mcilloni.uplink.nano.UplinkProto.Name,
              com.github.mcilloni.uplink.nano.UplinkProto.ID>(
                serviceImpl, METHODID_NEW_CONVERSATION)))
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
        .addMethod(
          METHOD_RECEIVED_REQUESTS,
          asyncUnaryCall(
            new MethodHandlers<
              com.github.mcilloni.uplink.nano.UplinkProto.Empty,
              com.github.mcilloni.uplink.nano.UplinkProto.FriendList>(
                serviceImpl, METHODID_RECEIVED_REQUESTS)))
        .addMethod(
          METHOD_REQUEST_FRIENDSHIP,
          asyncUnaryCall(
            new MethodHandlers<
              com.github.mcilloni.uplink.nano.UplinkProto.Name,
              com.github.mcilloni.uplink.nano.UplinkProto.BoolResp>(
                serviceImpl, METHODID_REQUEST_FRIENDSHIP)))
        .addMethod(
          METHOD_SEND_INVITE,
          asyncUnaryCall(
            new MethodHandlers<
              com.github.mcilloni.uplink.nano.UplinkProto.Invite,
              com.github.mcilloni.uplink.nano.UplinkProto.BoolResp>(
                serviceImpl, METHODID_SEND_INVITE)))
        .addMethod(
          METHOD_SEND_MESSAGE,
          asyncUnaryCall(
            new MethodHandlers<
              com.github.mcilloni.uplink.nano.UplinkProto.NewMsgReq,
              com.github.mcilloni.uplink.nano.UplinkProto.NewMsgResp>(
                serviceImpl, METHODID_SEND_MESSAGE)))
        .addMethod(
          METHOD_SENT_REQUESTS,
          asyncUnaryCall(
            new MethodHandlers<
              com.github.mcilloni.uplink.nano.UplinkProto.Empty,
              com.github.mcilloni.uplink.nano.UplinkProto.FriendList>(
                serviceImpl, METHODID_SENT_REQUESTS)))
        .build();
  }
}
