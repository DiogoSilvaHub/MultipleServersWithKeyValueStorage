// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ServiceRingToServer.proto

package ringtoserverservice;

public final class ServiceRingToServer {
  private ServiceRingToServer() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ringtoserverservice_Location_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ringtoserverservice_Location_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\031ServiceRingToServer.proto\022\023ringtoserve" +
      "rservice\"$\n\010Location\022\n\n\002IP\030\001 \001(\t\022\014\n\004port" +
      "\030\002 \001(\t2e\n\023RingToServerService\022N\n\016registe" +
      "rServer\022\035.ringtoserverservice.Location\032\035" +
      ".ringtoserverservice.LocationB\027\n\023ringtos" +
      "erverserviceP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_ringtoserverservice_Location_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_ringtoserverservice_Location_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ringtoserverservice_Location_descriptor,
        new java.lang.String[] { "IP", "Port", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
