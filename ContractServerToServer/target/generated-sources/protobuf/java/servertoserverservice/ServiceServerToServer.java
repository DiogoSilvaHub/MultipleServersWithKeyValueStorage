// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ServiceServerToServer.proto

package servertoserverservice;

public final class ServiceServerToServer {
  private ServiceServerToServer() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_servertoserverservice_Pair_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_servertoserverservice_Pair_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_servertoserverservice_Void_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_servertoserverservice_Void_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\033ServiceServerToServer.proto\022\025servertos" +
      "erverservice\"I\n\004Pair\022\013\n\003key\030\001 \001(\t\022\r\n\005val" +
      "ue\030\002 \001(\t\022\016\n\006IPPort\030\003 \001(\t\022\025\n\rflagWriteRea" +
      "d\030\004 \001(\010\"\006\n\004Void2^\n\025ServerToServerService" +
      "\022E\n\twriteRead\022\033.servertoserverservice.Pa" +
      "ir\032\033.servertoserverservice.VoidB\031\n\025serve" +
      "rtoserverserviceP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_servertoserverservice_Pair_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_servertoserverservice_Pair_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_servertoserverservice_Pair_descriptor,
        new java.lang.String[] { "Key", "Value", "IPPort", "FlagWriteRead", });
    internal_static_servertoserverservice_Void_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_servertoserverservice_Void_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_servertoserverservice_Void_descriptor,
        new java.lang.String[] { });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
