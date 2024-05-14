package servertoclientservice;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.28.1)",
    comments = "Source: ServiceServerToClient.proto")
public final class ServerToClientServiceGrpc {

  private ServerToClientServiceGrpc() {}

  public static final String SERVICE_NAME = "servertoclientservice.ServerToClientService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<servertoclientservice.Pair,
      servertoclientservice.Void> getWriteUpdateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "writeUpdate",
      requestType = servertoclientservice.Pair.class,
      responseType = servertoclientservice.Void.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<servertoclientservice.Pair,
      servertoclientservice.Void> getWriteUpdateMethod() {
    io.grpc.MethodDescriptor<servertoclientservice.Pair, servertoclientservice.Void> getWriteUpdateMethod;
    if ((getWriteUpdateMethod = ServerToClientServiceGrpc.getWriteUpdateMethod) == null) {
      synchronized (ServerToClientServiceGrpc.class) {
        if ((getWriteUpdateMethod = ServerToClientServiceGrpc.getWriteUpdateMethod) == null) {
          ServerToClientServiceGrpc.getWriteUpdateMethod = getWriteUpdateMethod =
              io.grpc.MethodDescriptor.<servertoclientservice.Pair, servertoclientservice.Void>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "writeUpdate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  servertoclientservice.Pair.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  servertoclientservice.Void.getDefaultInstance()))
              .setSchemaDescriptor(new ServerToClientServiceMethodDescriptorSupplier("writeUpdate"))
              .build();
        }
      }
    }
    return getWriteUpdateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<servertoclientservice.Key,
      servertoclientservice.Value> getReadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "read",
      requestType = servertoclientservice.Key.class,
      responseType = servertoclientservice.Value.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<servertoclientservice.Key,
      servertoclientservice.Value> getReadMethod() {
    io.grpc.MethodDescriptor<servertoclientservice.Key, servertoclientservice.Value> getReadMethod;
    if ((getReadMethod = ServerToClientServiceGrpc.getReadMethod) == null) {
      synchronized (ServerToClientServiceGrpc.class) {
        if ((getReadMethod = ServerToClientServiceGrpc.getReadMethod) == null) {
          ServerToClientServiceGrpc.getReadMethod = getReadMethod =
              io.grpc.MethodDescriptor.<servertoclientservice.Key, servertoclientservice.Value>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "read"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  servertoclientservice.Key.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  servertoclientservice.Value.getDefaultInstance()))
              .setSchemaDescriptor(new ServerToClientServiceMethodDescriptorSupplier("read"))
              .build();
        }
      }
    }
    return getReadMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ServerToClientServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServerToClientServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ServerToClientServiceStub>() {
        @java.lang.Override
        public ServerToClientServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ServerToClientServiceStub(channel, callOptions);
        }
      };
    return ServerToClientServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ServerToClientServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServerToClientServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ServerToClientServiceBlockingStub>() {
        @java.lang.Override
        public ServerToClientServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ServerToClientServiceBlockingStub(channel, callOptions);
        }
      };
    return ServerToClientServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ServerToClientServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServerToClientServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ServerToClientServiceFutureStub>() {
        @java.lang.Override
        public ServerToClientServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ServerToClientServiceFutureStub(channel, callOptions);
        }
      };
    return ServerToClientServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class ServerToClientServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void writeUpdate(servertoclientservice.Pair request,
        io.grpc.stub.StreamObserver<servertoclientservice.Void> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteUpdateMethod(), responseObserver);
    }

    /**
     */
    public void read(servertoclientservice.Key request,
        io.grpc.stub.StreamObserver<servertoclientservice.Value> responseObserver) {
      asyncUnimplementedUnaryCall(getReadMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getWriteUpdateMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                servertoclientservice.Pair,
                servertoclientservice.Void>(
                  this, METHODID_WRITE_UPDATE)))
          .addMethod(
            getReadMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                servertoclientservice.Key,
                servertoclientservice.Value>(
                  this, METHODID_READ)))
          .build();
    }
  }

  /**
   */
  public static final class ServerToClientServiceStub extends io.grpc.stub.AbstractAsyncStub<ServerToClientServiceStub> {
    private ServerToClientServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServerToClientServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServerToClientServiceStub(channel, callOptions);
    }

    /**
     */
    public void writeUpdate(servertoclientservice.Pair request,
        io.grpc.stub.StreamObserver<servertoclientservice.Void> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteUpdateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void read(servertoclientservice.Key request,
        io.grpc.stub.StreamObserver<servertoclientservice.Value> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ServerToClientServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<ServerToClientServiceBlockingStub> {
    private ServerToClientServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServerToClientServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServerToClientServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public servertoclientservice.Void writeUpdate(servertoclientservice.Pair request) {
      return blockingUnaryCall(
          getChannel(), getWriteUpdateMethod(), getCallOptions(), request);
    }

    /**
     */
    public servertoclientservice.Value read(servertoclientservice.Key request) {
      return blockingUnaryCall(
          getChannel(), getReadMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ServerToClientServiceFutureStub extends io.grpc.stub.AbstractFutureStub<ServerToClientServiceFutureStub> {
    private ServerToClientServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServerToClientServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServerToClientServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<servertoclientservice.Void> writeUpdate(
        servertoclientservice.Pair request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteUpdateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<servertoclientservice.Value> read(
        servertoclientservice.Key request) {
      return futureUnaryCall(
          getChannel().newCall(getReadMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_WRITE_UPDATE = 0;
  private static final int METHODID_READ = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ServerToClientServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ServerToClientServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_WRITE_UPDATE:
          serviceImpl.writeUpdate((servertoclientservice.Pair) request,
              (io.grpc.stub.StreamObserver<servertoclientservice.Void>) responseObserver);
          break;
        case METHODID_READ:
          serviceImpl.read((servertoclientservice.Key) request,
              (io.grpc.stub.StreamObserver<servertoclientservice.Value>) responseObserver);
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

  private static abstract class ServerToClientServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ServerToClientServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return servertoclientservice.ServiceServerToClient.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ServerToClientService");
    }
  }

  private static final class ServerToClientServiceFileDescriptorSupplier
      extends ServerToClientServiceBaseDescriptorSupplier {
    ServerToClientServiceFileDescriptorSupplier() {}
  }

  private static final class ServerToClientServiceMethodDescriptorSupplier
      extends ServerToClientServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ServerToClientServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ServerToClientServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ServerToClientServiceFileDescriptorSupplier())
              .addMethod(getWriteUpdateMethod())
              .addMethod(getReadMethod())
              .build();
        }
      }
    }
    return result;
  }
}
