package com.netty.client.handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;
import io.netty.util.CharsetUtil;


/**
 * @Author : mmy
 * @Creat Time : 2020/6/4  8:31
 * @Description
 */
@ChannelHandler.Sharable
public class UdpClientHandler extends SimpleChannelInboundHandler<DatagramPacket> {

    /**
     * 出自 闪电侠-Netty-IM
     * 单例模式
     */
    public static final UdpClientHandler UDP_CLIENT_HANDLER = new UdpClientHandler();

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DatagramPacket msg) throws Exception {
        String response = msg.content().toString(CharsetUtil.UTF_8);
        if (response.startsWith("谚语查询结果：")) {
            System.out.println(response);
            ctx.close();
        }
    }
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

}
