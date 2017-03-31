package com.memosea.netty.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * Created by IvanMa on 2017/3/16.
 */
public class TimeClientHandler extends SimpleChannelInboundHandler<ByteBuf> {


    Logger logger = LoggerFactory.getLogger(TimeClientHandler.class);
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
        long time = (msg.readUnsignedInt() - 2208988800L) * 1000l;
        System.out.println(new Date(time));

    }

}
