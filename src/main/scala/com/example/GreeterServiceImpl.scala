package com.example

import akka.NotUsed
import akka.stream.Materializer
import akka.stream.scaladsl.{Sink, Source}
import come.example.grpc._

import scala.concurrent.Future

class GreeterServiceImpl(implicit mat: Materializer) extends GreeterService {
  import mat.executionContext

  override def sayHello(in: HelloRequest): Future[HelloReply] = {
    Future.successful(HelloReply(s"Hello, ${in.name}"))
  }

  override def itKeepsTalking(in: Source[HelloRequest, NotUsed]): Future[HelloReply] = {
    in.runWith(Sink.seq)
      .map { elements =>
        HelloReply(s"Hello, ${elements.map(_.name).mkString(", ")}")
      }
  }

  override def itKeepsReplying(in: HelloRequest): Source[HelloReply, NotUsed] = {
    Source(s"Hello, ${in.name}".toList).map(character => HelloReply(character.toString))
  }

  override def streamHellos(in: Source[HelloRequest, NotUsed]): Source[HelloReply, NotUsed] = {
    in.map(request => HelloReply(s"Hello, ${request.name}"))
  }

}
