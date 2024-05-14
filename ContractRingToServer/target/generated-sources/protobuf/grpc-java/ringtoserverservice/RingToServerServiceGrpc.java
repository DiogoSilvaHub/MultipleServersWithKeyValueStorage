package ringtoserverservice;

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
    comments = "Source: ServiceRingToServer.proto")
public final class RingToServerServiceGrpc {

  private RingToServerServiceGrpc() {}

  public static final String SERVICE_NAME = "ringtoserverservice.RingToServerService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ringtoserverservice.Location,
      ringtoserverservice.Location> getRegisterServerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "registerServer",
      requestType = ringtoserverservice.Location.class,
      responseType = ringtoserverservice.Location.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ringtoserverservice.Location,
      ringtoserverservice.Location> getRegisterServerMethod() {
    io.grpc.MethodDescriptor<ringtoserverservice.Location, ringtoserverservice.Location> getRegisterServerMethod;
    if ((getRegisterServerMethod = RingToServerServiceGrpc.getRegisterServerMethod) == null) {
      synchronized (RingToServerServiceGrpc.class) {
        if ((getRegisterServerMethod = RingToServerServiceGrpc.getRegisterServerMethod) == null) {
          RingToServerServiceGrpc.getRegisterServerMethod = getRegisterServerMethod =
              io.grpc.MethodDescriptor.<ringtoserverservice.Location, ringtoserverservice.Location>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "registerServer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ringtoserverservice.Location.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ringtoserverservice.Location.getDefaultInstance()))
              .setSchemaDescriptor(new RingToServerServiceMethodDescriptorSupplier("registerServer"))
              .build();
        }
      }
    }
    return getRegisterServerMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RingToServerServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RingToServerServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RingToServerServiceStub>() {
        @java.lang.Override
        public RingToServerServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RingToServerServiceStub(channel, callOptions);
        }
      };
    return RingToServerServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RingToServerServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RingToServerServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RingToServerServiceBlockingStub>() {
        @java.lang.Override
        public RingToServerServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RingToServerServiceBlockingStub(channel, callOptions);
        }
      };
    return RingToServerServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RingToServerServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RingToServerServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RingToServerServiceFutureStub>() {
        @java.lang.Override
        public RingToServerServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RingToServerServiceFutureStub(channel, callOptions);
        }
      };
    return RingToServerServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class RingToServerServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void registerServer(ringtoserverservice.Location request,
        io.grpc.stub.StreamObserver<ringtoserverservice.Location> responseObserver) {
      asyncUnimplementedUnaryCall(getRegisterServerMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRegisterServerMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ringtoserverservice.Location,
                ringtoserverservice.Location>(
                  this, METHODID_REGISTER_SERVER)))
          .build();
    }
  }

  /**
   */
  public static final class RingToServerServiceStub extends io.grpc.stub.AbstractAsyncStub<RingToServerServiceStub> {
    private RingToServerServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RingToServerServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RingToServerServiceStub(channel, callOptions);
    }

    /**
     */
    public void registerServer(ringtoserverservice.Location request,
        io.grpc.stub.StreamObserver<ringtoserverservice.Location> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRegisterServerMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class RingToServerServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<RingToServerServiceBlockingStub> {
    private RingToServerServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RingToServerServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RingToServerServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public ringtoserverservice.Location registerServer(ringtoserverservice.Location request) {
      return blockingUnaryCall(
          getChannel(), getRegisterServerMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class RingToServerServiceFutureStub extends io.grpc.stub.AbstractFutureStub<RingToServerServiceFutureStub> {
    private RingToServerServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RingToServerServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RingToServerServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ringtoserverservice.Location> registerServer(
        ringtoserverservice.Location request) {
      return futureUnaryCall(
          getChannel().newCall(getRegisterServerMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REGISTER_SERVER = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RingToServerServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RingToServerServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REGISTER_SERVER:
          serviceImpl.registerServer((ringtoserverservice.Location) request,
              (io.grpc.stub.StreamObserver<ringtoserverservice.Location>) responseObserver);
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

  private static abstract class RingToServerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RingToServerServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ringtoserverservice.ServiceRingToServer.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RingToServerService");
    }
  }

  private static final class RingToServerServiceFileDescriptorSupplier
      extends RingToServerServiceBaseDescriptorSupplier {
    RingToServerServiceFileDescriptorSupplier() {}
  }

  private static final class RingToServerServiceMethodDescriptorSupplier
      extends RingToServerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RingToServerServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (RingToServerServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RingToServerServiceFileDescriptorSupplier())
              .addMethod(getRegisterServerMethod())
              .build();
        }
      }
    }
    return result;
  }
}
