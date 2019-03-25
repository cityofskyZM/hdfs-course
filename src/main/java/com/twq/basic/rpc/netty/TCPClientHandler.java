package com.twq.basic.rpc.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class TCPClientHandler extends ChannelInboundHandlerAdapter {
    private final ByteBuf firstMessage;

    private boolean mFlag = true;

    public TCPClientHandler() {
        byte[] req = "hello nio!".getBytes();
        firstMessage = Unpooled.buffer(req.length);
        firstMessage.writeBytes(req);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        ctx.writeAndFlush(firstMessage);

        new Thread() {
            @Override
            public void run() {
                try {
                    while (mFlag) {
                        Scanner scan = new Scanner(System.in);//键盘输入数据
                        String str = scan.next();
                        byte[] byteMessage = str.getBytes("UTF-8");
                        ByteBuf buf = Unpooled.buffer(byteMessage.length);
                        buf.writeBytes(byteMessage);
                        ctx.writeAndFlush(buf);
                    }
                } catch (UnsupportedEncodingException e) {
                    mFlag = false;
                    e.printStackTrace();
                } finally {
                    mFlag = false;
                }
                super.run();
            }
        }.start();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        ByteBuf buf = (ByteBuf)msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        String body = new String(req, "utf-8");
        System.out.println("接收到来自服务器" + ctx.channel().remoteAddress() + "的信息:" + body);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

        System.out.println("unexpected exception from downstream : " + cause.getMessage());
        ctx.close();
    }
}
