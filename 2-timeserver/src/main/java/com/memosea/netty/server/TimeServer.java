package com.memosea.netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;

/**
 * Created by IvanMa on 2017/3/16.
 */
public class TimeServer {

    static Logger logger = LoggerFactory.getLogger(TimeServer.class);

    public static void main(String[] args) {
        ServerBootstrap bootstrap = new ServerBootstrap();
        try {
            ChannelFuture future = bootstrap.localAddress(new InetSocketAddress("127.0.0.1",8990)).channel(NioServerSocketChannel.class).group(new NioEventLoopGroup()).childHandler(new ChannelInitializer<SocketChannel>() {
                protected void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new TimeServerHandler());
                }
            }).bind().sync();
            future.addListener(new GenericFutureListener<Future<? super Void>>() {
                public void operationComplete(Future<? super Void> future) throws Exception {
                    logger.info(String.valueOf(future.isCancelled()));
                }
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
