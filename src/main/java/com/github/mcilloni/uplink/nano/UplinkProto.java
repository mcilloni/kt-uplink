// Generated by the protocol buffer compiler.  DO NOT EDIT!

package com.github.mcilloni.uplink.nano;

@SuppressWarnings("hiding")
public interface UplinkProto {

  public static final class Empty extends
      com.google.protobuf.nano.MessageNano {

    private static volatile Empty[] _emptyArray;
    public static Empty[] emptyArray() {
      // Lazily initializes the empty array
      if (_emptyArray == null) {
        synchronized (
            com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK) {
          if (_emptyArray == null) {
            _emptyArray = new Empty[0];
          }
        }
      }
      return _emptyArray;
    }

    public Empty() {
      clear();
    }

    public Empty clear() {
      cachedSize = -1;
      return this;
    }

    @Override
    public Empty mergeFrom(
            com.google.protobuf.nano.CodedInputByteBufferNano input)
        throws java.io.IOException {
      while (true) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            return this;
          default: {
            if (!com.google.protobuf.nano.WireFormatNano.parseUnknownField(input, tag)) {
              return this;
            }
            break;
          }
        }
      }
    }

    public static Empty parseFrom(byte[] data)
        throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
      return com.google.protobuf.nano.MessageNano.mergeFrom(new Empty(), data);
    }

    public static Empty parseFrom(
            com.google.protobuf.nano.CodedInputByteBufferNano input)
        throws java.io.IOException {
      return new Empty().mergeFrom(input);
    }
  }

  public static final class BoolResp extends
      com.google.protobuf.nano.MessageNano {

    private static volatile BoolResp[] _emptyArray;
    public static BoolResp[] emptyArray() {
      // Lazily initializes the empty array
      if (_emptyArray == null) {
        synchronized (
            com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK) {
          if (_emptyArray == null) {
            _emptyArray = new BoolResp[0];
          }
        }
      }
      return _emptyArray;
    }

    // optional bool success = 1;
    public boolean success;

    public BoolResp() {
      clear();
    }

    public BoolResp clear() {
      success = false;
      cachedSize = -1;
      return this;
    }

    @Override
    public void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano output)
        throws java.io.IOException {
      if (this.success != false) {
        output.writeBool(1, this.success);
      }
      super.writeTo(output);
    }

    @Override
    protected int computeSerializedSize() {
      int size = super.computeSerializedSize();
      if (this.success != false) {
        size += com.google.protobuf.nano.CodedOutputByteBufferNano
            .computeBoolSize(1, this.success);
      }
      return size;
    }

    @Override
    public BoolResp mergeFrom(
            com.google.protobuf.nano.CodedInputByteBufferNano input)
        throws java.io.IOException {
      while (true) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            return this;
          default: {
            if (!com.google.protobuf.nano.WireFormatNano.parseUnknownField(input, tag)) {
              return this;
            }
            break;
          }
          case 8: {
            this.success = input.readBool();
            break;
          }
        }
      }
    }

    public static BoolResp parseFrom(byte[] data)
        throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
      return com.google.protobuf.nano.MessageNano.mergeFrom(new BoolResp(), data);
    }

    public static BoolResp parseFrom(
            com.google.protobuf.nano.CodedInputByteBufferNano input)
        throws java.io.IOException {
      return new BoolResp().mergeFrom(input);
    }
  }

  public static final class Username extends
      com.google.protobuf.nano.MessageNano {

    private static volatile Username[] _emptyArray;
    public static Username[] emptyArray() {
      // Lazily initializes the empty array
      if (_emptyArray == null) {
        synchronized (
            com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK) {
          if (_emptyArray == null) {
            _emptyArray = new Username[0];
          }
        }
      }
      return _emptyArray;
    }

    // optional string name = 1;
    public java.lang.String name;

    public Username() {
      clear();
    }

    public Username clear() {
      name = "";
      cachedSize = -1;
      return this;
    }

    @Override
    public void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano output)
        throws java.io.IOException {
      if (!this.name.equals("")) {
        output.writeString(1, this.name);
      }
      super.writeTo(output);
    }

    @Override
    protected int computeSerializedSize() {
      int size = super.computeSerializedSize();
      if (!this.name.equals("")) {
        size += com.google.protobuf.nano.CodedOutputByteBufferNano
            .computeStringSize(1, this.name);
      }
      return size;
    }

    @Override
    public Username mergeFrom(
            com.google.protobuf.nano.CodedInputByteBufferNano input)
        throws java.io.IOException {
      while (true) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            return this;
          default: {
            if (!com.google.protobuf.nano.WireFormatNano.parseUnknownField(input, tag)) {
              return this;
            }
            break;
          }
          case 10: {
            this.name = input.readString();
            break;
          }
        }
      }
    }

    public static Username parseFrom(byte[] data)
        throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
      return com.google.protobuf.nano.MessageNano.mergeFrom(new Username(), data);
    }

    public static Username parseFrom(
            com.google.protobuf.nano.CodedInputByteBufferNano input)
        throws java.io.IOException {
      return new Username().mergeFrom(input);
    }
  }

  public static final class AuthInfo extends
      com.google.protobuf.nano.MessageNano {

    private static volatile AuthInfo[] _emptyArray;
    public static AuthInfo[] emptyArray() {
      // Lazily initializes the empty array
      if (_emptyArray == null) {
        synchronized (
            com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK) {
          if (_emptyArray == null) {
            _emptyArray = new AuthInfo[0];
          }
        }
      }
      return _emptyArray;
    }

    // optional string name = 1;
    public java.lang.String name;

    // optional string pass = 2;
    public java.lang.String pass;

    public AuthInfo() {
      clear();
    }

    public AuthInfo clear() {
      name = "";
      pass = "";
      cachedSize = -1;
      return this;
    }

    @Override
    public void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano output)
        throws java.io.IOException {
      if (!this.name.equals("")) {
        output.writeString(1, this.name);
      }
      if (!this.pass.equals("")) {
        output.writeString(2, this.pass);
      }
      super.writeTo(output);
    }

    @Override
    protected int computeSerializedSize() {
      int size = super.computeSerializedSize();
      if (!this.name.equals("")) {
        size += com.google.protobuf.nano.CodedOutputByteBufferNano
            .computeStringSize(1, this.name);
      }
      if (!this.pass.equals("")) {
        size += com.google.protobuf.nano.CodedOutputByteBufferNano
            .computeStringSize(2, this.pass);
      }
      return size;
    }

    @Override
    public AuthInfo mergeFrom(
            com.google.protobuf.nano.CodedInputByteBufferNano input)
        throws java.io.IOException {
      while (true) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            return this;
          default: {
            if (!com.google.protobuf.nano.WireFormatNano.parseUnknownField(input, tag)) {
              return this;
            }
            break;
          }
          case 10: {
            this.name = input.readString();
            break;
          }
          case 18: {
            this.pass = input.readString();
            break;
          }
        }
      }
    }

    public static AuthInfo parseFrom(byte[] data)
        throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
      return com.google.protobuf.nano.MessageNano.mergeFrom(new AuthInfo(), data);
    }

    public static AuthInfo parseFrom(
            com.google.protobuf.nano.CodedInputByteBufferNano input)
        throws java.io.IOException {
      return new AuthInfo().mergeFrom(input);
    }
  }

  public static final class SessInfo extends
      com.google.protobuf.nano.MessageNano {

    private static volatile SessInfo[] _emptyArray;
    public static SessInfo[] emptyArray() {
      // Lazily initializes the empty array
      if (_emptyArray == null) {
        synchronized (
            com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK) {
          if (_emptyArray == null) {
            _emptyArray = new SessInfo[0];
          }
        }
      }
      return _emptyArray;
    }

    // optional int64 uid = 1;
    public long uid;

    // optional string session_id = 2;
    public java.lang.String sessionId;

    public SessInfo() {
      clear();
    }

    public SessInfo clear() {
      uid = 0L;
      sessionId = "";
      cachedSize = -1;
      return this;
    }

    @Override
    public void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano output)
        throws java.io.IOException {
      if (this.uid != 0L) {
        output.writeInt64(1, this.uid);
      }
      if (!this.sessionId.equals("")) {
        output.writeString(2, this.sessionId);
      }
      super.writeTo(output);
    }

    @Override
    protected int computeSerializedSize() {
      int size = super.computeSerializedSize();
      if (this.uid != 0L) {
        size += com.google.protobuf.nano.CodedOutputByteBufferNano
            .computeInt64Size(1, this.uid);
      }
      if (!this.sessionId.equals("")) {
        size += com.google.protobuf.nano.CodedOutputByteBufferNano
            .computeStringSize(2, this.sessionId);
      }
      return size;
    }

    @Override
    public SessInfo mergeFrom(
            com.google.protobuf.nano.CodedInputByteBufferNano input)
        throws java.io.IOException {
      while (true) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            return this;
          default: {
            if (!com.google.protobuf.nano.WireFormatNano.parseUnknownField(input, tag)) {
              return this;
            }
            break;
          }
          case 8: {
            this.uid = input.readInt64();
            break;
          }
          case 18: {
            this.sessionId = input.readString();
            break;
          }
        }
      }
    }

    public static SessInfo parseFrom(byte[] data)
        throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
      return com.google.protobuf.nano.MessageNano.mergeFrom(new SessInfo(), data);
    }

    public static SessInfo parseFrom(
            com.google.protobuf.nano.CodedInputByteBufferNano input)
        throws java.io.IOException {
      return new SessInfo().mergeFrom(input);
    }
  }

  public static final class Notification extends
      com.google.protobuf.nano.MessageNano {

    // enum Type
    public static final int MESSAGE = 0;
    public static final int FRIENDSHIP = 1;
    public static final int INVITE = 2;

    private static volatile Notification[] _emptyArray;
    public static Notification[] emptyArray() {
      // Lazily initializes the empty array
      if (_emptyArray == null) {
        synchronized (
            com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK) {
          if (_emptyArray == null) {
            _emptyArray = new Notification[0];
          }
        }
      }
      return _emptyArray;
    }

    // optional .protodef.Notification.Type type = 1;
    public int type;

    // optional string sender_name = 2;
    public java.lang.String senderName;

    // optional int64 conv_id = 3;
    public long convId;

    // optional string body = 4;
    public java.lang.String body;

    public Notification() {
      clear();
    }

    public Notification clear() {
      type = com.github.mcilloni.uplink.nano.UplinkProto.Notification.MESSAGE;
      senderName = "";
      convId = 0L;
      body = "";
      cachedSize = -1;
      return this;
    }

    @Override
    public void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano output)
        throws java.io.IOException {
      if (this.type != com.github.mcilloni.uplink.nano.UplinkProto.Notification.MESSAGE) {
        output.writeInt32(1, this.type);
      }
      if (!this.senderName.equals("")) {
        output.writeString(2, this.senderName);
      }
      if (this.convId != 0L) {
        output.writeInt64(3, this.convId);
      }
      if (!this.body.equals("")) {
        output.writeString(4, this.body);
      }
      super.writeTo(output);
    }

    @Override
    protected int computeSerializedSize() {
      int size = super.computeSerializedSize();
      if (this.type != com.github.mcilloni.uplink.nano.UplinkProto.Notification.MESSAGE) {
        size += com.google.protobuf.nano.CodedOutputByteBufferNano
          .computeInt32Size(1, this.type);
      }
      if (!this.senderName.equals("")) {
        size += com.google.protobuf.nano.CodedOutputByteBufferNano
            .computeStringSize(2, this.senderName);
      }
      if (this.convId != 0L) {
        size += com.google.protobuf.nano.CodedOutputByteBufferNano
            .computeInt64Size(3, this.convId);
      }
      if (!this.body.equals("")) {
        size += com.google.protobuf.nano.CodedOutputByteBufferNano
            .computeStringSize(4, this.body);
      }
      return size;
    }

    @Override
    public Notification mergeFrom(
            com.google.protobuf.nano.CodedInputByteBufferNano input)
        throws java.io.IOException {
      while (true) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            return this;
          default: {
            if (!com.google.protobuf.nano.WireFormatNano.parseUnknownField(input, tag)) {
              return this;
            }
            break;
          }
          case 8: {
            int value = input.readInt32();
            switch (value) {
              case com.github.mcilloni.uplink.nano.UplinkProto.Notification.MESSAGE:
              case com.github.mcilloni.uplink.nano.UplinkProto.Notification.FRIENDSHIP:
              case com.github.mcilloni.uplink.nano.UplinkProto.Notification.INVITE:
                this.type = value;
                break;
            }
            break;
          }
          case 18: {
            this.senderName = input.readString();
            break;
          }
          case 24: {
            this.convId = input.readInt64();
            break;
          }
          case 34: {
            this.body = input.readString();
            break;
          }
        }
      }
    }

    public static Notification parseFrom(byte[] data)
        throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
      return com.google.protobuf.nano.MessageNano.mergeFrom(new Notification(), data);
    }

    public static Notification parseFrom(
            com.google.protobuf.nano.CodedInputByteBufferNano input)
        throws java.io.IOException {
      return new Notification().mergeFrom(input);
    }
  }

  public static final class FriendList extends
      com.google.protobuf.nano.MessageNano {

    private static volatile FriendList[] _emptyArray;
    public static FriendList[] emptyArray() {
      // Lazily initializes the empty array
      if (_emptyArray == null) {
        synchronized (
            com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK) {
          if (_emptyArray == null) {
            _emptyArray = new FriendList[0];
          }
        }
      }
      return _emptyArray;
    }

    // repeated string friends = 1;
    public java.lang.String[] friends;

    public FriendList() {
      clear();
    }

    public FriendList clear() {
      friends = com.google.protobuf.nano.WireFormatNano.EMPTY_STRING_ARRAY;
      cachedSize = -1;
      return this;
    }

    @Override
    public void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano output)
        throws java.io.IOException {
      if (this.friends != null && this.friends.length > 0) {
        for (int i = 0; i < this.friends.length; i++) {
          java.lang.String element = this.friends[i];
          if (element != null) {
            output.writeString(1, element);
          }
        }
      }
      super.writeTo(output);
    }

    @Override
    protected int computeSerializedSize() {
      int size = super.computeSerializedSize();
      if (this.friends != null && this.friends.length > 0) {
        int dataCount = 0;
        int dataSize = 0;
        for (int i = 0; i < this.friends.length; i++) {
          java.lang.String element = this.friends[i];
          if (element != null) {
            dataCount++;
            dataSize += com.google.protobuf.nano.CodedOutputByteBufferNano
                .computeStringSizeNoTag(element);
          }
        }
        size += dataSize;
        size += 1 * dataCount;
      }
      return size;
    }

    @Override
    public FriendList mergeFrom(
            com.google.protobuf.nano.CodedInputByteBufferNano input)
        throws java.io.IOException {
      while (true) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            return this;
          default: {
            if (!com.google.protobuf.nano.WireFormatNano.parseUnknownField(input, tag)) {
              return this;
            }
            break;
          }
          case 10: {
            int arrayLength = com.google.protobuf.nano.WireFormatNano
                .getRepeatedFieldArrayLength(input, 10);
            int i = this.friends == null ? 0 : this.friends.length;
            java.lang.String[] newArray = new java.lang.String[i + arrayLength];
            if (i != 0) {
              java.lang.System.arraycopy(this.friends, 0, newArray, 0, i);
            }
            for (; i < newArray.length - 1; i++) {
              newArray[i] = input.readString();
              input.readTag();
            }
            // Last one without readTag.
            newArray[i] = input.readString();
            this.friends = newArray;
            break;
          }
        }
      }
    }

    public static FriendList parseFrom(byte[] data)
        throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
      return com.google.protobuf.nano.MessageNano.mergeFrom(new FriendList(), data);
    }

    public static FriendList parseFrom(
            com.google.protobuf.nano.CodedInputByteBufferNano input)
        throws java.io.IOException {
      return new FriendList().mergeFrom(input);
    }
  }
}
