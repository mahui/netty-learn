package com.memosea.netty.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.ByteBuffer;

/**
 * Created by IvanMa on 2017/3/16.
 */
public class TimeClientHandler extends SimpleChannelInboundHandler<ByteBuf> {


    Logger logger = LoggerFactory.getLogger(TimeClientHandler.class);
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
        logger.info("张三0====" + msg.toString(CharsetUtil.UTF_8));
        ctx.writeAndFlush(Unpooled.copiedBuffer("张三0",CharsetUtil.UTF_8));
    }


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(Unpooled.copiedBuffer("客户端的一条消息",CharsetUtil.UTF_8));
        logger.info("客户端的一条消息");
    }

}
