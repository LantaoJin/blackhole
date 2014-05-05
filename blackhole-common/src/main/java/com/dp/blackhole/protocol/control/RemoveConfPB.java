// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: RemoveConf.proto

package com.dp.blackhole.protocol.control;

public final class RemoveConfPB {
  private RemoveConfPB() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public static final class RemoveConf extends
      com.google.protobuf.GeneratedMessage {
    // Use RemoveConf.newBuilder() to construct.
    private RemoveConf() {
      initFields();
    }
    private RemoveConf(boolean noInit) {}
    
    private static final RemoveConf defaultInstance;
    public static RemoveConf getDefaultInstance() {
      return defaultInstance;
    }
    
    public RemoveConf getDefaultInstanceForType() {
      return defaultInstance;
    }
    
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dp.blackhole.protocol.control.RemoveConfPB.internal_static_blackhole_RemoveConf_descriptor;
    }
    
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dp.blackhole.protocol.control.RemoveConfPB.internal_static_blackhole_RemoveConf_fieldAccessorTable;
    }
    
    // required string app_name = 1;
    public static final int APP_NAME_FIELD_NUMBER = 1;
    private boolean hasAppName;
    private java.lang.String appName_ = "";
    public boolean hasAppName() { return hasAppName; }
    public java.lang.String getAppName() { return appName_; }
    
    // repeated string app_servers = 2;
    public static final int APP_SERVERS_FIELD_NUMBER = 2;
    private java.util.List<java.lang.String> appServers_ =
      java.util.Collections.emptyList();
    public java.util.List<java.lang.String> getAppServersList() {
      return appServers_;
    }
    public int getAppServersCount() { return appServers_.size(); }
    public java.lang.String getAppServers(int index) {
      return appServers_.get(index);
    }
    
    private void initFields() {
    }
    public final boolean isInitialized() {
      if (!hasAppName) return false;
      return true;
    }
    
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (hasAppName()) {
        output.writeString(1, getAppName());
      }
      for (java.lang.String element : getAppServersList()) {
        output.writeString(2, element);
      }
      getUnknownFields().writeTo(output);
    }
    
    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;
    
      size = 0;
      if (hasAppName()) {
        size += com.google.protobuf.CodedOutputStream
          .computeStringSize(1, getAppName());
      }
      {
        int dataSize = 0;
        for (java.lang.String element : getAppServersList()) {
          dataSize += com.google.protobuf.CodedOutputStream
            .computeStringSizeNoTag(element);
        }
        size += dataSize;
        size += 1 * getAppServersList().size();
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }
    
    public static com.dp.blackhole.protocol.control.RemoveConfPB.RemoveConf parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static com.dp.blackhole.protocol.control.RemoveConfPB.RemoveConf parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static com.dp.blackhole.protocol.control.RemoveConfPB.RemoveConf parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static com.dp.blackhole.protocol.control.RemoveConfPB.RemoveConf parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static com.dp.blackhole.protocol.control.RemoveConfPB.RemoveConf parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static com.dp.blackhole.protocol.control.RemoveConfPB.RemoveConf parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    public static com.dp.blackhole.protocol.control.RemoveConfPB.RemoveConf parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      Builder builder = newBuilder();
      if (builder.mergeDelimitedFrom(input)) {
        return builder.buildParsed();
      } else {
        return null;
      }
    }
    public static com.dp.blackhole.protocol.control.RemoveConfPB.RemoveConf parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      Builder builder = newBuilder();
      if (builder.mergeDelimitedFrom(input, extensionRegistry)) {
        return builder.buildParsed();
      } else {
        return null;
      }
    }
    public static com.dp.blackhole.protocol.control.RemoveConfPB.RemoveConf parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static com.dp.blackhole.protocol.control.RemoveConfPB.RemoveConf parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    
    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(com.dp.blackhole.protocol.control.RemoveConfPB.RemoveConf prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }
    
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder> {
      private com.dp.blackhole.protocol.control.RemoveConfPB.RemoveConf result;
      
      // Construct using com.dp.blackhole.protocol.control.RemoveConfPB.RemoveConf.newBuilder()
      private Builder() {}
      
      private static Builder create() {
        Builder builder = new Builder();
        builder.result = new com.dp.blackhole.protocol.control.RemoveConfPB.RemoveConf();
        return builder;
      }
      
      protected com.dp.blackhole.protocol.control.RemoveConfPB.RemoveConf internalGetResult() {
        return result;
      }
      
      public Builder clear() {
        if (result == null) {
          throw new IllegalStateException(
            "Cannot call clear() after build().");
        }
        result = new com.dp.blackhole.protocol.control.RemoveConfPB.RemoveConf();
        return this;
      }
      
      public Builder clone() {
        return create().mergeFrom(result);
      }
      
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.dp.blackhole.protocol.control.RemoveConfPB.RemoveConf.getDescriptor();
      }
      
      public com.dp.blackhole.protocol.control.RemoveConfPB.RemoveConf getDefaultInstanceForType() {
        return com.dp.blackhole.protocol.control.RemoveConfPB.RemoveConf.getDefaultInstance();
      }
      
      public boolean isInitialized() {
        return result.isInitialized();
      }
      public com.dp.blackhole.protocol.control.RemoveConfPB.RemoveConf build() {
        if (result != null && !isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return buildPartial();
      }
      
      private com.dp.blackhole.protocol.control.RemoveConfPB.RemoveConf buildParsed()
          throws com.google.protobuf.InvalidProtocolBufferException {
        if (!isInitialized()) {
          throw newUninitializedMessageException(
            result).asInvalidProtocolBufferException();
        }
        return buildPartial();
      }
      
      public com.dp.blackhole.protocol.control.RemoveConfPB.RemoveConf buildPartial() {
        if (result == null) {
          throw new IllegalStateException(
            "build() has already been called on this Builder.");
        }
        if (result.appServers_ != java.util.Collections.EMPTY_LIST) {
          result.appServers_ =
            java.util.Collections.unmodifiableList(result.appServers_);
        }
        com.dp.blackhole.protocol.control.RemoveConfPB.RemoveConf returnMe = result;
        result = null;
        return returnMe;
      }
      
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.dp.blackhole.protocol.control.RemoveConfPB.RemoveConf) {
          return mergeFrom((com.dp.blackhole.protocol.control.RemoveConfPB.RemoveConf)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }
      
      public Builder mergeFrom(com.dp.blackhole.protocol.control.RemoveConfPB.RemoveConf other) {
        if (other == com.dp.blackhole.protocol.control.RemoveConfPB.RemoveConf.getDefaultInstance()) return this;
        if (other.hasAppName()) {
          setAppName(other.getAppName());
        }
        if (!other.appServers_.isEmpty()) {
          if (result.appServers_.isEmpty()) {
            result.appServers_ = new java.util.ArrayList<java.lang.String>();
          }
          result.appServers_.addAll(other.appServers_);
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }
      
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder(
            this.getUnknownFields());
        while (true) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              this.setUnknownFields(unknownFields.build());
              return this;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                this.setUnknownFields(unknownFields.build());
                return this;
              }
              break;
            }
            case 10: {
              setAppName(input.readString());
              break;
            }
            case 18: {
              addAppServers(input.readString());
              break;
            }
          }
        }
      }
      
      
      // required string app_name = 1;
      public boolean hasAppName() {
        return result.hasAppName();
      }
      public java.lang.String getAppName() {
        return result.getAppName();
      }
      public Builder setAppName(java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  result.hasAppName = true;
        result.appName_ = value;
        return this;
      }
      public Builder clearAppName() {
        result.hasAppName = false;
        result.appName_ = getDefaultInstance().getAppName();
        return this;
      }
      
      // repeated string app_servers = 2;
      public java.util.List<java.lang.String> getAppServersList() {
        return java.util.Collections.unmodifiableList(result.appServers_);
      }
      public int getAppServersCount() {
        return result.getAppServersCount();
      }
      public java.lang.String getAppServers(int index) {
        return result.getAppServers(index);
      }
      public Builder setAppServers(int index, java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  result.appServers_.set(index, value);
        return this;
      }
      public Builder addAppServers(java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  if (result.appServers_.isEmpty()) {
          result.appServers_ = new java.util.ArrayList<java.lang.String>();
        }
        result.appServers_.add(value);
        return this;
      }
      public Builder addAllAppServers(
          java.lang.Iterable<? extends java.lang.String> values) {
        if (result.appServers_.isEmpty()) {
          result.appServers_ = new java.util.ArrayList<java.lang.String>();
        }
        super.addAll(values, result.appServers_);
        return this;
      }
      public Builder clearAppServers() {
        result.appServers_ = java.util.Collections.emptyList();
        return this;
      }
      
      // @@protoc_insertion_point(builder_scope:blackhole.RemoveConf)
    }
    
    static {
      defaultInstance = new RemoveConf(true);
      com.dp.blackhole.protocol.control.RemoveConfPB.internalForceInit();
      defaultInstance.initFields();
    }
    
    // @@protoc_insertion_point(class_scope:blackhole.RemoveConf)
  }
  
  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_blackhole_RemoveConf_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_blackhole_RemoveConf_fieldAccessorTable;
  
  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\020RemoveConf.proto\022\tblackhole\"3\n\nRemoveC" +
      "onf\022\020\n\010app_name\030\001 \002(\t\022\023\n\013app_servers\030\002 \003" +
      "(\tB1\n!com.dp.blackhole.protocol.controlB" +
      "\014RemoveConfPB"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
      new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public com.google.protobuf.ExtensionRegistry assignDescriptors(
            com.google.protobuf.Descriptors.FileDescriptor root) {
          descriptor = root;
          internal_static_blackhole_RemoveConf_descriptor =
            getDescriptor().getMessageTypes().get(0);
          internal_static_blackhole_RemoveConf_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_blackhole_RemoveConf_descriptor,
              new java.lang.String[] { "AppName", "AppServers", },
              com.dp.blackhole.protocol.control.RemoveConfPB.RemoveConf.class,
              com.dp.blackhole.protocol.control.RemoveConfPB.RemoveConf.Builder.class);
          return null;
        }
      };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
  }
  
  public static void internalForceInit() {}
  
  // @@protoc_insertion_point(outer_class_scope)
}