package com.taobao.api.internal.toplink.endpoint.protocol;

import com.taobao.api.internal.toplink.endpoint.MessageIO.MessageDecoder;

import java.nio.ByteBuffer;

public interface MessageDecoderFactory {
	public MessageDecoder get(ByteBuffer buffer);
}