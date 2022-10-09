package com.ib315168.grpc.client;

import com.ib315168.grpc.HelloRequest;
import com.ib315168.grpc.HelloResponse;
import com.ib315168.grpc.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient
{
  public static void main(String[] args) {
    ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
        .usePlaintext()
        .build();

    HelloServiceGrpc.HelloServiceBlockingStub stub
        = HelloServiceGrpc.newBlockingStub(channel);

    HelloResponse helloResponse = stub.hello(HelloRequest.newBuilder()
        .setFirstName("Baeldung")
        .setLastName("gRPC")
        .build());

    HelloResponse noResponse = stub.nohello(HelloRequest.newBuilder()
        .setFirstName("")
        .setLastName("")
        .build());

    System.out.println(noResponse);
    channel.shutdown();
  }
}
