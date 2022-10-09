package com.ib315168.grpc.server;

import com.ib315168.grpc.HelloRequest;
import com.ib315168.grpc.HelloResponse;
import com.ib315168.grpc.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;

public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase
{

  @Override public void hello(HelloRequest request,
      StreamObserver<HelloResponse> responseObserver)
  {
    String greeting = new StringBuilder()
        .append("Hello, ")
        .append(request.getFirstName())
        .append(" ")
        .append(request.getLastName())
        .toString();

    HelloResponse response = HelloResponse.newBuilder()
        .setGreeting(greeting)
        .build();

    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }

  @Override public void nohello(HelloRequest request,
      StreamObserver<HelloResponse> responseObserver)
  {
    String greeting = new StringBuilder()
        .append("Fuck gRPC")
        .toString();

    HelloResponse response = HelloResponse.newBuilder()
        .setGreeting(greeting)
        .build();

    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }
}
